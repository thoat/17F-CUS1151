import java.util.Iterator;

public class AVLTree implements StringTree{

	private class AVLNode{
		//Do not change these variable names
		String key;
		String value;
		AVLNode left;
		AVLNode right;
                int height;
		
		//Place any additional fields you need here
			
		//TODO implement the node class here
                public AVLNode(String k, String v) {
                    key = k;
                    value = v;
                    left = null;
                    right = null;
                    height = 0;
                }
	}
	
	//Use this variable as your root
	AVLNode root;
        int size;
	
	//You may use any additional fields here as you see fit
	
	public void makeEmpty() {
                root = null;
	}
	
	public int size() {
		return size;
	}

	public void insert(String key, String value) {
		// TODO Insert the <key,value> pair into the AVLTree
		// Throw an IllegalArgumentException if the client attempts to insert a duplicate key
                AVLNode aNode = new AVLNode(key, value);
                insert(aNode, root);
		
	}
        
        private void insert(AVLNode aNode, AVLNode currPosition) {
        if (currPosition == null) {
            currPosition = aNode;
            size++;
        }
        else if (currPosition.key.compareTo(aNode.key) < 0) {  //if currentNode is smaller than the new node, go to the right
            insert(aNode, currPosition.right);
        }
        else if (currPosition.key.compareTo(aNode.key) > 0) {  //if currentNode is greater than the new node, go to the left
            insert(aNode, currPosition.left);
        }
        else //if duplicate
            throw new IllegalArgumentException("Duplicate key!");
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
