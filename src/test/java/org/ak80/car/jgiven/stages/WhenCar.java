package org.ak80.car.jgiven.stages;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.ak80.car.Driver;
import org.ak80.car.Obstacle;
import org.ak80.car.TrafficLight;

public class WhenCar extends Stage<WhenCar> {

    @ExpectedScenarioState
    private Driver driver;

    public WhenCar the_driver_sees_a_$_obstacle(Obstacle obstacle) {
        driver.reactToSeeing(obstacle);
        return this;
    }

    public WhenCar the_driver_sees_an_$_obstacle(Obstacle obstacle) {
        return the_driver_sees_a_$_obstacle(obstacle);
    }

    public WhenCar the_driver_comes_to_a_$_color_traffic_light(TrafficLight.Color color) {
        return the_traffic_light_is(color);
    }

    public WhenCar the_traffic_light_is(TrafficLight.Color color) {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.setColor(color);
        driver.reactToSeeing(trafficLight);
        return this;
    }
}
