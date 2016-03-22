/** Copyright or License
 *
 */

/**
 * Package: 
 *
 * Class: tDistributionFunction tDistributionFunction.java
 * 
 * Original Author: @author AOSORIO
 * 
 * Description: [one line class summary]
 * 
 * Implementation: [Notes on implementation]
 *
 * Created: Mar 21, 2016 7:13:08 PM
 * 
 */
public class tDistributionFunction implements OneDimFunction {

	double [] params;
		
	/**
	 * @param params
	 */
	public tDistributionFunction(double[] params) {
		super();
		this.params = params;
	}

	/* (non-Javadoc)
	 * @see OneDimFunction#doEval(double)
	 */
	@Override
	public double doEval(double x) {
	
		double y = StatisticalFunctions.tDistribution(x,this.params);
		return y;
		
	}
	
}

