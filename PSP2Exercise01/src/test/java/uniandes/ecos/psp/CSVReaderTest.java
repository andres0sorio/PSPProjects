package uniandes.ecos.psp;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import uniandes.ecos.psp.CSVReader;;

public class CSVReaderTest {

	@Test
	public void testTable1() {
		String path = "./data/";
		String infile = path + "Table-1.csv";
		CSVReader test = new CSVReader(infile);
		test.readFile();
		ArrayList< ArrayList<Double>> table = test.getTable();
		double output = (double)table.get(1).get(0);
		assertEquals(130.0, output , 0.01 );
		output = (double)table.get(4).get(9);
		assertEquals(138.2, output, 0.01 );
	}
	
	@Test
	public void testTable2() {
		String path = "./data/";
		String infile = path + "Table-2.csv";
		CSVReader test = new CSVReader(infile);
		test.readFile();
		ArrayList< ArrayList<Double>> table = test.getTable();
		double output = (double)table.get(0).get(0);
		assertEquals(-22.55, output , 0.01 );
		output = (double)table.get(4).get(3);
		assertEquals(49.49, output, 0.01 );
	}
	

}
