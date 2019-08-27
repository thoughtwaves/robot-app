package com.gaurav.roboapp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gaurav.roboapp.exception.OverweightException;

public class RobotTest {

	// Robot walks for 3.5 KM
	@Test
	public void getBattery_RobotWalkTestCase() {
		Robot robot = new Robot();
		double battery = robot.calculateRemainingBattery(3.5);
		assertTrue(30.0 == battery);
	}

	// Robot walks for 2 Km carrying 3 Kg weight
	@Test
	public void getBattery_RobotWalkWithLoadTestCase() {
		Robot robot = new Robot();
		robot.setLoad(3);
		double battery = robot.calculateRemainingBattery(2);
		assertTrue(54.0 == battery);
	}

	// Robot carries 12 Kg weight.
	@Test(expected = OverweightException.class)
	public void checkOverweightExceptionTestCase() {
		Robot robot = new Robot();
		try {
			robot.setLoad(12);
		} catch (OverweightException owe) {
			System.out.println(owe.getMessage());
			throw owe;
		}

	}

	// To check battery low indicator
	@Test
	public void checkLowBatteryTestCase() {
		Robot robot = new Robot();

		robot.setLoad(3);
		robot.calculateRemainingBattery(4);
		assertTrue(robot.isBatteryLow());

	}

}
