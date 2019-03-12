import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class Library {

	//create ArrayList Library
	ArrayList<Book> Library = new ArrayList<>();
	
	//create Hashtable 
	Hashtable<String, ArrayList<Book>> ht = new Hashtable<String, ArrayList<Book>>(); //creates new hashtable for book objects

	//create priority queue
	PriorityQueue<Book> pq = new PriorityQueue<Book>();
	
	public void addPriority(Book b) {
		pq.addElement(b);
	}
	 
	public ArrayList<Book> getList(){
		return Library;
	}
	
	
	public void addBook(Book e) {
		Library.add(e); 
		//add e to hashtable
			//if hashtable contains key(genre), add book to that genre list. Then add to ht.
			//else create new genre list and add book to genre list, add new genre key to ht and add list as value.
		if(ht.containsKey(e.getGenre())) {
			ArrayList<Book> list = ht.get(e.getGenre());
	    	list.add(e); 
	    	selectionSort(list); 
	    	ht.put(e.getGenre(), list);
	    }
	    else {
	    	ArrayList<Book> list = new ArrayList<>();
	    	list.add(e);
	    	selectionSort(list);
	    	ht.put(e.getGenre(), list);
	    }
	}
	
	
	public void removeBook(String t, String a) {
		//first find index of book I want to remove
		//then use Library.remove(index i);
		for (int i = 0; i < Library.size(); i++) {
			if(((Library.get(i).getTitle()).equals(t)) && ((Library.get(i).getAuthor()).equals(a))) {
				Library.remove(i);
			}
		}
	}
	
	
	public <T extends Comparable<T>> void bubbleSort(ArrayList<T> data) {
		//loop through the array
		//after one loop, the next biggest number is in place
		//do this by swapping("bubbling") up
		int position, scan;
		T temp;
		
		for (position = data.size()-1; position >= 0; position--) {
			
			for (scan = 0; scan <= position-1; scan++) {
				if(data.get(scan).compareTo(data.get(scan+1)) > 0) {
					temp = data.get(scan);
					data.set(scan, data.get(scan+1));
					data.set((scan+1), temp);
				}
			}
		}
	}
	
	
	public <T extends Comparable<T>> void selectionSort(ArrayList<T> l) {
		
		int min;
		
		for (int index = 0; index < l.size()-1; index++) {
			min = index;
			for (int scan = index+1; scan < l.size(); scan++) {
				
				if ((l.get(scan)).compareTo((l.get(min))) < 0) {
					min = scan;
				}
				
			}
			swap(l, min, index);
		}
	}
	
	private static <T extends Comparable<T>> void swap(ArrayList<T> data, int index1, int index2) {
		T temp = data.get(index1);
		data.set(index1, data.get(index2));
		data.set(index2, temp);
	}

	
	public String toString() { 
		String allinfo = ("Library Contents:\n");

		for (int i = 0; i < Library.size(); i++) {
			allinfo += ("\nItem " + (i+1) + ": " + "\n" + Library.get(i));
		}	
		
		allinfo += ("\n\n\nHASHTABLE: \n");
		 
	//use enumeration to iterate through the elements; loop stops when hasMoreElements returns false
		for(Enumeration<String> e = ht.keys(); e.hasMoreElements();) {
			//get the next key, store it in s
			String s = e.nextElement();
			//print the key and the value
			allinfo+= ("\n<"+s+">" + ": " + ht.get(s) + "\n");
		}
		
		return allinfo;
	}
	
}
