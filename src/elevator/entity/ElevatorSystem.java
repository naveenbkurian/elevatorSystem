package elevator.entity;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    List<ElevatorCar> cars = new ArrayList<>();

    public ElevatorSystem() {
    }

    public void addCar(ElevatorCar car){
        cars.add(car);
    }

    public List<ElevatorCar> getCars() {
        return cars;
    }

    public void setCars(List<ElevatorCar> cars) {
        this.cars = cars;
    }

    public void startSystem(){
        for(ElevatorCar car: cars){
            car.run();
        }
    }


}
