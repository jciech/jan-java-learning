package MockExam2;

import java.util.ArrayList;
import java.util.List;

public class FastestSelector implements Selector {

	@Override
	public List<Flight> select(List<Flight> list) {
		
		Flight dummyFlight = new Flight();
		dummyFlight.duration = Long.MAX_VALUE;
		for (Flight flight : list) {
			if(flight.duration<dummyFlight.duration) {
				dummyFlight = flight;
			}
		}
		
		ArrayList<Flight> dummyList = new ArrayList<Flight>();
		dummyList.add(dummyFlight);
		return dummyList;
	}

}
