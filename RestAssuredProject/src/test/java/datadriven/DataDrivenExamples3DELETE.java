package datadriven;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

//From: https://www.youtube.com/watch?v=2ggM0vm4fbg
//REST Assured API testing Beginner Tutorial | Part 4

public class DataDrivenExamples3DELETE {


	@DataProvider(name = "DeleteUsersData")
	public Object[] DataUsersForDelete() {
		
//		deleting users 4, 5 and 6 created in earlier test
		return new Object[] {
				4,5,6
		};
	}
	
	@Test(dataProvider = "DeleteUsersData")
	public void test_delete(int userId) {
		
		baseURI = "http://localhost:3000/";
		
		when().
			delete("/users/"+userId).
		then().
		statusCode(200);

	}

}
