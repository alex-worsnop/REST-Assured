package datadriven;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import groovyjarjarpicocli.CommandLine.Parameters;
import io.restassured.http.ContentType;

//From: https://www.youtube.com/watch?v=2ggM0vm4fbg
//REST Assured API testing Beginner Tutorial | Part 4

public class DataDrivenExamples4DELETE {


//Delete via the parameters in the testng.xml file
	
	@Parameters({"userId"})
	@Test
	public void test_delete2(int userId) {
		
		System.out.println("Value for the userId is : "+userId);
		baseURI = "http://localhost:3000/";
		
		when().
			delete("/users/"+userId).
		then().
		statusCode(200);

	}

}
