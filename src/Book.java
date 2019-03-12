
public class Book implements Comparable<Book> {

	//instance variables
	private String title;
	private String author;
	private String genre;
	private String rating;
	
	
	Book(String[] s) {
		
		for (int i = 0; i < s.length; i++) {
    		title = s[0];
    		author = s[1];
    		genre = s[2];
    		rating = s[3];
    	}
	}
	
	@Override 
	public int compareTo(Book o) {
		int result;
		if (this.genre.equals(o.genre)) {
			result = (this.rating.compareTo(o.rating))*-1;
		}
		else {
			result = (this.genre.compareTo(o.genre));
		}
		return result;
	}
	
	//getters //return info to the driver
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getGenre() {
		return genre;
	}
	public String getRating() {
		return rating;
	}
	//setters (void, not returning anything) //make it so user can't easily disrupt variables
	public void setTitle(String t) {
		title = t;
	}
	public void setAuthor(String a) {
		author = a;
	}
	public void setGenre(String g) {
		genre = g;
	}
	public void setRating(String r) {
		rating = r; 
	}
	
	public String toString() {
		String allinfo = getTitle() + " by " + getAuthor() + ". Genre: " + getGenre() + ". "+ getRating() + "/5";
		return allinfo;
	}
}
