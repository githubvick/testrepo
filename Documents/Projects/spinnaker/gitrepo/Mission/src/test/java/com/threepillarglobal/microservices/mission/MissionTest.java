package com.threepillarglobal.microservices.mission;


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

public class MissionTest {

	

	@Test
	public void testMission() throws Exception{
		String IP = System.getProperty("IP");
		String PORT2 = System.getProperty("PORT2");
		String URL = "http://"+IP+":" + PORT2 + "/mission/";
		HttpUriRequest request = new HttpGet(URL);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());
	}
	
	
}
