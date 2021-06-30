package General.streams.flatMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import General.PrintUtility;

/**
 * 
 * 
 * (if base stream is of String, as in below test)
 
<String> Stream<String> java.util.stream.Stream.flatMap(Function<? super String[], ? extends Stream<? extends String>> mapper)


Returns a stream consisting of the results of replacing each element of this stream with the contents of a mapped stream 
produced by applying the provided mapping function to each element. 

Each mapped stream is closed after its contents have been placed into this stream. (If a mapped stream is null an empty stream is used, instead.) 

This is an intermediate operation.

Type
 
Parameters:<R> The element type of the new stream
Parameters:mapper a non-interfering, stateless function to apply to each element which produces a stream of new values

Returns:the new stream@apiNoteThe flatMap() operation has the effect of applying a one-to-many transformation to the elements of the stream, and then flattening the resulting elements into a new stream. 

Examples. 

If orders is a stream of purchase orders, and each purchase order contains a collection of line items, then the following produces a stream containing all the line items in all the orders: 
orders.flatMap(order -> order.getLineItems().stream())...

If path is the path to a file, then the following produces a stream of the words contained in that file: 
	
	 Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
     Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +")));
     
The mapper function passed to flatMap splits a line, using a simple regular expression, into an array of words, and then creates a stream of words from that array.
 * @author cnayak
 *
 */
public class TestFlatMap {
	
	public static void main(String[] args) {
		 flatMap();
		 
		 System.out.println(" =========== SIMPLE EXAMPLE ============== ");
		 
		 flatMapSimpleExample();
	}
	
	private static void flatMapSimpleExample() {
		
		// flat map
		// 2d int array to flat 1d
		System.out.println("FLAT MAP a 2D array");
		int[][] i1 = new int[][] { 
									{ 1, 2, 3 }, 
									{ 4, 5, 6 }, 
									{ 7, 8, 9 } 
								};
								
		Arrays.asList(i1)
		    .stream() //converts to stream of int []
			.flatMap(y -> Arrays.stream(y).boxed()) //for each element (int[]) converts to IntStream which is then boxed() [Returns a Stream consisting of the elements of this stream, each boxed to an Integer"]. Finally, a stream of stream that is passed to flatMap.
			.forEach(System.out::print); //prints it
		
		System.out.println("FLAT MAP a 3D array");
		
		int [][][] i2  = new int[][] [] { 
											{ 
												{1, 2, 3}
											}, 
											{ 
												{4, 5, 6}
											},
											{ 
												{7, 8, 9}
											},
										};
									
		Arrays.asList(i2) //converts to list of int [][]
		    .stream() //converts to stream of int [][]
			.flatMap(twoD -> Arrays.stream(twoD)) //input (element) is int [][], maps to stream of int [], output is stream of int []
			.flatMap(oneD -> Arrays.stream(oneD).boxed()) // input (element) is int [], maps to stream of ints, output is IntStream, then boxed
			.forEach(System.out::print); //prints it
		
	}

	private static void flatMap() {
		
		//find unique characters
		
		String [] strings = "jhony jhony yes papa eating sugar no papa telling lies no papa open your mouth ha ha ha".split("\\s");
		
		PrintUtility.printBanner("without flatMap()");		
		
		Arrays.asList(strings).stream().map(x -> x.split("")).distinct().forEach(System.out::println);
		
		PrintUtility.printBanner("with flatMap() - 1 - for array input with map()");		
		Arrays.asList(strings).stream()
			.map(x -> x.split(""))
			.flatMap(x -> Arrays.asList(x).stream())
			.distinct()
			.forEach(System.out::println);
		
		/*
		 * what is happening ?
		 * 
		 * in : Arrays.asList(strings).stream()
		 * 
		 * 	   strings array is converted to corresponding stream with each element as
		 *     "word" in it.
		 * 
		 * in : map(x -> x.split(""))
		 * 
		 * 	  each element "word" is then splitted into String[] having individual "string" letters.
		 * 
		 * in : flatMap(x -> Arrays.asList(x).stream())
		 * 
			  each element "word" that is now a String [] from above is fed to flatMap(), which applies mapping function
			  
			  "x -> Arrays.asList(x).stream()" 
			  
			  and converts each (element) array to list and then to stream and then by property of flatMap() adds to outgoing
			  single stream.
		 * 
		 * in : distinct().forEach(System.out::println);
		 * 
		 *   distinct/unique elemets are preserved and printed by Sys.out.println
		 * 
		 */
		
		PrintUtility.printBanner("with flatMap() - 2 - for array without map()");
		Arrays.asList(strings).stream().flatMap(x -> Arrays.stream(x.split(""))).distinct().forEach(System.out::println);
		
		PrintUtility.printBanner("with flatMap() for List input");
		List<List<Integer>> squares = new ArrayList<>();
		
		squares.add(Arrays.asList(new Integer[] {1,2,3}));
		squares.add(Arrays.asList(new Integer[] {4,5}));
		
		squares.stream().flatMap(x -> x.stream()).map(x -> x*x).forEach(System.out::println);
	}
	
	/*
	
	++++++++++++++++++
	without flatMap()
	++++++++++++++++++
	[Ljava.lang.String;@65ab7765
	[Ljava.lang.String;@1b28cdfa
	[Ljava.lang.String;@eed1f14
	[Ljava.lang.String;@7229724f
	[Ljava.lang.String;@4c873330
	[Ljava.lang.String;@119d7047
	[Ljava.lang.String;@776ec8df
	[Ljava.lang.String;@4eec7777
	[Ljava.lang.String;@3b07d329
	[Ljava.lang.String;@41629346
	[Ljava.lang.String;@404b9385
	[Ljava.lang.String;@6d311334
	[Ljava.lang.String;@682a0b20
	[Ljava.lang.String;@3d075dc0
	[Ljava.lang.String;@214c265e
	[Ljava.lang.String;@448139f0
	[Ljava.lang.String;@7cca494b
	[Ljava.lang.String;@7ba4f24f
	++++++++++++++++++++++++++++++++++++++++++++++++
	with flatMap() - 1 - for array input with map()
	++++++++++++++++++++++++++++++++++++++++++++++++
	j
	h
	o
	n
	y
	e
	s
	p
	a
	t
	i
	g
	u
	r
	l
	m
	+++++++++++++++++++++++++++++++++++++++++++++
	with flatMap() - 2 - for array without map()
	+++++++++++++++++++++++++++++++++++++++++++++
	j
	h
	o
	n
	y
	e
	s
	p
	a
	t
	i
	g
	u
	r
	l
	m
	++++++++++++++++++++++++++++++
	with flatMap() for List input
	++++++++++++++++++++++++++++++
	1
	4
	9
	16
	25

	  
	 * */

}
