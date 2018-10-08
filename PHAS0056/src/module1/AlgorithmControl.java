package module1;

public class AlgorithmControl {

	public static void main(String[] args) {
	timer();
	}
	static void loop(){
		int i = 0;
		for(i = 1; i <= 8; i++) {
			System.out.println(i);
		}
	}
	static void decrement() {
		int i = 10;
		while (i>=-5) {
			System.out.println(i);
			i--;
		}
	}
	static void increment() {
		double i = 2.5;
		while (i<=4.3) {
			System.out.println(i);
			i = i + 0.1;
		}
	}
	static void timer() {
		int i = 0;
		long timeNow = System.currentTimeMillis();
		long timeEnd = timeNow+5000;
		while (System.currentTimeMillis() < timeEnd) {
			i++;
			int ireminder = i % 100;
			if (ireminder == 0) {
				System.out.println(i);
				
			}
		}
	}
}
