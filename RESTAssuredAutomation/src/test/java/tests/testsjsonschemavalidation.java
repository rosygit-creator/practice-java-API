
package tests;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class testsjsonschemavalidation {
	

	
	@Test
	public void test_1() {
		baseURI="https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
		statusCode(200).
		body("data[1].id", equalTo(8));
		
	}

	
	
}
