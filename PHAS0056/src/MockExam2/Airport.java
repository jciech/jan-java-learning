package MockExam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Scanner;

public class Airport {

	String airportFullName, airportTimeZone;

	public static HashMap<String, Airport> mapfromCSV(String string) {

		HashMap<String,Airport> dummyMap = new HashMap<String,Airport>();
		
		try {
			BufferedReader br = brfromURL(string);
			String line;
			while ((line = br.readLine()) != null) {
				Scanner s = new Scanner(line);
				s.useDelimiter(", ");
				while (s.hasNext()) {
					Airport dummyAirport = new Airport();
					String code = s.next();
					dummyAirport.airportFullName = s.next();
					dummyAirport.airportTimeZone = s.next();
					dummyMap.put(code,dummyAirport);
				}
				s.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return dummyMap;
	}
	
	
	@Override
	public String toString() {
		return "Airport [airportFullName=" + airportFullName + ", airportTimeZone=" + airportTimeZone + "]";
	}


	public static BufferedReader brfromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();

		// Creating a BufferedReader from the created InputStream object
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;

	}
	
}
