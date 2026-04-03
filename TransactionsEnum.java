public enum TransactionsEnum {
    TRANS1("1001"),
    TRANS2("1002"),
    TRANS3("1001"),
    TRANS4("1003");

    private final String accountNumber;

    TransactionsEnum(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}