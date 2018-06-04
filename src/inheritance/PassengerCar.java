package inheritance;

public class PassengerCar extends TrainCar{
	private int passengers;
	private int tare;
	
	public PassengerCar(int tare, int passengers) {
		super(tare);
		this.passengers = passengers;
		this.tare = tare;
	}
	
	public int getPassengerCount() {
		return passengers;
	}
	
	public void setPassengerCount(int passengers) {
		this.passengers = passengers;
	}
	
	@Override
	public int getTotalWeight() {
		return this.tare + (this.passengers*80);
	}


}
