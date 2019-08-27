package com.gaurav.roboapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.roboapp.Robot;

@RestController
@RequestMapping("robot/api")
public class RobotRestController {

	@Autowired
	private Robot robot;

	@GetMapping("/batteryLowIndicator")
	public boolean getBatteryLowIndicator() {
		return robot.isBatteryLow();
	}

	@GetMapping("/batteryRemaining")
	public double getBatteryRemaining(@RequestParam double kms, @RequestParam double load) {
		robot.setLoad(load);
		return robot.calculateRemainingBattery(kms);
	}

}
