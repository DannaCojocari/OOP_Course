package lab_3.task4;

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

import java.io.IOException;

public class Semaphore {
    private CarStation[] stations;
    private Car[] cars;

    public Semaphore(CarStation[] stations, Car[] cars) {
        this.stations = stations;
        this.cars = cars;
    }

    public void guideCarToStation() {
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

    public int getTypeCar(Car.CarType type) {
        int i = 0;
        for (Car car : cars) {
            if (car.getType().equals(type)) {
                i++;
            }
        }
        return i;
    }

    public int getTypePassenger(Car.PassengerType type) {
        int i = 0;
        for (Car car : cars) {
            if (car.getPassengers().equals(type)) {
                i++;
            }
        }
        return i;
    }

    public int getDining() {
        int i = 0;
        for (Car car : cars) {
            if (car.getIsDining()) {
                i++;
            }
        }
        return i;
    }

    public int getNotDining() {
        int i = 0;
        for (Car car : cars) {
            if (!car.getIsDining()) {
                i++;
            }
        }
        return i;
    }

    public int getSumConsumption(Car.CarType type) {
        int i = 0;
        for (Car car : cars) {
            if (car.getType().equals(type)) {
                i += car.getConsumption();
            }
        }
        return i;
    }
}
