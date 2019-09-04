package module8;

public class ThreadsMain {

	public static void main(String[] args) throws InterruptedException {

		// We initialise both tasks in separate threads
		CountdownTask cdt = new CountdownTask(10);
		PrimeNumberTask pnt = new PrimeNumberTask();
		Thread countdownTask = new Thread(cdt);
		Thread primeNumberTask = new Thread(pnt);

		// We start both tasks
		countdownTask.start();
		primeNumberTask.start();

		// Waiting until the countdown is complete
		try {
			countdownTask.join();
		}

		catch (InterruptedException e) {

		}

		// and only thenafter do we interrupt our prime number task
		primeNumberTask.interrupt();
		// We must tell the thread to wait a short while to avoid a
		// ConcurrentModificationException
		primeNumberTask.join(200);

		// Below we print out the required information
		// Note that the first and second output will often be similar as the time it
		// will take for the checking loop to run for a new, large, prime number will be
		// progressively more and more compared to non-primes
		System.out.println("The largest number we checked is " + pnt.largest_checked + ".");
		System.out.println("The largest prime number found is " + pnt.primeList.get(pnt.primeList.size() - 1) + ".");
		System.out.println("The total number of primes found is " + pnt.primeList.size() + ".");

	}

}
