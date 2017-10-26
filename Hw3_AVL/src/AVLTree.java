import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class AVLTree implements StringTree{

    
	private class AVLNode
        {
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
                AVLNode aNode = new AVLNode(key, value);
                insert(aNode, root);
		
	}
        
        private void checkBalance(AVLNode currPosition) {
                if (currPosition.left.height - currPosition.right.height > 1) {
                    //not balance, left is too tall, have to switch
                }
                else if (currPosition.left.height - currPosition.right.height < -1) {
                    //not balance, right is too tall, have to switch
                }
                else
                    return;
        }

        private void insert(AVLNode aNode, AVLNode currPosition) {
                if (currPosition == null) {
                        currPosition = aNode;
                        size++;
                        checkBalance(currPosition);
        }
                else if (currPosition.key.compareTo(aNode.key) < 0) {  //if currentNode is smaller than the new node, go to the right
                        currPosition.height++;
                        insert(aNode, currPosition.right);
                }
                else if (currPosition.key.compareTo(aNode.key) > 0) {  //if currentNode is greater than the new node, go to the left
                        currPosition.height++;
                        insert(aNode, currPosition.left);
                }
                else //if duplicate
                        throw new IllegalArgumentException("Duplicate key!");
    }

	public String find(String key) {
		// TODO Return the value affiliated with the String key.
		// Throw an ObjectNotFoundException if the key is not in the AVLTree
		return find(key, root);
	}
        
        private String find(String key, AVLNode currentNode) {
            if (currentNode == null)
                throw new NoSuchElementException("Key not found.");
            if (key.compareTo(currentNode.key) == 0)
                return currentNode.value;
            if (key.compareTo(currentNode.key) > 0)
                return find(key, currentNode.right);
            else
                return find(key, currentNode.left);
        }

 
       
      
	public Iterator<String> getBFSIterator() {
		// TODO Only complete this section if you wish to attempt the 10 points EC
		// This function should return a BFSIterator: Starter code provided below
		return new BFSIterator();
	}
	
/*	Define your private Iterator class below.
        Cite: geeksforgeeks.org/level-order-tree-traversal */
        
	private class BFSIterator implements Iterator<String>{            
                String curr;
                String currPlus;
                ArrayList<String> arr;
            
		public BFSIterator() {
                    arr = buildListFromTree(root);
                    currPlus = arr.get(0);
                    curr = null;
                }
        
                public boolean hasNext() {
			return currPlus != null;
		}

		public String next() {
			// TODO Return the next value in a BFS traversal of the tree
			// It should start at the root and iterate through left children before right
			if (currPlus == null) {
                            throw new NoSuchElementException();
                        }
                        String result = currPlus;
                        curr = currPlus;
                        int currPlusIndx = arr.indexOf(currPlus);
                        currPlus = arr.get(currPlusIndx + 1);
        
        
                        return result;
		}
                        
                public ArrayList<String> buildListFromTree(AVLNode root) {
                    ArrayList<String> arr = new ArrayList<String>();
                    int h = height(root);
                    int i;
                    for (i = 1; i <= height; i++) {
                        printGivenLevel(root, i, arr);
                    }
                    return arr;
                }
                
                void printGivenLevel(AVLNode root, int level, ArrayList<String> arr) {
                    if (root == null)
                        return;
                    if (level == 1) {
                        //add this to the array list
                        arr.add(root.value);
                    }
                    else if (level > 1) {
                            printGivenLevel(root.left, level - 1, arr);
                            printGivenLevel(root.right, level - 1, arr);
                    }
                }
                
                int height(AVLNode root) {
                    if (root == null)
                        return 0;
                    else {
                        /* Compute height of each subtree */
                        int lh = height(root.left);
                        int rh = height(root.right);
                        
                        if(lh > rh)
                            return(lh + 1);
                        else return(rh + 1);
                    }
                }
	}
}

  
