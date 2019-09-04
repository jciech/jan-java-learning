package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable {

	ArrayList<Integer> primeList = new ArrayList<Integer>();
	
	// Getter for list of primes
	public ArrayList<Integer> getPrimeList() {
		return primeList;
	}

	@Override
	public void run() {

		// Starting with 1 and iterating through all numbers
		for (int i=1; i<Integer.MAX_VALUE; i+=1) {
			// Checking and adding to prime list
			if (PrimeNumberTask.isPrime(i)) {
				PrimeNumberTask.addToPrimeList(i);
			}			
		}
	}

	public static boolean isPrime(int n) {
		boolean prime = false;
		
		// checking if n is a multiple of 2
		if(n%2==0) {}
		// if not, we check odd numbers
		for (int i=3; i*i<=n; i+=2) {
			if (n%i==0) {
				prime = true;
			}
		}
		
		return prime;
	}
	
	
	public static void addToPrimeList(int n) {
		this.primeList.add(n);
	}
	
}
