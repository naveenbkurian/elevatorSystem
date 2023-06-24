package elevator.requests;

import elevator.entity.Direction;
import elevator.entity.Floor;
import elevator.entity.Location;

public class Request {
  public  int  currentFloor;
  public   int desiredFloor;
  public  Direction direction;
  public Location location;

    public Request(int currentFloor, int desiredFloor, Direction direction, Location location) {
        this.currentFloor = currentFloor;
        this.desiredFloor = desiredFloor;
        this.direction = direction;
        this.location = location;
    }
}
