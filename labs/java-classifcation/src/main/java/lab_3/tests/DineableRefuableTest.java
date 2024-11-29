package lab_3.tests;

import lab_3.task2.ElectricStation;
import lab_3.task2.GasStation;
import lab_3.task2.PeopleDinner;
import lab_3.task2.RobotDinner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DineableRefuableTest {

    @Test
     void testElectricStation() {
        ElectricStation electricStation1 = new ElectricStation();
        ElectricStation electricStation2 = new ElectricStation();
        ElectricStation electricStation3 = new ElectricStation();

        electricStation1.refuel("1");
        electricStation1.refuel("2");
        electricStation2.refuel("10");
        electricStation3.refuel("34");
        electricStation3.refuel("12");
        electricStation3.refuel("14");

        Assertions.assertEquals(6, electricStation1.getElectricCar());
    }

    @Test
    void testGasStation() {
        GasStation gasStation1 = new GasStation();
        GasStation gasStation2 = new GasStation();

        gasStation1.refuel("1");
        gasStation1.refuel("7");
        gasStation1.refuel("15");
        gasStation2.refuel("84");
        gasStation2.refuel("2");
        gasStation2.refuel("4");
        gasStation2.refuel("3");

        Assertions.assertEquals(7, gasStation1.getGasStation());
    }

    @Test
    void testPeopleDinner() {
        PeopleDinner peopleDinner1 = new PeopleDinner();
        PeopleDinner peopleDinner2 = new PeopleDinner();
        PeopleDinner peopleDinner3 = new PeopleDinner();

        peopleDinner1.serveDinner("1");
        peopleDinner1.serveDinner("2");
        peopleDinner1.serveDinner("10");
        peopleDinner2.serveDinner("34");
        peopleDinner3.serveDinner("12");
        peopleDinner3.serveDinner("14");

        Assertions.assertEquals(6, peopleDinner1.getPeople());
    }

    @Test
    void testRobotDinner() {
        RobotDinner robotDinner1 = new RobotDinner();
        RobotDinner robotDinner2 = new RobotDinner();

        robotDinner1.serveDinner("1");
        robotDinner1.serveDinner("2");
        robotDinner2.serveDinner("10");
        robotDinner2.serveDinner("34");
        robotDinner1.serveDinner("12");

        Assertions.assertEquals(5, robotDinner1.getRobot());
    }
}
