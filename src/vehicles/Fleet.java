package vehicles;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private List<MotorVehicle> vehicles;

    public Fleet() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(MotorVehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(String licensePlate) {
        vehicles.removeIf(vehicle -> vehicle.licensePlate.equals(licensePlate));
    }

    public MotorVehicle findVehicle(String licensePlate) {
        for (MotorVehicle vehicle : vehicles) {
            if (vehicle.licensePlate.equals(licensePlate)) {
                return vehicle;
            }
        }
        return null;
    }

    public void displayAllVehicles() {
        if(vehicles.size()==0) {
        	System.out.println("NO records found");
        }
        else {
        	for (MotorVehicle vehicle : vehicles) {
                vehicle.displayDetails();
                System.out.println();
            }
        }
    }
}
