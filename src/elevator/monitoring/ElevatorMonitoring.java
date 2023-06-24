package elevator.monitoring;

import elevator.entity.ElevatorCar;
import elevator.entity.ElevatorSystem;

import java.util.Map;

public class ElevatorMonitoring implements ElevatorMonitoringInterface{

    @Override
    public Map<Integer, Integer> displayElevatorStates(ElevatorSystem system){
        //current floors of each car

        for(ElevatorCar car: system.getCars()){
            System.out.println("Elevator Id: "+ car.getId() + " : Elevator is currently at: "+ car.getCurrentFloor());
        }
        return null;
    }

    //fn to show button direction as well

}
