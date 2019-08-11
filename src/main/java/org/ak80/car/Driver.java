package org.ak80.car;

public class Driver {

    private Car car;

    public Driver() {

    }

    public void drive(Car car) {
        this.car = car;
        car.drive();
    }

    public void reactToSeeing(StreetObject streetObject) {
        if (streetObject instanceof TrafficLight) {
            evaluateTrafficLight((TrafficLight) streetObject);
        } else if (streetObject instanceof Obstacle) {
            evaluateObstacle((Obstacle) streetObject);
        }
    }

    private void evaluateTrafficLight(TrafficLight trafficLight) {
        switch (trafficLight.getColor()) {
            case RED:
                if (car.isDriving()) {
                    car.brake();
                }
                break;
            case YELLOW:
                if (car.isDriving()) {
                    car.brake();
                } else {
                    car.drive();
                }
                break;
            case GREEN:
                car.drive();
                break;
            default:
                throw new IllegalStateException("Unknown traffic light color " + trafficLight.getColor());

        }
    }

    private void evaluateObstacle(Obstacle obstacle) {
        switch (obstacle) {
            case ROCK:
                car.evading();
                break;
            default:
                car.brake();
        }
    }

}
