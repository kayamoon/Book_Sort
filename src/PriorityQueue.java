import java.util.Arrays;


public class PriorityQueue<T> {
	
	protected int count;
	protected T[] pq;
	protected int modCount;
	
	@SuppressWarnings("unchecked")
	public PriorityQueue() {
		count = 0;
		pq = (T[]) new Object[10];
	}
	
	private void expandCapacity(){
		pq = Arrays.copyOf(pq, pq.length * 2);
	}
	
	
	public void addElement(T object) {

		if (count == pq.length) {
			expandCapacity();
		}
		
		pq[count] = object;
		count++;
		modCount++;
		
		if (count > 1) {
			heapifyAdd();
		}
	}
	
	
	private void heapifyAdd() {
		T temp;
		int next = count - 1;
		
		temp = pq[next];
		
		while ((next!=0) && (((Comparable<T>)temp).compareTo(pq[(next-1)/2])<0)) {
			pq[next] = pq[(next-1)/2];
			next = (next-1)/2;
		}
		
		pq[next] = temp;
		
	}
	

	public String toString() {
		String s = "";
		for (int i = pq.length-1; i>=0; i--) {
				s += pq[i] + "\n";
		}
		return(s);
	}
	


}
