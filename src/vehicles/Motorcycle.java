package vehicles;

public class Motorcycle extends MotorVehicle {
    private boolean hasSidecar;

    public Motorcycle(String licensePlate, String model, double fuelLevel, boolean hasSidecar,String enginestatus) {
        super(licensePlate, model, fuelLevel,enginestatus);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void displayDetails() {
        System.out.println("Motorcycle Details:");
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Model: " + model);
        System.out.println("Fuel Level: " + fuelLevel);
        System.out.println("Engine Status: " + enginestatus);
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
    }
}
