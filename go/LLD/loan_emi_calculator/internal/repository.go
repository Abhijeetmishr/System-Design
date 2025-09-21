package internal

import (
	"loan_emi_calculator/internal/types"
	"sync"
	"time"
)

type DataStore struct {
	loans     map[string][]types.Loan
	customers map[string][]types.User
	mu        sync.RWMutex
}

func NewDataStore() *DataStore {
	return &DataStore{
		loans:     make(map[string][]types.Loan),
		customers: make(map[string][]types.User),
	}
}

type LoanRepository interface {
	CreateLoan(loanId string, customerId string, principal float64, interest float64, EMI float64, tenure int, date time.Time, status string) error
	GetAllLoans() ([]types.Loan, error)
	GetLoanStatus(loanId string) (string, error)
}

type loanRepository struct {
	repo *DataStore
}

func NewLoanRepository(datastore *DataStore) *loanRepository {
	return &loanRepository{repo: datastore}
}

type PaymentRepository interface {
	MakeRepayment(loanId, amount, month string) error
	GetBalance(loanId string) (float64, error)
}

type paymentRepository struct {
	repo *DataStore
}

func NewPaymentRepository(datastore *DataStore) *paymentRepository {
	return &paymentRepository{repo: datastore}
}

func (ds *DataStore) AddLoan(customerId string, loan types.Loan) {
	ds.mu.Lock()
	defer ds.mu.Unlock()
	ds.loans[customerId] = append(ds.loans[customerId], loan)
}

func (ds *DataStore) GetLoans() map[string][]types.Loan {
	ds.mu.RLock()
	defer ds.mu.RUnlock()
	return ds.loans
}

func (ds *DataStore) GetCustomers() map[string][]types.User {
	ds.mu.RLock()
	defer ds.mu.RUnlock()
	return ds.customers
}

func (r *loanRepository) CreateLoan(loanId string, customerId string, principal float64, interest float64, EMI float64, tenure int, date time.Time, status string) error {
	r.repo.loans[customerId] = append(r.repo.loans[customerId], types.Loan{Id: loanId, CustomerId: customerId, Principal: principal, Interest: interest, EMI: EMI, Tenure: tenure, Date: date.Format(time.RFC3339), Status: types.StatusType(status)})
	return nil
}

func (r *loanRepository) GetAllLoans() ([]types.Loan, error) {
	loans := make([]types.Loan, 0)
	for _, loan := range r.repo.loans {
		loans = append(loans, loan...)
	}
	return loans, nil
}

func (r *loanRepository) GetLoanStatus(loanId string) (string, error) {
	return string(r.repo.loans[loanId][0].Status), nil
}

func (r *paymentRepository) MakeRepayment(loanId, amount, month string) error {
	return nil
}

func (r *paymentRepository) GetBalance(loanId string) (float64, error) {
	return 0, nil
}
