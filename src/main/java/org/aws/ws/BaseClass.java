package org.aws.ws;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class BaseClass {

	public static String baseURI = "http://ec2-54-174-213-136.compute-1.amazonaws.com:3000";

	public static ValidatableResponse getAPI(String endpoint, int statusCode) {
		RestAssured.baseURI = baseURI;

		ValidatableResponse response = given().when().get(endpoint).then().assertThat().statusCode(statusCode).and()
				.contentType(ContentType.JSON);

		return response;

	}

	public static ValidatableResponse postAPI(String endpoint, int statusCode, String payload) {
		{
			RestAssured.baseURI = baseURI;

			ValidatableResponse response = given().queryParam("key", "value").body(payload).when().post(endpoint).then()
					.assertThat().statusCode(statusCode);

			return response;

		}
	}

	public static ValidatableResponse putAPI(String endpoint, int statusCode,
			String payload) {
		RestAssured.baseURI = baseURI;

		ValidatableResponse response = given().queryParam("key", "value").body(payload).when().put(endpoint).then()
				.assertThat().statusCode(statusCode);

		return response;

	}
}
