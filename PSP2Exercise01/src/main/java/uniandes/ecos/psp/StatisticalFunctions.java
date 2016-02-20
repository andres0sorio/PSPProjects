/** Copyright or License
 *
 */

package uniandes.ecos.psp;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Package: uniandes.ecos.psp
 *
 * Class: StatisticalFunctions StatisticalFunctions.java
 * 
 * Original Author: @author AOSORIO
 * 
 * Description: Use this class for Statistical methods implementations
 * 
 * Implementation: static methods are implemented
 * 
 * Created: Feb 15, 2016 3:47:08 PM
 * 
 */
public class StatisticalFunctions {

	public static double evalMean(LinkedList<Double> input) {

		double result = 0.0;
		double sum = 0.0;

		Iterator<Double> itr = input.iterator();

		while (itr.hasNext()) {
			double value = (double) itr.next();
			sum += value;
		}

		int nValues = input.size();

		if (nValues != 0)
			result = sum / (double) nValues;

		return result;

	}

	public static double evalStdDev(LinkedList<Double> input) {

		double result = 0.0;
		double average = evalMean(input);
		double sum = 0.0;

		Iterator<Double> itr = input.iterator();

		while (itr.hasNext()) {
			double value = (double) itr.next();
			sum += (value - average) * (value - average);
		}

		int nValues = input.size();

		if ( nValues > 1)
			result = Math.sqrt(sum / ((double) nValues - 1));
		else if ( nValues == 1 )
			System.out.println("Note: Std deviation of 1 number. List should have at least 2 elements");
		
		return result;

	}

}
