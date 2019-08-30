package MockExam2;

import java.util.ArrayList;
import java.util.List;

public class LessSelector implements Selector {
	
	int costbound;
	
	public LessSelector(int costbound) {
		this.costbound = costbound;
	}

	@Override
	public List<Flight> select(List<Flight> list) {

		ArrayList<Flight> dummyList = new ArrayList<Flight>();
		for (Flight flight : list) {
			if(flight.cost<this.costbound) {
				dummyList.add(flight);
			}
		}
		
		return dummyList;
	}

}
