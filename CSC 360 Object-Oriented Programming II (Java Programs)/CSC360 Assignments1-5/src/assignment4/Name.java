package assignment4;

/*
File Name: Name.java 
Author: Corey Shrader
Course: CSC 360-002
Date: 3/12/15
 */

public class Name {
	
	private String name = null;
	private String sex = "M";
	
	public Name( String name, String sex ) {
		this.name = name;
		this.sex = sex;
	}
	
	public Name( String name ) {
		this.name = name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
	
	public void setSex( String sex ) {
		this.sex = sex;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSex() {
		return sex;
	}
	
	public String getRank(int year) {
		// Returns the rank of a name in a given year, if the name is found.
		
		String rank = "N/A";
		int yearIndex = (NamePopularity.years.size() - 1) - (NamePopularity.MOST_RECENT_YEAR - year);
		int count = 0;
		for (int yearLine = 0; yearLine < NamePopularity.years.get(yearIndex).size(); yearLine++) {
			String[] yearLineStats = NamePopularity.years.get(yearIndex).get(yearLine).split(",");
			if (yearLineStats[1].equalsIgnoreCase(sex))
				count++;
			if (yearLineStats[0].equalsIgnoreCase(name) && yearLineStats[1].equalsIgnoreCase(sex))
				rank = yearLineStats[2];
				//rank = new String("" + count);
		}
		return rank;
	}
	
	public boolean equals(Object o) {
		// Returns true if two Name objects have the same name and sex
		
		return (name == ((Name)o).getName() && sex == ((Name)o).getSex());
	}
	
	public String toString() {
		// Returns the name and sex of the Name object
		
		return "Name: " + name + "\t Sex: " + sex;
	}
	
}
