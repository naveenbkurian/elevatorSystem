package elevator.services;

import elevator.entity.Direction;
import elevator.entity.ElevatorCar;
import elevator.entity.ElevatorSystem;
import elevator.requests.Request;

import java.util.List;
import java.util.stream.Collectors;

public class ElevatorDispatcherStrategyY implements ElevatorDispatcherInterface{

    @Override
    public ElevatorCar getOptimalCar(ElevatorSystem elevatorSystem, Request request) {
        // find using direction and Location
        List<ElevatorCar> filteredCars = elevatorSystem.getCars().stream()
                .filter(car -> car.getDirection() == request.direction)
                .collect(Collectors.toList());


        return filteredCars.get(0);
    }
}
