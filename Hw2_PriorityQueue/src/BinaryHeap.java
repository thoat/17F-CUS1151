
public class BinaryHeap implements PriorityQueue{
	private class HeapData{
		private String data;
		private int priority;
		
		protected HeapData(String dat,int pri){
			data = dat;
			priority = pri;
		}
		
		protected void changePriority(int newPri){
			priority = newPri;
		}
		// Add additional functions here as necessary
		
	}
	
	private HeapData[] heap; // This should be the array where you store your data, priority pairs.
	// We recommend that you use an array that starts at index 1 to make the math easier
	
	private int size;
	
	public BinaryHeap(){
		//TODO BinaryHeap constructor
	}
	
	public BinaryHeap(int startArray){
		//TODO this constructor should set the start size of your heap array to startArray
	}
	
	public boolean isEmpty(){
		//TODO implement isEmpty
		return true;
	}
	
	public int size(){
		//TODO implement size
		return 0;
	}
	
	public String findMin(){
		//TODO implement findMin
		return null;
	}
	
	public void insert(String data, int priority){
		//TODO implement insert
	}
	
	public String deleteMin(){
		//TODO implement deleteMin
		return null;
	}
	
	public void makeEmpty(){
		//TODO implement makeEmpty
	}
	
	public boolean changePriority(String data, int newPri){
		//TODO implement changePriority
		return false;
	}

}
