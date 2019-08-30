package exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import MockExam2.Airport;

public class Areas {

	public static HashMap<String, Double> hashMapFromURL(String string) {

		HashMap<String,Double> dummyMap = new HashMap<String,Double>();
		
		try {
			BufferedReader br = Species.brfromURL(string);
			String line;
			while ((line = br.readLine()) != null) {
				Scanner s = new Scanner(line);
				while (s.hasNext()) {
					dummyMap.put(s.next(), s.nextDouble());
				}
				s.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return dummyMap;
	}
	
}
