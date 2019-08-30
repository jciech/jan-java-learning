package MockExam1;

import java.util.ArrayList;

public class MajoritySelector implements ImageSelector {

	String species = new String();

	public MajoritySelector(String species) {
		this.species = species;
	}

	@Override
	public ArrayList<ImageData> select(ArrayList<ImageData> list) {

		ArrayList<ImageData> dummyList = new ArrayList<ImageData>();

		for (ImageData image : list) {
			if (image.speciesExpert.equals(this.species)) {
				int n = image.volunteerClassifications.size();
				int tempn = n;
				for (String volunteerClass : image.volunteerClassifications) {
					if (volunteerClass.equals(image.speciesExpert)) {
						tempn -= 1;
					}
				}
				if (tempn * 2 < n) {
					dummyList.add(image);
				}
			}
		}
		return dummyList;
	}

}
