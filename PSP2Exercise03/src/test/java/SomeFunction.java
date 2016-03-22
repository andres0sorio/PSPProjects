/** Copyright or License
 *
 */

/**
 * Package: 
 *
 * Class: SomeFunction SomeFunction.java
 * 
 * Original Author: @author AOSORIO
 * 
 * Description: [one line class summary]
 * 
 * Implementation: [Notes on implementation]
 *
 * Created: Mar 21, 2016 7:28:43 PM
 * 
 */
public class SomeFunction implements OneDimFunction {

	double [] params;

	/**
	 * @param params
	 */
	public SomeFunction(double[] params) {
		super();
		this.params = params;
	}



	/* (non-Javadoc)
	 * @see OneDimFunction#doEval(double)
	 */
	@Override
	public double doEval(double x) {
		double a = params[0];
		double y = a * Math.sqrt(x);
		return y;
	}
	
}
