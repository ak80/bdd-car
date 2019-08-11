package org.ak80.car.jgiven.stages;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExtendedDescription;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.ak80.car.Car;
import org.ak80.car.Driver;

public class GivenCar extends Stage<GivenCar> {

    @ProvidedScenarioState
    private Car car;

    @ProvidedScenarioState
    private Driver driver;


    @ExtendedDescription("An car with a driver in state driving")
    public GivenCar a_car_is_driving() {
        car = new Car();
        driver = new Driver();
        driver.drive(car);
        return this;
    }

    @ExtendedDescription("An car with a driver waiting at a traffic light")
    public GivenCar a_car_at_a_traffic_light() {
        car = new Car();
        driver = new Driver();
        driver.drive(car);
        car.stop();
        return this;
    }
}
