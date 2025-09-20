package internal

import (
	"fmt"
	types "payment_gateway/types"
	"strings"
)

type PaymentService interface {
	CreateTransaction(txnID string, amount float64, paymentType types.PaymentType, currency types.Currency) error
	ProcessTransaction(txnID string) error
	GetTransactionByID(id string) (string, error)
	GetAllTransactionsByStatus(status types.Status) (string, error)
	GetStats() (string, error)
}

type paymentService struct {
	repo PaymentRepository
}

func NewPaymentService(repo PaymentRepository) PaymentService {
	return &paymentService{repo: repo}
}

func (s *paymentService) CreateTransaction(txnID string, amount float64, paymentType types.PaymentType, currency types.Currency) error {
	err := s.repo.CreateTransaction(txnID, amount, paymentType, currency)
	if err != nil {
		if err.Error() == "duplicate transaction" {
			fmt.Println("Error: Duplicate transaction")
		}
		return err
	}
	fmt.Printf("TRANSACTION_CREATED %s\n", txnID)
	return nil
}

func (s *paymentService) ProcessTransaction(txnID string) error {
	err := s.repo.ProcessTransaction(txnID)
	if err != nil {
		if err.Error() == "transaction not found" {
			fmt.Println("Error: Transaction not found")
		}
		return err
	}

	// Get the transaction to determine the output message
	txn, _ := s.repo.GetTransactionByID(txnID)
	if txn.Status == types.SUCCESS {
		fmt.Printf("TRANSACTION_SUCCESS %s\n", txnID)
	} else if txn.Status == types.FAILED {
		fmt.Printf("TRANSACTION_FAILED %s\n", txnID)
	}

	return nil
}

func (s *paymentService) GetTransactionByID(txnID string) (string, error) {
	txn, err := s.repo.GetTransactionByID(txnID)
	if err != nil {
		return "", err
	}
	return fmt.Sprintf("%s,%.0f,%s,%s,%s",
		txn.ID, txn.Amount, string(txn.Currency), string(txn.PaymentType), string(txn.Status)), nil
}

func (s *paymentService) GetAllTransactionsByStatus(status types.Status) (string, error) {
	txns, err := s.repo.GetAllTransactionsByStatus(status)
	if err != nil {
		return "", err
	}

	var result []string
	for _, txn := range txns {
		result = append(result, txn.ID)
	}
	return strings.Join(result, ","), nil
}

func (s *paymentService) GetStats() (string, error) {
	stats, err := s.repo.GetStats()
	if err != nil {
		return "", err
	}

	total := 0
	success := 0
	failed := 0

	for _, stat := range stats {
		total += stat.Total
		if stat.Status == types.SUCCESS {
			success += stat.Total
		} else if stat.Status == types.FAILED {
			failed += stat.Total
		}
	}

	return fmt.Sprintf("TOTAL:%d,SUCCESS:%d,FAILED:%d", total, success, failed), nil
}
