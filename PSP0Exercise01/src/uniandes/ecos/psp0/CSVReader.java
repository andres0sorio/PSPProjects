package uniandes.ecos.psp0;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * This is a simple CSV reader. Input must be in the form of columns, each column 
 * separated by a , (comma).
 * Given we have to work out data in columns in terms of Linked Lists
 * there is a method to provide the data in such form.
 */

public class CSVReader {

	private String inputFile;

	BufferedReader buffer = null;
	
	String cvsSplitBy = ",";
	int nrow = 0;
	int ncol = 0;
	
	ArrayList<ArrayList<Double>> table = new ArrayList<ArrayList<Double>>();

	public CSVReader(String infile) {
		inputFile = infile;
	}

	public void readFile() {

		try {

			buffer = new BufferedReader(new FileReader(inputFile));
			
			String line;
			
			while ((line = buffer.readLine()) != null) {

				String[] data = line.split(cvsSplitBy);

				ncol = data.length;
				
				for (int col = 0; col < ncol; ++col) {

					if (nrow == 0) {
						ArrayList<Double> column = new ArrayList<Double>();
						table.add(column);
					}

					Double value = Double.parseDouble(data[col]);
					table.get(col).add(value);
				}

				nrow++;

			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found, please check!.");
		} catch (IOException e) {
			System.out.println("IO error. Please check");
		} finally {
			if (buffer != null) {
				try {
					if(nrow == 0)
						System.out.println("Empty file.");
					else
						System.out.println("File read. End of file reached");
					buffer.close();
				} catch (IOException e) {
					System.out.println("IO error at closing file.");
				}
			}
		}
	}

	public ArrayList<ArrayList<Double>> getTable() {
		return table;
	}
	
	public ArrayList<Double> getSingleColumn( int column) {
		ArrayList<Double> selectedColumn = table.get(column);
		return selectedColumn;
	}
	

	public LinkedList<Double> getLinkedList(int column) {

		LinkedList<Double> singleColumn = new LinkedList<Double>();		
		ArrayList<Double> data = this.getSingleColumn(column);

		// Convert the arrays list to a linked list
		Iterator<Double> itr = data.iterator();

		while (itr.hasNext()) {
			double value = itr.next();
			singleColumn.add(value);
		}

		return singleColumn;

	}

}
