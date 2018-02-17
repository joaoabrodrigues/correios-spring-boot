package com.joaoabrodrigues.correios.service;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TrackService {
	
	@Value("${correios.url.tracking}")
	private String urlTracking;
	
	public String getTrackInformation(String object) {
		
		String request = "<rastroObjeto>"
				+ "<usuario>MobileXect</usuario>"
				+ "<senha>DRW0#9F$@0</senha>"
				+ "<tipo>L</tipo>"
				+ "<resultado>L</resultado>"
				+ "<objetos>"
				+ object
				+ "</objetos>"
				+ "<lingua>101</lingua>"
				+ "</rastroObjeto>";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);

		HttpEntity<String> entity = new HttpEntity<String>(request, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		
		return restTemplate.postForObject(urlTracking, entity, String.class);
	}

}
