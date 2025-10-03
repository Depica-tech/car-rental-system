public class car {
    private String licensePlate;
    private String model;
    private boolean isAvailable;

    public car(String licensePlate, String model) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.isAvailable = true;
    }

    public String getLicensePlate() { return licensePlate; }
    public String getModel() { return model; }
    public boolean isAvailable() { return isAvailable; }

    public void rentOut() { isAvailable = false; }
    public void returnCar() { isAvailable = true; }

    @Override
    public String toString() {
        return model + " (" + licensePlate + ") - " + (isAvailable ? "Available" : "Rented");
    }
}