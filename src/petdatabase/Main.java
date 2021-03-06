/*
    CSC422 Week 2 Assignment

    This program will create a basic database program for managing
    information (name and age) about pets. The database allows the user to add pet information
    to the database, remove pet information, updating pet information, and searching for pets by
    name or by age. 
 
    Change Log:
    Added requirements for Milestone 1 - Loading and saving pet data to file.

*/
package petdatabase;

/**
 *
 * @author LUNDQJA
 */

import java.io.*;
import java.util.*;

public class Main {
	static Scanner in=new Scanner(System.in);
	static int menu() {
		System.out.println("\nWhat would you like to do?");
		System.out.println("1) View all pets ");
		System.out.println("2) Add more pets");
		System.out.println("3) Update an existing pet ");
		System.out.println("4) Remove an existing pet ");
		System.out.println("5) Search pets by name ");
		System.out.println("6) Search pets by age ");
		System.out.println("7) Exit program");
		System.out.print("\nYour choice: ");
		
	    int choice= in.nextInt();
	    in.nextLine();
	    return choice;
	    
	   
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		ArrayPets arr=new ArrayPets();
		int choice=1;
		do {
			choice=menu();
			switch(choice) {
			case 1:{ 
                            arr.show();
                        
                            break;
                        }
			case 2:{
				arr.show();
				int count=0;
				while(true) {
				
				System.out.print("add a pet (name, age): ");
				String line=in.nextLine();
				if(line.equalsIgnoreCase("done"))
					break;
				String[] items=line.split(" ");
				//Validate input (name age).
                                if(items.length !=2) {
					System.out.println("Error: "+ line+ " is not a valid input.");
					continue;
				}
				int age=Integer.parseInt(items[1]);
				//Validate age input (1 to 20)
                                if(age<1 || age>20) {
					System.out.println("Error: "+ line+ " is not a valid age.");
					continue;
				}
				arr.add(items[0], age);
				count++;
				}
				System.out.println(count + " pets added.");
				break;			
                        }
			case 3:{
				arr.show();
				System.out.print("Enter the pet ID to update: ");
				int id=in.nextInt();
				in.nextLine();
				System.out.print("Enter new name and new age: ");
				String line=in.nextLine();
				String[] items=line.split(" ");
                                    arr.update(id,items[0], Integer.parseInt(items[1]));
                                break;
			}
			case 4: {
				arr.show();
				System.out.print("Enter the pet ID to remove: ");
				int id=in.nextInt();
				in.nextLine();
				arr.remove(id);
				break;	
			}
			case 5: {
				arr.show();
				System.out.print("Enter a name to search: ");
				String name=in.nextLine();
				arr.searchPetByName(name);
				break;	
			}
			case 6: {
				arr.show();
				System.out.print("Enter age to search: ");
				int age=in.nextInt();
				in.nextLine();
				arr.searchPetByAge(age);
				break;	
			}
			case 7: {
                                arr.writeToFile();
                                System.out.println("Goodbye!"); 
                                break;
                        }
		}
            }while(choice != 7);
	}
}
