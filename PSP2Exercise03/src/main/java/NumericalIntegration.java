/** Copyright or License
 *
 */

/**
 * Package:
 *
 * Class: NumericalIntegration NumericalIntegration.java
 * 
 * Original Author: @author AOSORIO
 * 
 * Description: [one line class summary]
 * 
 * Implementation: [Notes on implementation]
 *
 * Created: Mar 21, 2016 2:03:06 AM
 * 
 */
public class NumericalIntegration {

	private OneDimFunction integrand = null;
	private double lowerLimit = Double.NaN;
	private double upperLimit = Double.NaN;
	private double deltaX = 0.0;
	private double numSegs = 10.0;
	private double error = 0.0001;
	private double integral = 0.0;

	public NumericalIntegration(OneDimFunction integrand, double lowerLimit, double upperLimit) {
		super();
		this.integrand = integrand;
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
		this.deltaX = deltaX;
	}

	public OneDimFunction getIntegrand() {
		return integrand;
	}

	public void setIntegrand(OneDimFunction integrand) {
		this.integrand = integrand;
	}

	/**
	 * @return the lowerLimit
	 */
	public double getLowerLimit() {
		return lowerLimit;
	}

	/**
	 * @return the upperLimit
	 */
	public double getUpperLimit() {
		return upperLimit;
	}

	/**
	 * @param lowerLimit
	 *            the lowerLimit to set
	 * @param upperLimit
	 *            the upperLimit to set
	 */
	public void setLowerLimit(double lowerLimit, double upperLimit) {

		if (lowerLimit >= upperLimit)
			throw new IllegalArgumentException("Check limits (a<b)");
		if (!Double.isNaN(lowerLimit))
			this.lowerLimit = lowerLimit;
		if (!Double.isNaN(upperLimit))
			this.upperLimit = upperLimit;

	}

	/**
	 * @return result
	 */
	public double doIntegral() {

		double currentError = 0.0;

		while (currentError > error) {

			double fOdd = 0.0;
			double fEven = 0.0;
			
			deltaX = (upperLimit - lowerLimit) / numSegs;
			
			double f0 = (deltaX / 3.0) * integrand.doEval(0.0);
			
			for (int i = 1; i < numSegs; i = (2 * i) + 1)
				fOdd += 4.0 * integrand.doEval(i * deltaX);

			for (int i = 2; i < numSegs; i = (2 * i))
				fEven += 2.0 * integrand.doEval(i * deltaX);

			double fx = (deltaX / 3.0) * integrand.doEval(upperLimit);
			
			integral = f0+fOdd+fEven+fx;
			
			currentError = Math.abs(integral-currentError);
			
			numSegs = numSegs*2.0;

		}

		return integral;

	}

}
