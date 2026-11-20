//Programmer: Javan Graber
//Date: 11/17/26
//Title: Person Tasks APP

package javanproject;
import java.util.Scanner;


//Create the class with all the variables
class Person {
	String firstName;
	String lastName;
	String gender;
	int age;
	double weight;
	String height;
	String ethnicGroup;
	String religion;
	
	//Create the greeting method
	public void sayGreeting(String personName) {
		System.out.println("Hello, I am " + personName + "! It is great to meet you!");
	}
	//Create the prayer method
	public void sayPrayer(String personReligion) {
		System.out.println("My religion is " + personReligion + ". God, I thank you for your blessings! Please guide me and watch over me!");
	}
	//Create the nap method
	public void takeNap() {
		System.out.println("I will now take a nap. ZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
	}
	//Create the eating method
	public void eatSomething() {
		System.out.println("I will now eat something *Munch Munch Crunch*. YUM!");
	}
	//Create the retrieving name method
	public String getName(String first, String last) {
		String fullName = first + " " + last;
		return fullName;
	}
	//Create the setting religion method
	public void setReligion(String newReligion) {
		religion = newReligion;
		System.out.println("Your new religion is " + religion);
	}
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
	    	
	    	//Show the options
	    	System.out.println();
	    	System.out.println("1. Say A Greeting");
	    	System.out.println("2. Say a Prayer");
	    	System.out.println("3. Take a Nap");
	    	System.out.println("4. Eat Something");
	    	System.out.println("5. Get the Name");
	    	System.out.println("6. Change the Religion");
	    	
	    	
			//Initialize the choice
			int choice = 10;
			
			//Go until the user enters 0
			while (choice != 0) {
				
				try {
					System.out.println();
					System.out.println("Please enter the number for your choice (it must be an integer) or enter 0 to stop: ");
					choice = userinput.nextInt();
					userinput.nextLine();
					
					//Based on the selection, call the required function by the menu order
					if (choice == 0) {
				    	//Display the information before ending
				    	System.out.println();
				    	System.out.println("Final Person Information");
				    	System.out.println("**********************************************");
				    	System.out.println("First name:    " + newPerson.firstName);
				    	System.out.println("Last name:     " + newPerson.lastName);
				    	System.out.println("Gender:        " + newPerson.gender);
				    	System.out.println("Age:           " + newPerson.age);
				    	System.out.println("Weight:        " + newPerson.weight);
				    	System.out.println("Height:        " + newPerson.height);
				    	System.out.println("Ethnic Group:  " + newPerson.ethnicGroup);
				    	System.out.println("Religion:      " + newPerson.religion);
					}
					if (choice == 1) {
						newPerson.sayGreeting(newPerson.firstName);
					}
					else if (choice == 2) {
						newPerson.sayPrayer(newPerson.religion);
					}
					else if (choice == 3) {
						newPerson.takeNap();
					}
					else if (choice == 4) {
						newPerson.eatSomething();
					}
					else if (choice == 5) {
						System.out.println("Person full name: " + newPerson.getName(newPerson.firstName, newPerson.lastName));
					}
					else if (choice == 6) {
						System.out.println("Enter the new religion: ");
						String newUserReligion = userinput.nextLine();
						newPerson.setReligion(newUserReligion);
					}

					//Check for numbers beyond the specified options
					else if (choice > 6 || choice < 0) {
						System.out.println("Sorry, that integer was not a valid option!");
					}
				//Catch any exceptions for invalid input
				} catch (Exception e) {
					System.out.println("That choice was not valid. Please enter a valid integer!");
					userinput.nextLine();
				}
			}
		//Catch any exceptions
		} catch (Exception e) {
			System.out.println("Something you entered was not valid. Make sure you enter valid information!");
		}
	}
		
}
