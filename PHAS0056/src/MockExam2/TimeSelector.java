package MockExam2;

import java.util.ArrayList;
import java.util.List;

public class TimeSelector implements Selector {

	int duration;
	
	public TimeSelector(int duration) {
		this.duration = duration;
	}

	@Override
	public List<Flight> select(List<Flight> list) {

		ArrayList<Flight> dummyList = new ArrayList<Flight>();
		
		for (Flight flight : list) {
			if(flight.duration<(this.duration*60)) {
				dummyList.add(flight);
			}
		}
		
		
		return dummyList;
	}

}
