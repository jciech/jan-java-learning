package MockExam2;

import java.util.*;
import java.util.List;

public class FPSelector implements Selector {

	String origin, destination;

	public FPSelector(String origin, String destination) {
		this.origin = origin;
		this.destination = destination;
	}

	@Override
	public List<Flight> select(List<Flight> list) {
		
		ArrayList<Flight> dummyList = new ArrayList<Flight>();
		
		for(Flight flight : list) {
			if(flight.originFull.equals(this.origin)) {
				if(flight.destinationFull.equals(this.destination)) {
					dummyList.add(flight);
				}
			}
		}
		
		return dummyList;
	}
	
	
	
}
