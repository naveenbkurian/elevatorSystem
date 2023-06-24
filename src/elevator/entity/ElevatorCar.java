package elevator.entity;

import elevator.requests.Request;

import java.util.PriorityQueue;

public class ElevatorCar {
    int id;
    int currentFloor;
    Direction direction;
    DoorState doorState;
    PriorityQueue<Request> upQueue;
    PriorityQueue<Request> downQueue;

    public ElevatorCar(int id, int currentFloor) {
        this.id = id;
        this.currentFloor = currentFloor;

        this.direction = Direction.IDLE;

        this.doorState = DoorState.CLOSED;

        //min heap
        upQueue = new PriorityQueue<>((a, b) -> a.desiredFloor - b.desiredFloor);

        //max heap
        downQueue =  new PriorityQueue<>((a, b) -> b.desiredFloor - a.desiredFloor);
    }

    public void processRequests(){
        if(direction == Direction.UP || direction == Direction.IDLE){
            processUpRequests();
            processDownRequests();
        }
        else {
            processDownRequests();
            processUpRequests();
        }
    }


    private void processUpRequests() {
        while (!upQueue.isEmpty()) {
            Request upRequest = upQueue.poll();
            this.currentFloor = upRequest.desiredFloor;
        }
        if (!downQueue.isEmpty()) {
            this.direction = Direction.DOWN;
        } else {
            this.direction = Direction.IDLE;
        }
    }

    private void processDownRequests() {
        while (!downQueue.isEmpty()) {
            Request downRequest = downQueue.poll();
            this.currentFloor = downRequest.desiredFloor;
            // notify
        }
        if (!upQueue.isEmpty()) {
            this.direction = Direction.UP;
        } else {
            this.direction = Direction.IDLE;
        }
    }

    public void sendUpRequest(Request upRequest) {
        if (upRequest.location == Location.OUTSIDE) {
            upQueue.offer(new Request(upRequest.currentFloor,
                    upRequest.currentFloor,
                    Direction.UP,
                    Location.OUTSIDE));

        }
        //go
        upQueue.offer(upRequest);

    }

    public void sendDownRequest(Request downRequest) {
        if (downRequest.location == Location.OUTSIDE) {
            downQueue.offer(new Request(downRequest.currentFloor,
                    downRequest.currentFloor,
                    Direction.DOWN,
                    Location.OUTSIDE));

        }
        downQueue.offer(downRequest);
    }

    public void run() {
        while (!upQueue.isEmpty() || !downQueue.isEmpty()) {
            processRequests();
        }

        System.out.println("done with all requests.");
        this.direction = Direction.IDLE;
    }

    public int getUpQueueSize(){
        return upQueue.size();
    }

    public int getDownQueueSize(){
        return downQueue.size();
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }
}
