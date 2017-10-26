import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represents an AVLTree.
 * Note: methods getDeepestLevel(), buildListFromTree(), and printGivenOrder() 
 * are referenced in some or all parts from 
 * geeksforgeeks.org/level-order-tree-traversal
 * @author Nova A. & Thoa T.
 */
public class AVLTree implements StringTree {

	private class AVLNode {
            //Do not change these variable names
            String key;
            String value;
            AVLNode left;
            AVLNode right;
            int height;

            public AVLNode(String k, String v) 
            {
                key = k;
                value = v;
                left = null;
                right = null;
                height = 0;
            }   
	}
	
	AVLNode root;
        int size;

	public void makeEmpty() { root = null; }
	
	public int size() { return size; }
        
        public void insert(String key, String value) {
                AVLNode aNode = new AVLNode(key, value);
                insert(aNode, root);
	}

        private void insert(AVLNode aNode, AVLNode currPosition) {
                if (currPosition == null) {
                    currPosition = aNode;
                    size++;
                    updateHeightsInTree(root);
                    checkBalanceInTree(root);
                }
                else if (aNode.key.compareTo(currPosition.key) > 0) {  //if the new node is greater than the currentNode, go to the right
                    insert(aNode, currPosition.right);
                }
                else if (aNode.key.compareTo(currPosition.key) < 0) {  //if the new node is less than the currentNode, go to the left
                    insert(aNode, currPosition.left);
                }
                else //if duplicate
                    throw new IllegalArgumentException("Duplicate key!");
    }
        
        /* Return the value affiliated with the String key. 
           Throw a NoSuchElementException if the key is not in the AVLTree*/
	public String find(String key) {
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
                String prev;
                ArrayList<String> arr;
            
		public BFSIterator() {
                        arr = buildListFromTree();
                        curr = arr.get(0);
                        prev = null;
                }
        
                public boolean hasNext() {
			return curr != null;
		}

		public String next() {
			// TODO Return the next value in a BFS traversal of the tree
			// It should start at the root and iterate through left children before right
			if (curr == null) {
                            throw new NoSuchElementException();
                        }
                        String result = curr;
                        prev = curr;
                        int currIndx = arr.indexOf(curr);
                        curr = arr.get(currIndx + 1);
                        return result;
		}
	}
        
        /* Find the deepest level in a tree,
         * which is depth of that tree + 1 */
        public int getDeepestLevel(AVLNode root) {
                if (root == null)
                    return 0;
                else {
                    /* Compute deepest level of each subtree */
                    int lh = getDeepestLevel(root.left);
                    int rh = getDeepestLevel(root.right);

                    if(lh > rh)
                        return(lh + 1);
                    else return(rh + 1);
                }
        }
        
        /* Update heights for all the nodes in tree */
        private void updateHeightsInTree(AVLNode root) {
                while (root != null) {
                    root.height = getNodeHeight(root);
                    updateHeightsInTree(root.left);
                    updateHeightsInTree(root.right);
                }
        }
        
        /* Compute height for individual node */
        private int getNodeHeight(AVLNode currNode) {
                if (currNode == null)
                    return -1;
                if (currNode.left == null && currNode.right == null)
                    return 0;
                else {
                    int lh = getNodeHeight(root.left);
                    int rh = getNodeHeight(root.right);

                    if (lh > rh)
                        return lh + 1;
                    else
                        return rh + 1;
                }
        }
   
        private ArrayList<String> buildListFromTree() {
                ArrayList<String> arr = new ArrayList<>();

                //find the deepest level in this tree
                int deepest = getDeepestLevel(root); 

                for (int i = 1; i <= deepest; i++) {
                    printGivenLevel(root, i, arr);
                }
                return arr;
        }
        
        private void printGivenLevel(AVLNode currNode, int level, ArrayList<String> arr) {
                if (currNode == null)
                    return;
                if (level == 1) {
                    //add this node to the array list
                    arr.add(currNode.value);
                }
                else if (level > 1) {
                        printGivenLevel(currNode.left, level - 1, arr);
                        printGivenLevel(currNode.right, level - 1, arr);
                }
        }
        
        private void checkBalanceInTree(AVLNode currPosition) {
            
                /* 0 : node does not have child; 
                   1 : node has only one child; 
                  -1 : node is null */
                if (getNodeHeight(currPosition) <= 1) 
                    return;
                
                int hdiff = getNodeHeight(currPosition.left) - getNodeHeight(currPosition.right);
                if (hdiff <= 1 && hdiff >= -1) {
                    checkBalanceInTree(currPosition.left);
                    checkBalanceInTree(currPosition.right);
                }
                
                else if (hdiff > 1) {
                    //not balance, left is too tall                  
                    //is it left-left or left-right?
                    if (getNodeHeight(currPosition.left.left) - getNodeHeight(currPosition.left.right) >= 1)
                        fixLeftLeft(currPosition, currPosition.left);
                    else
                        fixLeftRight(currPosition, currPosition.left);                    
                }
                else {
                    //not balance, right is too tall
                    //is it right-right or right-left?
                    if (getNodeHeight(currPosition.right.right) - getNodeHeight(currPosition.right.left) >= 1)
                        fixRightRight(currPosition, currPosition.right);
                    else {
                        fixRightLeft(currPosition, currPosition.right);
                    }
                }
        }
        
        private void fixLeftLeft(AVLNode currPosition, AVLNode child) {
                //left-left, so move child into parent
                AVLNode newParent = child;
                child.right = currPosition;
                currPosition.left = newParent.right;
                currPosition = newParent;
        }
        
        private void fixRightRight(AVLNode currPosition, AVLNode child) {
                //right-right, so move child into parent
                AVLNode newParent = child;
                child.left = currPosition;
                currPosition.right = newParent.left;
                currPosition = newParent;
        }
        
        private void fixLeftRight(AVLNode currPosition, AVLNode child) {
                //left-right, so move grandChild into parent
                AVLNode grandChild = child.right;
                AVLNode leftOfGrandChild = grandChild.left;
                AVLNode rightOfGrandChild = grandChild.right;

                AVLNode newParent = grandChild;
                newParent.right = currPosition;
                currPosition.left = rightOfGrandChild;
                currPosition = newParent;
                newParent.left = child;
                child.right = leftOfGrandChild;
        }
        
        private void fixRightLeft(AVLNode currPosition, AVLNode child) {
                //right-left, so move grandChild into parent
                AVLNode grandChild = child.left;
                AVLNode rightOfGrandChild = grandChild.right;
                AVLNode leftOfGrandChild = grandChild.left;

                AVLNode newParent = grandChild;
                newParent.left = currPosition;
                currPosition.right = leftOfGrandChild;
                currPosition = newParent;
                newParent.right = child;
                child.left = rightOfGrandChild;
        }
}
