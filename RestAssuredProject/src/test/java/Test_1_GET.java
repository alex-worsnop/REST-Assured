import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

//REST Assured API testing Beginner Tutorial | Part 2
//Youtube" https://www.youtube.com/watch?v=mkIliGAePBM
public class Test_1_GET {
	
	@Test
	void test01() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
	}	
	
	@Test
	void test2() {
		
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[0]", equalTo(7));
	}
	
}
