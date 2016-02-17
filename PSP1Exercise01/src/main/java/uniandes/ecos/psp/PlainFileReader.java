/** Copyright or License
 *
 */

package uniandes.ecos.psp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Package: uniandes.ecos.psp1
 *
 * Class: PlainFileReader PlainFileReader.java
 * 
 * Original Author: @author AOSORIO
 * 
 * Description: Simple ascii file reader
 * 
 * Implementation: Returns the file content line by line in an ArrayList
 *
 * Created: Feb 15, 2016 8:42:24 AM
 * 
 */

public class PlainFileReader {

	private String inputFile;

	BufferedReader buffer;;
	String line;
	int nlines;

	ArrayList<String> lines = new ArrayList<String>();

	public PlainFileReader(String infile) {
		buffer = null;
		line = "";
		nlines = 0;
		inputFile = infile;
	}

	public void readFile() {

		try {
			buffer = new BufferedReader(new FileReader(inputFile));
			while ((line = buffer.readLine()) != null) {
				lines.add(line);
				nlines++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("No file found! Please check");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Cannot open file! Please check");
			e.printStackTrace();
		} finally {
			if (buffer != null) {
				try {
					System.out.println("End of file reached. Total lines read: " + nlines);
					buffer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public ArrayList<String> getLines() {
		return lines;
	}

}
