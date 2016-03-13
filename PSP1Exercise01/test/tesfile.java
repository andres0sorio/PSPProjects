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
	private int numClasses;
	private int numMethods;
	private int numEmptyLines;
	private int LOC;
	private int numComments;
	private boolean insideOfComment;
		
	public JavaCodeComponents(String fileName) {
		super();
		this.fileName = fileName;
		className  = new ArrayList<String>();
		methodName = new ArrayList<String>();
		numClasses = 0;
		numMethods = 0;
		setNumComments(0);
		LOC = 0;
		insideOfComment = false;
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

	public void addLine(String currentLine) {
		
		//Check if line is empty
		if ( currentLine == null ) {
			setNumEmptyLines(getNumEmptyLines() + 1);
			return;
		}		
		//Check for a simple comment
		else if (currentLine.startsWith("//")) {
			setNumComments(getNumComments() + 1);
		}
		else if ( currentLine.startsWith("/*")) {
			//opening of a multi line comment
			insideOfComment = true;	
		} 
		else if ( currentLine.startsWith("*/")) {
			//closing of a multi line comment
			insideOfComment = false;
			setNumComments(getNumComments() + 1);
		}
		else if ( !insideOfComment ) {
			LOC += 1;
		}
		else {}	
	}
	
	public double convertToKLOC() {		
		return LOC/1000.0;	
	}

	public int getNumComments() {
		return numComments;
	}

	public void setNumComments(int numComments) {
		this.numComments = numComments;
	}

	public int getLOC() {
		return LOC;
	}

	public int getNumEmptyLines() {
		return numEmptyLines;
	}

	public void setNumEmptyLines(int numEmptyLines) {
		this.numEmptyLines = numEmptyLines;
	}
	
}
