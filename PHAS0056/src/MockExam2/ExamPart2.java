package MockExam2;

import java.util.*;

public class ExamPart2 {

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
		
		
		Selector LHRtoATHSelector = new FPSelector("London Heathrow","Athens International");
		List<Flight> LHRtoATHFlights = LHRtoATHSelector.select(processedFlights);
		System.out.println(LHRtoATHFlights);
		
		Selector sub200Selector = new LessSelector(200);
		List<Flight> LHRtoATHsub200 = sub200Selector.select(LHRtoATHFlights);
		System.out.println(LHRtoATHsub200);
		
		Selector sub4hSelector = new TimeSelector(4);
		List<Flight> LHRtoATHsub4h = sub4hSelector.select(LHRtoATHFlights);
		System.out.println(LHRtoATHsub4h);
		
		Selector fastestSelector = new FastestSelector();
		List<Flight> fastestFlight = fastestSelector.select(LHRtoATHsub200);
		System.out.println(fastestFlight);
		
	}

}
