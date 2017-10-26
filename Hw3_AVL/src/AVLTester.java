
/**
 * While writing this class, we consulted the following websites regarding how to
 * write test cases for exceptions (using JUnit):
 * https://www.mkyong.com/unittest/junit-4-tutorial-2-expected-exception-test/
 * https://github.com/junit-team/junit4/wiki/Exception-testing 
 * https://blog.goyello.com/2015/10/01/different-ways-of-testing-exceptions-in-java-and-junit/
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public abstract class AVLTester {

	public static boolean verifyAVL(StringTree toTest){
		// TODO Return true if toTest is an AVL implementation of a String tree and false otherwise. 
		// All StringTree interface methods must behave correctly
		// You may assume that size() and isEmpty() return the correct values
		// Other than this, do not assume anything about the tree toTest, including its start size.
                
                
                //insert(String key, String value);
                //find(String key);
                //makeEmpty();
                boolean test1 = testMakeEmpty(toTest);
                boolean test2 = testInsertNormal(toTest);
                testInsertException(toTest);
                boolean test4 = testFindNormal(toTest);
                testFindException(toTest);
                
		return test1 && test2 && test4;
	}
	
	// You may use as many static helper functions as you think are necessary
        private static boolean testMakeEmpty(StringTree toTest) {
            toTest.makeEmpty();
            if (toTest.size() == 0)
                return true;
            return false;
        }
        
        private static boolean testFindNormal(StringTree toTest) {
            if (toTest.size() == 0)
                return true;
            if (toTest.find("66").equals("day"))
                return true;
            return false;
        }
        
        private static boolean testInsertNormal(StringTree toTest) {
            toTest.makeEmpty();
            toTest.insert("20", "Today");
            toTest.insert("1", "is");
            toTest.insert("10", "a");
            toTest.insert("5", "wonderful");
            toTest.insert("66", "day");
            toTest.insert("11", "isn't");
            toTest.insert("4", "it");
            
            String actual = printTreeBFS(toTest);
            String expected = "a it Today is wonderful isn't day ";
            
            return actual.equals(expected);                
        }
        
        @Rule
        public static ExpectedException thrown = ExpectedException.none();

        @Test
        public static void testInsertException(StringTree toTest) {
            thrown.expect(IllegalArgumentException.class);
            thrown.expectMessage("Duplicate key!");

            toTest.insert("5", "?");
        }
        
        @Test
        public static void testFindException(StringTree toTest) throws NoSuchElementException {
            thrown.expect(NoSuchElementException.class);
            thrown.expectMessage("Key not found.");
            
            toTest.find("-9999");
        }

        private static String printTreeBFS(StringTree toTest) {
            Iterator<String> iter = toTest.getBFSIterator();
            String result = "";

            while(iter.hasNext()) {
                result = result + iter.next() + " ";
            }
            return result;
        }
}
