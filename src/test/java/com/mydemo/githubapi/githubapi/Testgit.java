package com.mydemo.githubapi.githubapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Testgit {
	String access_token;

	@BeforeClass
	public void beforeTest() {
		access_token = "5e428926b37ae9ea278fa0ecad2e38ffcd393a82";

		RestAssured.baseURI = "https://api.github.com";
	}

	@Test(enabled=false)
	public void searchRepo() {
		given().queryParam("access_token", access_token).queryParam("q", "test").queryParam("order", "desc").when()
				.get("/search/repositories").then().statusCode(200).log().all();

		System.out.println("done ");
	}
	
	@Test(enabled=false)
	public void searchCode()
	{
		given().queryParam("access_token", access_token).queryParam("q", "addClass+in:file+language:js+repo:jquery/jquery").queryParam("order", "desc").when()
		.get("/search/code").then().statusCode(200).log().all();

		System.out.println("done 2");
		//q=addClass+in:file+language:js+repo:jquery/jquery

	}
	
	@Test()
	public void searchRepobranch()
	{
		given().queryParam("access_token", access_token).when()
		.get("/repos/manjut123/testgit/commits").then().statusCode(200).log().all();

		System.out.println("done 3");
		//repos/octocat/Hello-World/commits
	}
}
