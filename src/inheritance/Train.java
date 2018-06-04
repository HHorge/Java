package inheritance;

import java.util.ArrayList;

public class Train {
	
	ArrayList<TrainCar> trainCars = new ArrayList<>();
	
	void addTrainCar(TrainCar tc) {
		trainCars.add(tc);
	}
	
	public boolean contains(TrainCar tc) {
		return trainCars.contains(tc);
	}
	
	public int getTotalWeight() {
		int totalWeight = 0;
		
		for(TrainCar car: trainCars) {
			totalWeight += car.getTotalWeight();
		}
		return totalWeight;
	}
	
	public int getPassengerCount() {
		int passengers = 0;
		
		for (TrainCar car : trainCars) {
			if(car instanceof PassengerCar) {
				passengers += ((PassengerCar) car).getPassengerCount();			
				}
				
		}
		
		return passengers;
	}
	
	public int getCargoWeight() {
		int cargo = 0;
		
		for(TrainCar car: trainCars) {
			if(car instanceof CargoCar) {
				cargo += ((CargoCar) car).getCargoWeight();
			}
		}
		
		return cargo;
	}
	
	public String toString() {
		for(TrainCar car: trainCars) {
			if(car instanceof PassengerCar) {
				return "Passenger car, with weight "+car.getTotalWeight()+" and " + ((PassengerCar) car).getPassengerCount() + "passengers ";
			}else if(car instanceof CargoCar){
				return "Cargo car, with weight " + car.getTotalWeight();
			}
		}
		return "This train has no cars attached";
		
	}
	
	
	public static void main(String[] args) {
		
	}

}
