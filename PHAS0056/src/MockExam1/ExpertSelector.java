package MockExam1;

import java.util.ArrayList;

public class ExpertSelector implements ImageSelector {

	String species;
		
	public ExpertSelector(String species) {
		this.species = species;
	}

	@Override
	public ArrayList<ImageData> select(ArrayList<ImageData> list) {
		
		ArrayList<ImageData> dummyList = new ArrayList<ImageData>();
		
		for (ImageData image : list) {
			if (image.getSpeciesExpert().equals(this.species)) {
				dummyList.add(image);
			}
		}
		
		return dummyList;
	}


	
}
