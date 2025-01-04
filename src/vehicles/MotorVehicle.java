package vehicles;

public abstract class MotorVehicle implements Vehicle {
	protected String licensePlate;
	protected String model;
	protected double fuelLevel;
	protected String enginestatus;
	
	public MotorVehicle(String licensePlate, String model, double fuelLevel,String enginestatus) {
	    this.licensePlate = licensePlate;
	    this.model = model;
	    this.fuelLevel = fuelLevel;
	    this.enginestatus=enginestatus;
	}
	
	@Override
	public void startEngine() {
	    if (fuelLevel > 10) {
	        System.out.println("Engine started.");
	        enginestatus="on";
	    } 
	    else {
	        System.out.println("Cannot start engine. Fuel level is too low.");
	    }
	}
	
	@Override
	public void stopEngine() {
	    System.out.println("Engine stopped.");
	    enginestatus="off";
	}
	
	@Override
	public void refuel(int amount) {
	    if(amount<200 && amount>10) {
	    	this.fuelLevel += amount;
		    System.out.println("Refueled " + amount + " units. Current fuel level: " + fuelLevel);
	    }
	    else if(amount>200) {
	    	System.out.println("ENTER BELOW 200 units");
	    }
	    else if(amount<10) {
	    	System.out.println("ENTER ABOVE 10 units");
	    }
	    }
	
	public abstract void displayDetails();
}
