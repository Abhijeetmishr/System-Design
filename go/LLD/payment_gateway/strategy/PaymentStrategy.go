package strategy

import (
	"errors"
	types "payment_gateway/types"
	"sync"
)

type PaymentStrategy interface {
	ProcessTransaction(txnID string, mem *sync.Map) error
}

type CardPaymentStrategy struct{}

func NewCardPaymentStrategy() PaymentStrategy {
	return &CardPaymentStrategy{}
}

func (p *CardPaymentStrategy) ProcessTransaction(txnID string, mem *sync.Map) error {
	txn, ok := mem.Load(txnID)
	if !ok {
		return errors.New("transaction not found")
	}
	transaction := txn.(types.Transaction)
	transaction.Status = types.Status(types.SUCCESS)
	transaction.PaymentType = types.PaymentType(types.CARD)
	mem.Store(txnID, transaction)
	return nil
}

type UPIPaymentStrategy struct{}

func NewUPIPaymentStrategy() PaymentStrategy {
	return &UPIPaymentStrategy{}
}

func (p *UPIPaymentStrategy) ProcessTransaction(txnID string, mem *sync.Map) error {
	txn, ok := mem.Load(txnID)
	if !ok {
		return errors.New("transaction not found")
	}
	transaction := txn.(types.Transaction)
	transaction.Status = types.Status(types.SUCCESS)
	transaction.PaymentType = types.PaymentType(types.UPI)
	mem.Store(txnID, transaction)
	return nil
}

type WalletPaymentStrategy struct{}

func NewWalletPaymentStrategy() PaymentStrategy {
	return &WalletPaymentStrategy{}
}

func (p *WalletPaymentStrategy) ProcessTransaction(txnID string, mem *sync.Map) error {
	txn, ok := mem.Load(txnID)
	if !ok {
		return errors.New("transaction not found")
	}
	transaction := txn.(types.Transaction)
	transaction.Status = types.Status(types.SUCCESS)
	transaction.PaymentType = types.PaymentType(types.WALLET)
	mem.Store(txnID, transaction)
	return nil
}
