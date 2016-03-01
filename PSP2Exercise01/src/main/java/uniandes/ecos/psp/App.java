/** Copyright or License
 *
 */

package uniandes.ecos.psp;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Package: uniandes.ecos.psp
 *
 * Class: App App.java
 * 
 * Original Author: @author AOSORIO
 * 
 * Description: [one line class summary]
 * 
 * Implementation: [Notes on implementation]
 *
 * Created: Feb 29, 2016 1:32:16 PM
 * 
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		LinearRegEvaluator linReg = new LinearRegEvaluator("./data/", "Table-1.csv");

		linReg.doLinearRegression();

		linReg.printReport();
		
		linReg.printExpected("./data/", "Table-2.csv");

	}

}
