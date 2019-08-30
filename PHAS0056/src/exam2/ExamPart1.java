package exam2;

import java.util.*;

public class ExamPart1 {

	public static void main(String[] args) {

		// Defining the parent directory for the problem
		String directory = "http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19-lsa/";

		// Instantiating HashMaps for clear ID -> object area.txt and species.txt
		// An ArrayList with a custom class was chosen to read data for population.txt
		HashMap<String, Double> areaIdentifiers = new HashMap<String, Double>();
		HashMap<String, String> speciesNames = new HashMap<String, String>();
		ArrayList<Populations> populations = new ArrayList<Populations>();

		// Calling methods reading in the data from the URLs
		areaIdentifiers = Areas.hashMapFromURL(directory + "areas.txt");
		speciesNames = Species.hashMapFromURL(directory + "species.txt");
		populations = Populations.arrayListFromURL(directory + "population.txt");

		// Iterating through the species map to print out species names in a clean way
		for (String species : speciesNames.keySet()) {
			System.out
					.println("The species labelled " + species + " is the species " + speciesNames.get(species) + ".");
		}

		// To generate total number of specimens for each species, we must loop over
		// them all.
		// The resulting data will be stored in a HashMap

		HashMap<String, Integer> totalSpecimenNumber = new HashMap<String, Integer>();

		for (String species : speciesNames.keySet()) {
			// Instantiating method counting populations
			int specimenNumber = Populations.countPopulations(species, populations);
			totalSpecimenNumber.put(species, specimenNumber);
		}

		for (String species : totalSpecimenNumber.keySet()) {
			System.out.println(
					"There are a total of " + totalSpecimenNumber.get(species) + " of the species " + species + ".");
		}

		// To find the species population density for each species, we must first find
		// all the areas where a species was found
		// Then we must find the total number of instances of a species in these areas
		// (which we already have from the step above)
		// and finally find the total area and divide one by the other
		// We again iterate through all species and store the result in a HashMap

		HashMap<String, Double> speciesDensities = new HashMap<String, Double>();

		for (String species : speciesNames.keySet()) {

			double totalArea = 0;
			double specimenNumber = totalSpecimenNumber.get(species);

			ArrayList<String> areasWithSpecies = new ArrayList<String>();
			areasWithSpecies = Populations.findAreas(species, populations);
			for (String area : areasWithSpecies) {
				totalArea += areaIdentifiers.get(area);
			}

			speciesDensities.put(species, specimenNumber / totalArea);

		}

		for (String species : speciesDensities.keySet()) {
			System.out.println("The density of the species " + speciesNames.get(species) + " is "
					+ speciesDensities.get(species) + " per unit area.");
		}

		// To find the plots which have the highest density of a species we must compute
		// the density species for each plot/species pair that exists and choose the
		// highest value for each species. Results will again be stored in a HashMap
		
		HashMap<String, String> speciesMaxDensityPlot = new HashMap<String,String>();
		for (String species : speciesNames.keySet()) {
			
			String plotID = null;
			double maxDensity = 0;
			
			for (Populations population : populations) {
				if(population.speciesId.equals(species)){
					double density = population.computeDensity(areaIdentifiers);
					if(density>maxDensity) {
						plotID = population.areaId;
					}
				}
			}
		
		speciesMaxDensityPlot.put(species, plotID);
			
		}
		
		for (String species : speciesMaxDensityPlot.keySet()) {
			System.out.println("The ID of the plot with the greatest population density of "+species+" is "+speciesMaxDensityPlot.get(species));
		}
		
	}
}
