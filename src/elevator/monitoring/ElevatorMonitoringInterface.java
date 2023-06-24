package elevator.monitoring;

import elevator.entity.ElevatorSystem;

import java.util.Map;

public interface ElevatorMonitoringInterface {
    Map<Integer, Integer> displayElevatorStates(ElevatorSystem system);
}
