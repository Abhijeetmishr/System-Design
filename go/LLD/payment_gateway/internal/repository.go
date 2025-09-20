package internal

import (
	"container/list"
	"errors"
	"payment_gateway/observer"
	strategy "payment_gateway/strategy"
	types "payment_gateway/types"
	"sync"
)

type PaymentRepository interface {
	CreateTransaction(txnID string, amount float64, paymentType types.PaymentType, currency types.Currency) error
	ProcessTransaction(txnID string) error
	GetTransactionByID(id string) (types.Transaction, error)
	GetAllTransactionsByStatus(status types.Status) ([]types.Transaction, error)
	GetStats() ([]types.Stats, error)
}

type paymentRepository struct {
	mem                *sync.Map
	stats              *list.List
	strategy           strategy.PaymentStrategy
	notificationSystem observer.NotificationObservable
}

func NewPaymentRepository(mem *sync.Map, stats *list.List, strategy strategy.PaymentStrategy, notificationSystem observer.NotificationObservable) PaymentRepository {
	return &paymentRepository{
		mem:                mem,
		stats:              stats,
		strategy:           strategy,
		notificationSystem: notificationSystem,
	}
}

func (r *paymentRepository) CreateTransaction(txnID string, amount float64, paymentType types.PaymentType, currency types.Currency) error {
	// Check for duplicate transaction (idempotency)
	if _, exists := r.mem.Load(txnID); exists {
		return errors.New("duplicate transaction")
	}

	transaction := types.Transaction{
		ID:          txnID,
		Amount:      amount,
		PaymentType: paymentType,
		Currency:    currency,
		Status:      types.INITIATED,
	}

	r.mem.Store(txnID, transaction)
	return nil
}

func (r *paymentRepository) ProcessTransaction(txnID string) error {
	txn, ok := r.mem.Load(txnID)
	if !ok {
		return errors.New("transaction not found")
	}

	transaction := txn.(types.Transaction)

	// Update status to PROCESSING
	transaction.Status = types.PROCESSING
	r.mem.Store(txnID, transaction)

	// Select strategy based on payment type
	var selectedStrategy strategy.PaymentStrategy
	switch transaction.PaymentType {
	case types.CARD:
		selectedStrategy = strategy.NewCardPaymentStrategy()
	case types.UPI:
		selectedStrategy = strategy.NewUPIPaymentStrategy()
	case types.WALLET:
		selectedStrategy = strategy.NewWalletPaymentStrategy()
	default:
		selectedStrategy = r.strategy // fallback to default
	}

	// Process using selected strategy
	err := selectedStrategy.ProcessTransaction(txnID, r.mem)
	if err != nil {
		// If strategy fails, mark as FAILED
		transaction.Status = types.FAILED
		r.mem.Store(txnID, transaction)

		// Notify observers of failure
		r.notificationSystem.NotifyObservers(transaction)

		// Update stats
		r.updateStats(transaction.Status)
		return err
	}

	// Get updated transaction after strategy processing
	updatedTxn, _ := r.mem.Load(txnID)
	transaction = updatedTxn.(types.Transaction)

	// Notify observers of final status (SUCCESS or FAILED)
	if transaction.Status == types.SUCCESS || transaction.Status == types.FAILED {
		r.notificationSystem.NotifyObservers(transaction)
	}

	// Update stats
	r.updateStats(transaction.Status)

	return nil
}

func (r *paymentRepository) updateStats(status types.Status) {
	stats := &types.Stats{
		Status: status,
		Total:  1,
	}
	r.stats.PushBack(stats)
}

func (r *paymentRepository) GetAllTransactionsByStatus(status types.Status) ([]types.Transaction, error) {
	transactions := make([]types.Transaction, 0)
	r.mem.Range(func(key, value interface{}) bool {
		transaction := value.(types.Transaction)
		if transaction.Status == status {
			transactions = append(transactions, transaction)
		}
		return true
	})
	return transactions, nil
}

func (r *paymentRepository) GetStats() ([]types.Stats, error) {
	stats := make([]types.Stats, 0)
	for e := r.stats.Front(); e != nil; e = e.Next() {
		stats = append(stats, *e.Value.(*types.Stats))
	}
	return stats, nil
}

func (r *paymentRepository) GetTransactionByID(txnID string) (types.Transaction, error) {
	txn, ok := r.mem.Load(txnID)
	if !ok {
		return types.Transaction{}, errors.New("transaction not found")
	}
	return txn.(types.Transaction), nil
}
