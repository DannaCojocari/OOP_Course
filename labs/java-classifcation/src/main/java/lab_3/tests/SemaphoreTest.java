package lab_3.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab_3.task1.ArrayQueue;
import lab_3.task1.CircularQueue;
import lab_3.task1.LinkedListQueue;
import lab_3.task2.ElectricStation;
import lab_3.task2.GasStation;
import lab_3.task2.PeopleDinner;
import lab_3.task2.RobotDinner;
import lab_3.task3.Car;
import lab_3.task3.CarStation;
import lab_3.task4.Semaphore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SemaphoreTest {

    @Test
    public void testSemaphore() throws IOException {
        CarStation[] stations = {
                new CarStation(new LinkedListQueue<>(), new PeopleDinner(), new ElectricStation()),
                new CarStation(new CircularQueue<>(10), new PeopleDinner(), new GasStation()),
                new CarStation(new ArrayQueue<>(10), new RobotDinner(), new ElectricStation()),
                new CarStation(new LinkedListQueue<>(), new RobotDinner(), new GasStation())
        };

        String jsonString = """
            [
                {"id": 1, "type": "ELECTRIC", "passengers": "ROBOTS", "isDining": false, "consumption": 46},
                {"id": 2, "type": "GAS", "passengers": "PEOPLE", "isDining": false, "consumption": 46},
                {"id": 3, "type": "ELECTRIC", "passengers": "ROBOTS", "isDining": false, "consumption": 28},
                {"id": 4, "type": "ELECTRIC", "passengers": "PEOPLE", "isDining": true, "consumption": 16},
                {"id": 5, "type": "ELECTRIC", "passengers": "PEOPLE", "isDining": false, "consumption": 33},
                {"id": 6, "type": "ELECTRIC", "passengers": "ROBOTS", "isDining": false, "consumption": 17},
                {"id": 7, "type": "GAS", "passengers": "PEOPLE", "isDining": true, "consumption": 78}
            ]
            """;

        ObjectMapper mapper = new ObjectMapper();
        Car[] cars = mapper.readValue(jsonString, Car[].class);

        Semaphore semaphore = new Semaphore(stations, cars);
        semaphore.guideCarToStation();

        Assertions.assertEquals(2, stations[0].getNrPassengers()); //nr total people dining is 2
        Assertions.assertEquals(2, stations[1].getNrPassengers()); //nr total people dining is 2
        Assertions.assertEquals(0, stations[2].getNrPassengers()); //nr total robots dining is 0
        Assertions.assertEquals(0, stations[3].getNrPassengers()); //nr total robots dining is 0

        Assertions.assertEquals(5, stations[0].getNrCars()); //nr total electric cars is 5
        Assertions.assertEquals(2, stations[1].getNrCars()); //nr total gas cars is 2
        Assertions.assertEquals(5, stations[2].getNrCars()); //nr total electric cars is 5
        Assertions.assertEquals(2, stations[3].getNrCars()); //nr total electric cars is 2

    }

    @Test
    public void testCarAssignmentToStations() throws IOException {
        CarStation[] stations = {
                new CarStation(new LinkedListQueue<>(), new PeopleDinner(), new ElectricStation()),
                new CarStation(new CircularQueue<>(10), new PeopleDinner(), new GasStation()),
                new CarStation(new ArrayQueue<>(10), new RobotDinner(), new ElectricStation()),
                new CarStation(new LinkedListQueue<>(), new RobotDinner(), new GasStation())
        };

        String jsonString = """
                [
                   {"id": 1, "type": "GAS", "passengers": "ROBOTS", "isDining": true, "consumption": 24},
                   {"id": 2, "type": "ELECTRIC", "passengers": "ROBOTS", "isDining": false, "consumption": 28},
                   {"id": 3, "type": "ELECTRIC", "passengers": "PEOPLE", "isDining": true, "consumption": 21},
                   {"id": 4, "type": "GAS", "passengers": "PEOPLE", "isDining": false, "consumption": 48},
                   {"id": 5, "type": "ELECTRIC", "passengers": "PEOPLE", "isDining": true, "consumption": 46},
                   {"id": 6, "type": "GAS", "passengers": "ROBOTS", "isDining": true, "consumption": 24},
                   {"id": 7, "type": "ELECTRIC", "passengers": "ROBOTS", "isDining": false, "consumption": 35},
                   {"id": 8, "type": "ELECTRIC", "passengers": "PEOPLE", "isDining": true, "consumption": 22},
                   {"id": 9, "type": "ELECTRIC", "passengers": "ROBOTS", "isDining": false, "consumption": 20},
                   {"id": 10, "type": "ELECTRIC", "passengers": "PEOPLE", "isDining": true, "consumption": 24}
                ]
                """;

        ObjectMapper mapper = new ObjectMapper();
        Car[] cars =mapper.readValue(jsonString, Car[].class);

        Semaphore semaphore = new Semaphore(stations, cars);
        semaphore.guideCarToStation();

        Assertions.assertEquals(7,semaphore.getTypeCar(Car.CarType.ELECTRIC)); //nr total electric cars
        Assertions.assertEquals(3,semaphore.getTypeCar(Car.CarType.GAS)); //nr total gas cars
        Assertions.assertEquals(5,semaphore.getTypePassenger(Car.PassengerType.PEOPLE)); //nr total people
        Assertions.assertEquals(5,semaphore.getTypePassenger(Car.PassengerType.ROBOTS)); //nr total robots
        Assertions.assertEquals(6,semaphore.getDining()); //nr total dining
        Assertions.assertEquals(4,semaphore.getNotDining()); //nr total not dining
        Assertions.assertEquals(196,semaphore.getSumConsumption(Car.CarType.ELECTRIC)); //nr total electric consumption
        Assertions.assertEquals(96,semaphore.getSumConsumption(Car.CarType.GAS)); //nr total gas consumption
    }
}
