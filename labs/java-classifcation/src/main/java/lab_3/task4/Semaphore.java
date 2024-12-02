package lab_3.task4;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lab_3.task3.Car;
import lab_3.task3.CarStation;

import java.util.ArrayList;
import java.util.List;

public class Semaphore {
    private CarStation[] stations;
    private List<Car> cars;
    private List<Car> carsStatistic = new ArrayList<>();

    public Semaphore(CarStation[] stations, List<Car> cars) {
        this.stations = stations;
        this.cars = cars;
    }

    public Semaphore(CarStation[] stations) {
        this.stations = stations;
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
        carsStatistic.add(car);
    }

    public void removeCar() {
        cars.clear();
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

        cars.clear();
    }


    public int getTypeCar(Car.CarType type) {
        int i = 0;
        for (Car car : carsStatistic) {
            if (car.getType().equals(type)) {
                i++;
            }
        }
        return i;
    }

    public int getTypePassenger(Car.PassengerType type) {
        int i = 0;
        for (Car car : carsStatistic) {
            if (car.getPassengers().equals(type)) {
                i++;
            }
        }
        return i;
    }

    public int getDining() {
        int i = 0;
        for (Car car : carsStatistic) {
            if (car.getIsDining()) {
                i++;
            }
        }
        return i;
    }

    public int getNotDining() {
        int i = 0;
        for (Car car : carsStatistic) {
            if (!car.getIsDining()) {
                i++;
            }
        }
        return i;
    }

    public int getSumConsumption(Car.CarType type) {
        int i = 0;
        for (Car car : carsStatistic) {
            if (car.getType().equals(type)) {
                i += car.getConsumption();
            }
        }
        return i;
    }

    public JsonNode Statistics() {
        // Create an ObjectNode (this is a type of JsonNode) for constructing the JSON structure
        ObjectNode statistics = new ObjectNode(com.fasterxml.jackson.databind.node.JsonNodeFactory.instance);

        // Add the necessary statistics to the JSON object
        statistics.put("ELECTRIC", getTypeCar(Car.CarType.ELECTRIC));
        statistics.put("GAS", getTypeCar(Car.CarType.GAS));
        statistics.put("PEOPLE", getTypePassenger(Car.PassengerType.PEOPLE));
        statistics.put("ROBOTS", getTypePassenger(Car.PassengerType.ROBOTS));
        statistics.put("DINING", getDining());
        statistics.put("NOT_DINING", getNotDining());

        // Add a nested JSON object for consumption
        ObjectNode consumption = statistics.putObject("CONSUMPTION");
        consumption.put("ELECTRIC", getSumConsumption(Car.CarType.ELECTRIC));
        consumption.put("GAS", getSumConsumption(Car.CarType.GAS));

        return statistics; // Return the constructed JSON object
    }

}
