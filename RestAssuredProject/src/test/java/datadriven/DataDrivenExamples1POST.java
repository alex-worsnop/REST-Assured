package datadriven;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

//From: https://www.youtube.com/watch?v=2ggM0vm4fbg
//REST Assured API testing Beginner Tutorial | Part 4

public class DataDrivenExamples1POST extends DataForTests {

	@DataProvider(name = "DataUsersForPost")
	public Object [] [] dataForPost() {
		
		Object [] [] data = new Object[2][3]; //(2 columns and 3 rows)
		
		data [0][0] = "Albert"; //(1st row, 1st column)
		data [0][1] = "Einstein"; //(1st row, 2nd column)
		data [0][2] = 2; //(1st row, 3rd column)
		
		data [1][0] = "Thomas"; //(2nd row, 1st column)
		data [1][1] = "Edison"; //(2nd row, 2nd column)
		data [1][2] = 1; //(2nd row, 3rd column)
		
		return data;
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
