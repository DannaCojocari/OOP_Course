package lab_3.task2;

public class RobotDinner implements Dineable{
    private static Integer robot = 0;

    public void countRobot() {
        robot++;
    }

    public Integer getRobot() {
        return robot;
    }

    @Override
    public void serveDinner(String carId) {
        System.out.println("Serving robot dinner to car " + carId + ".");
        countRobot();
    }
}
