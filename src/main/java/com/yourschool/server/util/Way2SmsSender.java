package com.yourschool.server.util;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Way2SmsSender {

    static final String URL = "https://www.sms4india.com";
    static final String API_KEY = "BWW6G8GNYT3Z6CXJJDR0R7E0AL7C8VR4";
    static final String SECRET_KEY = "88XPA1UWVHPXX0LJ";
    
    private static void getEmployees()
    {
        final String uri = "http://localhost:8080/springrestexample/employees";
        
        
         
        RestTemplate restTemplate = new RestTemplate();
         
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
         
        ResponseEntity<String> result = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
         
        System.out.println(result);
    }
    
    /**
     *
     * @param token 
     * @param phone 10 digit mobile number
     * @param message
     * @param senderId
     */
	/*
	 * public static String sendCampaign(String apiKey,String secretKey,String
	 * useType, String phone, String message, String senderId){ try{ // construct
	 * data JSONObject urlParameters = new JSONObject();
	 * urlParameters.put("apikey",apiKey); urlParameters.put("secret",secretKey);
	 * urlParameters.put("usetype",useType); urlParameters.put("phone", phone);
	 * urlParameters.put("message", URLEncoder.encode(message,"UTF-8"));
	 * urlParameters.put("senderid", senderId); URL obj = new URL(url +
	 * "/api/v1/sendCampaign"); // send data HttpURLConnection httpConnection =
	 * (HttpURLConnection) obj.openConnection(); httpConnection.setDoOutput(true);
	 * httpConnection.setRequestMethod("POST"); DataOutputStream wr = new
	 * DataOutputStream(httpConnection.getOutputStream());
	 * wr.write(urlParameters.toString().getBytes()); // get the response
	 * BufferedReader bufferedReader = null; if (httpConnection.getResponseCode() ==
	 * 200) { bufferedReader = new BufferedReader(new
	 * InputStreamReader(httpConnection.getInputStream())); } else { bufferedReader
	 * = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
	 * } StringBuilder content = new StringBuilder(); String line; while ((line =
	 * bufferedReader.readLine()) != null) { content.append(line).append("\n"); }
	 * bufferedReader.close(); return content.toString(); }catch(Exception ex){
	 * System.out.println("Exception at:",ex); return
	 * "{'status':500,'message':'Internal Server Error'}"; }
	 * 
	 * }
	 */
    
    class W2SmsRequest{
    	String apikey;
    	String secret;
    	String usetype;
    	String senderid;
    	String phone;
    	String message;
    	
    	W2SmsRequest Build() {
    		return this;
    	}
    	W2SmsRequest apikey(String apikey) {
    		this.apikey = apikey;
    		return this;
    	}
    	W2SmsRequest secret(String secret) {
    		this.secret = secret;
    		return this;
    	}
    	W2SmsRequest usetype(String usetype) {
    		this.usetype = usetype;
    		return this;
    	}
    	W2SmsRequest senderid(String senderid) {
    		this.senderid = senderid;
    		return this;
    	}
    	W2SmsRequest phone(String phone) {
    		this.phone = phone;
    		return this;
    	}
    	W2SmsRequest message(String message) {
    		this.message = message;
    		return this;
    	}
    	
    }
    
}
