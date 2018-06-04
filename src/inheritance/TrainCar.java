package inheritance;

public class TrainCar {
	
	private int tare;
	private int weight = 0;
	
	public TrainCar(int tare) {
		this.tare = tare;
	}
	
	public int getTotalWeight() {
		return weight + tare;
	}
	
	public void  setDeadWeight(int tare) {
		this.tare = tare;
	}
	
	public int getDeadWeight() {
		return this.tare;
	}

}
