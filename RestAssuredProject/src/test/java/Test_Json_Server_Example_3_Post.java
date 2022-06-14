import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

// From: https://www.youtube.com/watch?v=IbJdcApXziU
//REST Assured API testing Beginner Tutorial | Part 3 

public class Test_Json_Server_Example_3_Post {

	
//	@Test
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
	public void test_post() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Tom");
		request.put("lastName", "Selleck's Moustache");
		request.put("subjectId", 1);
	

		baseURI = "http://localhost:3000/";
	
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
	}
}
// NOTE: Created user 4 first run, but subsequently increments the id -  to 5 then 6 etc
