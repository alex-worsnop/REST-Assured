import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

// From: https://www.youtube.com/watch?v=IbJdcApXziU
//REST Assured API testing Beginner Tutorial | Part 3 

public class Test_Json_Server_Example_6_DELETE {
	
	public void test_get() {
		
		baseURI = "http://localhost:3000/";
		given ().
			param("name", "Automation").
			get("/subjects").
		then().
			statusCode(200).
			log().all();
	
	}

	@Test
	public void test_delete() {
		
		baseURI = "http://localhost:3000/";
		
		when().
			delete("/users/4").
		then().
		statusCode(200);

	}
}