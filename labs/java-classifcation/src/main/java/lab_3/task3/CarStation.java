package lab_3.task3;

import lab_3.task2.*;
import lab_3.task1.Queue;

public class CarStation {
    private Dineable diningService;
    private Refuelable refuelingService;
    private Queue<Car> queue;
    private Car car;

    public CarStation(Queue<Car> queue, Dineable diningService, Refuelable refuelingService) {
        this.queue = queue;
        this.diningService = diningService;
        this.refuelingService = refuelingService;
    }

    public void serveCars() {
        car = queue.peek();

        if (car.getIsDining()) {
            diningService.serveDinner(car.getId());
        }

        refuelingService.refuel(car.getId());

        queue.dequeue();
    }

    public void addCar(Car car) {
        queue.enqueue(car);
        serveCars();
    }

    public Integer getNrCars() {
        if (refuelingService instanceof ElectricStation) {
            return ElectricStation.getElectricCar();
        } else if (refuelingService instanceof GasStation) {
            return GasStation.getGasStation();
        } else {
            return 0;
        }
    }

    public Integer getNrPassengers() {
        if (diningService instanceof PeopleDinner) {
            return PeopleDinner.getPeople();
        } else if (diningService instanceof RobotDinner) {
            return RobotDinner.getRobot();
        } else {
            return 0;
        }
    }

    public Boolean queueIsEmpty() {
        return queue.isEmpty();
    }

    public Refuelable getRefuelingService() {
        return refuelingService;
    }

    public Dineable getDiningService() {
        return diningService;
    }

    public Queue<Car> getQueue() {
        return queue;
    }
}
