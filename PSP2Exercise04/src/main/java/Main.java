import java.sql.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

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
	
	/**
	 * @return
	 */
	public static String doPSP2Exercise04() {
		
		double result1 = 0.0;
		double result2 = 0.0;
		double result3 = 0.0;

		DecimalFormat df=new DecimalFormat("0.00000");
 		
		TableReport summary = new TableReport("Inverse t-distribution");
		summary.addRow("p \t \t dof \t expected \t actual");
		
		double[] params = new double[2];
		params[0] = 6.0; // dof

		
		result1 = StatisticalFunctions.tDistributionInverse(0.20, params);

		String strResult = "0.20 \t 6 \t 0.55338 \t" + df.format(result1);

		summary.addRow(strResult);
				
		return summary.toString();		
	
	}

}
