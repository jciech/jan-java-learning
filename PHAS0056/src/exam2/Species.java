package exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Species {

	public static HashMap<String, String> hashMapFromURL(String string) {

		HashMap<String, String> dummyMap = new HashMap<String, String>();

		try {
			BufferedReader br = Species.brfromURL(string);
			String line;
			while ((line = br.readLine()) != null) {
				Scanner s = new Scanner(line);
				while (s.hasNext()) {
					dummyMap.put(s.next(), s.next() + " " + s.next());
				}
				s.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dummyMap;
	}

	// Method to create BufferedReader object from a file at a URL
	public static BufferedReader brfromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();

		// Creating a BufferedReader from the created InputStream object
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;

	}

}
