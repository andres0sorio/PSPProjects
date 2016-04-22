import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Map;

/** Copyright or License
 *
 */

/**
 * Package: 
 *
 * Class: Analyzer Analyzer.java
 * 
 * Original Author: @author AOSORIO
 * 
 * Description: Class for running full analysis
 * 
 * Implementation: Implements three methods: beginJob, analyze, endJob
 *
 * Created: Apr 17, 2016 8:44:21 PM
 * 
 */
public class Analyzer {
	
	CSVReader inputFile;
	PairValues<Integer,Integer> option;
	LinkedList<PairValues<Double,Double>> data;
	Map<String,Double> results;
	TableReport table;
	
	public final static PairValues<Integer,Integer> OPTIONONE = new PairValues<Integer,Integer>(1, 2);
	public final static PairValues<Integer,Integer> OPTIONTWO = new PairValues<Integer,Integer>(1, 3);
	
	/** Main constructor method - sets everything from the sart
	 * @param option the option to use for analyzing our data (select pair of columns)
	 * @param inputFile this is our object that contains the pointer to our data
	 */
	public Analyzer(PairValues<Integer, Integer> option, CSVReader inputFile) {
		super();
		this.option = option;
		this.inputFile = inputFile;

	}

	/**
	 * beginJob: setup here input data and output data
	 */
	public void beginJob() throws FileNotFoundException {
		
		//Get the data and store in into xi, yi
		try {
			inputFile.readFile();
			data = inputFile.getLinkedList(option.getX(),option.getY());
		} catch (FileNotFoundException e) {
			throw e;
		}
		
	}
	
	/**
	 * run the analysis on the data - save results
	 */
	public void analyze() {
		
		//R1. calculate correlation
		results.put("rXY", StatisticalFunctions.evalCorrXY(data));
		results.put("r2", StatisticalFunctions.evalCorrXY(data));
		
		//R2. calculate the significance of such correlation
		results.put("significance", StatisticalFunctions.evalSignificance(data));

		//R3. Perform the linear regression of data
		PairValues<Double, Double> betas = StatisticalFunctions.evalLinearRegression(data);
		results.put("beta0", betas.getX());
		results.put("beta1", betas.getX());
		
		//R4. Get the 70% prediction interval
		double interval = StatisticalFunctions.evalPredictionIntervale(data);
		results.put("Range",interval);
	
	}
	
	/**
	 * process reports based on analysis - export output if needed
	 */
	public void endJob() {
		
		//Produce reports
		table = new TableReport("Test");
		
		for (Map.Entry<String, Double> entry : results.entrySet())
		{
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		    table.addRow(entry.getKey(), entry.getValue());
		}
		
	}
	
	
	

}
