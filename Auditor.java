public class Auditor {
    private int frequencyRating;
    private int amountRating;
    private int locationRating;
    private int oddHourRating;
    private int compositeRating;
    private int riskLevel;
    private String riskTitle;
    private String actionToTake;

    public Auditor() {}

    public void auditTransactions(String accountNumber) {
        frequencyRating = (int) (Math.random() * 6);
        amountRating = (int) (Math.random() * 6);
        locationRating = (int) (Math.random() * 6);
        oddHourRating = (int) (Math.random() * 6);

        compositeRating = frequencyRating + amountRating + locationRating + oddHourRating;
        riskLevel = Math.min(5, compositeRating / 2);

        switch (riskLevel) {
            case 0:
                riskTitle = "No Risk";
                actionToTake = "No action required.";
                break;
            case 1:
                riskTitle = "Low Risk";
                actionToTake = "Monitor account periodically.";
                break;
            case 2:
                riskTitle = "Low-Medium Risk";
                actionToTake = "Review monthly transactions.";
                break;
            case 3:
                riskTitle = "Medium Risk";
                actionToTake = "Flag for further review.";
                break;
            case 4:
                riskTitle = "High Risk";
                actionToTake = "Contact account holder.";
                break;
            case 5:
                riskTitle = "Severe Risk";
                actionToTake = "Freeze account immediately.";
                break;
            default:
                riskTitle = "Unknown Risk";
                actionToTake = "Manual review required.";
        }
    }

    public int getFrequencyRating() { return frequencyRating; }
    public int getAmountRating() { return amountRating; }
    public int getLocationRating() { return locationRating; }
    public int getOddHourRating() { return oddHourRating; }
    public int getCompositeRating() { return compositeRating; }
    public int getRiskLevel() { return riskLevel; }
    public String getRiskTitle() { return riskTitle; }
    public String getActionToTake() { return actionToTake; }
}