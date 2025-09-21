package types

type Loan struct {
	Id         string
	CustomerId string
	Principal  float64
	Interest   float64
	EMI        float64
	Tenure     int
	Date       string
	Status     StatusType
}

type User struct {
	Id   string
	Role string
}

type RoleType string

const (
	RoleAdmin    RoleType = "ADMIN"
	RoleCustomer RoleType = "CUSTOMER"
)

type StatusType string

const (
	StatusActive   StatusType = "ACTIVE"
	StatusInactive StatusType = "INACTIVE"
)
