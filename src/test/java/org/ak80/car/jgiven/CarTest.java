package org.ak80.car.jgiven;

import com.tngtech.jgiven.junit5.ScenarioTest;
import org.ak80.car.Obstacle;
import org.ak80.car.TrafficLight;
import org.ak80.car.jgiven.stages.GivenCar;
import org.ak80.car.jgiven.stages.ThenCar;
import org.ak80.car.jgiven.stages.WhenCar;
import org.junit.jupiter.api.Test;

import static org.ak80.car.Car.State.*;

class CarTest extends ScenarioTest<GivenCar, WhenCar, ThenCar> {

    @Test
    void when_a_driver_sees_a_person_the_car_is_braking() {
        given().a_car_is_driving();

        when().the_driver_sees_a_$_obstacle(Obstacle.PERSON);

        then().the_car_is_$state(BRAKING);
    }

    @Test
    void when_a_driver_sees_an_animal_the_car_is_braking() {
        given().a_car_is_driving();

        when().the_driver_sees_an_$_obstacle(Obstacle.ANIMAL);

        then().the_car_is_$state(BRAKING);
    }

    @Test
    void when_a_driver_sees_a_rock_the_car_is_evading() {
        given().a_car_is_driving();

        when().the_driver_sees_a_$_obstacle(Obstacle.ROCK);

        then().the_car_is_$state(EVADING);
    }

    @Test
    void when_a_driver_come_to_a_green_traffic_light() {
        given().a_car_is_driving();

        when().the_driver_comes_to_a_$_color_traffic_light(TrafficLight.Color.GREEN);

        then().the_car_is_$state(DRIVING);
    }

    @Test
    void when_a_driver_come_to_a_yellow_traffic_light() {
        given().a_car_is_driving();

        when().the_driver_comes_to_a_$_color_traffic_light(TrafficLight.Color.YELLOW);

        then().the_car_is_$state(BRAKING);
    }

    @Test
    void when_a_driver_come_to_a_red_traffic_light() {
        given().a_car_is_driving();

        when().the_driver_comes_to_a_$_color_traffic_light(TrafficLight.Color.RED);

        then().the_car_is_$state(BRAKING);
    }

    @Test
    void when_a_driver_waits_at_a_red_traffic_light_and_it_stays_red_he_waits() {
        given().a_car_at_a_traffic_light();

        when().the_traffic_light_is(TrafficLight.Color.RED);

        then().the_car_is_$state(STOPPED);
    }

    @Test
    void when_a_driver_waits_at_a_red_traffic_light_and_it_turns_yellow_he_drives() {
        given().a_car_at_a_traffic_light();

        when().the_traffic_light_is(TrafficLight.Color.YELLOW);

        then().the_car_is_$state(DRIVING);
    }

    @Test
    void when_a_driver_waits_at_a_red_traffic_light_and_it_turns_green_he_drives() {
        given().a_car_at_a_traffic_light();

        when().the_traffic_light_is(TrafficLight.Color.GREEN);

        then().the_car_is_$state(DRIVING);
    }

}
