package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable {

	ArrayList<Integer> primeList = new ArrayList<Integer>();
	int largest_checked;

	@Override
	public void run() {

		
			// Starting with 2 and iterating through all numbers
			for (int i = 2; i < Integer.MAX_VALUE; i += 1) {
				
				// Setting the most recent checked number
				this.largest_checked = i;
				
				// Checking and adding to prime list
				if (PrimeNumberTask.isPrime(i)) {
					this.primeList.add(i);
				}
				if (Thread.interrupted()==true) {
					return;
				}


			}
	}

	public static boolean isPrime(int n) { 
        // for n = 1
        if (n == 1) {
            return false; 
        }
        // Check from 2 to n-1 
        for (int i = 2; i < n; i+=1) {
            if (n % i == 0) {
                return false; 
            }
        }
        return true; 
	}

}
