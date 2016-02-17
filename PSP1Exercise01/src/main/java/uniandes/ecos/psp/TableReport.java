/** Copyright or License
 *
 */

package uniandes.ecos.psp;

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
		
		String add_row = description + " " + value + "\n";
		rows.add(add_row);

	}

	@Override
	public String toString() {
		
		String table_report = "\n";
		table_report += "TableReport " + name + "\n";
		for (int nrow = 0; nrow < rows.size(); ++nrow) {
			table_report += rows.get(nrow);
		}
		return table_report;
	}

}
