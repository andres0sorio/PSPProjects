/** Copyright or License
 *
 */

package uniandes.ecos.psp;

import java.util.ArrayList;

/**
 * Package: uniandes.ecos.psp
 *
 * Class: RunLocCounter RunLocCounter.java
 * 
 * Original Author: @author AOSORIO
 * 
 * Description: [one line class summary]
 * 
 * Implementation: [Notes on implementation]
 *
 * Created: Feb 15, 2016 3:40:29 PM
 * 
 */
public class RunLocCounter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FileChaser finder = new FileChaser("D:\\GIT\\PSPProjects");

		finder.processRoot();

		ArrayList<String> java_files = finder.getAllFiles();

		JavaCodeAnalyzer analyzer = new JavaCodeAnalyzer(java_files);

		analyzer.beginJob();
		analyzer.analyze();
		analyzer.endJob();

	}

}
