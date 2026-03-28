public enum RiskEnum {
    NO_RISK(0, "No Risk", "There's no risk detected. No action required"),
    NEGLIGIBLE_RISK(1, "Negligible Risk", "Very likely false positive. No action required"),
    LOW_RISK(2, "Low Risk", "Only traces of suspicious activity. Monitor the account on occasion"),
    MEDIUM_RISK(3, "Medium Risk", "Increasingly suspicious activity. Consider contacting the account holder for verification"),
    HIGH_RISK(4, "High Risk", "Suspicious activity at an alarming frequency. Contact the account holder for on-site verification and inform them of 'account freezing' possibility");

    private final int level;
    private final String title;
    private final String action;
    
    RiskEnum(int level, String title, String action) {
        this.level = level;
        this.title = title;
        this.action = action;
    }
    
    public int getLevel() {
        return level;
    }

    public String getTitle() {
        return title;
    }

    public String getAction() {
        return action;
    }
    
    public static RiskEnum fromCompositeRating(int compositeRating) {
        if (compositeRating == 0) {
            return NO_RISK;
        } else if (compositeRating <= 5) {
            return NEGLIGIBLE_RISK;
        } else if (compositeRating <= 10) {
            return LOW_RISK;
        } else if (compositeRating <= 15) {
            return MEDIUM_RISK;
        } else {
            return HIGH_RISK;
        }
    }
}