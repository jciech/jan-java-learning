package exam2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CorrelationCalculator implements StatisticCalculator {

	@Override
	public double calculateStatistic(ArrayList<Populations> set1, ArrayList<Populations> set2) {

		// We must take care to iterate over only the areas are both contained in the
		// set, so first, the method will create subsets of the sets that are
		// appropriate for finding the correlation.

		List<Populations> dummyList1 = new ArrayList<Populations>();
		List<Populations> dummyList2 = new ArrayList<Populations>();

		for (Populations population1 : set1) {
			for (Populations population2 : set2) {
				if (population1.areaId.equals(population2.areaId)) {
					dummyList1.add(population1);
					dummyList2.add(population2);
				}
			}
		}

		// Shortening the lists which double count
		// Unfortunately this is the point of failure and I will not fix it in time. I
		// print out a line of what the list looks like in an attempt to fix the method
		dummyList1 = dummyList1.subList(dummyList1.size() / 2, dummyList1.size());
		System.out.println(dummyList1);
		dummyList2 = dummyList2.subList(dummyList2.size() / 2, dummyList2.size());

		// Now we can move on to calculating the correlation

		double correlation = 0;
		double size = dummyList1.size();

		// We compute each term separately and also in separate methods for clarity.

		double xiyi, xi, yi, xi2, yi2;
		xiyi = CorrelationCalculator.xiyicalc(dummyList1, dummyList2);
		xi = CorrelationCalculator.xicalc(dummyList1);
		yi = CorrelationCalculator.xicalc(dummyList2);
		xi2 = CorrelationCalculator.xi2calc(dummyList1);
		yi2 = CorrelationCalculator.xi2calc(dummyList1);

		correlation = (size * xiyi - xi * yi)
				/ (Math.sqrt(size * xi2 - Math.pow(xi, 2)) - Math.sqrt(size * yi2 - Math.pow(yi, 2)));

		return correlation;
	}

	// Method used in the calculation of the correlation in the calculation of the sum(xi^2)
	private static double xi2calc(List<Populations> dummyList1) {

		HashMap<String, Double> areaIdentifiers = new HashMap<String, Double>();
		areaIdentifiers = Areas
				.hashMapFromURL("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19-lsa/areas.txt");

		double result = 0;

		for (Populations population : dummyList1) {
			result += Math.pow(population.computeDensity(areaIdentifiers), 2);
		}
		return result;

	}

	// Method used in the calculation of the correlation to find sum(xi)
	private static double xicalc(List<Populations> dummyList1) {

		HashMap<String, Double> areaIdentifiers = new HashMap<String, Double>();
		areaIdentifiers = Areas
				.hashMapFromURL("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19-lsa/areas.txt");

		double result = 0;

		for (Populations population : dummyList1) {
			result += population.computeDensity(areaIdentifiers);
		}
		return result;
	}

	// Method to compute density product for correlation function
	private static double xiyicalc(List<Populations> dummyList1, List<Populations> dummyList2) {

		// Storing area map here as well because it becomes easier to use density
		// computing method
		// (Yes, now I see that my method of computing densities is very inefficient, I
		// would definitely do it differently
		// if I were starting over).
		HashMap<String, Double> areaIdentifiers = new HashMap<String, Double>();
		areaIdentifiers = Areas
				.hashMapFromURL("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19-lsa/areas.txt");

		double result = 0;

		for (Populations population1 : dummyList1) {
			for (Populations population2 : dummyList2) {
				double dummyResult = 0;
				if (population1.areaId.equals(population2.areaId)) {
					dummyResult = population1.computeDensity(areaIdentifiers)
							* population2.computeDensity(areaIdentifiers);
				}

				result += dummyResult;
			}
		}

		// To avoid double counting we must divide by 2
		return result / 2;
	}
}
