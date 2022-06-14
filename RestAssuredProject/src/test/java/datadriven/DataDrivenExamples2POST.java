package datadriven;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

//From: https://www.youtube.com/watch?v=2ggM0vm4fbg
//REST Assured API testing Beginner Tutorial | Part 4

public class DataDrivenExamples2POST extends DataForTests {

//	Using Object because it can store both strings and integers etc
	
	@DataProvider(name = "DataUsersForPost")
	public Object [] [] dataForPost() {
		
		return new Object [][] {
			{"Graham", "Bell", 1},
			{"Henry", "Ford", 2},
			{"Hillary", "Rodham", 2}
		};
	}
	
	@Test(dataProvider = "DataUsersForPost")
	public void test_post_with_parameters(String firstname, String lastName, int subjectId) {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", firstname);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);
	

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
