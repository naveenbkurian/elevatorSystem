package elevator.services;

import elevator.entity.Direction;
import elevator.entity.ElevatorCar;
import elevator.entity.ElevatorSystem;
import elevator.requests.Request;

public class ElevatorService {

    private static ElevatorService elevatorService = null;
    private ElevatorSystem elevatorSystem;
    private ElevatorDispatcherInterface dispatcher;

    private ElevatorService(ElevatorSystem elevatorSystem){
        this.elevatorSystem = elevatorSystem;
        this.dispatcher = new ElevatorDispatcherStrategyX();

    }

    public static ElevatorService getInstance(ElevatorSystem elevatorSystem){
        if(elevatorService == null){
            elevatorService = new ElevatorService(elevatorSystem);
        }
        return elevatorService;
    }

    //initialize Elevators

    public boolean processElevatorRequest(Request request){
      //  dispatcher = new ElevatorDispatcherStrategyX();
        ElevatorCar car = dispatcher.getOptimalCar(elevatorSystem, request);
        if(request.direction == Direction.UP ) car.sendUpRequest(request);
        else car.sendDownRequest(request);
        return true;
    }

}
