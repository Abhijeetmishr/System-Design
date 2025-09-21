## DESIGN LOAN EMI CALCULATOR
### Requirement gatherings
- admin can create loans for customers
- admin can check balances for all the customers
- Custommers can make repayment
- Customer can check their account/balance

### API
#### ADMIN
- CREATE_LOANS(loanId, customerId, principal, interest, EMI, tenure, date, status)
- GET_ALL_LOANS

#### CUSTOMER
- MAKE_REPAYMENT(loanId, amount, month)
- GET_BALANCE(loanId)
- GET_LOAN_STATUS(loan_id)

### CLASSES
    LOAN                        USER
    - ID                         - Id
    - customerId                 - role
    - principal_amount
    - interest
    - tenure
    - date
    - status

