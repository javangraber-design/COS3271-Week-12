//Programmer: Javan Graber
//Date: 11/17/26
//Title: Person Info APP

package javanproject;
import java.util.Scanner;


//Create the class with all the variables
class Person{
	String firstName;
	String lastName;
	String gender;
	int age;
	double weight;
	String height;
	String ethnicGroup;
	String religion;
}

//Create the main class containing the mainline
public class MyProject {   
    static Scanner userinput = new Scanner(System.in); 
	
	//Create the mainline
	public static void main (String[] args){
		try {
	    	//Ask for the person's information
	    	Person newPerson = new Person();
	    	System.out.println("Enter the first name: ");
	    	newPerson.firstName = userinput.nextLine();
	    	
	    	System.out.println("Enter the last name: ");
	    	newPerson.lastName = userinput.nextLine();
	    	
	    	System.out.println("Enter the gender: ");
	    	newPerson.gender = userinput.nextLine();
	    	
	    	System.out.println("Enter the age (as an integer): ");
	    	newPerson.age = userinput.nextInt();
	    	userinput.nextLine();
	    	
	    	System.out.println("Enter the weight (in pounds): ");
	    	newPerson.weight = userinput.nextDouble();
	    	userinput.nextLine();
	    	
	    	System.out.println("Enter the height (with feet and inches): ");
	    	newPerson.height = userinput.nextLine();
	    	
	    	System.out.println("Enter the ethnic group: ");
	    	newPerson.ethnicGroup = userinput.nextLine();
	    	
	    	System.out.println("Enter the religion: ");
	    	newPerson.religion = userinput.nextLine();
		
	    	//Display the information
	    	System.out.println();
	    	System.out.println("First name:    " + newPerson.firstName);
	    	System.out.println("Last name:     " + newPerson.lastName);
	    	System.out.println("Gender:        " + newPerson.gender);
	    	System.out.println("Age:           " + newPerson.age);
	    	System.out.println("Weight:        " + newPerson.weight);
	    	System.out.println("Height:        " + newPerson.height);
	    	System.out.println("Ethnic Group:  " + newPerson.ethnicGroup);
	    	System.out.println("Religion:      " + newPerson.religion);
		}
		//Catch any exceptions
		catch (Exception e) {
			System.out.println("Something you entered was not valid. Make sure you enter valid information!");
		}
	}
		
}
