import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Auditor {

    private int frequencyRating = 0;
    private int amountRating = 0;
    private int locationRating = 0;
    private int oddHoursRating = 0;
    private int compositeRating = 0;
    private int riskLevel = 0;
    private String riskTitle = "";
    private String actionToTake = "";

    public int getFrequencyRating() {
        return frequencyRating;
    }

    public int getAmountRating() {
        return amountRating;
    }

    public int getLocationRating() {
        return locationRating;
    }

    public int getOddHoursRating() {
        return oddHoursRating;
    }

    public int getCompositeRating() {
        return compositeRating;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public String getRiskTitle() {
        return riskTitle;
    }

    public String getActionToTake() {
        return actionToTake;
    }


    public void accountNumberInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Accounts:");
        // 先打印所有账户给用户看
        for (AccountsEnum acc : AccountsEnum.values()) {
            System.out.println("- " + acc.getAccountHolderName() + " (" + acc.getAccountNumber() + ")");
        }

        String inputAccNum;
        boolean accountExists = false;

        do {
            System.out.print("\nPlease enter the account number to check: ");
            inputAccNum = scanner.nextLine().trim();

            for (AccountsEnum acc : AccountsEnum.values()) {
                if (acc.getAccountNumber().equals(inputAccNum)) {
                    accountExists = true;
                    break;
                }
            }
            if (!accountExists) {
                System.out.println("Oops! This account number doesn't exist. Please try again.");
            }
        } while (!accountExists);


        auditTransactions(inputAccNum);
    }


    public void auditTransactions(String accountNumber) {
        evaluateFrequency(accountNumber);
        evaluateAmount(accountNumber);
        evaluateLocation(accountNumber);
        evaluateOddHour(accountNumber);

        compositeRating = frequencyRating + amountRating + locationRating + oddHoursRating;

        evaluateRiskLevel(compositeRating);
    }


    private void evaluateFrequency(String accountNumber) {
        List<LocalDateTime> timestamps = new ArrayList<>();

        for (TransactionsEnum tx : TransactionsEnum.values()) {
            if (tx.getAccountNumber().equals(accountNumber)) {
                timestamps.add(tx.getLocalDateTime());
            }
        }

        for (int i = 0; i < timestamps.size() - 1; i++) {
            LocalDateTime t1 = timestamps.get(i);
            LocalDateTime t2 = timestamps.get(i + 1);
            long minutesDiff = Duration.between(t1, t2).toMinutes();

            if (minutesDiff <= 1440) {
                frequencyRating += 5;
            } else if (minutesDiff > 1440 && minutesDiff <= 2880) {
                frequencyRating += 2;
            }
        }
    }


    private void evaluateAmount(String accountNumber) {
        for (TransactionsEnum tx : TransactionsEnum.values()) {
            if (tx.getAccountNumber().equals(accountNumber)) {
                double txAmount = tx.getAmount();
                if (txAmount > 5000) {
                    amountRating += 5;
                } else if (txAmount > 100 && txAmount < 500) {
                    amountRating += 1;
                }
            }
        }
    }


    private void evaluateLocation(String accountNumber) {
        for (TransactionsEnum tx : TransactionsEnum.values()) {
            if (tx.getAccountNumber().equals(accountNumber) && "International".equals(tx.getTransactionCategory())) {
                locationRating += 5;
            }
        }
    }


    private void evaluateOddHour(String accountNumber) {
        for (TransactionsEnum tx : TransactionsEnum.values()) {
            if (tx.getAccountNumber().equals(accountNumber)) {
                int hour = tx.getLocalDateTime().getHour();
                
                if (hour < 6 || hour >= 22) {
                    oddHoursRating += 5;
                }
            }
        }
    }


    private void evaluateRiskLevel(int compositeRating) {
        RiskEnum risk = RiskEnum.fromCompositeRating(compositeRating);
        riskLevel = risk.getLevel();
        riskTitle = risk.getTitle();
        actionToTake = risk.getAction();
    }
    
    @Override
    public String toString() {
        return "\nRisk Audit Result:\n" +
                "Transaction Frequency Risk: " + frequencyRating + "\n" +
                "Transaction Amount Risk: " + amountRating + "\n" +
                "Transaction Location Risk: " + locationRating + "\n" +
                "Transaction Timing Risk: " + oddHoursRating + "\n" +
                "Composite Risk: " + compositeRating + "\n" +
                "Estimated Risk Level: " + riskLevel + "\n\n" +
                "Overall Risk: " + riskTitle + "\n" +
                "Recommended Action: " + actionToTake + "\n" +
                "NOTE: Lower values are better.";
    }
}