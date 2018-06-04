package inheritance;

public class CargoCar extends TrainCar{
	private int cargo;
	private int tare;

	public CargoCar(int tare, int cargo) {
		super(tare);
		this.tare = tare;
		this.cargo = cargo;
		
	}
	
	public int getCargoWeight() {
		return cargo;
	}
	
	public void setCargoWeight(int cargo) {
		this.cargo = cargo;
	}
	
	@Override
	public int getTotalWeight() {
		return this.cargo + this.tare;
	}

}
