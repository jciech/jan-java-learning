package MockExam2;

import java.util.*;

public class ExamPart1 {

	public static void main(String[] args) {
		
		String dir = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/";
		
		HashMap<String, Airport> airMap = new HashMap<String, Airport>();
		ArrayList<FlightRaw> flights = new ArrayList<FlightRaw>();
		
		airMap = Airport.mapfromCSV(dir+"airports.txt");
		flights = FlightRaw.listfromCSV(dir+"flights.txt");
		
		ArrayList<Flight> processedFlights = new ArrayList<Flight>();
		
		for (FlightRaw flight : flights) {
			Flight processedFlight = new Flight();
			processedFlight = Flight.convertToProcessed(flight, airMap);
			processedFlights.add(processedFlight);
		}
		
		System.out.println(processedFlights);
	}
	
}
