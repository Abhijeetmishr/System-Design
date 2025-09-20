package observer

import (
	"fmt"
	types "payment_gateway/types"
)

type NotificationObserver interface {
	Update(transaction types.Transaction)
}

type EmailNotificationObserver struct{}

// Fixed: Proper constructor function (not a method)
func NewEmailNotificationObserver() *EmailNotificationObserver {
	return &EmailNotificationObserver{}
}

// Fixed: Update method should be void, not return string
// Fixed: Method name should be capitalized (Update, not update)
func (e *EmailNotificationObserver) Update(transaction types.Transaction) {
	// Fixed: Proper notification format as specified in requirements
	notification := fmt.Sprintf("Notification: Transaction %s %s for %s %.0f via %s",
		transaction.ID,
		string(transaction.Status),
		string(transaction.Currency),
		transaction.Amount,
		string(transaction.PaymentType))

	fmt.Println(notification)
}

// Console notification observer for logging
type ConsoleNotificationObserver struct{}

func NewConsoleNotificationObserver() *ConsoleNotificationObserver {
	return &ConsoleNotificationObserver{}
}

func (c *ConsoleNotificationObserver) Update(transaction types.Transaction) {
	// Log to console as specified in requirements
	fmt.Printf("Transaction %s %s for %s %.0f via %s\n",
		transaction.ID,
		string(transaction.Status),
		string(transaction.Currency),
		transaction.Amount,
		string(transaction.PaymentType))
}
