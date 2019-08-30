package exam2;

import java.util.*;

public class ExamPart3 {

	public static void main(String[] args) {

		String directory = "http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19-lsa/";
		
		// The data would be stored in a HashMap for ease of use
		
		HashMap<String, Double> altitudeMap = new HashMap<String, Double>();
		
		// I reuse the method used to read area classification as the structure is identical
		
		altitudeMap = Areas.hashMapFromURL(directory+"altitudes.txt");

		HashMap<String, Double> reducedAltitudeMap = new HashMap<String, Double>();
		reducedAltitudeMap = Areas.reduceAltitude(altitudeMap,2000.0);
		
		// We will need to reuse a lot of the initial code
		ArrayList<Populations> populations = new ArrayList<Populations>();
		populations = Populations.arrayListFromURL(directory + "population.txt");
		HashMap<String, Double> areaIdentifiers = new HashMap<String, Double>();
		areaIdentifiers = Areas.hashMapFromURL(directory + "areas.txt");
		HashMap<String, String> speciesNames = new HashMap<String, String>();
		speciesNames = Species.hashMapFromURL(directory + "species.txt");

		ArrayList<Populations> finalList = new ArrayList<Populations>();
		
		// Applying the logic required 
		for (String area : reducedAltitudeMap.keySet()) { 
			for(Populations population : populations) {
				if(area.equals(population.areaId)) { // Remembering to only check the areas above 2000m
					if(population.computeDensity(areaIdentifiers)>1) { // Computing density
						finalList.add(population); // Adding to the final list
					}
				}
			}
		}
		
		// Printing out the results
		System.out.println("The species with a density of more than 1 specimen per square kilometer above 2000m"
				+ " are: ");
		
		for (Populations population : finalList) {
			System.out.println(speciesNames.get(population.speciesId));
		}
	}

}
