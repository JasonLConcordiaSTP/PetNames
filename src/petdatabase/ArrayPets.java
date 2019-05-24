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
import java.io.*; 

public class ArrayPets {
	static Pet pets[] = new Pet[5];
	
	//Method for loading Pet data from file.
	public ArrayPets() throws FileNotFoundException {
		  { 
			  String[] items = null;
			  int i=0;
			try {
		            FileInputStream fstream = new FileInputStream("pets.txt");
		            DataInputStream in = new DataInputStream(fstream);
		            BufferedReader br = new BufferedReader(new InputStreamReader(in));
		            String strLine;
		            
		            while ((strLine = br.readLine()) != null) {
		                items = strLine.split(" ");
		                pets[i++]= new Pet(items[0], Integer.parseInt(items[1])); 
		                
		            }
		            in.close();
		        } 
			  catch (FileNotFoundException e){
					//e.printStackTrace();
					}
			  catch(ArrayIndexOutOfBoundsException exception) {
		            	add(items[0], Integer.parseInt(items[1]));
			  		}
			  
			  catch (Exception e){
		            System.err.println("Error: " + e.getMessage());
		            
		            }
		    }
        }
	//Method used to output pet data to file.
	public static void writeToFile(){
		try{
	          FileWriter fr = new FileWriter("pets.txt");
	          BufferedWriter br = new BufferedWriter(fr);
	          PrintWriter out = new PrintWriter(br);
	          for(int i=0; i<pets.length; i++){
	            
                    if(pets[i] != null){  
	            out.write(pets[i].getName()+" "+pets[i].getAge());
	                out.write("\n");
                    }
	          }
	          out.close();
	      }
	      catch(IOException e){
	       System.out.println(e);   
	      }
	}
        


        //Show munu items
        public static void show() {
		int size=pets.length;
		System.out.println("+-------------------+");
		System.out.println("|ID | NAME     |AGE |");
		System.out.println("+-------------------+");
		for(int i=0;i<size;i++) {
                    if(pets[i] != null){
                    pets[i].show(i);
                    }
		}
		System.out.println("+-------------------+");
		System.out.println(Arrays.stream(pets).filter(e -> e != null).count() +" rows in set.");
		System.out.println();
	}
	//Add pet by name and age.
	public static void add(String name, int age) {
	     
		// Convert array to list
		List<Pet> listFromArray = Arrays.asList(pets);
		
	
		// Create new list, because, List to Array always returns a fixed-size list backed by the specified array.
		List<Pet> tempList = new ArrayList<Pet>(listFromArray);
                //Check to see if the database is full
                if(Arrays.stream(pets).filter(e -> e != null).count() < 5)
                {
                tempList.add(new Pet(name,age));
                }
                else
                {
                System.out.println("Error: Database is full.");
                }	
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
		System.out.println(Arrays.stream(pets).filter(e -> e != null).count() +" rows in set.");
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
		System.out.println(Arrays.stream(pets).filter(e -> e != null).count() +" rows in set.");
		System.out.println();
	}
	//Remove pet using index value.
        public static void remove(int index) {
	     
                // Convert array to list
		List<Pet> listFromArray = Arrays.asList(pets);
		

		// Create new list, because, List to Array always returns a fixed-size list backed by the specified array.
		List<Pet> tempList = new ArrayList<Pet>(listFromArray);
                //Validate that the index value exists.
                if( index > 4 || tempList.get(index)== null ) {
                    System.out.println("Error: ID " + index + " does not exist.");
                }
                else {
                    System.out.println(pets[index].getName() + " "+ pets[index].getAge()+ " was removed. ");
                    tempList.remove(index);
               
		//Convert list back to array
		Pet[] tempArray = new Pet[tempList.size()];
		pets = tempList.toArray(tempArray);
                }
		
		}
	//Update pet's Name / Age.
	public static void update(int index, String name, int age) {
		
                    try {    
			System.out.println(pets[index].getName() + " "+ pets[index].getAge()+  " changed to "+ name+ " "+age);
			pets[index].setName(name);
			pets[index].setAge(age);
                    }
                    catch(NullPointerException e) 
        { 
            System.out.println("Error: ID not found."); 
        } 
		}
	
	     
}