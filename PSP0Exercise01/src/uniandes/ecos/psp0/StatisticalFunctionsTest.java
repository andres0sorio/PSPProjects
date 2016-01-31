package uniandes.ecos.psp0;

import static org.junit.Assert.*;

import java.util.LinkedList;
import org.junit.Test;

public class StatisticalFunctionsTest {

	private final static double testPrecision = 0.01;
	
	@Test
	public void testMean() {

		String path = "./data/test/";
		String infile = path + "datos-Prueba.csv";
		CSVReader test = new CSVReader(infile);
		test.readFile();

		LinkedList<Double>  table = test.getLinkedList(0);
		double result = StatisticalFunctions.evalMean(table);
		System.out.println("Mean Col 0: " + result );
		assertEquals(550.6, result, testPrecision);

		table = test.getLinkedList(1);
		result = StatisticalFunctions.evalMean(table);
		System.out.println("Mean Col 1: " + result );
		assertEquals(60.32, result, testPrecision);

	}
	
	@Test
	public void testStdDev() {

		String path = "./data/test/";
		String infile = path + "datos-Prueba.csv";
		CSVReader test = new CSVReader(infile);
		test.readFile();

		LinkedList<Double>  table = test.getLinkedList(0);
		double result = StatisticalFunctions.evalStdDev(table);
		System.out.println("Stdev Col 0: " + result );
		assertEquals(572.03, result, testPrecision);

		table = test.getLinkedList(1);
		result = StatisticalFunctions.evalStdDev(table);
		System.out.println("Stdev Col 1: " + result );
		assertEquals(62.26, result, testPrecision);
		
		table.clear();
		table.add(1.0);
		result = StatisticalFunctions.evalStdDev(table);
		System.out.println("Stdev: " + result );
		assertEquals(0.0, result, testPrecision);
		
		

	}

}
