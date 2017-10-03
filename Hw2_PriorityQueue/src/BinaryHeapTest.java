
public abstract class BinaryHeapTest {

	public static void main(String[] args) {
		// Use your tests here to make sure your implementation is working, this is for your help
		// Call your tests here to make sure that your implementation works.
		// This section will not be graded
		
		testEmptyHelper(new BinaryHeap());
		testOneHelper(new BinaryHeap());
		
		//testMany(new BinaryHeap())

	}
	
	private static void testEmptyHelper(BinaryHeap toTest) {
		if (testEmpty(toTest))
			System.out.println("Test empty: successful.");
		else
			System.out.println("Test empty: failed.");
			
	}
	
	private static void testOneHelper(BinaryHeap toTest) {
		if (testOne(toTest))
			System.out.println("Test empty: successful.");
		else
			System.out.println("Test empty: failed.");
			
	}
	//Make the below tests as thorough as possible.
	//Assume toTest is empty when the function is called
	//These will be tested against other implementations, both correct and incorrect, so be as thorough as you can
	//Only applicable functions need to be tested at each level.
	//Helper tests are strongly recommended
	
	public static boolean testEmpty(BinaryHeap toTest){
		//TODO write a test case that tests functionality for all of the functions applicable to a BinaryHeap when it is empty
		//toTest should be empty when it is called
		//You may find writing helper tests to be useful
		//This should return true if it passes your tests, false otherwise
		
		//isEmpty()
		boolean one = toTest.isEmpty();
		//size()
		boolean two = (toTest.size() == 0);
		//insert(String data, int priority)
		toTest.insert("first word", 2);
		String actual = "";
		while (!(toTest.isEmpty())) {
			actual += toTest.deleteMin() + ", "; 
		}
		boolean three = (actual.equals("first word, "));
		
		return (one && two && three);
		
	}
	
	public static boolean testOne(BinaryHeap toTest){
		//TODO write a test case that tests functionality for all of the functions applicable to a BinaryHeap when it has one element
		//Add the element in this function, toTest should be empty when it is called.
		toTest.insert("first word", 2);
		
		//You may find writing helper tests to be useful
		//This should return true if it passes your tests, false otherwise
		
		//isEmpty()
		boolean one = !(toTest.isEmpty());
		//size()
		boolean two = (toTest.size() == 1);
		//findMin()
		String min = toTest.findMin();
		boolean three = (min.equals("first word"));
		
		//deleteMin()
		String deleted = toTest.deleteMin();
		boolean four = (deleted.equals("first word"));
				
		//insert(String data, int priority)
		toTest.insert("first word", 2);
		toTest.insert("second word", 3);
		String actual = "";
		while (!(toTest.isEmpty())) {
			actual += toTest.deleteMin() + ", "; 
		}
		boolean five = (actual.equals("first word, second word, "));
		
		return (one && two && three && four && five); 
	}
	
	public boolean testMany(BinaryHeap toTest){
		//TODO write a test case that tests functionality for all of the functions applicable to a BinaryHeap when it has many elements
		//Add the elements to the BinaryHeap in this function, toTest should be empty when it is called.
                toTest.insert("first word", 2);
                toTest.insert("second word", 3);
                toTest.insert("third word", 1);
                toTest.insert("fourth word", 20);
                toTest.insert("fifth word", 12);
                toTest.insert("sixth word", 3);
                toTest.insert("seventh word", 15);
                toTest.insert("eighth word", 7);
                toTest.insert("ninth word", 8);
                toTest.insert("tenth word", 4);
                
		//isEmpty()
		boolean one = !(toTest.isEmpty());
		//size()
		boolean two = (toTest.size() == 10);
		//findMin()
		String min = toTest.findMin();
		boolean three = (min.equals("third word"));
                
		//insert(String data, int priority)
		//findMin()
		//deleteMin()
		//changePriority(String data, int priority)
	
		//You may find writing helper tests to be useful
		//This should return true if it passes your tests, false otherwise
		return false;
	}

}
