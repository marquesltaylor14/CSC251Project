public class Policy {
    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;

    private static int policyCount = 0;

    /**
     * No-arg constructor.
     */
    public Policy() {
        policyNumber = 0;
        providerName = "";
        policyHolder = new PolicyHolder();
        policyCount++;
    }

    /**
     * Constructor with arguments.
     */
    public Policy(int policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;

        // Defensive copy (minimizes aggregate-class security risks)
        if (policyHolder == null) {
            this.policyHolder = new PolicyHolder();
        } else {
            this.policyHolder = new PolicyHolder(policyHolder);
        }

        policyCount++;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * Returns a copy of the PolicyHolder object (defensive copy).
     */
    public PolicyHolder getPolicyHolder() {
        return new PolicyHolder(policyHolder);
    }

    /**
     * Stores a copy of the passed PolicyHolder object (defensive copy).
     */
    public void setPolicyHolder(PolicyHolder policyHolder) {
        if (policyHolder == null) {
            this.policyHolder = new PolicyHolder();
        } else {
            this.policyHolder = new PolicyHolder(policyHolder);
        }
    }

    /**
     * Returns number of Policy objects created.
     */
    public static int getPolicyCount() {
        return policyCount;
    }

    /**
     * Calculates policy price.
     */
    public double calculatePolicyPrice() {
        double price = 600.0;

        if (policyHolder.getPolicyholderAge() > 50) {
            price += 75.0;
        }

        if (policyHolder.getPolicyholderSmokingStatus() != null &&
            policyHolder.getPolicyholderSmokingStatus().equalsIgnoreCase("smoker")) {
            price += 100.0;
        }

        double bmi = policyHolder.calculateBMI();
        if (bmi > 35.0) {
            price += (bmi - 35.0) * 20.0;
        }

        return price;
    }

    /**
     * Returns a formatted string containing policy information.
     * Includes policyholder information by calling policyHolder.toString().
     */
    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + "\n"
             + "Provider Name: " + providerName + "\n"
             + policyHolder.toString() + "\n"
             + String.format("Policy Price: $%.2f", calculatePolicyPrice());
    }
}
