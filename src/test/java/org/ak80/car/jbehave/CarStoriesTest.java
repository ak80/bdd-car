package org.ak80.car.jbehave;

import com.github.valfirst.jbehave.junit.monitoring.JUnitReportingRunner;
import org.ak80.car.Car;
import org.ak80.car.Obstacle;
import org.ak80.car.TrafficLight;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.junit.runner.RunWith;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

@RunWith(JUnitReportingRunner.class)
public class CarStoriesTest extends JUnitStories {

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(codeLocationFromClass(this.getClass()))
                        .withFormats(Format.CONSOLE, Format.TXT, Format.HTML, Format.XML))
                .useParameterConverters(
                        new ParameterConverters().addConverters(customConverters()));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new CarSteps());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "");
    }

    private ParameterConverters.ParameterConverter[] customConverters() {
        List<ParameterConverters.ParameterConverter> converters = new ArrayList<>();
        converters.add(new CarStateConverter());
        converters.add(new ObstacleConverter());
        converters.add(new TrafficLightConverter());
        return converters.toArray(new ParameterConverters.ParameterConverter[0]);
    }

    public static class CarStateConverter extends ParameterConverters.AbstractParameterConverter<Car.State> {

        @Override
        public Car.State convertValue(String value, Type type) {
            return Car.State.valueOf(value.toUpperCase());
        }
    }

    public static class ObstacleConverter extends ParameterConverters.AbstractParameterConverter<Obstacle> {

        @Override
        public Obstacle convertValue(String value, Type type) {
            return Obstacle.valueOf(value.toUpperCase());
        }
    }

    public static class TrafficLightConverter extends ParameterConverters.AbstractParameterConverter<TrafficLight> {

        @Override
        public TrafficLight convertValue(String value, Type type) {
            TrafficLight trafficLight = new TrafficLight();
            trafficLight.setColor(TrafficLight.Color.valueOf(value.toUpperCase()));
            return trafficLight;
        }
    }

}
