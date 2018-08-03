package pack.Execution;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.WebDriver;

import pack.Scripts.TestScripts;
import testdata.TestData;

public class Executor {

public static	WebDriver driver=null;
public static List<String> listofTestSripts=null;

public static Class<?> className=null;
	
/**
 * Hybrid Framework Core Code
 * 
 * @param args
 * @throws ClassNotFoundException
 * @throws IllegalAccessException
 * @throws IllegalArgumentException
 * @throws InvocationTargetException
 * @throws IOException
 */
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		
		listofTestSripts = new LinkedList<String>();
		
	//	String CLASSPATH= System.getProperty("java.class.path");
		
		
		
		File ClassesPath = new File("bin/pack/Scripts");
		
		File[] listOfSriptClasses= ClassesPath.listFiles();
		
		for(File       eachFile  :            listOfSriptClasses){
			
			listofTestSripts.add(FilenameUtils.removeExtension(eachFile.getName()));
			
			System.out.println(listofTestSripts.size());
		}
		
		for(String   testSriptCName:          listofTestSripts){
			
			
			System.out.println("testSriptCName....."+testSriptCName);
			
			className=  Class.forName("pack.Scripts."+testSriptCName);
			
			Method[] listOfCmethods=className.getMethods();
			
			for(Method eaChMethod:listOfCmethods){
				
				/**
				 * Getting TestCase IDs from the Excel Sheet
				 * 
				 */
				for(int rowNo=4; rowNo <= 9; rowNo++){
					String currentTestCase = TestData.readExcel(rowNo, 0);
					String currentTestCaseRunStatus = TestData.readExcel(rowNo, 6);
					if(eaChMethod.getName().startsWith("keyword_") &&
							eaChMethod.getName().contains(currentTestCase) && currentTestCaseRunStatus.equalsIgnoreCase("YES")){
						
						eaChMethod.invoke(null);
						
					}
				}
				
				
			}
			
			
		}
		
		/*TestScripts tsObj = new TestScripts();
		tsObj.keyword_DoLaunch();*/
	}

}
