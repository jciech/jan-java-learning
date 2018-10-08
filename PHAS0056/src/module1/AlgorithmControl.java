package module1;

public class AlgorithmControl {

	public static void main(String[] args) {
	
	System.out.println(timer(10000, 1000));
	System.out.println(timer(10000, 50000));
	System.out.println("If the value of the number of loops completed is output less often, more iterations of the loop can be processed, as the processor uses less time on returning values.");
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
	static int timer(long maxTime, int loopSteps) {
		int i = 0;
		long timeNow = System.currentTimeMillis();
		long timeEnd = timeNow+maxTime;
		while (System.currentTimeMillis() < timeEnd) {
			i++;
			int ireminder = i % loopSteps;
			if (ireminder == 0) {
				System.out.println(i);
				
			}
		}
		return i;
	}
}
