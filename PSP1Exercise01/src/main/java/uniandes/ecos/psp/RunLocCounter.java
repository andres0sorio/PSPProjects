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

		//FileChaser finder = new FileChaser("D:\\GIT\\PSPProjects");
		FileChaser finder = new FileChaser("D:\\GIT\\PSPProjects\\PSP2Exercise02");
		//FileChaser finder = new FileChaser("D:\\GIT\\PSPProjects\\PSP1Exercise01\\test");
		//FileChaser finder = new FileChaser("/home/aosorio/GIT/PSPProjects");
		try {
			finder.processRoot();

			ArrayList<String> java_files = finder.getAllFiles();

			JavaCodeAnalyzer analyzer = new JavaCodeAnalyzer(java_files);

			analyzer.beginJob();
			analyzer.analyze();
			analyzer.endJob();
		} catch (NullPointerException e) {
			System.out.println("You have a nullpointer exception! please check");
			System.exit(1);
		}
	}

}
