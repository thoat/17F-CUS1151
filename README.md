# 17F-CUS1151
Platform to do pair programming for this course' projects

## Homework: Project 3
We started on Sunday, 2017.10.21

Sun, 2017.10.21:
* We added a `height` instance variable, as well as a constructor for the `AVLNode` class.
* We added a `size` instance variable for `AVLTree` class.
* We filled in the bodies of the following methods in `AVLTree` class: `size()`, `makeEmpty()`, and `insert()`. The `insert()` method requires a helper method.

Wed, 2017.10.25:
* Filled in body for `find()` and a bit of `getBFSIterator`.

Thu, 2017.10.26:
* Finished up methods inside AVLTree, including `insert()` and `getBFSIterator()`
* Attempted AVLTester

*TODO*
 * Figure out JUnit in NetBeans IDE and complete AVLTester

## Homework: Project 2
We started on Thursday, 2017.09.28.

Thu, 2017.09.28:
* We added 2 more methods to private class `HeapData`: method `getData()` and method `getPriority()`.
* We filled in the body for:
  * default constructor and user-defined constructor. We set default length to 16.
  * `isEmpty()`, `size()`, `findMin()`, `makeEmpty()`, `insert()`, `deleteMin()`, and `changePriority()`. 
* We have not touched on the Test class yet. 

Mon, 2017.10.02:
* We started implementing the body of `testEmpty()` and `testOne()`.
* We also added the missing code (the "swap") inside the body of `BinaryHeap.changePriority`.

Tue, 2017.10.03:
* We augmented the methods `testEmpty()` and `testOne()`. 
* We also started implementing the body of `testMany()`. However, it's still currently incomplete code.

## Homework: Project 1
We started on Thursday, 2017.09.07.

Thu, 2017.09.07:
* We filled in the `Node` class. Each node has a data field and a link to the next node (one-way link).

* Then we filled out `ListQueue` class: constructors and 3 methods (`enqueue()`, `dequeue()`, `front()`). For each, we figured out the cases there would be, such as an empty queue, one-element queue, and many-element queue.

Sun, 2017.09.10:
* We got `testEmpty()` and `testOne()` to work. 
For each test, we test the `front()`, then `dequeue()`, then `enqueue()`, in the order of how those methods impact the queue's original state; otherwise, we will not be testing what we are supposed to. For example, when we want to test the methods on an empty queue, if we enqueue() before front(), the queue is no longer empety.

## Lab: Assignment 1
We started on Thursday, 2017.09.07.

Thu, 2017.09.07:
* Question 1 done.

Sun, 2017.09.10:
* Questions 5,6,7 done (still need a careful review, though).

Tue, 2017.09.19:
* Questions 8,9 done (believed to compute correctly, but may need to refine the language used)
* Questions 2,3,4 done
* Revised all question answers and submitted.

