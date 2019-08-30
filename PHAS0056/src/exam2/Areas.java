package exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import MockExam2.Airport;

public class Areas {

	public static HashMap<String, Double> hashMapFromURL(String string) {

		HashMap<String, Double> dummyMap = new HashMap<String, Double>();

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

	public static HashMap<String, Double> reduceAltitude(HashMap<String, Double> altitudeMap, double i) {

		HashMap<String, Double> reducedList = new HashMap<String,Double>();
		
		for (String string : altitudeMap.keySet()) {
			if (!(altitudeMap.get(string) < i)) {
				reducedList.put(string, altitudeMap.get(string));
			}
		}

		return reducedList;
	}

}
