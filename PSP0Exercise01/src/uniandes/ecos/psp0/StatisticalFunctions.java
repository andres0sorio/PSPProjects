package uniandes.ecos.psp0;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class contains an implementation of statistical methods:
 * for the moment we have mean and standard deviation
 * methods are *static*
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
