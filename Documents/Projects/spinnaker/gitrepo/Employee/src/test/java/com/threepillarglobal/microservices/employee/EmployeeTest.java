package com.threepillarglobal.microservices.employee;

import static org.junit.Assert.*;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class EmployeeTest {

	String jsonPost = "{\"id\" : \"1\",  \"email\": \"vickram.chakravarthy@macys.com\",  \"fullName\": \"Vickram Chakravarthy\",  \"managerEmail\": \"james.harry@macys.com\",  \"totalPointsEarned\" : 100,  \"availablePoints\" : 1000,  \"completedMissions\":[{\"missionId\": \"1\", \"completionDate\":\"2011-11-02T02:50:12.208Z\", \"pointsEarned\": 100},{\"missionId\": \"2\", \"completionDate\":\"2011-11-02T02:50:12.208Z\", \"pointsEarned\": 100}],  \"redeemedRewards\":[{\"rewardId\": \"1\", \"redeemedOn\":\"2011-11-02T02:50:12.208Z\", \"pointCost\": 100},{\"rewardId\": \"2\", \"redeemedOn\":\"2011-11-02T02:50:12.208Z\", \"pointCost\": 100}]}";
	
	@Test
	public void testEmployee() throws Exception{
		String IP = System.getProperty("IP");
		String PORT1 = System.getProperty("PORT1");
		String URL = "http://"+IP+":" + PORT1 + "/employee";
		HttpUriRequest request = new HttpGet(URL);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());
	}
	
	@Test
	public void testMission() throws Exception{
		String IP = System.getProperty("IP");
		String PORT2 = System.getProperty("PORT2");
		String URL = "http://"+IP+":" + PORT2 + "/mission/";
		HttpUriRequest request = new HttpGet(URL);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());
	}
	
	@Test
	public void testReward() throws Exception{
		String IP = System.getProperty("IP");
		String PORT3 = System.getProperty("PORT3");
		String URL = "http://"+IP+":" + PORT3 + "/reward/";
		HttpUriRequest request = new HttpGet(URL);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());
	}
	
	@Test
	public void integrationTest() throws Exception{
		String IP = System.getProperty("IP");
		String PORT1 = System.getProperty("PORT1");
		String URL = "http://"+IP+":" + PORT1 + "/employee";
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(URL);
		StringEntity postingString = new StringEntity(jsonPost);
		post.setEntity(postingString);
		post.setHeader("Content-type", "application/json");
		HttpResponse  response = client.execute(post);
		assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());
	}
	
	
	
}
