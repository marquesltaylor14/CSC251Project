public class PolicyHolder {
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus; // "smoker" or "non-smoker"
    private double height;        // inches
    private double weight;        // pounds

    /**
     * No-arg constructor.
     */
    public PolicyHolder() {
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    /**
     * Constructor with arguments.
     */
    public PolicyHolder(String firstName, String lastName, int age,
                        String smokingStatus, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Copy constructor (helps reduce security risks with aggregate classes).
     */
    public PolicyHolder(PolicyHolder other) {
        if (other == null) {
            firstName = "";
            lastName = "";
            age = 0;
            smokingStatus = "non-smoker";
            height = 0.0;
            weight = 0.0;
        } else {
            firstName = other.firstName;
            lastName = other.lastName;
            age = other.age;
            smokingStatus = other.smokingStatus;
            height = other.height;
            weight = other.weight;
        }
    }

    // Getters and setters
    public String getPolicyholderFirstName() {
        return firstName;
    }

    public void setPolicyholderFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPolicyholderLastName() {
        return lastName;
    }

    public void setPolicyholderLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPolicyholderAge() {
        return age;
    }

    public void setPolicyholderAge(int age) {
        this.age = age;
    }

    public String getPolicyholderSmokingStatus() {
        return smokingStatus;
    }

    public void setPolicyholderSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public double getPolicyholderHeight() {
        return height;
    }

    public void setPolicyholderHeight(double height) {
        this.height = height;
    }

    public double getPolicyholderWeight() {
        return weight;
    }

    public void setPolicyholderWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Calculates BMI.
     */
    public double calculateBMI() {
        if (height <= 0) {
            return 0.0;
        }
        return (weight * 703.0) / (height * height);
    }

    /**
     * Returns a formatted string containing policyholder information.
     */
    @Override
    public String toString() {
        return "Policyholder's First Name: " + firstName + "\n"
             + "Policyholder's Last Name: " + lastName + "\n"
             + "Policyholder's Age: " + age + "\n"
             + "Policyholder's Smoking Status: " + smokingStatus + "\n"
             + "Policyholder's Height: " + height + "\n"
             + "Policyholder's Weight: " + weight + "\n"
             + String.format("Policyholder's BMI: %.2f", calculateBMI());
    }
}
