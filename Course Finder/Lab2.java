import java.util.Scanner;
public class Lab2 {
 public static void main(String[] args){
  
//Asks user to input course number	
	 
  Scanner input = new Scanner(System.in);
  System.out.println("Please input the course number: ");
  int courseNumber = input.nextInt();
  
//Error message will occur if input is incorrect. Asks user to input again
  
  while(courseNumber>1110 || courseNumber<1100){
   System.out.println("This course number does not exist. Please try again.");
   
   System.out.println("Please input the course number: ");
   courseNumber = input.nextInt();
  }
  
//Asks user to input course time
  
  System.out.println("Please input the time of your course, 8-12 for morning, and 1-5 for afternoon: ");
  int courseTime = input.nextInt();
  
///Error message will occur if input is incorrect. Asks user to input again
  
  while(courseTime>5 && courseTime<8 || courseTime>12){
   System.out.println("This course time does not exist. Please try again.");
   
   System.out.println("Please input the time of your course, 8-12 for morning, and 1-5 for afternoon:");
   courseTime = input.nextInt();
  }
  
//Nested If statements to designate classroom
  
  String location = "";
  
  
  if(courseNumber==1100){
   if(courseTime>=8 && courseTime<=12){
    location = "E119";
   }
   else{
    location = "E210";
   }
  }
  

  else if(courseNumber==1101){
   if(courseTime>=8 && courseTime<=12){
    location = "E118";
   }
   else{
    location = "E119";
   }
  }

  else if(courseNumber==1102){
   if(courseTime>=8 && courseTime<=12){
    location = "E117";
   }
   else{
    location = "E118";
   }
  }

  else if(courseNumber==1103){
   if(courseTime>=8 && courseTime<=12){
    location = "E210";
   }
   else{
    location = "E117";
   }
  }

  else if(courseNumber==1104){
   if(courseTime>=8 && courseTime<=12){
    location = "E211";
   }
   else{
    location = "E212";
   }
  }

  else if(courseNumber==1105){
   if(courseTime>=8 && courseTime<=12){
    location = "E213";
   }
   else{
    location = "E211";
   }
  }

  else if(courseNumber==1106){
   if(courseTime>=8 && courseTime<=12){
    location = "E214";
   }
   else{
    location = "E213";
   }
  }

  else if(courseNumber==1107){
   if(courseTime>=8 && courseTime<=12){
    location = "E215";
   }
   else{
    location = "E214";
   }
  }

  else if(courseNumber==1108){
   if(courseTime>=8 && courseTime<=12){
    location = "E216";
   }
   else{
    location = "E215";
   }
  }

  else if(courseNumber==1109){
   if(courseTime>=8 && courseTime<=12){
    location = "E217";
   }
   else{
    location = "E216";
   }
  }

  else if(courseNumber==1110){
   if(courseTime>=8 && courseTime<=12){
    location = "E212";
   }
   else{
    location = "E217";
   }
  }
  
//Prompts user about classroom information  
  
  System.out.println("Your classroom is " + location + "!"); 

 }
}
