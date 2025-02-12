package elevateProjectAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;


//GET Request
public class APIAutomationTest {
	
  @Test(priority=1)
    void getUsers() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response getResponse = RestAssured
                .given()
                .when()
                	.get("/posts")
                .then()
                	.statusCode(200) 
                	.extract()
                	.response();

        System.out.println("GET Response: " + getResponse.prettyPrint());
    }



  @Test(priority=2)
  void postUsers() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        String requestBody = "{\n" +
                "  \"title\": \"New Post\",\n" +
                "  \"body\": \"This is the body of the new post\",\n" +
                "  \"userId\": 1\n" +
                "}";

        Response postResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201) 
                .extract()
                .response();

        System.out.println("POST Response: " + postResponse.prettyPrint());
    }

 
	@Test(priority=3)
	void putUsers() {
	        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

	        String requestBody = "{\n" +
	                "  \"title\": \"Updated Post\",\n" +
	                "  \"body\": \"This is the updated body of the post\",\n" +
	                "  \"userId\": 1\n" +
	                "}";

	        Response putResponse = RestAssured
	                .given()
	                .contentType(ContentType.JSON)
	                .body(requestBody)
	                .when()
	                .put("/posts/1") 
	                .then()
	                .statusCode(200) 
	                .extract()
	                .response();

	        System.out.println("PUT Response: " + putResponse.prettyPrint());
	    }
	
  
  //DELETE Request
	
	@Test(priority=4)
	void deleteUsers() {
	        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

	        Response deleteResponse = RestAssured
	                .given()
	                .when()
	                .delete("/posts/1") 
	                .then()
	                .statusCode(200)
	                .extract()
	                .response();

	        System.out.println("DELETE Response: " + deleteResponse.prettyPrint());
	    }
	
 }
