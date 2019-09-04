package module8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadsTimer {

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		long start_time = System.currentTimeMillis();
		long nPoints = 10000000L;
		int nThreads = 4;
		ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
		List<Future<Double>> futures = new ArrayList<Future<Double>>();
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			MonteCarloPiCalculatorTask task = new MonteCarloPiCalculatorTask(nPoints / nThreads);
			Future<Double> future = threadPool.submit(task);
			futures.add(future);
		}
		double sum = 0.0;
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			double result = futures.get(iThread).get();
			sum += result;
		}
		threadPool.shutdown();
		double pi = sum / nThreads;
		System.out.println("The time taken to run the program using 4 threads is: ");
		System.out.println(System.currentTimeMillis()-start_time);
		System.out.println("and the value of pi calculated is:"+pi);
		
		start_time = System.currentTimeMillis();
		MonteCarloPiCalculatorTask task = new MonteCarloPiCalculatorTask(nPoints);
		pi = task.call();
		
		System.out.println("Comparatively, the time it takes to run it using one thread is: ");
		System.out.println(System.currentTimeMillis()-start_time);
		
		System.out.println("Which takes longer, as expected, due to a smaller available processing power");
		System.out.println("Note it is not 4x less time as there are diminishing returns related to the usage of multiple threads");


		
	}
}
