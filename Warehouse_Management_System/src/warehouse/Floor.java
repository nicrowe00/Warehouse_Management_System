package warehouse;

public class Floor {
    private int floorNumber;
    private String securityLevel;
    private double floorTemperature;
    LinkedLists<Aisle> aisleLinkedLists = new LinkedLists<>();


    //Constructor
    public Floor(int floorNumber, String securityLevel, double floorTemperature) {
        this.floorNumber = floorNumber;
        this.securityLevel = securityLevel;
        this.floorTemperature = floorTemperature;
    }

    //Getters and Setters
    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }

    public double getFloorTemperature() {
        return floorTemperature;
    }

    public void setFloorTemperature(double floorTemperature) {
        this.floorTemperature = floorTemperature;
    }

    @Override
    public String toString() {
        return "Floor number: " + getFloorNumber() + ", Security Level: " + getSecurityLevel() + " and Floor Temperature: " + getFloorTemperature() + " Celsius" + "\n";
    }

    public String toString1(){
        return "Floor " + floorNumber;
    }
}