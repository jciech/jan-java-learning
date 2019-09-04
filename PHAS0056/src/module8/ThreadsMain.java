package module8;

public class ThreadsMain {

	public static void main(String[] args) {
		
		CountdownTask cdt = new CountdownTask(10);
		cdt.run();
		
	}

}
