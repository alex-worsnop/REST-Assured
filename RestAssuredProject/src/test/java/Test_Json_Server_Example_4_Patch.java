import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

//From: https://www.youtube.com/watch?v=IbJdcApXziU
//REST Assured API testing Beginner Tutorial | Part 3 

// *** Change the last name of Tom Selleck (user 4), created in test 3 ***

public class Test_Json_Server_Example_4_Patch {

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
	public void test_patch() {
		
		JSONObject request = new JSONObject();
		
		request.put("lastName", "Selleck's BUSHY Moustache");
	

		baseURI = "http://localhost:3000/";
	
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			patch("/users/4").
		then().
			statusCode(200).
			log().all();
	}
}