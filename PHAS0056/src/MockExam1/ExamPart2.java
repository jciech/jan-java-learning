package MockExam1;

import java.util.ArrayList;

public class ExamPart2 {

	public static void main(String[] args) {
		
		String urlClassification = "http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/classification.txt";
		String urlExpert = "http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/expert.txt";
		String urlLocations = "http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/locations.txt";

		ArrayList<ImageData> classification = ImageData.classificationFromURL(urlClassification);
		ArrayList<ImageData> expert = ImageData.expertFromURL(urlExpert);
		ArrayList<ImageData> locations = ImageData.locationsFromURL(urlLocations);
		
		ArrayList<ImageData> completeList = ImageData.collectAll(classification, expert, locations);
				
		// For part 2 we use the ExpertSelector to find all lions:
		ImageSelector lionExpertSelector = new ExpertSelector("lion");
		ArrayList<ImageData> lionsList = lionExpertSelector.select(completeList);
		
		System.out.println(lionsList);
		
		// and the MajoritySelector to find all lion candidates:
		
		ImageSelector lionMajoritySelector = new MajoritySelector("lion");
		ArrayList<ImageData> lionsCandidateList = lionMajoritySelector.select(completeList);
		
		System.out.println(lionsCandidateList);		
		
	}

}
