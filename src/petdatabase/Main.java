/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petdatabase;

/**
 *
 * @author LUNDQJA
 */

import java.util.Scanner;

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
	
	
	public static void main(String[] args) {
		ArrayPets arr=new ArrayPets();
		int choice=1;
		do {
			choice=menu();
			switch(choice) {
			case 1: arr.show(); break;
			case 2:{
				arr.show();
				int count=0;
				while(true) {
				
				System.out.print("add a pet (name, age): ");
				String line=in.nextLine();
				if(line.equalsIgnoreCase("done"))
					break;
				String[] items=line.split(" ");
				arr.add(items[0], Integer.parseInt(items[1]));
				count++;
				}
				System.out.println(count + " pets added.");
				break;
			}
			case 3:{
				arr.show();
				System.out.print("Update coming in future release.");
				break;
				
			}
			case 4: {
				arr.show();
				System.out.print("Remove coming in future release.");
				break;	
			}
			case 5: {
				arr.show();
				System.out.print("Search by name coming in future release.");
				break;	
			}
			case 6: {
				arr.show();
				System.out.print("Search by age coming in future release.");
				break;	
			}
			case 7: System.out.println("Goodbye!"); break;
			}
		}while(choice != 7);
		
		
	}

}
