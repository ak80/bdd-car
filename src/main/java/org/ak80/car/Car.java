package org.ak80.car;

import static org.ak80.car.Car.State.*;

public class Car {

    private State state;

    public Car() {
        this.state = STOPPED;
    }

    public void drive() {
        this.state = DRIVING;
    }

    public void brake() {
        this.state = BRAKING;
    }

    public void stop() {
        this.state = STOPPED;
    }

    public void evading() {
        this.state = EVADING;
    }

    public boolean isStopped() {
        return state == STOPPED;
    }

    public boolean isDriving() {
        return state == DRIVING;
    }

    public boolean isBraking() {
        return state == BRAKING;
    }

    public boolean isEvading() {
        return state == EVADING;
    }

    public enum State {

        STOPPED,
        DRIVING,
        BRAKING,
        EVADING,


    }


}
