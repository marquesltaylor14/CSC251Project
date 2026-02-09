/**
 * Models an insurance policy for one person.
 */
public class Policy {
    private int policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String policyholderSmokingStatus; // "smoker" or "non-smoker"
    private double policyholderHeight;        // inches
    private double policyholderWeight;        // pounds

    /**
     * No-arg constructor that sets default values for all fields.
     */
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

    /**
     * Constructor that initializes a Policy object using all required field values.
     *
     * @param policyNumber the policy number
     * @param providerName the provider name
     * @param policyholderFirstName the policyholder's first name
     * @param policyholderLastName the policyholder's last name
     * @param policyholderAge the policyholder's age
     * @param policyholderSmokingStatus the policyholder's smoking status ("smoker" or "non-smoker")
     * @param policyholderHeight the policyholder's height in inches
     * @param policyholderWeight the policyholder's weight in pounds
     */
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

    /**
     * Gets the policy number.
     *
     * @return the policy number
     */
    public int getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Sets the policy number.
     *
     * @param policyNumber the policy number
     */
    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * Gets the provider name.
     *
     * @return the provider name
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Sets the provider name.
     *
     * @param providerName the provider name
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * Gets the policyholder's first name.
     *
     * @return the policyholder's first name
     */
    public String getPolicyholderFirstName() {
        return policyholderFirstName;
    }

    /**
     * Sets the policyholder's first name.
     *
     * @param policyholderFirstName the policyholder's first name
     */
    public void setPolicyholderFirstName(String policyholderFirstName) {
        this.policyholderFirstName = policyholderFirstName;
    }

    /**
     * Gets the policyholder's last name.
     *
     * @return the policyholder's last name
     */
    public String getPolicyholderLastName() {
        return policyholderLastName;
    }

    /**
     * Sets the policyholder's last name.
     *
     * @param policyholderLastName the policyholder's last name
     */
    public void setPolicyholderLastName(String policyholderLastName) {
        this.policyholderLastName = policyholderLastName;
    }

    /**
     * Gets the policyholder's age.
     *
     * @return the policyholder's age
     */
    public int getPolicyholderAge() {
        return policyholderAge;
    }

    /**
     * Sets the policyholder's age.
     *
     * @param policyholderAge the policyholder's age
     */
    public void setPolicyholderAge(int policyholderAge) {
        this.policyholderAge = policyholderAge;
    }

    /**
     * Gets the policyholder's smoking status.
     *
     * @return the smoking status ("smoker" or "non-smoker")
     */
    public String getPolicyholderSmokingStatus() {
        return policyholderSmokingStatus;
    }

    /**
     * Sets the policyholder's smoking status.
     *
     * @param policyholderSmokingStatus the smoking status ("smoker" or "non-smoker")
     */
    public void setPolicyholderSmokingStatus(String policyholderSmokingStatus) {
        this.policyholderSmokingStatus = policyholderSmokingStatus;
    }

    /**
     * Gets the policyholder's height in inches.
     *
     * @return the height in inches
     */
    public double getPolicyholderHeight() {
        return policyholderHeight;
    }

    /**
     * Sets the policyholder's height in inches.
     *
     * @param policyholderHeight the height in inches
     */
    public void setPolicyholderHeight(double policyholderHeight) {
        this.policyholderHeight = policyholderHeight;
    }

    /**
     * Gets the policyholder's weight in pounds.
     *
     * @return the weight in pounds
     */
    public double getPolicyholderWeight() {
        return policyholderWeight;
    }

    /**
     * Sets the policyholder's weight in pounds.
     *
     * @param policyholderWeight the weight in pounds
     */
    public void setPolicyholderWeight(double policyholderWeight) {
        this.policyholderWeight = policyholderWeight;
    }

    /**
     * Calculates and returns the BMI of the policyholder.
     * BMI = (weight * 703) / (height^2)
     *
     * @return the calculated BMI
     */
    public double calculateBMI() {
        if (policyholderHeight <= 0) {
            return 0.0;
        }
        return (policyholderWeight * 703.0) / (policyholderHeight * policyholderHeight);
    }

    /**
     * Calculates and returns the price of the insurance policy based on the rules provided.
     *
     * @return the calculated policy price
     */
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
