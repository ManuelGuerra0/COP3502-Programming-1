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

public class GraduateStudent extends Student{
	
	//Declares variables
	private String major;
	private String advisor;
    
	//Get method
    public String getMajor() {
    	return major;
    }
    
    //Set method
    public void setMajor(String major) {
    	this.major = major;
    }
    
    //Get method
    public String getAdvisor() {
    	return advisor;
    }
    
    //Set method
    public void setAdvisor(String advisor) {
    	this.advisor = advisor;
    }
    
    //Writing to file method
    public void writeToFile() {
    	try {
			PrintWriter writer = new PrintWriter((getId() + "_graded.txt"), "UTF-8");
			writer.println("Graduate Student " + getName());
			writer.println("Student ID: " + getId());
			writer.println("Major: " + getMajor());
			writer.println("Advisor: " + getAdvisor());
			writer.println(getPrintableErrorList());
			writer.close();
		} catch (IOException e) {
			// do something
		}
    }
    
    GraduateStudent(String name, String id, String essay, ArrayList<String> errorList, String major, String advisor) {
    	super(name, id, essay, errorList);
		this.major = major;
		this.advisor = advisor;
    }

}
