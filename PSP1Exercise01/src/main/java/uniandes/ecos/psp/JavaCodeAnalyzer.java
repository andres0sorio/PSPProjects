/** Copyright or License
 *
 */

package uniandes.ecos.psp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Package: uniandes.ecos.psp1
 *
 * Class: JavaCodeAnalizer JavaCodeAnalyzer.java
 * 
 * Original Author: @author AOSORIO
 * 
 * Description: This is a simple Java Code LOC counter / analyzer
 * 
 * Implementation: Implemented as an Analyzer
 *
 * Created: Feb 15, 2016 8:39:48 AM
 * 
 */
public class JavaCodeAnalyzer {

	ArrayList<String> files;
	ArrayList<String> expressions;
	ArrayList<Pattern> patterns;
	ArrayList<JavaCodeComponents> javaResults;
	TableReport results = null;
	Matcher matcher = null;

	public JavaCodeAnalyzer(ArrayList<String> data) {
		super();
		this.files = data;

		expressions = new ArrayList<String>();
		patterns = new ArrayList<Pattern>();
		javaResults = new ArrayList<JavaCodeComponents>();
		results = new TableReport();

	}

	public void beginJob() {

		expressions.add("public\\s((?=class)(.*\\{))"); // public class
		expressions.add("public\\s((?!class)(.*\\{))"); // public method
		expressions.add("private\\s((?=class)(.*\\{))"); // private class
		expressions.add("private\\s((?!class)(.*\\{))"); // private method
		expressions.add("protected\\s((?=class)(.*\\{))"); // protected class
		expressions.add("protected\\s((?!class)(.*\\{))"); // protected method

		Iterator<String> itrExpr = expressions.iterator();
		while (itrExpr.hasNext()) {
			Pattern pattern;
			try {
				pattern = Pattern.compile(itrExpr.next());
			} catch (PatternSyntaxException pse) {
				System.out.println("Wrong pattern found. Please check.");
				continue;
			}
			patterns.add(pattern);
		}
		System.out.println("beginJob> done!");

	}

	public void analyze() {

		// Here loop over data and perform Regexp searches
		Iterator<Pattern> itrPattern;
		Iterator<String> itrFile = files.iterator();

		while (itrFile.hasNext()) {

			String fileName = itrFile.next();
			PlainFileReader reader = new PlainFileReader(fileName);
			ArrayList<String> data = reader.getLines();
			Iterator<String> itrData = data.iterator();
			JavaCodeComponents javaCode = new JavaCodeComponents(fileName);

			while (itrData.hasNext()) {

				itrPattern = patterns.iterator();
				String currentLine = itrData.next();

				while (itrPattern.hasNext()) {

					matcher = itrPattern.next().matcher(currentLine);

					while (matcher.find()) {

						// System.out.format(
						// "I found the text" + " \"%s\" starting at " + "index
						// %d
						// and ending at index %d.%n",
						// matcher.group(), matcher.start(), matcher.end());

						if (matcher.group().contains("class")) {
							javaCode.addClass("myclass");
						} else {
							javaCode.addMethod("mymethod");
						}
					}
				}
			}
			javaResults.add(javaCode);
		}
	}

	public void endJob() {

		System.out.println("endJob> done!");

	}

}
