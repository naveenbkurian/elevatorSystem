package elevator.services;

import elevator.entity.ElevatorCar;
import elevator.entity.ElevatorSystem;
import elevator.requests.Request;

import java.util.List;

public interface ElevatorDispatcherInterface {

    ElevatorCar getOptimalCar(ElevatorSystem elevatorSystem, Request request);
}
