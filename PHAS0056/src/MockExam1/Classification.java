package MockExam1;

import java.io.*;
import java.net.URL;
import java.util.Scanner;
import java.util.Vector;
import java.util.ArrayList;
import java.util.HashMap;

public class Classification {



	// Method to create a list of strings from a BufferedReader to easily utlise the
	// Scanner class

	public static ArrayList<String> listFromBR(BufferedReader br) throws IOException {

		ArrayList<String> dummyList = new ArrayList<String>();
		String dummyString = new String();
		try (Scanner s = new Scanner(br);) {
			while (s.hasNext()) {
				dummyString = s.nextLine();
				dummyList.add(dummyString);
			}
		}

		return dummyList;

	}

	public static Vector<Double> vectorFromScanner(Scanner scanner) {

		Vector<Double> dummyVector = new Vector<Double>(2);
		dummyVector.add(scanner.nextDouble());
		dummyVector.add(scanner.nextDouble());
		return dummyVector;

	}
}
