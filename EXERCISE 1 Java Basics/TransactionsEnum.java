import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public enum TransactionsEnum {
    TRANSACTION_1("John Doe", "1015890118", "Withdrawal", 500.00, "2024-01-15T09:30:00", "Main Street", "New York", "Domestic"),
    TRANSACTION_2("Jane Smith", "2894890016", "Deposit", 1000.00, "2024-01-16T14:20:00", "Elm Street", "London", "International"),
    TRANSACTION_3("Alice Johnson", "6490380021", "Withdrawal", 200.00, "2024-01-17T11:15:00", "Oak Avenue", "Paris", "International"),
    TRANSACTION_4("Bob Brown", "3090264629", "Deposit", 1500.00, "2024-01-18T16:45:00", "Pine Road", "Tokyo", "International"),
    TRANSACTION_5("Charlie Davis", "9801894038", "Withdrawal", 300.00, "2024-01-19T08:00:00", "Cedar Lane", "Sydney", "International"),
    TRANSACTION_6("Dave Evans", "1234567890", "Deposit", 800.00, "2024-01-20T10:30:00", "Maple Drive", "Toronto", "Domestic"),
    TRANSACTION_7("Emily Wilson", "2098781638", "Withdrawal", 400.00, "2024-01-21T13:25:00", "Birch Street", "Berlin", "International"),
    TRANSACTION_8("Frank Miller", "3456789012", "Deposit", 1200.00, "2024-01-22T15:10:00", "Willow Way", "Madrid", "International"),
    TRANSACTION_9("Grace Lee", "4567890123", "Withdrawal", 600.00, "2024-01-23T07:45:00", "Aspen Court", "Rome", "International"),
    TRANSACTION_10("Henry Wang", "5678901234", "Deposit", 900.00, "2024-01-24T12:00:00", "Chestnut Lane", "Vienna", "International"),
    TRANSACTION_11("Ivy Chen", "6789012345", "Withdrawal", 250.00, "2024-01-25T14:30:00", "Walnut Street", "Prague", "International"),
    TRANSACTION_12("Jack Liu", "7890123456", "Deposit", 1800.00, "2024-01-26T16:20:00", "Hickory Road", "Budapest", "International"),
    TRANSACTION_13("Kate Zhang", "8901234567", "Withdrawal", 350.00, "2024-01-27T09:10:00", "Poplar Avenue", "Warsaw", "International"),
    TRANSACTION_14("Leo Hu", "9012345678", "Deposit", 700.00, "2024-01-28T11:45:00", "Elmwood Drive", "Krakow", "International"),
    TRANSACTION_15("Mia Guo", "0123456789", "Withdrawal", 450.00, "2024-01-29T13:30:00", "Cherry Lane", "Lisbon", "International"),
    TRANSACTION_16("Oliver Davis", "2309827046", "Deposit", 5000.00, "2024-01-16T10:00:00", "Ocean Drive", "Miami", "Domestic"),
    TRANSACTION_17("Emily Wilson", "2098781638", "Deposit", 8000.00, "2024-01-10T21:18:32", "Sandhurst Street", "Edinburgh", "International"),
    TRANSACTION_18("Quinn Wilson", "3972049382", "Deposit", 5500.00, "2024-01-18T16:30:00", "Market Street", "San Francisco", "Domestic"),
    TRANSACTION_19("Emily Wilson", "2098781638", "Withdrawal", 3000.00, "2024-01-13T04:23:17", "Collins Avenue", "Miami", "Domestic"),
    TRANSACTION_20("Charlie Davis", "9801894038", "Withdrawal", 150.00, "2024-01-09T04:13:15", "Decumanus", "Naples", "International");

    private final String accountHolderName;
    private final String accountNumber;
    private final String transactionType;
    private final double amount;
    private final String timestamp;
    private final String location;
    private final String city;
    private final String transactionCategory;

    TransactionsEnum(String accountHolderName, String accountNumber, String transactionType, double amount, String timestamp, String location, String city, String transactionCategory) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.timestamp = timestamp;
        this.location = location;
        this.city = city;
        this.transactionCategory = transactionCategory;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public LocalDateTime getLocalDateTime() {
        return LocalDateTime.parse(timestamp, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public String getLocation() {
        return location;
    }

    public String getCity() {
        return city;
    }

    public String getTransactionCategory() {
        return transactionCategory;
    }
    
    @Override
    public String toString() {
        return "Transactions Details\n" +
                "Account Holder: " + accountHolderName + "\n" +
                "Account Number: " + accountNumber + "\n" +
                "Transaction Type: " + transactionType + "\n" +
                "Transaction Amount: " + amount + "\n" +
                "Time of Transaction: " + timestamp + "\n" +
                "Location of Transaction: " + location + "\n" +
                "City of Transaction: " + city + "\n" +
                "Category of Transaction: " + transactionCategory;
    }
}