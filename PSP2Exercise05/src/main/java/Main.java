
/** Copyright or License
 *
 */

import java.sql.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Map;

import org.jfree.chart.plot.XYPlot;

import java.io.FileNotFoundException;
import java.math.RoundingMode;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;

/**
 * Package:
 *
 * Class: Main Main.java
 * 
 * Original Author: @author AOSORIO
 * 
 * Description: Main class for PSP2Exercise05
 * 
 * Implementation:
 *
 * Created: Apr 21, 2016 8:44:21 PM
 * 
 */

public class Main {

	public static void main(String[] args) {

		String message = doPSP2Exercise05();

	}

	/**
	 * doPSP2Exercise05: exercise 7 Combining all tools
	 * 
	 * @return string with a table of results (expected vs actual)
	 */
	public static String doPSP2Exercise05() {

		CSVReader testFile    = new CSVReader("data/Table-1.csv");
		CSVReader aosorioFile = new CSVReader("data/AOsorio-Table-2.csv");
		CSVReader expectedOne = new CSVReader("data/expected-1.csv");
		CSVReader expectedTwo = new CSVReader("data/expected-2.csv");

		ArrayList<Analyzer> allAnalysis = new ArrayList<Analyzer>();

		Analyzer an1 = new Analyzer(Analyzer.OPTIONONE, testFile, "Test 1");
		Analyzer an2 = new Analyzer(Analyzer.OPTIONTWO, testFile, "Test 2");
		Analyzer an3 = new Analyzer(Analyzer.OPTIONONE, aosorioFile, "AOsorio A1");
		Analyzer an4 = new Analyzer(Analyzer.OPTIONTWO, aosorioFile, "AOsorio A2");

		an1.setProxySize(386);
		an2.setProxySize(386);
		an3.setProxySize(169);
		an4.setProxySize(169);
		
		allAnalysis.add(an1);
		allAnalysis.add(an2);
		allAnalysis.add(an3);
		allAnalysis.add(an4);

		Iterator<Analyzer> itr = allAnalysis.iterator();

		while (itr.hasNext()) {

			Analyzer current = (Analyzer) itr.next();

			try {
				current.beginJob();
				current.analyze();
				current.endJob();
			} catch (FileNotFoundException e) {
				System.out.println("File not found, please check");
			}

		}

		//
		
		try {
			expectedOne.readFile();
			expectedTwo.readFile();
		} catch (FileNotFoundException e) {
			System.out.println("File not found, please check");
		}
		
		an1.getReport().addColumn(expectedOne.getSingleColumn(0));
		an2.getReport().addColumn(expectedTwo.getSingleColumn(0));
		
		System.out.println(an1.getReport().toString());
		System.out.println(an2.getReport().toString());
		System.out.println(an3.getReport().toString());
		System.out.println(an4.getReport().toString());
		
		String fullMessage = "";
		fullMessage += an1.getReport().toHTML();
		fullMessage += an2.getReport().toHTML();
		fullMessage += an3.getReport().toHTML();
		fullMessage += an4.getReport().toHTML();
			
		return fullMessage;

	}

}
