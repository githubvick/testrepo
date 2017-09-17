package com.threepillarglobal.microservices.reward;

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

public class RewardTest {

	

	@Test
	public void testReward() throws Exception{
		String IP = System.getProperty("IP");
		String PORT3 = System.getProperty("PORT3");
		String URL = "http://"+IP+":" + PORT3 + "/reward/";
		HttpUriRequest request = new HttpGet(URL);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());
	}
	
	
}
