import java.sql.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.math.RoundingMode;
import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;

public class Main {

	public static void main(String[] args) {

		String message = doPSP2Exercise04();

		System.out.println(message);
	}
	
	/** doPSP2Exercise04: exercise 6 finding root
	 * @return string with a table of results (expected vs actual)
	 */
	public static String doPSP2Exercise04() {
		
		double result1 = 0.0;

		DecimalFormat df = new DecimalFormat("0.00000");
		df.setRoundingMode(RoundingMode.DOWN);
 		
		TableReport summary = new TableReport("Inverse t-distribution");
		summary.addRow("p \t dof \t expected \t actual");
		
		double[] params = new double[1];
		params[0] = 6.0; // dof
		
		result1 = StatisticalFunctions.tDistributionCDFInverse(0.20, params);

		String strResult = "0.20 \t 6 \t 0.55338 \t" + df.format(result1);

		summary.addRow(strResult);
				
		params[0] = 15.0; // dof
		
		result1 = StatisticalFunctions.tDistributionCDFInverse(0.45, params);

		strResult = "0.45 \t 15 \t 1.75305 \t" + df.format(result1);

		summary.addRow(strResult);
		
		params[0] = 4.0; // dof

		result1 = StatisticalFunctions.tDistributionCDFInverse(0.495, params);

		strResult = "0.495 \t 4 \t 4.60409 \t" + df.format(result1);

		summary.addRow(strResult);
				
		return summary.toString();		
	
	}

}
