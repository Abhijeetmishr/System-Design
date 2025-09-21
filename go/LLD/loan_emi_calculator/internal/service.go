package internal

import (
	types "loan_emi_calculator/internal/types"
	"time"
)

type LoanService interface {
	CreateLoan(loanId string, customerId string, principal float64, interest float64, EMI float64, tenure int, date time.Time, status string) error
	GetAllLoans() ([]types.Loan, error)
	GetLoanStatus(loanId string) (string, error)
}

type loanService struct {
	repo LoanRepository
}

func NewLoanService(repo LoanRepository) LoanService {
	return &loanService{repo: repo}
}

type PaymentService interface {
	MakeRepayment(loanId, amount, month string) error
	GetBalance(loanId string) (float64, error)
}

type paymentService struct {
	repo PaymentRepository
}

func NewPaymentService(repo PaymentRepository) PaymentService {
	return &paymentService{repo: repo}
}

func (s *loanService) CreateLoan(loanId, customerId string, principal float64, interest float64, EMI float64, tenure int, date time.Time, status string) error {
	return s.repo.CreateLoan(loanId, customerId, principal, interest, EMI, tenure, date, status)
}

func (s *loanService) GetAllLoans() ([]types.Loan, error) {
	return s.repo.GetAllLoans()
}

func (s *loanService) GetLoanStatus(loanId string) (string, error) {
	return s.repo.GetLoanStatus(loanId)
}

func (s *paymentService) MakeRepayment(loanId, amount, month string) error {
	return s.repo.MakeRepayment(loanId, amount, month)
}

func (s *paymentService) GetBalance(loanId string) (float64, error) {
	return s.repo.GetBalance(loanId)
}
