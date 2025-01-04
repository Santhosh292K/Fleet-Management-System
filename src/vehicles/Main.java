package vehicles;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Fleet fleet = new Fleet();
    private static Scanner obj = new Scanner(System.in);
    private static Driver driver = new Driver("Santhosh", "cse23047");

    public static void main(String[] args) {

        while (true) {
            showMenu();
            try {
                int choice = obj.nextInt();
                obj.nextLine();

                switch (choice) {
                    case 1:
                        addVehicle();
                        break;
                    case 2:
                        removeVehicle();
                        break;
                    case 3:
                        searchVehicle();
                        break;
                    case 4:
                        displayAllVehicles();
                        break;
                    case 5:
                        manageDrivers();
                        break;
                    case 6:
                        System.out.println("");
                        return; 
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                obj.nextLine();
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
            System.out.println("-----------------------------------------------------");
        }
    }

    private static void showMenu() {
        System.out.println("Vehicle Management System");
        System.out.println("1. Add Vehicle");
        System.out.println("2. Remove Vehicle");
        System.out.println("3. Search Vehicle");
        System.out.println("4. Display All Vehicles");
        System.out.println("5. Manage Drivers");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addVehicle() {
        while (true) {
            try {
                System.out.println("Select Vehicle Type:");
                System.out.println("1. Car");
                System.out.println("2. Truck");
                System.out.println("3. Motorcycle");
                System.out.println("4. Exit");

                int type = obj.nextInt();
                obj.nextLine(); 

                if (type < 1 || type > 4) {
                    System.out.println("Invalid vehicle type. Please try again.");
                    continue; // Retry on invalid vehicle type
                }
                
               String licensePlate="";
               String model="";
               double fuelLevel = 0;
               String enginestatus="off";
               if(type!=4) {
            	   while(true) {
                       System.out.print("Enter License Plate: ");
                       licensePlate = obj.nextLine();
                       licensePlate=licensePlate.toUpperCase();
                   	   if(licensePlate.length()>6) {
                   		if(!Character.isLetter(licensePlate.charAt(0))||!Character.isLetter(licensePlate.charAt(1))||!Character.isDigit(licensePlate.charAt(2))||!Character.isDigit(licensePlate.charAt(3))||!Character.isLetter(licensePlate.charAt(4))||!Character.isLetter(licensePlate.charAt(5))) {
                           	System.out.println("Please Enter a valid number plate");
                           	
                           }
                       	else {
                       		if (fleet.findVehicle(licensePlate) != null) {
                                   System.out.println("License plate already taken. Please enter a different one.");
                                   continue;
                               }
                       		else {
                       			break;
                       		}
                       	}
                   	   }
                   	   else {
                   		   System.out.println("Enter a valid number plate");
                   	   }
                   }
                   
                   System.out.print("Enter Model: ");
                   model = obj.nextLine();
                   while(true) {
                   	System.out.print("Enter Fuel Level: ");
                       fuelLevel = obj.nextDouble();
                       if(fuelLevel<0) {
                       	System.out.println("Enter a valid fuel level");
                       }
                       else {
                       	break;
                       }
                   }
                   obj.nextLine();
                   while(true) {
                     	System.out.print("Enter Engine Status: ");
                         enginestatus = obj.nextLine();
                         if(!enginestatus.equals("on")&& !enginestatus.equals("off")) {
                         	System.out.println("Enter a valid status");
                         }
                         else {
                         	break;
                         }
                     }

               }
               else {
            	 
               }
               
                switch (type) {
                    case 1:
                    	int numberOfDoors;
                        while(true) {
                        	System.out.print("Enter Number of Doors: ");
                            numberOfDoors = obj.nextInt();
                            if(numberOfDoors<0) {
                            	System.out.println("Enter a valid Number");
                            }
                            else {
                            	break;
                            }
                        }
                        fleet.addVehicle(new Car(licensePlate, model, fuelLevel,numberOfDoors, enginestatus));
                        break;
                    case 2:
                        
                        double loadCapacity;
                        while(true) {
                        	System.out.print("Enter Load Capacity (tons): ");
                            loadCapacity = obj.nextDouble();
                            if(loadCapacity<0) {
                            	System.out.println("Enter a valid Number");
                            }
                            else {
                            	break;
                            }
                        }
                        fleet.addVehicle(new Truck(licensePlate, model, fuelLevel,loadCapacity, enginestatus));
                        break;
                    case 3:
                        
                    	boolean hasSidecar;
                        while(true) {
                        	System.out.print("Does it have a sidecar? (true/false): ");
                            hasSidecar = obj.nextBoolean();
                            if(hasSidecar!=true&&hasSidecar!=false) {
                            	System.out.println("Enter a valid input");
                            }
                            else {
                            	break;
                            }
                        }
                        fleet.addVehicle(new Motorcycle(licensePlate, model, fuelLevel,hasSidecar, enginestatus));
                        break;
                    case 4:
                    	break;
                    default:
                        System.out.println("Invalid vehicle type. Please try again.");
                        continue; 
                }
                break;
            } 
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter the correct data type.");
                obj.nextLine();
            }
        }
    }

    private static void removeVehicle() {
        String licensePlate;
        while(true) {
        	System.out.print("Enter License Plate of the vehicle to remove: ");
            licensePlate = obj.nextLine();
            licensePlate=licensePlate.toUpperCase();
        	if(!Character.isLetter(licensePlate.charAt(0))||!Character.isLetter(licensePlate.charAt(1))||!Character.isDigit(licensePlate.charAt(2))||!Character.isDigit(licensePlate.charAt(3))||!Character.isLetter(licensePlate.charAt(4))||!Character.isLetter(licensePlate.charAt(5))) {
            	System.out.println("Please Enter a valid number plate");
            	
            }
        	else {
        		break;
        	}
        }
        fleet.removeVehicle(licensePlate);
        System.out.println("Vehicle removed.");
    }

    private static void searchVehicle() {
        
        String licensePlate;
        while(true) {
        	System.out.print("Enter License Plate of the vehicle to search: ");            
        	licensePlate = obj.nextLine();
            licensePlate=licensePlate.toUpperCase();
        	if(!Character.isLetter(licensePlate.charAt(0))||!Character.isLetter(licensePlate.charAt(1))||!Character.isDigit(licensePlate.charAt(2))||!Character.isDigit(licensePlate.charAt(3))||!Character.isLetter(licensePlate.charAt(4))||!Character.isLetter(licensePlate.charAt(5))) {
            	System.out.println("Please Enter a valid number plate");
            	
            }
        	else {
        		break;
        	}
        }
        MotorVehicle vehicle = fleet.findVehicle(licensePlate);
        if (vehicle != null) {
            vehicle.displayDetails();
        
        while(true) {
        	System.out.println("Manage the vehicle activities(Y/N)");
        	String chose = obj.nextLine();
        	chose=chose.toLowerCase();
        	if(chose.equals("y")) {
                System.out.println("1. START ENGINE");
                System.out.println("2. STOP ENGINE");
                System.out.println("3. REFUEL");
                System.out.println("4. Exit");
        		System.out.println("CHOOSE THE OPERATION");
                try {
                	int option = obj.nextInt();
                	obj.nextLine();
                	switch(option) {
                	case 1:
                		vehicle.startEngine();
                		break;
                	case 2:
                		vehicle.stopEngine();
                		break;
                	case 3:
                		System.out.println("ENTER REFUEL AMOUNT");
                		int amt = obj.nextInt();
                    	obj.nextLine();
                		vehicle.refuel(amt);
                		break;
                	case 4:
                		break;
                	default:
                		System.out.println("Enter a valid input");
                		continue;
                	}
                }
                catch(InputMismatchException e) {
                	
                }
        	}
        	else if(chose.equals("n")) {
        		break;
        	}
        	else {
        		System.out.println("Enter a valid input");
        	}
        }
        } 
        else {
            System.out.println("Vehicle not found.");
        }
        
    }

    private static void displayAllVehicles() {
        fleet.displayAllVehicles();
    }

    private static void manageDrivers() {
        while (true) {
            try {
                System.out.println("Driver Management");
                System.out.println("1. Assign Vehicle to Driver");
                System.out.println("2. Unassign Vehicle from Driver");
                System.out.println("3. Display Assigned Vehicles");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = obj.nextInt();
                obj.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        assignVehicleToDriver();
                        break;
                    case 2:
                        unassignVehicleFromDriver();
                        break;
                    case 3:
                        displayDriverAssignedVehicles();
                        break;
                    case 4:
                    	break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        continue; // Retry on invalid choice
                }
                break; // Exit loop on successful choice
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                obj.nextLine(); // consume invalid input
            }
        }
    }

    private static void assignVehicleToDriver() {
        try {

            System.out.print("Enter License Plate of the vehicle to assign: ");
            String licensePlate = obj.nextLine();
            licensePlate=licensePlate.toUpperCase();
            MotorVehicle vehicle = fleet.findVehicle(licensePlate);

            if (vehicle != null) {
                driver.assignVehicle(vehicle);
                System.out.println("Vehicle assigned to driver.");
            } else {
                System.out.println("Vehicle not found.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while assigning the vehicle: " + e.getMessage());
        }
    }

    private static void unassignVehicleFromDriver() {
        try {
           

            System.out.print("Enter License Plate of the vehicle to unassign: ");
            String licensePlate = obj.nextLine();
            licensePlate=licensePlate.toUpperCase();
            MotorVehicle vehicle = fleet.findVehicle(licensePlate);

            if (vehicle != null) {
                driver.unassignVehicle(vehicle);
                System.out.println("Vehicle unassigned from driver.");
            } else {
                System.out.println("Vehicle not found.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while unassigning the vehicle: " + e.getMessage());
        }
    }

    private static void displayDriverAssignedVehicles() {
        try {
            
            driver.displayAssignedVehicles();
        } 
        catch (Exception e) {
            System.out.println("An error occurred while displaying assigned vehicles: " + e.getMessage());
        }
    }
    
}
