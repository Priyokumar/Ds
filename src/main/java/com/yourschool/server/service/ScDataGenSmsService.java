package com.yourschool.server.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yourschool.server.entity.sms.ScDatagenResponse;
import com.yourschool.server.vo.DataGenSMSStatus;

@Service
public class ScDataGenSmsService {
	
	private static final String URL = "https://global.datagenit.com/API/sms-api.php";
	private static final String AUTH_KEY = "D!~3385Zi1T3dpjkk";
	private static final String SENDER_ID = "PESADM";

	@Autowired
	private ScBeansService scBeansService;
	
	public ScDatagenResponse sendSms(String contactNumber, String message) {
		
		ScDatagenResponse smsResponse = new ScDatagenResponse();
		System.out.println("Sending sms");
		try {
			RestTemplate restTemplate = scBeansService.getBeans().getRestTemplate();

			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.add("cache-control", "no-cache");
			
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL)
			        .queryParam("auth", AUTH_KEY)
			        .queryParam("senderid", SENDER_ID)
			        .queryParam("msisdn", contactNumber)
			        .queryParam("message", message);
			
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			
			HttpEntity<String> response = restTemplate.exchange(
			        builder.toUriString(), 
			        HttpMethod.GET, 
			        entity, 
			        String.class);
			
			String body = response.getBody();
			
			ObjectMapper mapper = new ObjectMapper();
			smsResponse = mapper.readValue(body, ScDatagenResponse.class);
			System.out.println("sms response :");
			System.out.println(smsResponse);

		} catch (Exception e) {
			smsResponse.setStatus(DataGenSMSStatus.FAILED_TO_SEND);
			System.out.println(e.getMessage());
		}
		return smsResponse;
	}
	
}
