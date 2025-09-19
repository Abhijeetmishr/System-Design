package main

import (
	"bufio"
	factory "cache/factory"
	"cache/internal"
	"cache/strategy"
	"fmt"
	"os"
	"strings"
)

func main() {
	//create in memory map to store key value pairs
	mem := make(map[string]strategy.CacheItem)
	f := factory.NewCacheEvictionFactory()
	s := internal.NewCacheService(internal.NewCacheRepository(mem), f)

	reader := bufio.NewReader(os.Stdin)
	for {
		fmt.Print("Enter command: ")
		command, _ := reader.ReadString('\n')
		command = strings.TrimSpace(command)

		switch command {
		case "SET":
			fmt.Print("Enter key, value and ttl: ")
			var input string
			fmt.Scanln(&input)
			input = strings.TrimSpace(input)

			// Split by comma and trim spaces
			parts := strings.Split(input, ",")
			if len(parts) >= 2 {
				key := strings.TrimSpace(parts[0])
				value := strings.TrimSpace(parts[1])

				err := s.Set(key, value)
				if err != nil {
					fmt.Printf("Error: %v\n", err)
				} else {
					fmt.Printf("Successfully set %s = %s\n", key, value)
				}
			} else {
				fmt.Println("Error: Please provide key and value separated by comma")
			}
		case "GET":
			fmt.Print("Enter key: ")
			var key string
			fmt.Scanln(&key)
			key = strings.TrimSpace(key)

			result, err := s.Get(key)
			if err != nil {
				fmt.Println(err)
			} else {
				fmt.Println(result)
			}
		case "DELETE":
			fmt.Print("Enter key: ")
			key, _ := reader.ReadString('\n')
			key = strings.TrimSpace(key)

			err := s.Delete(key)
			if err != nil {
				fmt.Println(err)
			} else {
				fmt.Println("Deleted successfully")
			}
		case "EXIT", "QUIT":
			fmt.Println("Goodbye!")
			return
		default:
			fmt.Println("Invalid command. Available commands: SET, GET, DELETE, EXIT")
		}
	}
}
