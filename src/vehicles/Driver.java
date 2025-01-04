package vehicles;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    private String name;
    private String driverId;
    private List<MotorVehicle> assignedVehicles = new ArrayList<>();

    public Driver(String name, String driverId) {
        this.name = name;
        this.driverId = driverId;
    }

    public void assignVehicle(MotorVehicle vehicle) {
    	
        if (!assignedVehicles.contains(vehicle)) {
            assignedVehicles.add(vehicle);
            System.out.println("Vehicle " + vehicle.licensePlate + " assigned to driver " + name);
        } else {
            System.out.println("Vehicle " + vehicle.licensePlate + " is already assigned to driver " + name);
        }
    }

    public void unassignVehicle(MotorVehicle vehicle) {
        if (assignedVehicles.remove(vehicle)) {
            System.out.println("Vehicle " + vehicle.licensePlate + " unassigned from driver " + name);
        } else {
            System.out.println("Vehicle " + vehicle.licensePlate + " is not assigned to driver " + name);
        }
    }

    public void displayAssignedVehicles() {
        System.out.println("Driver: " + name + " (ID: " + driverId + ")");
        if (assignedVehicles.isEmpty()) {
            System.out.println("No vehicles assigned.");
        } 
        else {
            for (MotorVehicle vehicle : assignedVehicles) {
                vehicle.displayDetails();
            }
        }
    }
}