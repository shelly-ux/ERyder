import java.util.LinkedList;
import java.util.Scanner;

public class AuditResultsReview {
    private Scanner scanner;
    private RecentAuditResults recentAuditResults;
    private LinkedList<AuditResults> auditResultsListForReview;


    public AuditResultsReview() {
        scanner = new Scanner(System.in);
        recentAuditResults = new RecentAuditResults();
        auditResultsListForReview = new LinkedList<>();
    }


    public void reviewAuditResults() {
        while (true) {
            System.out.println("\nChoose one of the following review activities:");
            System.out.println("1. Generate audit results for review");
            System.out.println("2. Display all the audit results");
            System.out.println("3. List accounts with a specific risk level");
            System.out.println("4. Modify an audit result");
            System.out.println("5. Delete an audit result");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please try again");
                continue;
            }

            switch (choice) {
                case 1:
                    generateAuditResults();
                    break;
                case 2:
                    displayAllAuditResults(auditResultsListForReview);
                    break;
                case 3:
                    searchByRiskLevel(auditResultsListForReview);
                    break;
                case 4:
                    modifyAuditResult(auditResultsListForReview);
                    break;
                case 5:
                    deleteAuditResult(auditResultsListForReview);
                    break;
                case 6:
                    System.out.println("Exiting review process");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }
    }


    private void generateAuditResults() {
        recentAuditResults.generateRecentAuditResults();

        auditResultsListForReview = recentAuditResults.getAuditResultsList();
        System.out.println("Audit results generated successfully!");
    }

    private void displayAllAuditResults(LinkedList<AuditResults> list) {
        if (list.isEmpty()) {
            System.out.println("No audit results found. Please generate results first.");
            return;
        }
        System.out.println("\n--- All Audit Results ---");
        for (AuditResults result : list) {
            System.out.println(result);
        }
    }


    private void searchByRiskLevel(LinkedList<AuditResults> list) {
        if (list.isEmpty()) {
            System.out.println("No audit results found. Please generate results first.");
            return;
        }

        System.out.print("Enter the risk level (0-5) to search: ");
        int riskLevel;
        try {
            riskLevel = Integer.parseInt(scanner.nextLine());
            if (riskLevel < 0 || riskLevel > 5) {
                System.out.println("Invalid risk level. Please enter 0-5.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number between 0-5.");
            return;
        }

        boolean found = false;
        System.out.println("\n--- Audit Results with Risk Level " + riskLevel + " ---");

        for (AuditResults result : list) {
            if (result.getRiskLevel() == riskLevel) {
                System.out.println("Account Number: " + result.getAccountNumber());
                System.out.println("Risk Title: " + result.getRiskTitle());
                System.out.println("Action To Take: " + result.getActionToTake() + "\n");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No audit results found with the specified risk level.");
        }
    }

    // 4. 修改审计结果方法
    private void modifyAuditResult(LinkedList<AuditResults> list) {
        if (list.isEmpty()) {
            System.out.println("No audit results found. Please generate results first.");
            return;
        }

        System.out.println("Please note that you can modify only the risk level, risk title, and action to take for an audit result.");
        System.out.print("Enter an account number whose detail must be modified: ");
        String accNum = scanner.nextLine();

        // 查找对应账号的审计结果
        AuditResults target = null;
        for (AuditResults result : list) {
            if (result.getAccountNumber().equals(accNum)) {
                target = result;
                break;
            }
        }

        if (target == null) {
            System.out.println("Audit result with the account number " + accNum + " not found");
            return;
        }

        // 1. 修改风险等级
        System.out.println("Current Risk Level: " + target.getRiskLevel());
        System.out.print("Enter the new risk level (Press ENTER to skip): ");
        String newLevelStr = scanner.nextLine();
        if (!newLevelStr.isEmpty()) {
            try {
                int newLevel = Integer.parseInt(newLevelStr);
                if (newLevel >= 0 && newLevel <= 5) {
                    target.setRiskLevel(newLevel);
                    System.out.println("Risk Level updated successfully");
                } else {
                    System.out.println("Invalid risk level, skipped.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, skipped.");
            }
        }

        // 2. 修改风险标题
        System.out.println("Current Risk Title: " + target.getRiskTitle());
        System.out.print("Enter the new risk title (Press ENTER to skip): ");
        String newTitle = scanner.nextLine();
        if (!newTitle.isEmpty()) {
            target.setRiskTitle(newTitle);
            System.out.println("Risk Title updated successfully");
        }

        // 3. 修改操作建议
        System.out.println("Current Action To Take: " + target.getActionToTake());
        System.out.print("Enter the new action to take (Press ENTER to skip): ");
        String newAction = scanner.nextLine();
        if (!newAction.isEmpty()) {
            target.setActionToTake(newAction);
            System.out.println("Action To Take updated successfully");
        }
    }


    private void deleteAuditResult(LinkedList<AuditResults> list) {
        if (list.isEmpty()) {
            System.out.println("No audit results found. Please generate results first.");
            return;
        }

        System.out.print("Enter the account number to delete: ");
        String accNum = scanner.nextLine();

        boolean removed = false;
        // 用迭代器安全删除元素，避免并发修改异常
        var iterator = list.iterator();
        while (iterator.hasNext()) {
            AuditResults result = iterator.next();
            if (result.getAccountNumber().equals(accNum)) {
                iterator.remove();
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Audit result for the account number " + accNum + " deleted successfully");
        } else {
            System.out.println("Audit result with the account number " + accNum + " not found");
        }
    }
}