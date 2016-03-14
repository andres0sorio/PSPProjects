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
		/*
		 * LinearRegEvaluator linReg = null; String workingdirectory =
		 * System.getProperty("user.dir");
		 * 
		 * try {
		 * 
		 * linReg = new LinearRegEvaluator(workingdirectory+"/data/",
		 * "Table-1.csv");
		 * 
		 * canProceed = true;
		 * 
		 * } catch (FileNotFoundException e) { canProceed = false; }
		 * 
		 * if (canProceed) {
		 * 
		 * linReg.doLinearRegression(); linReg.printReport();
		 * linReg.printExpected(workingdirectory+"/data/", "Table-2.csv");
		 * String htmlOutput = linReg.getHTML(); String htmlTable = "<table> " +
		 * htmlOutput + "</table>"; //System.out.println(htmlTable);
		 * port(Integer.valueOf(System.getenv("PORT")));
		 * staticFileLocation("/public"); get("/hello", (req, res) ->
		 * htmlTable);
		 * 
		 * } else { String htmlTable = "Error reading input file"; get("/hello",
		 * (req, res) -> htmlTable); }
		 */

		get("/hello", (req, res) -> "Hello you fucking piece of shit");

		get("/", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("message", "Hello World!");

			return new ModelAndView(attributes, "index.ftl");
		} , new FreeMarkerEngine());

		get("/db", (req, res) -> {
			Connection connection = null;
			Map<String, Object> attributes = new HashMap<>();
			try {
				connection = DatabaseUrl.extract().getConnection();

				Statement stmt = connection.createStatement();
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
				stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
				ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

				ArrayList<String> output = new ArrayList<String>();
				while (rs.next()) {
					output.add("Read from DB: " + rs.getTimestamp("tick"));
				}

				attributes.put("results", output);
				return new ModelAndView(attributes, "db.ftl");
			} catch (Exception e) {
				attributes.put("message", "There was an error: " + e);
				return new ModelAndView(attributes, "error.ftl");
			} finally {
				if (connection != null)
					try {
						connection.close();
					} catch (SQLException e) {
					}
			}
		} , new FreeMarkerEngine());

	}

}
