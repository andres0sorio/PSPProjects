import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;

public class Main {

	public static void main(String[] args) {

		boolean canProceed = false;

		final String dir = System.getProperty("user.dir");

		String path = dir + "/data/";
		String infile = path + "Tabla-1.csv";

		RelSizeClassifier sd1 = new RelSizeClassifier("LOC/Method");
		sd1.runClassification(path, infile, true);

		infile = path + "Tabla-2.csv";
		RelSizeClassifier sd2 = new RelSizeClassifier("Pages/Chapter");
		sd2.runClassification(path, infile, false);

		sd1.printSummary();
		sd2.printSummary();

		/*
		 * TableReport expected = new TableReport("Expected values");
		 * 
		 * 
		 * try { CSVReader data = new CSVReader(path + "Tabla-3.csv");
		 * data.readFile(); } catch (FileNotFoundException e) {
		 * e.printStackTrace(); }
		 */

	}

}
