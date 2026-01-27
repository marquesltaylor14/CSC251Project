public class Policy {
    private int policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String policyholderSmokingStatus; // "smoker" or "non-smoker"
    private double policyholderHeight;        // inches
    private double policyholderWeight;        // pounds

    // No-arg constructor (default values)
    public Policy() {
        policyNumber = 0;
        providerName = "";
        policyholderFirstName = "";
        policyholderLastName = "";
        policyholderAge = 0;
        policyholderSmokingStatus = "non-smoker";
        policyholderHeight = 0.0;
        policyholderWeight = 0.0;
    }

    // Constructor with arguments (fully initializes Policy)
    public Policy(int policyNumber,
                  String providerName,
                  String policyholderFirstName,
                  String policyholderLastName,
                  int policyholderAge,
                  String policyholderSmokingStatus,
                  double policyholderHeight,
                  double policyholderWeight) {

        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = policyholderFirstName;
        this.policyholderLastName = policyholderLastName;
        this.policyholderAge = policyholderAge;
        this.policyholderSmokingStatus = policyholderSmokingStatus;
        this.policyholderHeight = policyholderHeight;
        this.policyholderWeight = policyholderWeight;
    }

    // Getters and setters
    public int getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }

    public String getProviderName() { return providerName; }
    public void setProviderName(String providerName) { this.providerName = providerName; }

    public String getPolicyholderFirstName() { return policyholderFirstName; }
    public void setPolicyholderFirstName(String policyholderFirstName) { this.policyholderFirstName = policyholderFirstName; }

    public String getPolicyholderLastName() { return policyholderLastName; }
    public void setPolicyholderLastName(String policyholderLastName) { this.policyholderLastName = policyholderLastName; }

    public int getPolicyholderAge() { return policyholderAge; }
    public void setPolicyholderAge(int policyholderAge) { this.policyholderAge = policyholderAge; }

    public String getPolicyholderSmokingStatus() { return policyholderSmokingStatus; }
    public void setPolicyholderSmokingStatus(String policyholderSmokingStatus) { this.policyholderSmokingStatus = policyholderSmokingStatus; }

    public double getPolicyholderHeight() { return policyholderHeight; }
    public void setPolicyholderHeight(double policyholderHeight) { this.policyholderHeight = policyholderHeight; }

    public double getPolicyholderWeight() { return policyholderWeight; }
    public void setPolicyholderWeight(double policyholderWeight) { this.policyholderWeight = policyholderWeight; }

    // BMI = (Weight * 703) / (Height^2)
    public double calculateBMI() {
        if (policyholderHeight <= 0) {
            return 0.0; // avoids divide-by-zero / stale weirdness
        }
        return (policyholderWeight * 703.0) / (policyholderHeight * policyholderHeight);
    }

    // Price calculation rules
    public double calculatePolicyPrice() {
        double price = 600.0;

        if (policyholderAge > 50) {
            price += 75.0;
        }

        if (policyholderSmokingStatus != null &&
            policyholderSmokingStatus.equalsIgnoreCase("smoker")) {
            price += 100.0;
        }

        double bmi = calculateBMI();
        if (bmi > 35.0) {
            price += (bmi - 35.0) * 20.0;
        }

        return price;
    }
}

