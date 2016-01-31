package uniandes.ecos.psp0;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

public class CSVReaderTest {

	@Test
	public void test() {
		String path = "./data/test/";
		String infile = path + "datos-Prueba.csv";
		CSVReader test = new CSVReader(infile);
		test.readFile();
		ArrayList< ArrayList<Double>> table = test.getTable();
		double output = (double)table.get(0).get(0);
		assertEquals(160.0, output , 0.01 );
		output = (double)table.get(1).get(9);
		assertEquals(138.2, output, 0.01 );
	}
	
	@Test
	public void testNoFile() {
		String path = "./data/test/";
		String infile = path + "datos-XXXX.csv";
		CSVReader test = new CSVReader(infile);
		test.readFile();
	}
	
	@Test
	public void testSingleColumn() {
		String path = "./data/test/";
		String infile = path + "datos-Prueba2.csv";
		CSVReader test = new CSVReader(infile);
		test.readFile();
	}
	
	@Test
	public void testEmptyFile() {
		String path = "./data/test/";
		String infile = path + "datos-Prueba3.csv";
		CSVReader test = new CSVReader(infile);
		test.readFile();
	}

}
