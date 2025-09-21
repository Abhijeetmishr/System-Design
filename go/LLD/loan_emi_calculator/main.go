package main

import (
	"bufio"
	"fmt"
	"loan_emi_calculator/internal"
	"os"
	"strings"
)

func main() {
	datastore := internal.NewDataStore()
	loanRepository := internal.NewLoanRepository(datastore)
	paymentRepository := internal.NewPaymentRepository(datastore)
	loanService := internal.NewLoanService(loanRepository)
	paymentService := internal.NewPaymentService(paymentRepository)

	reader := bufio.NewReader(os.Stdin)
	for {
		fmt.Print("Enter command: ")
		command, _ := reader.ReadString('\n')
		command = strings.TrimSpace(command)

		switch command {
		case "CREATE_LOAN":
			loanService.CreateLoan(command)
		case "GET_ALL_LOANS":
			loanService.GetAllLoans()
		case "GET_LOAN_STATUS":
			loanService.GetLoanStatus(command)
		case "MAKE_REPAYMENT":
			paymentService.MakeRepayment(command)
		case "GET_BALANCE":
			paymentService.GetBalance(command)
		case "EXIT", "QUIT":
			return
		default:
			fmt.Println("Invalid command")
		}
	}
}
