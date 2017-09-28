
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
	
	private int size; //size refers to the last used position
	
	public BinaryHeap(){
            size = 0;    
            heap = new HeapData[16]; 
	}
	
	public BinaryHeap(int startArray){
            size = 0;    
            heap = new HeapData[startArray];
	}
	
	public boolean isEmpty(){
            if (size == 0) 
                return true;
            return false;
	}
	
	public int size(){
            return size;
	}
	
	public String findMin(){
            if (isEmpty())
                return null;
            String result = heap[1].getData();
            return result;
	}
	
	public void insert(String data, int priority){
            
            HeapData newElement = new HeapData(data, priority);
            
            //if the heap is empty, insert into index 1
            if (isEmpty()) {
                heap[1] = newElement;
            }
            
            else {
                //check first if the heap is full (i.e. last used position is also the last array element). 
                //if yes, resize the array before adding
                if (size == heap.length - 1) {

                    //create a new heap with double the size
                    HeapData[] newHeap = new HeapData[2 * heap.length];

                    //copy all the old elements over
                    for (int i = 0; i <= size; i++) {
                        newHeap[i] = heap[i];
                    }

                    //update the value of heap's size & point the "heap" reference to the new, bigger array
                    size = 2 * size;
                    heap = newHeap;
                }  
                //now, add to the last leaf and bubble up as needed
                //add to the first available slot
                size++;
                
                //while my parent is greater than me, i will keep switching up
                int indexForNewElement = percolateUp(size, priority);
                heap[indexForNewElement] = newElement; 
            }
	}
	
        private int percolateUp(int myIndex, int myPriority) {
            while (myIndex > 1 && myPriority < heap[myIndex/2].getPriority()) {
                heap[myIndex] = heap[myIndex/2];
                myIndex = myIndex/2;
            }
            return myIndex;
        }
        
	public String deleteMin(){
		//TODO implement deleteMin
            if (isEmpty())
                return null;
            String result = heap[1].getData();
            
            int newIndexForLastElement = percolateDown(1, heap[size].getPriority());
            heap[newIndexForLastElement] = heap[size];
            size--;
            return result;
            
//            //move the last element to the root
//            heap[1] = heap[size - 1];
//            size--;
//            
//            //and bubble down if I am greater than my children
//            while (me > mychilren) {
//                HeapData leftChild = heap[myIndex * 2];
//                HeapData rightChild = heap[myIndex * 2 + 1];
//                HeapData smallerChild = Math.min(leftChild.getPriority(), rightChild.getPriority());
//                HeapData temp = heap[myIndex];
//                heap[myIndex]= smallerChild;
//                heap[smallerChild.getIndex] = temp;
//            }
//            return result;
	}
	
        private int percolateDown(int myIndex, int myPriority) {
            
            //while I still have at least a child (i.e. my left child)
            while (2 * myIndex <= size) {
                int leftChild = 2 * myIndex;
                int rightChild = leftChild + 1;
                int targetIndex;
                
                //if my left child is smaller, or if I don't have a right child
                if (heap[leftChild].getPriority() < heap[rightChild].getPriority() 
                    || rightChild > size)
                    targetIndex = leftChild;
                else
                    targetIndex = rightChild;
                if (heap[targetIndex].getPriority() < myPriority) {
                    heap[myIndex] = heap[targetIndex];
                    myIndex = targetIndex;
                }
                else
                    break;
            }
            return myIndex;
        }
        
	public void makeEmpty(){
            HeapData[] newHeap = new HeapData[heap.length];
            size = 0;
            heap = newHeap;
	}
	
        //if a HeapData changes its priority, will it be re-positioned in the heap?
	public boolean changePriority(String data, int newPri){
		//TODO implement changePriority
		return false;
	}

}
