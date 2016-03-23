import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {

		String message = doPSP2Exercise03();

		System.out.println(message);

	}

	public static String doPSP2Exercise03() {

		double result1 = 0.0;
		double result2 = 0.0;
		double result3 = 0.0;

		DecimalFormat df=new DecimalFormat("0.00000");
 		
		TableReport summary = new TableReport("Numerical Integration with Simpson's Rule");
		summary.addRow("Range \t \t dof \t expected \t result");
		
		double[] params = new double[2];
		params[0] = 9.0; // dof

		IOneDimFunction tDistFunction = (IOneDimFunction) new tDistributionFunction(params);

		NumericalIntegration numIntegration = new NumericalIntegration(tDistFunction, 0.0, 1.1);

		result1 = numIntegration.doIntegral();

		String strResult = "[0.0,1.1] \t 9 \t 0.35006 \t" + df.format(result1);

		summary.addRow(strResult);
		
		params[0] = 10.0; // dof
		tDistFunction.setParams(params);
		numIntegration.setLimits(0.0, 1.1812);
		result2 = numIntegration.doIntegral();

		strResult = "[0.0,1.1812] \t 10 \t 0.36757 \t" + df.format(result2);
		summary.addRow(strResult);
		
		params[0] = 30.0; // dof
		tDistFunction.setParams(params);
		numIntegration.setLimits(0.0, 2.750);
		result3 = numIntegration.doIntegral();

		strResult = "[0.0,2.750] \t 30 \t 0.49500  \t" + df.format(result3);
		summary.addRow(strResult);
		
		return summary.toString();
	}

}
