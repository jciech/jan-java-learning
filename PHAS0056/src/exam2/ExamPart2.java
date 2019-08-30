package exam2;

import java.util.ArrayList;

public class ExamPart2 {

	public static void main(String[] args) {

		StatisticCalculator corrCaFrCalculator = new CorrelationCalculator();
		ArrayList<Populations> CaSet = null;
		ArrayList<Populations> FrSet = null;
		double correlation = corrCaFrCalculator.calculateStatistic(CaSet, FrSet);
		System.out.println("The correlation between densities of the species Campanula arvatica and Fritillaria roylei is "+correlation+".");
		
	}

}
