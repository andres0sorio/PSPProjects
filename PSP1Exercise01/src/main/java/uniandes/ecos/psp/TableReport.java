/** Copyright or License
 *
 */

package uniandes.ecos.psp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Package: uniandes.ecos.psp1
 *
 * Class: TableReport TableReport.java
 * 
 * Original Author: @author AOSORIO
 * 
 * Description: Simple table reported
 * 
 * Implementation: Throws a formated string
 *
 * Created: Feb 15, 2016 8:41:25 AM
 * 
 */
public class TableReport {

	String name;

	ArrayList<String> rows;

	public TableReport(String name) {
		super();
		this.name = name;
		rows = new ArrayList<String>();
	}

	public void addRow(String description, Integer value) {

		String add_row = description + "," + value;
		rows.add(add_row);

	}
	
	public void addRow(String description, String value) {

		String add_row = description + "," + value;
		rows.add(add_row);

	}

	public void saveToFile(String outfile) {

		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(outfile));
			writer.write(this.toString());

		} catch (IOException e) {
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
			}
		}

	}

	@Override
	public String toString() {

		String table_report = "\n";
		table_report += "<TableReport> " + name + "\r\n";
		for (int nrow = 0; nrow < rows.size(); ++nrow) {
			table_report += rows.get(nrow) + "\r\n";
		}
		return table_report;
	}

}
