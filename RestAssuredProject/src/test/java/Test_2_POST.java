import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

//REST Assured API testing Beginner Tutorial | Part 2
// Youtube" https://www.youtube.com/watch?v=mkIliGAePBM

public class Test_2_POST {
	
	@Test
	public void test_2_POST() {
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		map.put("name", "Alex");
//		map.put("job", "Teacher");
//		
//		System.out.println(map);
//		
//		JSONObject request = new JSONObject(map);
		
		JSONObject request = new JSONObject();
		
		
		request.put("name", "Alex");
		request.put("job", "Teacher");
		
		
		System.out.println(request);
//		or can use: System.out.println(request.toJSONString());
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
		post("https://reqres.in/api/users").
		then().statusCode(201);
		
		
	}
	

}
