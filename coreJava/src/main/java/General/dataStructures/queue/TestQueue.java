package General.dataStructures.queue;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {

	public static void main(String[] args) {

		Queue<String> qInterfaceRef = new LinkedList<>();

		qInterfaceRef.add("chirag");
		qInterfaceRef.add("nayak");
		qInterfaceRef.add("Thane");

		/*
		 * From java doc : ===============
		 * 
		 * Queue implementations generally do not allow insertion of null elements,
		 * although some implementations, such as LinkedList, do not prohibit insertion
		 * of null. Even in the implementations that permit it, null should not be
		 * inserted into a Queue, as null is also used as a special return value by the
		 * poll method to indicate that the queue contains no elements.
		 * 
		 * meaning : ==========
		 * 
		 * It means that if you insert a null to a LinkedList, if you call poll and get
		 * null, you can't tell is the Queue is empty or if a null element was at the
		 * head of the Queue.
		 * 
		 * Therefore, you can insert null to a LinkedList, but you should avoid doing so
		 * if you intend to use that LinkedList as a Queue.
		 * 
		 */

		qInterfaceRef.add(null);

		/*
		 * Retrieves, but "does not remove, the head of this queue", or returns null if
		 * this queue is empty.
		 * 
		 * Returns:the head of this queue, or null if this queue is empty
		 */
		System.out.println(qInterfaceRef.peek());

		/*
		 * Retrieves, but "does not remove, the head of this queue". This method differs
		 * from peek only in that it throws an exception if this queue is empty.
		 * 
		 * Returns:the head of this queue
		 * 
		 * Throws:NoSuchElementException - if this queue is empty
		 * 
		 */
		System.out.println(qInterfaceRef.element());

		/*
		 * 
		 * Retrieves and "removes the head of this queue", or returns null if this queue
		 * is empty.
		 * 
		 * Returns:the head of this queue, or null if this queue is empty
		 * 
		 */
		System.out.println(qInterfaceRef.poll());

		/*
		 * Removes a single instance of the specified element from this collection, if
		 * it is present (optional operation).
		 * 
		 * More formally, removes an element e such that (o==null ? e==null :
		 * o.equals(e)), if this collection contains one or more such elements.
		 * 
		 * Returns true if this collection contained the specified element (or
		 * equivalently, if this collection changed as a result of the call).
		 * 
		 * Parameters:o element to be removed from this collection, if present
		 * 
		 * Returns:true if an element was removed as a result of this call
		 * 
		 * Throws:
		 * 
		 * ClassCastException - if the type of the specified element is incompatible
		 * with this collection (optional)
		 * 
		 * NullPointerException - if the specified element is null and this collection
		 * does not permit null elements (optional)
		 * 
		 * UnsupportedOperationException - if the remove operation is not supported by
		 * this collection
		 * 
		 */
		System.out.println(qInterfaceRef.remove("chirag"));

		/*
		 * Retrieves and removes the head of this queue. This method differs from poll
		 * only in that it throws an exception if this queue is empty.
		 * 
		 */
		System.out.println(qInterfaceRef.remove());

		System.out.println(qInterfaceRef.add("chirag"));

		/*
		 * Inserts the specified element into this queue if it is possible to do so
		 * immediately without violating capacity restrictions, returning true upon
		 * success and throwing an IllegalStateException if no space is currently
		 * available
		 * 
		 * returns : true (as specified by Collection.add), else throws exception (in case of failure)
		 */
		System.out.println(qInterfaceRef.add("chirag")); // allows duplicates.

		/*
		 * Inserts the specified element into this queue if it is possible to do so
		 * immediately without violating capacity restrictions. When using a
		 * capacity-restricted queue, this method is generally preferable to add, which
		 * can fail to insert an element only by throwing an exception. 
		 * 
		 * Parameters:e the element to add
		 * 
		 * Returns:true if the element was added to this queue, else false
		 */
		System.out.println(qInterfaceRef.offer("chirag"));

		// duplicate references to required object type (string)
		String x = new String("duplicate");
		System.out.println(qInterfaceRef.add(x));
		System.out.println(qInterfaceRef.add(x)); // allows

		System.out.println(qInterfaceRef.toString());

	}

}
