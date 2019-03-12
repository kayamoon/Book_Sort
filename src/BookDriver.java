import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class BookDriver {

	public static void main(String[] args) throws FileNotFoundException {
		
	
  Scanner sc = new Scanner(new File("books.csv"));
  sc.nextLine();
  
  
  //library initiate
  Library library = new Library();
  
  while (sc.hasNextLine()){
    //split each line on commas
    String[] bookInfo = sc.nextLine().split(",");

    //create a Book from the string array   
    Book b = new Book(bookInfo);
    //add the Book to the Library and the priority queue
    library.addBook(b);
    library.addPriority(b);
      }
  
  
  sc.close();
  
  	
  	//call sort function
  	library.selectionSort(library.getList());
  	//library.bubbleSort(library.getList());
  	System.out.println(library); //print after library is sorted
  	
  	System.out.println("\nPriority Queue:\n");
  	System.out.println(library.pq);
  	
  	
	}
	
}




