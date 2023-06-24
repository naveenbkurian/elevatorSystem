import elevator.entity.Direction;
import elevator.entity.ElevatorCar;
import elevator.entity.ElevatorSystem;
import elevator.entity.Location;
import elevator.monitoring.ElevatorMonitoring;
import elevator.monitoring.ElevatorMonitoringInterface;
import elevator.requests.Request;
import elevator.services.ElevatorService;

public class Main {
    public static void main(String[] args) {
        int n = 4; // 4 elevators
        ElevatorSystem elevatorSystem = new ElevatorSystem();
        for(int i=0;i<n;i++){
            ElevatorCar car = new ElevatorCar(i, 0);
            elevatorSystem.addCar(car);
        }
        ElevatorService service = ElevatorService.getInstance(elevatorSystem);
        ElevatorMonitoringInterface monitoringInterface = new ElevatorMonitoring();
        Request request1 = new Request(0, 5, Direction.UP, Location.INSIDE);
        service.processElevatorRequest(request1);
        Request request2 = new Request(3, 3, Direction.UP, Location.OUTSIDE);
        service.processElevatorRequest(request2);
        Request request3 = new Request(2, 2, Direction.DOWN, Location.OUTSIDE);
        service.processElevatorRequest(request3);
        //can add them all to a queue
        elevatorSystem.startSystem(); // can keep polling for requests
        monitoringInterface.displayElevatorStates(elevatorSystem);
    }
}