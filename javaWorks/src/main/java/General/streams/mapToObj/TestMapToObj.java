package General.streams.mapToObj;

import java.util.stream.IntStream;

public class TestMapToObj {

	/**
	 * Returns an object-valued Stream consisting of the results of applying the
	 * given function to the elements of this stream.
	 * 
	 * This is an intermediate operation. 
	 * 
	 * Type Parameters:<U> the element type of the new stream
	 * 
	 * Parameters: mapper a non-interfering, stateless function to
	 * apply to each element
	 * 
	 * Returns:the new streamReturns an object-valued Stream
	 * consisting of the results of applying the given function to the elements of
	 * this stream.
	 * 
	 *  --> Can be used to convert one type of stream to another type of stream
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int[] array = new int[] { 9, 1, 4, 2, 1, 5, 99, 33, 2 };

		// IntStream --- mapped and converted to stream of string ----- //
		IntStream.of(array).mapToObj(s -> String.valueOf(s) + ",").forEach(System.out::print);

	}

}
