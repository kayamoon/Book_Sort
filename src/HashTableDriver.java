import java.util.*;
import java.io.File;

class DictHashDriver{

   public static void main(String[]args) throws Exception {

      String filename = "books.csv"; //assigns file to a variable
      Scanner scanner = new Scanner(new File(filename)); //passes file into text scanner
      
     Hashtable<String, Book> ht = new Hashtable<String, Book>(); //creates new hashtable for book objects

        while (scanner.hasNextLine()){ //condition = file must have a next line of text
            String data = scanner.nextLine(); //assigns each line of text to a variable
            String name = data.split(",")[0]; //puts each line into an array, and assigns first index of array to a (name) variable
            //each line is a person, and has a comma " , " between the name and age. This is why the .split() can effectively separate the name and age 
            Integer age = Integer.parseInt(data.split(",")[1]); //puts each line into an array, and assigns second index of array to a (age) variable
            Book b = new Book(name,age); //creates person object
            
            ht.put(genre, b); 
            //System.out.println(p); //prints person object
         }
        
      //use and enumeration to iterate through the elements; loop stops when hasMoreElements returns false
  		for(Enumeration<String> e = ht.keys(); e.hasMoreElements();) {
  			//get the next key, store it in s
  			String s = e.nextElement();
  			//print the key and the value
  			System.out.println("<"+s+">" + ": " + ht.get(s));
  		}
  			
       System.out.println("\ntoString below:\n"); 
  	   System.out.println(ht.toString());
  		
       scanner.close();
      
   }
   
}