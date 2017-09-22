import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	/*Your functions (on the left) correspond to the following java Queue functions (on the right)
	 * toTest.enqueue(String a) = toCompare.add(String a)
	 * toTest.dequeue() = toCompare.poll()
	 * toTest.front() = toCompare.peek()
	 * 
	 * This private class performs this interface for you.
	 */
    private static class JavaQueue{
    	//DO NOT EDIT THIS CLASS
    	Queue<String> queue;
    	protected JavaQueue(){
    		queue = new LinkedList<String>();
    	}
    	protected void enqueue(String a){
    		queue.add(a);
    	}
    	protected String dequeue(){
    		return queue.poll();
    	}
    	protected String front(){
    		return queue.peek();
    	}
    }

	public static void main(String[] args){
		testEmpty(new ListQueue(),new JavaQueue());
		testOne(new ListQueue(),new JavaQueue());
		testMany(new ListQueue(),new JavaQueue());
			
	}
	
	public static boolean testEmpty(ListQueue yourQueue, JavaQueue correctQueue){
		System.out.println("Test methods on empty queue:");
		boolean frontTest, dequeueTest, enqueueTest;
		
		//test front()
		if (yourQueue.front() == null && correctQueue.front() == null)		
			frontTest = true;
		else
			frontTest = false;
				
		//test dequeue()
		if (yourQueue.dequeue() == null && correctQueue.dequeue() == null)	
			dequeueTest = true;
		else
			dequeueTest = false;
		
		//test enqueue(String a)
		yourQueue.enqueue("hello");
		correctQueue.enqueue("hello");
		enqueueTest = checkEquals(yourQueue, correctQueue);
		
		return evaluateTestResults(frontTest, dequeueTest, enqueueTest);
	}

	public static boolean testOne(ListQueue a, JavaQueue b){
		//add one element in each queue first
		a.enqueue("goodbye");
		b.enqueue("goodbye");
		
		//starting the test
		System.out.println("Test methods on queue with one element:");
		boolean frontTest, dequeueTest, enqueueTest;
		
		//test front()
		String yourFString = a.front();
		String correctFString = b.front();
		frontTest = yourFString.equals(correctFString);
		
		//test dequeue()
		String yourDString = a.dequeue();
		String correctDString = b.dequeue();
		dequeueTest = yourDString.equals(correctDString);
		
		//test enqueue(String a)
		a.enqueue("hello");
		b.enqueue("hello");
		enqueueTest = checkEquals(a, b);
		
		return evaluateTestResults(frontTest, dequeueTest, enqueueTest);
	}
	
	public static boolean testMany(ListQueue a, JavaQueue b){
		//TODO implement a test of the three functions when the queues have many elements
		//Compare the result of your queue  against the java implementation
		//More than one test may be necessary
		
		//add 10 or more elements in each queue first
		a.enqueue("hello");
		a.enqueue("world");
		a.enqueue("this");
		a.enqueue("is");
		a.enqueue("a");
		a.enqueue("wonderful");
		a.enqueue("rainy");
		a.enqueue("windy");
		a.enqueue("day");
		a.enqueue("today");
		
		b.enqueue("hello");
		b.enqueue("world");
		b.enqueue("this");
		b.enqueue("is");
		b.enqueue("a");
		b.enqueue("wonderful");
		b.enqueue("rainy");
		b.enqueue("windy");
		b.enqueue("day");
		b.enqueue("today");
		
		//starting the test
		System.out.println("Test methods on queue with many elements:");
		boolean frontTest, dequeueTest, enqueueTest;
		
		//test front()
		String yourFString = a.front();
		String correctFString = b.front();
		frontTest = yourFString.equals(correctFString);
		
		//test dequeue()
		String yourDString = a.dequeue();
		String correctDString = b.dequeue();
		dequeueTest = yourDString.equals(correctDString);
		
		//test enqueue(String a)
		a.enqueue("goodbye");
		b.enqueue("goodbye");
		enqueueTest = checkEquals(a, b);
		
		return evaluateTestResults(frontTest, dequeueTest, enqueueTest);
	}
	
	private static boolean checkEquals(ListQueue a, JavaQueue b) {
		String actual = "";
		while (a.front() != null) {
			actual += a.dequeue();
		}
		String expected = "";
		while (b.front() != null) {
			expected += b.dequeue();
		}
		if (actual.equals(expected))
			return true;
		else
			return false;
	}
	private static boolean evaluateTestResults(boolean frontTest, boolean dequeueTest, boolean enqueueTest) {
		if (dequeueTest == true && 
				frontTest == true && 
				enqueueTest == true) {
			System.out.println("Test succeeded.");
			System.out.println();
			return true;
		}
		else {
			System.out.print("Test failed at ");
			if (frontTest == false) 	System.out.print("front() ");
			if (dequeueTest == false) 	System.out.print("dequeue() ");
			if (enqueueTest == false)	System.out.print("enqueue() ");
			System.out.println();
			return false;
		}
	}
}