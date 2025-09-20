package observer

import (
	"container/list"
	types "payment_gateway/types"
)

type NotificationObservable interface {
	AddObserver(observer NotificationObserver)
	RemoveObserver(observer NotificationObserver)
	NotifyObservers(transaction types.Transaction)
}

type PaymentNotificationObservable struct {
	observers *list.List
}

// Fixed: Proper constructor that initializes empty list
func NewPaymentNotificationObservable() *PaymentNotificationObservable {
	return &PaymentNotificationObservable{
		observers: list.New(),
	}
}

// Fixed: Store actual observer objects, not strings
func (p *PaymentNotificationObservable) AddObserver(observer NotificationObserver) {
	p.observers.PushBack(observer)
}

// Fixed: Remove actual observer objects
func (p *PaymentNotificationObservable) RemoveObserver(observer NotificationObserver) {
	for e := p.observers.Front(); e != nil; e = e.Next() {
		if e.Value == observer {
			p.observers.Remove(e)
			break
		}
	}
}

// Fixed: Proper type casting and method call
func (p *PaymentNotificationObservable) NotifyObservers(transaction types.Transaction) {
	for e := p.observers.Front(); e != nil; e = e.Next() {
		observer := e.Value.(NotificationObserver)
		observer.Update(transaction)
	}
}
