package vehicles;

public class Car extends MotorVehicle {
    private int numberOfDoors;

    public Car(String licensePlate, String model, double fuelLevel, int numberOfDoors,String enginestatus) {
        super(licensePlate, model, fuelLevel,enginestatus);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Model: " + model);
        System.out.println("Fuel Level: " + fuelLevel);
        System.out.println("Engine Status: " + enginestatus);
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}
