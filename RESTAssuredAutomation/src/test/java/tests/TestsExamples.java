
package tests;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class TestsExamples {
	

	
	@Test
	public void test_1() {
		baseURI="https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("data[1].id", equalTo(8));
		
	}
//	POST req
	@Test
	public void test_2() {
		baseURI="https://reqres.in/api";
		
		JSONObject request=new JSONObject();
		request.put("name", "rosy");
		request.put("job", "Teacher");
		
		given().
			headers("ContentType", "application/json").
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201);
		
		
	}
//	PUT req
	@Test
	public void test_3() {
		
		baseURI="https://reqres.in/api";
		JSONObject request=new JSONObject();
		
		request.put("name", "abc");
		request.put("job", "Teacher");
		
		given().
			cookie("session_id", "value").
			cookie("session_id2", "value").
			header("header1", "value1").
			header("header2", "value2").
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
		statusCode(200);
	}
}


