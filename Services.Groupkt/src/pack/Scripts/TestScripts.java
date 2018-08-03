package pack.Scripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import pack.Execution.Executor;
import testdata.TestData;

@SuppressWarnings("deprecation")
public class TestScripts extends Executor {
	RequestSpecification httpRequest =null;
	static Response response=null;
	static String responseBody = null;
	static WebDriver driver =null;
	
	public TestScripts(){
		RestAssured.baseURI = "http://services.groupkt.com/state/get/USA";
		httpRequest = RestAssured.given();
		 response = httpRequest.request(Method.GET, "/all");
	}
	
	
	/**
	 * Perform an API request to produce a list of all States in USA.
	 * @throws IOException 
	 */
	public  static void keyword_getAllStates() throws IOException {
		/**
		 * Calls an Object and Initializes baseURI, httpRequest, response for the upcoming TestValidations
		 */
		TestScripts ts = new TestScripts();
		responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
  if(response.getStatusCode() == 200){
	  TestData.writeResultsl(4, 5, "Passed");
  }
	}
	
	/**
	 * Using code, verify “Capital City” and  "Largest City"  is present in the response for the given valid state names and abbreviations.
	 * @throws IOException 
	 */
	public  static void keyword_verifyCityBased_OnValidStateInputs() throws IOException {
		String input1 = null;
		String input2 = null;
		String expectedBreed=null;
	
		/**//**
		 * Calls an Object and Initializes baseURI, httpRequest, response for the upcoming TestValidations
		 *//*
*/		
		TestScripts ts = new TestScripts();
		responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		
	//	Assert.assertEquals("Response body contains 'Capital City' ",responseBody.toLowerCase().contains(TestData.readExcel(5, 3)), true);
		if(responseBody.toLowerCase().contains(TestData.readExcel(5, 3))){
			TestData.writeResultsl(5, 5, "Passed");
		}
		else{
			TestData.writeResultsl(5, 5, "Failed");
		}
		
		
		
		
		
	//Assert.assertEquals("Response body contains 'Largest City",responseBody.toLowerCase().contains(TestData.readExcel(5, 4)), true);
	//	TestData.writeResultsl(5, 5, "Passed");
	}

	/**
	 *Perform an API request to produce a list of cities for  the invalid inputs of state names and abbreviations .
	 * @throws IOException 
	 */
	public  static void keyword_verifyCityBasedOn_InValidStateInputs() throws IOException {
		
	/*	*//**
		 * Calls an Object and Initializes baseURI, httpRequest, response for the upcoming TestValidations
		 *//*
*/		
		TestScripts ts = new TestScripts();
		responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		
		if(!responseBody.toLowerCase().contains(TestData.readExcel(6, 1))){
			TestData.writeResultsl(6, 5, "Passed");
		}
		else{
			TestData.writeResultsl(6, 5, "Failed");
		}
		
	}
	

/*	*//**
	 *Perform an API request to produce a list of cities On valid state and invalid State Abbreviations
	 * @throws IOException 
	 *//*
*/	public  static void keyword_verifyCityBasedOnValidState_InValidAbrInputs() throws IOException {
		String input1 = null;
		String input2 = null;
		boolean limiter = false;

		
		
		 // looping responses till On valid state and invalid State Abbreviations  is Validated
		 
		while(!limiter){
			
	//		 * Calls an Object and Initializes baseURI, httpRequest, response for the upcoming TestValidations
			 
			TestScripts ts = new TestScripts();
			responseBody = response.getBody().asString();
			System.out.println("Response Body is =>  " + responseBody);
			if(!responseBody.toLowerCase().contains(TestData.readExcel(7, 2))){
				limiter=true;
				TestData.writeResultsl(7, 5, "Passed");
				break;
			}
			else{
				TestData.writeResultsl(7, 5, "Failed");
			}
		}
		
		
		
		
	}
	


/**
 *Perform an API request to produce a list of cities for  the invalid inputs of state names and abbreviations .
 * @throws IOException 
 */
public  static void keyword_verifyCityBasedOnInvalidState_ValidAbrInputs() throws IOException {
	
/*	*//**
	 * Calls an Object and Initializes baseURI, httpRequest, response for the upcoming TestValidations
	 *//*
*/		
	TestScripts ts = new TestScripts();
	responseBody = response.getBody().asString();
	System.out.println("Response Body is =>  " + responseBody);
	
	if(!responseBody.toLowerCase().contains(TestData.readExcel(8, 1))){
		TestData.writeResultsl(8, 5, "Passed");
	}
	else{
		TestData.writeResultsl(8, 5, "Failed");
	}
	
}
	

/**
 *Perform an API request to produce a list of cities for  the blank inputs of state names and abbreviations .
 * @throws IOException 
 */
public  static void keyword_verifyCityBasedOnBlankStateInputs() throws IOException {
	
/*	*//**
	 * Calls an Object and Initializes baseURI, httpRequest, response for the upcoming TestValidations
	 *//*
*/		
	TestScripts ts = new TestScripts();
	responseBody = response.getBody().asString();
	System.out.println("Response Body is =>  " + responseBody);
	
	if(!responseBody.toLowerCase().contains(TestData.readExcel(9, 1))){
		TestData.writeResultsl(9, 5, "Passed");
	}
	else{
		TestData.writeResultsl(9, 5, "Failed");
	}
	
}
}
