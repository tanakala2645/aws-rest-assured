package org.aws.ws.test;

import org.aws.ws.BaseClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class Tests {

	@Test
	public void getPostsAPI() {
		ValidatableResponse response = BaseClass.getAPI("/posts", 200);
		response.contentType(ContentType.JSON).body("[0].id", equalTo(1));
	}

}
