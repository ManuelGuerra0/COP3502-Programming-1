/* Manuel Guerra
 * manuelaguerra
 * Section: 11H4
 * Project Number: 5
 * Program that acts as an auto grader for students in each class
 */
import java.util.ArrayList;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HighSchoolStudent extends Student{
	
	//Declares variable
	private String nameOfSchool;
	
	//Get method
	public String getSchoolName() {
		return nameOfSchool;
	}
	
	//Set method
	public void setSchoolName(String schoolName) {
		this.nameOfSchool = schoolName;
	}
	
	//Writing to file method
	public void writeToFile() {
		try {
			PrintWriter writer = new PrintWriter((getId() + "_graded.txt"), "UTF-8");
			writer.println("High School Student " + getName());
			writer.println("Student ID: " + getId());
			writer.println("School Name: " + getSchoolName());
			writer.println(getPrintableErrorList());
			writer.close();
		} catch (IOException e) {
			// do something
		}
	}
	
	HighSchoolStudent(String name, String id, String essay, ArrayList<String> errorList, String nameOfSchool) {
		super(name, id, essay, errorList);
		this.nameOfSchool = nameOfSchool;
	}
}
