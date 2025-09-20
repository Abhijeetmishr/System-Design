package main

import (
	"bufio"
	"container/list"
	"fmt"
	"os"
	"payment_gateway/internal"
	"payment_gateway/observer"
	strategy "payment_gateway/strategy"
	types "payment_gateway/types"
	"strconv"
	"strings"
	"sync"
)

func main() {
	// Initialize components
	mem := &sync.Map{}
	stats := list.New()

	// Initialize observer pattern
	notificationSystem := observer.NewPaymentNotificationObservable()
	emailObserver := observer.NewEmailNotificationObserver()
	consoleObserver := observer.NewConsoleNotificationObserver()

	// Register observers
	notificationSystem.AddObserver(emailObserver)
	notificationSystem.AddObserver(consoleObserver)

	// Initialize payment strategy and repository
	// We'll use a default strategy, but the repository will handle strategy selection
	paymentStrategy := strategy.NewCardPaymentStrategy()
	repo := internal.NewPaymentRepository(mem, stats, paymentStrategy, notificationSystem)
	service := internal.NewPaymentService(repo)

	reader := bufio.NewReader(os.Stdin)
	for {
		fmt.Print("Enter command: ")
		command, _ := reader.ReadString('\n')
		command = strings.TrimSpace(command)

		parts := strings.Split(command, ",")
		cmd := parts[0]

		switch cmd {
		case "CREATE_TRANSACTION":
			if len(parts) != 5 {
				fmt.Println("Error: Invalid command format")
				continue
			}
			transactionID := parts[1]
			amount, err := strconv.ParseFloat(parts[2], 64)
			if err != nil {
				fmt.Println("Error: Invalid amount")
				continue
			}
			currency := types.Currency(parts[3])
			paymentType := types.PaymentType(parts[4])
			service.CreateTransaction(transactionID, amount, paymentType, currency)

		case "PROCESS_TRANSACTION":
			if len(parts) != 2 {
				fmt.Println("Error: Invalid command format")
				continue
			}
			transactionID := parts[1]
			service.ProcessTransaction(transactionID)

		case "GET_TRANSACTION":
			if len(parts) != 2 {
				fmt.Println("Error: Invalid command format")
				continue
			}
			transactionID := parts[1]
			result, err := service.GetTransactionByID(transactionID)
			if err != nil {
				fmt.Println("Error: Transaction not found")
			} else {
				fmt.Println(result)
			}

		case "LIST_TRANSACTIONS":
			if len(parts) != 2 {
				fmt.Println("Error: Invalid command format")
				continue
			}
			status := types.Status(parts[1])
			result, err := service.GetAllTransactionsByStatus(status)
			if err != nil {
				fmt.Println("Error: Failed to get transactions")
			} else {
				fmt.Println(result)
			}

		case "GET_STATISTICS":
			result, err := service.GetStats()
			if err != nil {
				fmt.Println("Error: Failed to get statistics")
			} else {
				fmt.Println(result)
			}

		case "EXIT":
			return

		default:
			fmt.Println("Invalid command")
		}
	}
}
