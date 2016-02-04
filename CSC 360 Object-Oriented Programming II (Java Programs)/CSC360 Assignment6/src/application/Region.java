package application;

/*
File Name: Region.java 
Author: Corey Shrader
Course: CSC 360-002
Date: 4/24/15
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Region {

	private File regionFile;
	private String regionName;
	private ArrayList<Browser> browsers = new ArrayList<>();
	private ArrayList<String> dates = new ArrayList<>();
	
	public Region() {
		
	}
	
	public Region(String name) {
		regionName = name;
	}
	
	public Region(String name, String fileName) {
		regionName = name;
		regionFile = new File(fileName);
	}
	
	public String getName() {
		return regionName;
	}
	
	public String getDate(int index) {
		return dates.get(index);
	}
	
	public int getDateSize() {
		return dates.size();
	}
	
	public int getLength() {
		return browsers.size();
	}
	
	public void setName(String name) {
		regionName = name;
	}
	
	public void setFile(String fileName) {
		regionFile = new File(fileName);
	}
	
	public Browser getBrowser(int index) {
		return browsers.get(index);
	}
	
	public String toString() {
		return regionName;
	}
	
	public boolean equals(Object o) {
		
		if (o instanceof Region)
			return ((Region)o).getName() == regionName;
		else 
			return false;
	}
	
	public void initiateBrowsers() {
		try {
			browsers.clear();
			dates.clear();
			Scanner fileReader = new Scanner(regionFile);
			String[] browserNames = fileReader.nextLine().split(",");
			for (int i = 1; i < browserNames.length; i++) {
				browsers.add(new Browser(browserNames[i]));
			}
			while (fileReader.hasNextLine()) {
				String[] dataPoints = fileReader.nextLine().split(",");
				dates.add(dataPoints[0]);
				for (int i = 1; i < dataPoints.length; i++)
					browsers.get(i-1).addDataPoint(new Double(dataPoints[i]));
			}
			fileReader.close();
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
