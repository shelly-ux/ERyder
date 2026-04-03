public class AuditResults {
    private String accountNumber;
    private int frequencyRating;
    private int amountRating;
    private int locationRating;
    private int oddHourRating;
    private int compositeRating;
    private int riskLevel;
    private String riskTitle;
    private String actionToTake;

    public AuditResults() {}

    public AuditResults(String accountNumber, int frequencyRating, int amountRating,
                        int locationRating, int oddHourRating, int compositeRating,
                        int riskLevel, String riskTitle, String actionToTake) {
        this.accountNumber = accountNumber;
        this.frequencyRating = frequencyRating;
        this.amountRating = amountRating;
        this.locationRating = locationRating;
        this.oddHourRating = oddHourRating;
        this.compositeRating = compositeRating;
        this.riskLevel = riskLevel;
        this.riskTitle = riskTitle;
        this.actionToTake = actionToTake;
    }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public int getFrequencyRating() { return frequencyRating; }
    public void setFrequencyRating(int frequencyRating) { this.frequencyRating = frequencyRating; }

    public int getAmountRating() { return amountRating; }
    public void setAmountRating(int amountRating) { this.amountRating = amountRating; }

    public int getLocationRating() { return locationRating; }
    public void setLocationRating(int locationRating) { this.locationRating = locationRating; }

    public int getOddHourRating() { return oddHourRating; }
    public void setOddHourRating(int oddHourRating) { this.oddHourRating = oddHourRating; }

    public int getCompositeRating() { return compositeRating; }
    public void setCompositeRating(int compositeRating) { this.compositeRating = compositeRating; }

    public int getRiskLevel() { return riskLevel; }
    public void setRiskLevel(int riskLevel) { this.riskLevel = riskLevel; }

    public String getRiskTitle() { return riskTitle; }
    public void setRiskTitle(String riskTitle) { this.riskTitle = riskTitle; }

    public String getActionToTake() { return actionToTake; }
    public void setActionToTake(String actionToTake) { this.actionToTake = actionToTake; }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
                "\nFrequency Rating: " + frequencyRating +
                "\nAmount Rating: " + amountRating +
                "\nLocation Rating: " + locationRating +
                "\nOdd Hour Rating: " + oddHourRating +
                "\nComposite Rating: " + compositeRating +
                "\nRisk Level: " + riskLevel +
                "\nRisk Title: " + riskTitle +
                "\nAction To Take: " + actionToTake + "\n";
    }
}