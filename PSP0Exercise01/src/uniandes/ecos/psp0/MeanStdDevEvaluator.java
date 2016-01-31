package uniandes.ecos.psp0;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Main for this simple program: we provide a file with data in a column and
 * evaluate for this column the mean and standard deviation
 */

public class MeanStdDevEvaluator {

	public static void main(String[] args) {

		boolean useKeyboard = false;

		String file1 = "./data/datos-Ejemplo.csv";
		String file2 = "./data/data-Example2.csv";
		
		if (useKeyboard) {

			getDataFromKeyboard();

		} else {
			
			getDataFromFile(file1);
			getDataFromFile(file2);
			
		}

		System.out.println("Done. Goodbye!");
	}

	public static void getDataFromFile(String filename) {

		// Import data using our CVSReader
		CSVReader ex1 = new CSVReader(filename);
		ex1.readFile();

		// Mean + StdDev
		System.out.println("Mean & StdDev of data: " + filename);
		LinkedList<Double> data = ex1.getLinkedList(0);
		double mean = StatisticalFunctions.evalMean(data);
		double stdev = StatisticalFunctions.evalStdDev(data);
		System.out.println("Mean= " + mean);
		System.out.println("StdDev= " + stdev);

	}

	public static void getDataFromKeyboard() {

		Scanner keyboard = new Scanner(System.in);
		double value = 0.0;
		LinkedList<Double> data = new LinkedList<Double>();
		
		System.out.println("You are about to enter data. Continue? [Y/N]");

		while (keyboard.hasNext() && (keyboard.nextLine().equalsIgnoreCase("y"))) {
			
			System.out.println("Enter data (real numbers)");
			
			try {
				value = Double.parseDouble(keyboard.nextLine());
				data.add(value);
			} catch (NumberFormatException e) {
				System.out.println("Not a valid number! try again");
			}
			
			System.out.println("Continue?[Y/N]");
		}

		double mean = StatisticalFunctions.evalMean(data);
		double stdev = StatisticalFunctions.evalStdDev(data);
		System.out.println("Mean= " + mean);
		System.out.println("StdDev= " + stdev);
		
		keyboard.close();
		
	}

}
