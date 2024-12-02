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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    private static List<Car> cars;
    private static List<Car> carsLog = new ArrayList<>();
    private static CarStation[] stations;
    private static int fileIndex = 0;
    private static Car car = null;
    private static Boolean task1Completed = false;
    private static Boolean task2Completed = false;

    Main(CarStation[] stations) {
        this.cars = new ArrayList<>();
        this.stations = stations;
    }

    static class Task1 extends Thread {
        private final Semaphore semaphore;

        public Task1(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            File folder = new File("C:\\Users\\user\\Desktop\\OOP_Course\\labs\\java-classifcation\\src\\main\\java\\lab_3\\queue");

            if (folder.exists() && folder.isDirectory()) {
                File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));
                if (files != null && fileIndex < files.length) {
                    File file = files[fileIndex];
                    try {
                        ObjectMapper mapper = new ObjectMapper();
                        car = mapper.readValue(file, Car.class);

                        cars.add(car);
                        carsLog.add(car);
                        semaphore.addCar(car);

                        System.out.println("File: " + file.getName());
                        fileIndex++;
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + file.getName());
                        e.printStackTrace();
                    }
                } else {
                    task1Completed = true;
                }
            }
        }
    }

    // Task 2: Serves cars from the stations
    static class Task2 extends Thread {
        private final Semaphore semaphore;

        public Task2(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            semaphore.guideCarToStation();
            System.out.println();

            if (task1Completed) {
                try {
                    Thread.sleep(5000);
                    task2Completed = true;


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Task3 extends Thread {
        private final Semaphore semaphore;

        public Task3(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            if (task1Completed && task2Completed) {
                System.out.println(semaphore.Statistics().toString());
            }
        }
    }

    public static void main(String[] args) {
        CarStation[] stations = {
                new CarStation(new LinkedListQueue<>(), new PeopleDinner(), new ElectricStation()),
                new CarStation(new CircularQueue<>(40), new PeopleDinner(), new GasStation()),
                new CarStation(new ArrayQueue<>(40), new RobotDinner(), new ElectricStation()),
                new CarStation(new LinkedListQueue<>(), new RobotDinner(), new GasStation())
        };

        Main schedule = new Main(stations);

        Semaphore semaphore = new Semaphore(stations);

        // Create a ScheduledExecutorService with a pool of threads
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

        Task1 task1 = new Task1(semaphore);
        Task2 task2 = new Task2(semaphore);
        Task3 task3 = new Task3(semaphore);

        scheduler.scheduleAtFixedRate(task1, 0, 2, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(task2, 3, 5, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(task3, 4, 6, TimeUnit.SECONDS);

    }
}
