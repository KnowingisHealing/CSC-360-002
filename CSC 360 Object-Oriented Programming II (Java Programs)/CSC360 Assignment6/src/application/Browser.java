package application;

/*
File Name: Browser.java 
Author: Corey Shrader
Course: CSC 360-002
Date: 4/24/15
 */

import java.util.ArrayList;

public class Browser {

	private String browserName;
	private ArrayList<Double> browserData = new ArrayList<>();
	
	public Browser() {
	}
	
	public Browser( String name ) {
		browserName = name;
	}
	
	public String getName() {
		return browserName;
	}
	
	public Double getDataPoint(int index) {
		return browserData.get(index);
	}
	
	public ArrayList<Double> getBrowserData() {
		return browserData;
	}
	
	public String toString() {
		return "This browser represents " + browserName + ".";
	}
	
	public void addDataPoint(Double dataPoint) {
		browserData.add(dataPoint);
	}
	
	public boolean equals(Object o) {
		if (o instanceof Browser)
			return ((Browser)(o)).getName() == browserName;
		else
			return false;
	}
	
}
