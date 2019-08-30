package MockExam1;

import java.io.*;
import java.util.*;

public class ExamPart1 {

	public static void main(String[] args) {

		// For part 1. we need to store the data in the links into some structures

		String urlClassification = "http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/classification.txt";
		String urlExpert = "http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/expert.txt";
		String urlLocations = "http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/locations.txt";

		ArrayList<ImageData> classification = ImageData.classificationFromURL(urlClassification);
		ArrayList<ImageData> expert = ImageData.expertFromURL(urlExpert);
		ArrayList<ImageData> locations = ImageData.locationsFromURL(urlLocations);
		
		// For part 2. we need to print the number of images
		// This will be the length of expert list

		System.out.println(expert.size());
		
		// For part 3. we need to print the number of images classified by at least 1
		// volunteer. We will utilise the properties of Sets in java.
		
		HashSet<Integer> idsClassifiedByOne = new HashSet<Integer>();
		for (ImageData image : classification) {
			idsClassifiedByOne.add(image.getIdentifier());
		}
		System.out.println(idsClassifiedByOne.size());
		
		// For part 4. we need to print details of the images classified by at least 10
		// volunteers. 
		
		ArrayList<ImageData> atLeast10Vols = new ArrayList<ImageData>();
		atLeast10Vols = ImageData.atLeast10(classification);
		
		// Must merge the information from classification, locations and expert lists
		ArrayList<ImageData> atLeast10CompleteList = new ArrayList<ImageData>();
		atLeast10CompleteList = ImageData.collectAll(atLeast10Vols, expert, locations);
		ArrayList<ImageData> clean10CompleteList = ImageData.clean(atLeast10CompleteList);
		
		// Printing out the data
		
		System.out.println(clean10CompleteList);

	}




}
