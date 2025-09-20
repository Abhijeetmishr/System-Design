## PAYMENT GATEWAY PROCESSOR
### Requirements

#### Transaction Management
Users can create a transaction with:

    - transaction_id (unique)
    - amount 
    - currency (e.g., INR, USD)
    - payment_method (e.g., CARD, UPI, WALLET)
    - Initial status: INITIATED

Transaction status can change to:

    - PROCESSING
    - SUCCESS
    - FAILED

#### Payment Methods (Pluggable)
The system must support multiple payment methods:
    
    CARD → simulate OTP verification step.
    UPI → simulate UPI collect request.
    WALLET → simulate wallet balance check.

Each payment method has its own processing strategy.

✅ Use Strategy Pattern to support extensibility.

### Idempotency

If a client retries the same transaction request (same transaction_id), the system should return the existing transaction status instead of creating a duplicate.

### Thread-Safety

Multiple users can make payment requests concurrently.

Ensure concurrency-safe in-memory storage (using mutex or sync.Map).

### Query Operations

Fetch a transaction by transaction_id.

List all transactions by status (INITIATED, PROCESSING, SUCCESS, FAILED).

Get statistics:

Total transactions

Successful transactions

Failed transactions

### Bonus (Observer Pattern)

Send a notification (log to console) when a transaction reaches SUCCESS or FAILED.

Example:

Notification: Transaction TXN123 SUCCESS for INR 1000 via UPI

🔹 Commands

CREATE_TRANSACTION

CREATE_TRANSACTION,<transaction_id>,<amount>,<currency>,<payment_method>


Output:

TRANSACTION_CREATED <transaction_id>


or

Error: Duplicate transaction


PROCESS_TRANSACTION

PROCESS_TRANSACTION,<transaction_id>


Output:

TRANSACTION_SUCCESS <transaction_id>


or

TRANSACTION_FAILED <transaction_id>


or

Error: Transaction not found


GET_TRANSACTION

GET_TRANSACTION,<transaction_id>


Output:

<transaction_id>,<amount>,<currency>,<payment_method>,<status>


LIST_TRANSACTIONS

LIST_TRANSACTIONS,<status>


Output:

<txn_id>,<txn_id>,<txn_id>...


GET_STATISTICS

GET_STATISTICS


Output:

TOTAL:<value>,SUCCESS:<value>,FAILED:<value>

Sample Test Case

Input

    CREATE_TRANSACTION,TXN1,1000,INR,UPI
    CREATE_TRANSACTION,TXN2,2000,INR,CARD
    PROCESS_TRANSACTION,TXN1
    PROCESS_TRANSACTION,TXN2
    GET_TRANSACTION,TXN1
    LIST_TRANSACTIONS,SUCCESS
    GET_STATISTICS

Output

    TRANSACTION_CREATED TXN1
    TRANSACTION_CREATED TXN2
    TRANSACTION_SUCCESS TXN1
    TRANSACTION_FAILED TXN2
    TXN1,1000,INR,UPI,SUCCESS
    TXN1
    TOTAL:2,SUCCESS:1,FAILED:1


### Requirement Gathering
1. create transaction with amount and unique transaction_id
2. consider diffrent transaction methods like wallet, UPI, CARD
3. fetch transaction by id 
4. List all transaction by status 
5. GET statistics like failed, successful, processing

### API
1. CREATE(transaction_id, amount, currency_type, payment_type)
2. PROCESS_TRANSACTION(TXN_ID)
3. GET_TRANSACTION_BY_ID(transaction_id)
4. GET_ALL_TRANSACTION_BY_STATUS(status)
5. GET STATS()

### CLASSES
TRANSACTION             ENUM PAYMENT_TYPE
 - ID                    - WALLET
 - amount                - UPI
 - payment_type          - CARD
 - currency

ENUM CURRENCY_TYPE
- INR
- USD

