/** Copyright or License
 *
 */


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

	public void addRow(String description, Double x) {
		String value = String.format("%.4f", x);
		String add_row = description + " " + value + "\n";
		rows.add(add_row);
	}

	public void addRow(String string) {
		String add_row = string + "\n";
		rows.add(add_row);
	}

	public String toHTML() {

		String table_report = "<tr>";
		table_report += "<td> TableReport " + name + "</td></tr><tr>";
		for (int nrow = 0; nrow < rows.size(); ++nrow) {
			String item = rows.get(nrow).replace("\n", "");
			table_report += "<td>" + item + "</td>";
			if ( ( (nrow+1) % 6) == 0 && nrow != rows.size() - 1)
				table_report += "</tr><tr>";
			else if ( nrow == rows.size() - 1)
				table_report += "</tr>";
		}
		return table_report;
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
