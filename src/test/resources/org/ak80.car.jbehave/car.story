Scenario: when a driver sees a person, the car is braking
Given a car is driving
When the driver sees a person
Then the car is braking

Scenario: when a driver sees an animal, the car is braking
Given a car is driving
When the driver sees a animal
Then the car is braking

Scenario: when a driver sees a rock, the car is evading
Given a car is driving
When the driver sees an rock
Then the car is evading

Scenario: when a driver comes to a green traffic light
Given a car is driving
When the driver comes to a green traffic light
Then the car is driving

Scenario: when a driver comes to a yellow traffic light
Given a car is driving
When the driver comes to a yellow traffic light
Then the car is braking

Scenario: when a driver comes to a red traffic light
Given a car is driving
When the driver comes to a red traffic light
Then the car is braking

Scenario: when a driver waits at a traffic light and it stays red he waits
Given a car waits at a traffic light
When the traffic light is red
Then the car is stopped

Scenario: when a driver waits at a traffic light and it becomes yellow he drives
Given a car waits at a traffic light
When the traffic light is yellow
Then the car is driving

Scenario: when a driver waits at a traffic light and it becomes green he drives
Given a car waits at a traffic light
When the traffic light is green
Then the car is driving