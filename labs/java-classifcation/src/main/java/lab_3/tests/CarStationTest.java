package lab_3.tests;

import lab_3.task1.ArrayQueue;
import lab_3.task1.CircularQueue;
import lab_3.task1.LinkedListQueue;
import lab_3.task2.ElectricStation;
import lab_3.task2.GasStation;
import lab_3.task2.PeopleDinner;
import lab_3.task2.RobotDinner;
import lab_3.task3.Car;
import lab_3.task3.CarStation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CarStationTest {
    private Car[] cars;
    private CarStation[] stations;

    @BeforeEach
    void setUp() {
         cars = new Car[]{
                 new Car("1", Car.CarType.GAS, Car.PassengerType.PEOPLE, Boolean.FALSE, 10),
                 new Car("2", Car.CarType.ELECTRIC, Car.PassengerType.ROBOTS, Boolean.FALSE, 50),
                 new Car("3", Car.CarType.ELECTRIC, Car.PassengerType.PEOPLE, Boolean.TRUE, 30),
                 new Car("4", Car.CarType.GAS, Car.PassengerType.ROBOTS, Boolean.TRUE, 20),
                 new Car("5", Car.CarType.ELECTRIC, Car.PassengerType.ROBOTS, Boolean.TRUE, 27),
                 new Car("6", Car.CarType.ELECTRIC, Car.PassengerType.PEOPLE, Boolean.FALSE, 35)
        };

        stations = new CarStation[]{
                new CarStation(new LinkedListQueue<>(), new PeopleDinner(), new ElectricStation()),
                new CarStation(new CircularQueue<>(10), new PeopleDinner(), new GasStation()),
                new CarStation(new ArrayQueue<>(10), new RobotDinner(), new ElectricStation()),
                new CarStation(new LinkedListQueue<>(), new RobotDinner(), new GasStation())
        };

        for (Car car : cars) {
            if ((car.getPassengers().equals(Car.PassengerType.PEOPLE)) && (car.getType().equals(Car.CarType.ELECTRIC))) {
                stations[0].addCar(car);
            } else if ((car.getPassengers().equals(Car.PassengerType.PEOPLE)) && (car.getType().equals(Car.CarType.GAS))) {
                stations[1].addCar(car);
            } else if ((car.getPassengers().equals(Car.PassengerType.ROBOTS)) && (car.getType().equals(Car.CarType.ELECTRIC))) {
                stations[2].addCar(car);
            } else {
                stations[3].addCar(car);
            }
        }
    }

    @Test
    void testRefuel() {
        // Test to see if the code counts the cars correctly
        Assertions.assertEquals(4, stations[0].getNrCars());  // 4 electric cars
        Assertions.assertEquals(2, stations[1].getNrCars());  // 2 gas cars
        Assertions.assertEquals(4, stations[2].getNrCars());  // 4 electric cars
        Assertions.assertEquals(2, stations[3].getNrCars());  // 2 gas cars
    }

    @Test
    void testDining() {
        // Test to see if the code counts the dining correctly
        Assertions.assertEquals(1, stations[0].getNrPassengers());  // 1 person
        Assertions.assertEquals(1, stations[1].getNrPassengers());  // 1 person
        Assertions.assertEquals(2, stations[2].getNrPassengers());  // 2 robots
        Assertions.assertEquals(2, stations[3].getNrPassengers());  // 2 robots
    }
}
