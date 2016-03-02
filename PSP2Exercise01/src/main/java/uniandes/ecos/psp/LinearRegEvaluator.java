/** Copyright or License
 *
 */

package uniandes.ecos.psp;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Package: uniandes.ecos.psp
 *
 * Class: LinearRegEvaluator LinearRegEvaluator.java
 * 
 * Original Author: @author AOSORIO
 * 
 * Description: Linear regression evaluator
 * 
 * Implementation: [Notes on implementation]
 *
 * Created: Mar 1, 2016 3:09:41 PM
 * 
 */
public class LinearRegEvaluator {

	String path;
	String infile;
	CSVReader data;
	TableReport output;
	TableReport expected;

	public LinearRegEvaluator(String path, String infile) {
		super();
		this.path = path;
		this.infile = path + infile;
		data = new CSVReader(this.infile);
		data.readFile();
		output = new TableReport("Linear regression results");
	}

	public void doLinearRegression() {

		this.operateOnData(1, 3, 386.0);
		this.operateOnData(1, 4, 386.0);
		this.operateOnData(2, 3, 386.0);
		this.operateOnData(2, 4, 386.0);

	}

	public void operateOnData(int column1, int column2, double xk) {

		LinkedList<PairValues<Double, Double>> test1 = data.getLinkedList(column1, column2);

		// Do regression
		PairValues<Double, Double> coefficients = StatisticalFunctions.evalLinearRegression(test1);
		double Rxy = StatisticalFunctions.evalCorrXY(test1);
		double R2 = StatisticalFunctions.evalCorr2(test1);

		double yk = evalAt(coefficients, xk);

		// Export results
		// System.out.println("Beta coefficients: " + coefficients.getX() + " "
		// + coefficients.getY());
		// System.out.println("Rxy + R2 : " + Rxy + " " + R2);

		output.addRow("Test case " + column1 + " " + column2);
		output.addRow("Beta 0", coefficients.getX());
		output.addRow("Beta 1", coefficients.getY());
		output.addRow("Rxy", Rxy);
		output.addRow("R2", R2);
		output.addRow("yk", yk);

	}

	private double evalAt(PairValues<Double, Double> coefficients, double xk) {
		double yk = coefficients.getX() + (coefficients.getY() * xk);
		return yk;
	}

	public void printReport() {
		System.out.println(output);
	}

	public void printExpected(String path, String infile) {

		expected = new TableReport("Expected Results");

		CSVReader expval = new CSVReader(path + infile);
		expval.readFile();

		ArrayList<String> labels = new ArrayList<String>();

		labels.add("Test Case");
		labels.add("* Beta 0");
		labels.add("* Beta 1");
		labels.add("* Rxy");
		labels.add("* R2");
		labels.add("* yk");

		ArrayList<ArrayList<Double>> input = expval.getTable();

		int maxCol = input.size();
		int maxRow = input.get(0).size();

		for (int row = 0; row < maxRow; row++) {
			expected.addRow(labels.get(0) + " " + (row+1) );
			for (int col = 0; col < maxCol; col++) {
				double value = input.get(col).get(row);
				expected.addRow(labels.get(col + 1), value);
			}
		}

		System.out.println(expected);

	}

	public String getHTML() {
		String table_result = output.toHTML();
		String table_expected = expected.toHTML();
		return table_result + table_expected;
	}

}
