
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
		
                public String getData() {
                    return data;
                }
                
                public int getPriority() {
                    return priority;
                }
		
	}
	
	private HeapData[] heap; // This should be the array where you store your data, priority pairs.
	// We recommend that you use an array that starts at index 1 to make the math easier
	
	private int size;
	
	public BinaryHeap(){
            size = 0;    
            heap = new HeapData[size];
	}
	
	public BinaryHeap(int startArray){
            size = startArray;    
            heap = new HeapData[size];
	}
	
	public boolean isEmpty()
        {
            if (size == 0) 
                return true;
            else
                return false;
	}
	
	public int size(){
            return size;
	}
	
	public String findMin(){
            String result = heap[1].getData();
            return result;
	}
	
	public void insert(String data, int priority){
            //TODO implement insert
            
            HeapData newElement = new HeapData(data, priority);
            
            //if the heap is empty, insert into index 1
            if (isEmpty()) {
                heap[1] = newElement;
            }
            //else, add to the last leaf and bubble up as needed
            else {
                //add to the last leaf
                
                
                //while my parent is greater than me, i will keep switching up
                
            }
            

	}
	
	public String deleteMin(){
		//TODO implement deleteMin
            String result = heap[1].getData();
            
            //move the last element to the root
            heap[1] = heap[size - 1];
            size--;
            
            //and bubble down if I am greater than my children
            while (me > mychilren) {
                HeapData leftChild = heap[myIndex * 2];
                HeapData rightChild = heap[myIndex * 2 + 1];
                HeapData smallerChild = Math.min(leftChild.getPriority(), rightChild.getPriority());
                HeapData temp = heap[myIndex];
                heap[myIndex]= smallerChild;
                heap[smallerChild.getIndex] = temp;
            }
            return result;
	}
	
	public void makeEmpty(){
            //remove all the elements and set size to 0
            for (int i = 1; i < size; i++) {
                heap[i] = null;
            }
            size = 0;
	}
	
	public boolean changePriority(String data, int newPri){
		//goes through loop to see if there the string that is inserted exists
                //if it exists then change priority to new priority
                for( int i = 1; i <= size ; i++)
                {
                    if(data.equals(heap[i].getData()))
                    {
                        heap[i].changePriority(newPri);
                        //SWAP till it is in the correct position
                        
                        return true;
                              
                    }    
                }
		return false;
	}

}
