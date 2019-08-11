package org.ak80.car.jgiven.stages;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.ak80.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class ThenCar extends Stage<ThenCar> {

    @ExpectedScenarioState
    private Car car;

    public ThenCar the_car_is_$state(Car.State state) {
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

        return self();
    }
}
