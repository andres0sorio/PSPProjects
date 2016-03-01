/** Copyright or License
 *
 */

package uniandes.ecos.psp;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Package: uniandes.ecos.psp
 *
 * Class: App App.java
 * 
 * Original Author: @author AOSORIO
 * 
 * Description: [one line class summary]
 * 
 * Implementation: [Notes on implementation]
 *
 * Created: Feb 29, 2016 1:32:16 PM
 * 
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String path = "./data/";
		String infile = path + "Table-1.csv";
		CSVReader data = new CSVReader(infile);
		data.readFile();

		// Test 1
		LinkedList<PairValues<Double, Double>> test1 = data.getLinkedList(1, 3);

		// Do regression
		PairValues<Double, Double> coefficients = StatisticalFunctions.evalLinearRegression(test1);
		double Rxy = StatisticalFunctions.evalCorrXY(test1);
		double R2 = StatisticalFunctions.evalCorr2(test1);
		
		// Export results
		System.out.println("Beta coefficients: " + coefficients.getX() + " " + coefficients.getY());
		System.out.println("Rxy + R2 : " + Rxy + " " + R2);

		// Test 2
		LinkedList<PairValues<Double, Double>> test2 = data.getLinkedList(1, 4);

		// Do regression
		coefficients = StatisticalFunctions.evalLinearRegression(test2);
		Rxy = StatisticalFunctions.evalCorrXY(test2);
		R2 = StatisticalFunctions.evalCorr2(test2);
		
		// Export results
		System.out.println("Beta coefficients: " + coefficients.getX() + " " + coefficients.getY());
		System.out.println("Rxy + R2 : " + Rxy + " " + R2);

		// Test 3
		LinkedList<PairValues<Double, Double>> test3 = data.getLinkedList(2, 3);
		
		// Do regression
		coefficients = StatisticalFunctions.evalLinearRegression(test3);
		Rxy = StatisticalFunctions.evalCorrXY(test3);
		R2 = StatisticalFunctions.evalCorr2(test3);
		
		// Export results
		System.out.println("Beta coefficients: " + coefficients.getX() + " " + coefficients.getY());
		System.out.println("Rxy + R2 : " + Rxy + " " + R2);

		// Test 4
		LinkedList<PairValues<Double, Double>> test4 = data.getLinkedList(2, 4);
		Rxy = StatisticalFunctions.evalCorrXY(test4);
		R2 = StatisticalFunctions.evalCorr2(test4);
		
		// Do regression
		coefficients = StatisticalFunctions.evalLinearRegression(test4);

		// Export results
		System.out.println("Beta coefficients: " + coefficients.getX() + " " + coefficients.getY());
		System.out.println("Rxy + R2 : " + Rxy + " " + R2);

	}

}
