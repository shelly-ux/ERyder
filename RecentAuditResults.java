import java.util.ArrayList;
import java.util.LinkedList;

public class RecentAuditResults {
    private ArrayList<String> accountNumbersList = new ArrayList<>();
    private LinkedList<AuditResults> auditResultsList = new LinkedList<>();

    public void generateRecentAuditResults() {
        accountNumbersList.clear();
        auditResultsList.clear();

        for (TransactionsEnum transaction : TransactionsEnum.values()) {
            String accountNumber = transaction.getAccountNumber();
            if (!accountNumbersList.contains(accountNumber)) {
                accountNumbersList.add(accountNumber);
            }
        }

        for (String accountNumber : accountNumbersList) {
            Auditor auditor = new Auditor();
            auditor.auditTransactions(accountNumber);

            AuditResults result = new AuditResults(
                    accountNumber,
                    auditor.getFrequencyRating(),
                    auditor.getAmountRating(),
                    auditor.getLocationRating(),
                    auditor.getOddHourRating(),
                    auditor.getCompositeRating(),
                    auditor.getRiskLevel(),
                    auditor.getRiskTitle(),
                    auditor.getActionToTake()
            );

            auditResultsList.add(result);
        }
    }

    public LinkedList<AuditResults> getAuditResultsList() {
        return auditResultsList;
    }

    public ArrayList<String> getAccountNumbersList() {
        return accountNumbersList;
    }
}