import java.util.Iterator;

public class AVLTree implements StringTree{
	
	private class AVLNode{
		//Do not change these variable names
		String key;
		String value;
		AVLNode left;
		AVLNode right;
		
		//Place any additional fields you need here
			
		//TODO implement the node class here
	}
	
	//Use this variable as your root
	AVLNode root;
	
	//You may use any additional fields here as you see fit
	
	public void makeEmpty() {
		// TODO Remove all elements from the AVL tree.
                root = null;
	}
	
	public int size() {
		// TODO Return the number of elements currently in the tree.
		return 10;
	}

	public void insert(String key, String value) {
		// TODO Insert the <key,value> pair into the AVLTree
		// Throw an IllegalArgumentException if the client attempts to insert a duplicate key
		
	}

	public String find(String key) {
		// TODO Return the value affiliated with the String key.
		// Throw an ObjectNotFoundException if the key is not in the AVLTree
		return null;
	}

	public Iterator<String> getBFSIterator() {
		// TODO Only complete this section if you wish to attempt the 10 points EC
		// This function should return a BFSIterator: Starter code provided below
		return null;
	}
	
/*	Define your private Iterator class below.

	private class BFSIterator implements Iterator<String>{
		
		public boolean hasNext() {
			// TODO Return true if the iterator has another value to return
			return false;
		}

		public String next() {
			// TODO Return the next value in a BFS traversal of the tree
			// It should start at the root and iterate through left children before right
			return null;
		}
	
	}
*/


}
