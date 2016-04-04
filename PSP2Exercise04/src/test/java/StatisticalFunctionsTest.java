import static org.junit.Assert.*;

import org.junit.Test;

public class StatisticalFunctionsTest {

	/**
	 * Test against the provided test (using the CDF t-distribution function)
	 * Expected value number
	 */
	@Test
	public void TestOne() {

		double[] params = new double[1];
		params[0] = 9.0;
		double result = StatisticalFunctions.tDistributionCDF(1.1, params);
		assertEquals(0.35006, result, 0.00001);
	}
	
	/**
	 * Test against the provided test (using the CDF t-distribution function)
	 * Expected value number
	 */
	@Test
	public void TestTwo() {

		double[] params = new double[1];
		params[0] = 10.0;
		double result = StatisticalFunctions.tDistributionCDF(1.1812, params);
		assertEquals(0.36757, result, 0.00001);
	}
	
	/**
	 * Test against the provided test (using the CDF t-distribution function)
	 * Expected value number
	 */
	@Test
	public void TestThree() {

		double[] params = new double[1];
		params[0] = 30.0;
		double result = StatisticalFunctions.tDistributionCDF(2.750, params);
		assertEquals(0.49500, result, 0.00001);
	}

}
