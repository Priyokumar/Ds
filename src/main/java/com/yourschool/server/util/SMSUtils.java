package com.yourschool.server.util;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yourschool.server.entity.sms.ScDatagenResponse;

public class SMSUtils {

	private static final String URL = "https://global.datagenit.com/API/sms-api.php";
	private static final String AUTH_KEY = "D!~3385Zi1T3dpjkk";
	private static final String SENDER_ID = "PESADM";
	
	public static RestTemplate getRestTemplate() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
	    TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
	        @Override
	        public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
	            return true;
	        }
	    };
	    SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
	    SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
	    CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
	    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
	    requestFactory.setHttpClient(httpClient);
	    RestTemplate restTemplate = new RestTemplate(requestFactory);
	    return restTemplate;
	}

	public static void SendSMS(String contactNumber, String message) {

		try {
			RestTemplate restTemplate = getRestTemplate();

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
			ScDatagenResponse readValue = mapper.readValue(body, ScDatagenResponse.class);
			

			System.out.println(readValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
