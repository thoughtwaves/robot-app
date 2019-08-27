package com.gaurav.roboapp;

import org.springframework.stereotype.Component;

import com.gaurav.roboapp.exception.OverweightException;

@Component
public class Robot {

	private double battery;
	private double load;
	private final double KM_PER_FULL_CHARGE = 5;
	private final double MAX_LOAD = 10;
	private final double LOW_BATTERY_THRESHOLD = 15;

	public Robot(double load) {
		if (load > MAX_LOAD)
			throw new OverweightException("Overweight");
		else
			this.load = load;
		this.battery = 100;
	}

	public Robot() {
		this.load = 0;
		this.battery = 100;
	}

	public double getBattery() {
		return battery;
	}

	public void setBattery(double battery) {
		this.battery = battery;
	}

	public double getLoad() {
		return load;
	}

	public void setLoad(double load) {
		if (load > MAX_LOAD)
			throw new OverweightException("Overweight");
		else
			this.load = load;
	}

	public boolean isBatteryLow() {
		return this.getBattery() < LOW_BATTERY_THRESHOLD;
	}


	public double calculateRemainingBattery(double kilometers) {
		double load = this.getLoad();
		double battery = this.getBattery();
		double batteryConsumed = (100/KM_PER_FULL_CHARGE) * kilometers + (2 * load);
		if(battery > batteryConsumed) {
			battery = battery - batteryConsumed;
		} else
			battery = 0;
		this.setBattery(battery);
		
		return this.getBattery();
	}

}
