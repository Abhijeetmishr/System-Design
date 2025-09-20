package internal

type Transaction struct {
	ID          string
	Amount      float64
	PaymentType PaymentType
	Currency    Currency
	Status      Status
}

type Stats struct {
	Status Status
	Total  int
}

type Status string

const (
	INITIATED  Status = "INITIATED"
	PROCESSING Status = "PROCESSING"
	SUCCESS    Status = "SUCCESS"
	FAILED     Status = "FAILED"
)

type PaymentType string

type Currency string

const (
	WALLET PaymentType = "WALLET"
	UPI    PaymentType = "UPI"
	CARD   PaymentType = "CARD"
)

const (
	INR Currency = "INR"
	USD Currency = "USD"
)
