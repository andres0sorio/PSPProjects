/** Copyright or License
 *
 */

package uniandes.ecos.psp;

import java.util.ArrayList;

/**
 * Package: uniandes.ecos.psp1
 *
 * Class: JavaCodeComponents JavaCodeComponents.java
 * 
 * Original Author: @author AOSORIO
 * 
 * Description: Encapsulate here the Java code components (class name, methods)
 * 
 * Implementation: 
 *
 * Created: Feb 15, 2016 8:42:24 AM
 * 
 */
public class JavaCodeComponents {
	
	String fileName;
	ArrayList<String> className;
	ArrayList<String> methodName;
	Integer numClasses;
	Integer numMethods;
	
	public JavaCodeComponents(String fileName) {
		super();
		this.fileName = fileName;
		className  = new ArrayList<String>();
		methodName = new ArrayList<String>();
		numClasses = 0;
		numMethods = 0;
	}

	public void addClass(String string) {
		className.add(string);
	}

	public void addMethod(String string) {
		methodName.add(string);
	}

	public Integer getNumClasses() {
		numClasses = className.size();
		return numClasses;
	}

	public void setNumClasses(Integer numClasses) {
		this.numClasses = numClasses;
	}

	public Integer getNumMethods() {
		numMethods = methodName.size();
		return numMethods;
	}

	public void setNumMethods(Integer numMethods) {
		this.numMethods = numMethods;
	}
	
}
