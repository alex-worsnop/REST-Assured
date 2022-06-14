import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test_Json_Server_Example_1 {
	
	@Test
	public void test_get() {
		
		baseURI = "http://localhost:3000/";
		given ().
			get("/users").
		then().
			statusCode(200).
			log().all();
	
	}


}
