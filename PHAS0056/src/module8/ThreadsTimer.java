package module8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadsTimer {

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		// We initialise the time from which we start counting
		long start_time = System.currentTimeMillis();

		// And define the necessary initial variables
		long nPoints = 10000000L;
		int nThreads = 4;

		// We divide the calculation between 4 threads
		// each of these will calculate their own estimate of pi for a quarter of all
		// points
		ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
		List<Future<Double>> futures = new ArrayList<Future<Double>>();
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			MonteCarloPiCalculatorTask task = new MonteCarloPiCalculatorTask(nPoints / nThreads);
			Future<Double> future = threadPool.submit(task);
			futures.add(future);
		}
		// We take the average of these estimates, which is the same as if we performed
		// the task for 4 times as many points in each case
		double sum = 0.0;
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			double result = futures.get(iThread).get();
			sum += result;
		}
		threadPool.shutdown();
		double pi = sum / nThreads;
		
		// The relevant outputs are given
		System.out.println("The time taken to run the program using 4 threads is: ");
		System.out.println(System.currentTimeMillis() - start_time);
		System.out.println("and the value of pi calculated is: " + pi);
		
		
		// And we restart the timer to measure the time it takes to do the same task using one thread
		start_time = System.currentTimeMillis();
		
		// Which we initialise below
		MonteCarloPiCalculatorTask task = new MonteCarloPiCalculatorTask(nPoints);
		pi = task.call();

		// Again, we print out the relevant outputs
		System.out.println("Comparatively, the time it takes to run it using one thread is: ");
		System.out.println(System.currentTimeMillis() - start_time);
		System.out.println("and the value of pi calculated is: "+pi);

		// Observations are printed out below
		System.out.println("Which takes longer, as expected, due to a smaller available processing power");
		System.out.println(
				"Note it is not 4x less time as there are diminishing returns related to the usage of multiple threads");
		System.out.println("The accuracy of the estimates should be the same as the effective number of points considered is the same.");
		

	}
}
