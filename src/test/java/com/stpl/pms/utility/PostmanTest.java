/*package com.stpl.pms.utility;


import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author manoj.singh@skilrock.com
 *
 */
/*public class PostmanTest {

	@Test
	public void testPost(){

		try {
			PostRequest request = PostRequest.createPostRequest("foo", "bar", 1);
			Postman postman = new Postman()
					.setUrl("https://jsonplaceholder.typicode.com/posts")
					.setMethod("POST")
					.setExpectedStatus(201)
					.addResponseHandler(201, Postresponse.class)
					.addHeader("Content-Type","application/json")
					.setMessage(Utility.beanToJSON(request, false));
			Postresponse response = (Postresponse) postman.call();
			
			Assert.assertEquals(response.getId(),new Integer(101));
			Assert.assertEquals(request.getTitle(), "foo");
			Assert.assertEquals(request.getBody(), "bar");
			Assert.assertEquals(request.getUserId(), new Integer(1));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
//	@Test
//	public void testIthubaPost(){
//		try {
//			PostRequest request = PostRequest.createPostRequest("test", "",1)
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
}

class PostRequest {

	private String title;
	private String body;
	private Integer userId;
	
	public static PostRequest createPostRequest(String title, String body, Integer userId) {
		PostRequest obj = new PostRequest();
		obj.title = title;
		obj.body = body;
		obj.userId = userId;
		return obj;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("body")
	public String getBody() {
		return body;
	}

	@JsonProperty("body")
	public void setBody(String body) {
		this.body = body;
	}

	@JsonProperty("userId")
	public Integer getUserId() {
		return userId;
	}

	@JsonProperty("userId")
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}

class Postresponse extends PostRequest{
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
*/