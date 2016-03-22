import java.sql.*;
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

		String message = doPSP2Exercise03();

		System.out.println(message);

	}

	public static String doPSP2Exercise03() {
		
		double result1 = 0.0;
		double result2 = 0.0;
		double result3 = 0.0;
		
		double [] params = new double[1];
		params[0] = 1.0;

		OneDimFunction sqrtFunct = (OneDimFunction) new SomeFunction(params);

		NumericalIntegration numIntegration = new NumericalIntegration(sqrtFunct, 1.0, 10.0);
		
		double result = numIntegration.doIntegral();
		
		String strResult = "The result is: " + result;
		
		return strResult;
	}

}
