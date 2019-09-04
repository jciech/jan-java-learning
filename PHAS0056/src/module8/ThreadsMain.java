package module8;

public class ThreadsMain {

	public static void main(String[] args) throws InterruptedException {
		
		
		Thread countdownTask = new Thread(new CountdownTask(10));
		Thread primeNumberTask = new Thread(new PrimeNumberTask());
		countdownTask.run();
		primeNumberTask.run();
		while(true) {
			if(countdownTask.isInterrupted()) {
				primeNumberTask.interrupt();
			}
		}
		
		

		
	}

}
