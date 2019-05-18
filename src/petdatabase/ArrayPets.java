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
import java.util.List; 
import java.util.Arrays;
import java.util.ArrayList; 

public class ArrayPets {
	static Pet pets[] = new Pet[5];
	
	
	public ArrayPets() {
	     //Load some test data
             pets[0]= new Pet("Kitty", 8); 
	     pets[1]= new Pet("Bruno", 7);
	     pets[2]= new Pet("Boomer", 8);
	     pets[3]= new Pet("Boomer", 3);
	     pets[4]= new Pet("Fiesty", 3);
		
	}
	//Show munu items
        public static void show() {
		int size=pets.length;
		System.out.println("+-------------------+");
		System.out.println("|ID | NAME     |AGE |");
		System.out.println("+-------------------+");
		for(int i=0;i<size;i++) {
			pets[i].show(i);
		}
		System.out.println("+-------------------+");
		System.out.println(size +" rows in set.");
		System.out.println();
	}
	//Add pet by name and age.
	public static void add(String name, int age) {
	     
		// Convert array to list
		List<Pet> listFromArray = Arrays.asList(pets);
		
	
		// Create new list, because, List to Array always returns a fixed-size list backed by the specified array.
		List<Pet> tempList = new ArrayList<Pet>(listFromArray);
		tempList.add(new Pet(name,age));
	
		//Convert list back to array
		Pet[] tempArray = new Pet[tempList.size()];
		pets = tempList.toArray(tempArray);
	}
	//Search for pet by name
	public static void searchPetByName(String name) {
		int size=pets.length;
		System.out.println("+-------------------+");
		System.out.println("|ID | NAME     |AGE |");
		System.out.println("+-------------------+");
		
		for(int i=0;i<size;i++) {		
			if(pets[i].getName().toUpperCase().equals(name.toUpperCase()))
					pets[i].show(i);
		}
		
		System.out.println("+-------------------+");
		System.out.println(size +" rows in set.");
		System.out.println();
	}
	//Search for pet by age.
	public static void searchPetByAge(int age) {
		int size = pets.length;
		System.out.println("+-------------------+");
		System.out.println("|ID | NAME     |AGE |");
		System.out.println("+-------------------+");
		
		for(int i=0;i<size;i++) {		
			if(pets[i].getAge()==age)
					pets[i].show(i);
		}
		
		System.out.println("+-------------------+");
		System.out.println(size +" rows in set.");
		System.out.println();
	}
	
	
	     
}