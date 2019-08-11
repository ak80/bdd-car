package org.ak80.car.jbehave;

import org.ak80.car.Car;
import org.ak80.car.Driver;
import org.ak80.car.Obstacle;
import org.ak80.car.TrafficLight;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.assertj.core.api.Assertions.assertThat;

public class CarSteps {

    private Car car;
    private Driver driver;

    @Given("a car is $state")
    public void aCarIs(Car.State state) {
        car = new Car();
        driver = new Driver();
        driver.drive(car);
        switch (state) {
            case DRIVING:
                car.drive();
                break;
            case BRAKING:
                car.brake();
                break;
            case STOPPED:
                assert car.isStopped();
                break;
            default:
                throw new IllegalStateException("State " + state + " not mapped");
        }
    }

    @Given("a car waits at a traffic light")
    public void aCarIs() {
        car.stop();
    }

    @When("the driver sees a $obstacle")
    @Alias("the driver sees an $obstacle")
    public void theDriverSeesA(Obstacle obstacle) {
        driver.reactToSeeing(obstacle);
    }

    @When("the driver comes to a $color traffic light")
    @Alias("the traffic light is $color")
    public void theDriverComesToATrafficLightWithColor(TrafficLight trafficLight) {
        driver.reactToSeeing(trafficLight);
    }

    @Then("the car is $state")
    public void theCarIs(Car.State state) {
        switch (state) {
            case DRIVING:
                assertThat(car.isDriving()).isTrue();
                break;
            case BRAKING:
                assertThat(car.isBraking()).isTrue();
                break;
            case EVADING:
                assertThat(car.isEvading()).isTrue();
                break;
            case STOPPED:
                assertThat(car.isStopped()).isTrue();
                break;
            default:
                throw new IllegalStateException("State " + state + " not mapped");
        }
    }

}
