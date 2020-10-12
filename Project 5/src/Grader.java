/* Manuel Guerra
 * manuelaguerra
 * Section: 11H4
 * Project Number: 5
 * Program that acts as an auto grader for students in each class
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;

public class Grader {
  
	//Initializes and declares priavte variables
	private boolean available = true;
	private Student student;
	private Dictionary dict;
	  
	public Grader(Dictionary dict) {
		this.dict = dict;
	}
	  
	public boolean gradeStudent(String fileName) {
		
		//Declares ArrayList
		ArrayList<String> essay = new ArrayList<>();
		ArrayList<String> errorList = new ArrayList<>();    
	    
		//Contains all the student's information
	    try {
	    File student = new File(fileName + ".txt");
	    Scanner readStudent = new Scanner(student);
	    String studentVariety = readStudent.nextLine();
	    String nameOfStudent = readStudent.nextLine();
	    String idOfStudent = readStudent.nextLine();
	    String majorOfStudent = readStudent.nextLine();
	    
	    //High School Student
	    if(studentVariety.equalsIgnoreCase("HighSchool Student")) {
	      while(readStudent.hasNextLine()) {
	    	  
	        String line = readStudent.nextLine();
	        String[] words = line.split("\\s+");
	        
	        //received help from student: Jacob Rush
	        for(int i = 0; i < words.length; i++) {
	        	String word = words[i].replace(",", "").replace(".", "").replace("?", "").replace(":","").replace(";","").toLowerCase();
	        	essay.add(word);
	        }
	        //end help from student: Jacob Rush
	      }
	      
	      for(int i = 0; i < essay.size(); i++) {
	    	  
	    	  if(!this.dict.isWord(essay.get(i)))
	    	  errorList.add(essay.get(i));
	      }
	      
	      //High School Student Object Stats
	      this.student = new HighSchoolStudent(nameOfStudent, idOfStudent, essay.toString(), errorList, majorOfStudent);
	  	  this.available = false;
	  	  return true;
	
	    }
	
	    //Undergraduate Student
	    if(studentVariety.equalsIgnoreCase("Undergraduate Student")) {
	      while(readStudent.hasNextLine()) {
	    	  
	        String line = readStudent.nextLine();
	        String[] words = line.split("\\s+");
	        
	        //received help from student: Jacob Rush
	        for(int i = 0; i < words.length; i++) {
	        	String word = words[i].replace(",", "").replace(".", "").replace("?", "").replace(":","").replace(";","").toLowerCase();
	        	essay.add(word);
	        }
	        //end help from student: Jacob Rush
	      }
	      
	      for(int i = 0; i < essay.size(); i++) {
	    	  
	    	  if(!this.dict.isWord(essay.get(i)))
	    	  errorList.add(essay.get(i));
	      }
	      
	      //Undergraduate Student Object Stats
	      this.student = new UndergraduateStudent(nameOfStudent, idOfStudent, essay.toString(), errorList, majorOfStudent);
	  	  this.available = false;
	  	  return true;
	    }
	    
	    //Graduate Student
	    if(studentVariety.equalsIgnoreCase("Graduate Student")) {
	    	String advisorOfStudent = readStudent.nextLine();
	    	
	        while(readStudent.hasNextLine()) {
	        	
	          String line = readStudent.nextLine();
	          String[] words = line.split("\\s+");
	          
	          //received help from student: Jacob Rush
	          for(int i = 0; i < words.length; i++) {
	          	String word = words[i].replace(",", "").replace(".", "").replace("?", "").replace(":","").replace(";","").toLowerCase();
	          	essay.add(word);
	          }
	          //end help from student: Jacob Rush
	        }
	        
	        for(int i = 0; i < essay.size(); i++) {
	      	  
	          if(!this.dict.isWord(essay.get(i)))
	      	  errorList.add(essay.get(i));
	        }
	        
	        //Graduate Student Object Stats
	        this.student = new GraduateStudent(nameOfStudent, idOfStudent, essay.toString(), errorList, majorOfStudent, advisorOfStudent);
	    	this.available = false;
	    	return true;
	      }
	    
	    }
	    //Throws an exception
	    catch(FileNotFoundException fileNotFound) {
	    	this.reset();
	    	return false;
	    }
	    return true;
	  }
	  
	  public boolean isAvailable() {
		  return (this.available && (this.student == null));
	  }
	  
	  public Student getStudent() {
		  return this.student;
	  }
	  
	  public void reset() {
		  this.student = null;
		  this.available = true;
	  }
}



