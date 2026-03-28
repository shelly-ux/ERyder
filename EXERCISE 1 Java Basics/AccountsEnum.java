public enum AccountsEnum {
    JOHN_DOE("John Doe", "1015890118", 1000.00, "Savings", true),
    JANE_SMITH("Jane Smith", "2894890016", 2000.00, "Checking", false),
    ALICE_JOHNSON("Alice Johnson", "6490380021", 1500.00, "Savings", true),
    BOB_BROWN("Bob Brown", "3090264629", 2500.00, "Checking", false),
    CHARLIE_DAVIS("Charlie Davis", "9801894038", 3000.00, "Savings", true),
    DAVE_EVANS("Dave Evans", "1234567890", 1200.00, "Checking", false),
    EMILY_WILSON("Emily Wilson", "2098781638", 1800.00, "Savings", true),
    FRANK_MILLER("Frank Miller", "3456789012", 2200.00, "Checking", false),
    GRACE_LEE("Grace Lee", "4567890123", 1600.00, "Savings", true),
    HENRY_WANG("Henry Wang", "5678901234", 2800.00, "Checking", false),
    IVY_CHEN("Ivy Chen", "6789012345", 1400.00, "Savings", true),
    JACK_LIU("Jack Liu", "7890123456", 3200.00, "Checking", false),
    KATE_ZHANG("Kate Zhang", "8901234567", 1900.00, "Savings", true),
    LEO_HU("Leo Hu", "9012345678", 2600.00, "Checking", false),
    MIA_GUO("Mia Guo", "0123456789", 1300.00, "Savings", true),
    NATE_ZHOU("Nate Zhou", "1234509876", 2400.00, "Checking", false),
    OLIVER_DAVIS("Oliver Davis", "2309827046", 1700.00, "Savings", true),
    PENELOPE_COOK("Penelope Cook", "3456708901", 2900.00, "Checking", false),
    QUINN_WILSON("Quinn Wilson", "3972049382", 2100.00, "Savings", true),
    RACHEL_GREEN("Rachel Green", "4567801234", 2300.00, "Checking", false);

    private final String accountHolderName;
    private final String accountNumber;
    private final double balance;
    private final String accountType;
    private final boolean isActive;

    AccountsEnum(String accountHolderName, String accountNumber, double balance, String accountType, boolean isActive) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.isActive = isActive;
    }
    
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public boolean isActive() {
        return isActive;
    }
}