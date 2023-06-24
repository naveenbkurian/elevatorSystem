package elevator.services;

import elevator.entity.ElevatorCar;
import elevator.entity.ElevatorSystem;
import elevator.requests.Request;

import java.util.List;

public class ElevatorDispatcherStrategyX implements ElevatorDispatcherInterface{
    int k = 0;

    @Override
    public ElevatorCar getOptimalCar(ElevatorSystem elevatorSystem, Request request) {
        // modulus round robin
        int n =k % 4;
        k++;

        return elevatorSystem.getCars().get(n); //n
    }
}
