package vehicles;

public class Truck extends MotorVehicle {
    private double loadCapacity;

    public Truck(String licensePlate, String model, double fuelLevel, double loadCapacity,String enginestatus) {
        super(licensePlate, model, fuelLevel,enginestatus);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayDetails() {
        System.out.println("Truck Details:");
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Model: " + model);
        System.out.println("Fuel Level: " + fuelLevel);
        System.out.println("Engine Status: " + enginestatus);
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}
