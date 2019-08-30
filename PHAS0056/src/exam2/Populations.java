package exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Populations {

	String areaId, speciesId;
	int numberSpecimens;
	
	public static ArrayList<Populations> arrayListFromURL(String string) {
		
		ArrayList<Populations> dummyList = new ArrayList<Populations>();
		
		try {
			BufferedReader br = Species.brfromURL(string);
			String line;
			while ((line = br.readLine()) != null) {
				Scanner s = new Scanner(line);
				while (s.hasNext()) {
					Populations dummyPop = new Populations();
					dummyPop.areaId = s.next();
					dummyPop.speciesId = s.next();
					dummyPop.numberSpecimens = s.nextInt();
	
					dummyList.add(dummyPop);
				}
				s.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
		return dummyList;
	}

	@Override
	public String toString() {
		return "Populations [areaId=" + areaId + ", speciesId=" + speciesId + ", numberSpecimens=" + numberSpecimens
				+ "]";
	}

	public static int countPopulations(String species, ArrayList<Populations> populations) {
		
		int specimenNumber = 0;
		
		for (Populations population: populations) {
			if(population.speciesId.equals(species)) {
				specimenNumber =+ population.numberSpecimens;
			}
		}
		return specimenNumber;
	}

	public static ArrayList<String> findAreas(String species, ArrayList<Populations> populations) {
		
		ArrayList<String> dummyList = new ArrayList<String>();
		
		for (Populations population : populations) {
			if(population.speciesId.equals(species)) {
				dummyList.add(population.areaId);
			}
		}
		
		return dummyList;
	}

	public double computeDensity(HashMap<String, Double> areaIdentifiers) {
		
		int number = this.numberSpecimens;
		double area = areaIdentifiers.get(this.areaId);
		
		double density = (number/area);
		return density;
	}

	
	
}
