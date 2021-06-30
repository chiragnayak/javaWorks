package General.concepts.concurrency.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author cnayak
 * 
 *         This is the recursive implementation of the algorithm; inherit from
 *         RecursiveTask instead of RecursiveAction since we're returning
 *         values.
 *
 */

public class SumOfNUsingForkJoin {

	private static long N = 1000_000;
	// one million - we want to compute sum
	// from 1 .. one million

	private static final int NUM_THREADS = 10;
	// number of threads to create for
	// distributing the effort

	static class RecursiveSumOfN extends RecursiveTask<Long> {

		long from;
		long to;

		// from and to are range of values to sum-up
		public RecursiveSumOfN(long from, long to) {
			this.from = from;
			this.to = to;
		}

		@Override
		protected Long compute() {

			// condition (custom) to decide whether to fork a thread further or
			// do the computation and return result
			if ((to - from) <= N / NUM_THREADS) {

				long localSum = 0;

				// add in range 'from' .. 'to' inclusive of the value 'to'
				for (long i = from; i <= to; i++) {
					localSum += i;
				}
				System.out.printf("\tSum of value range %d to %d is %d %n", from, to, localSum);

				// value is returned from this thread.
				return localSum;

			} else {

				// no, the range is too big for a thread to handle,
				// so fork the computation
				// we find the mid-point value in the range from..to
				long mid = (from + to) / 2;

				System.out.printf("Forking computation into two ranges: " + "%d to %d and %d to %d %n", from, mid, mid,
						to);

				// determine the computation for first half
				// with the range from..mid
				RecursiveSumOfN firstHalf = new RecursiveSumOfN(from, mid);

				firstHalf.fork();

				RecursiveSumOfN secondHalf = new RecursiveSumOfN(mid + 1, to);

				long resultSecondHalf = secondHalf.compute();

				return firstHalf.join() + resultSecondHalf;

			}

		}

	}

	public static void main(String[] args) {

		// Create a fork-join pool that consists of NUM_THREADS
		ForkJoinPool pool = new ForkJoinPool(NUM_THREADS);
		
		// submit the computation task to the fork-join pool
		long computedSum = pool.invoke(new RecursiveSumOfN(0, N));
		
		// this is the formula sum for the range 1..N
		long formulaSum = (N * (N + 1)) / 2;
		
		// Compare the computed sum and the formula sum
		System.out.printf("Sum for range 1..%d; computed sum = %d, " + "formula sum = %d %n", N, computedSum,
				formulaSum);

	}

}
