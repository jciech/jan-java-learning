package module8;

public class CountdownTask implements Runnable {
	int runtime;

	public CountdownTask(int runtime) {
		this.runtime = runtime;
	}

	@Override
	public void run() {
		// The implementation of the method will use the Thread.sleep() method to wait
		// for an interval
		int i = 0;
		// Try/catch block is required for proper functioning
		try {
			while (i < this.runtime) { // Loop is created using a counter which counts every time we wait for 1 second
									   // Strictly less than condition is required to count correct number of seconds

				System.out.println("There are " + (this.runtime - i) + " seconds left of runtime.");
				Thread.sleep(1000);
				i += 1;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return;
	}

}
