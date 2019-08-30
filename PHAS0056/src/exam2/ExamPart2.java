package exam2;

import java.util.ArrayList;
import java.util.HashMap;

public class ExamPart2 {

	public static void main(String[] args) {

		// Loading in all the data from Part 1
		String directory = "http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19-lsa/";
		HashMap<String, Double> areaIdentifiers = new HashMap<String, Double>();
		HashMap<String, String> speciesNames = new HashMap<String, String>();
		ArrayList<Populations> populations = new ArrayList<Populations>();
		areaIdentifiers = Areas.hashMapFromURL(directory + "areas.txt");
		speciesNames = Species.hashMapFromURL(directory + "species.txt");
		populations = Populations.arrayListFromURL(directory + "population.txt");
		
		// We instantiate the generic calculator
		StatisticCalculator corrCaFrCalculator = new CorrelationCalculator();

		// And the sets for which the correlation will be calculated. Getting these sets
		// to a state in which they can be processed will require some additional
		// methods.
		ArrayList<Populations> CaSet = new ArrayList<Populations>();
		ArrayList<Populations> FrSet = new ArrayList<Populations>();
		
		CaSet = Populations.selectSpecies(populations,"Ca");
		FrSet = Populations.selectSpecies(populations,"Fr");
		System.out.println(CaSet);
		
		// Calculating the correlation using our method.
		double correlation = corrCaFrCalculator.calculateStatistic(CaSet, FrSet);
		
		// And printing it out.
		System.out.println(
				"The correlation between densities of the species Campanula arvatica and Fritillaria roylei is "
						+ correlation + ".");
		
		// The result doesn't work and the method used would need some fixing however I do not have time for it
	}

}
