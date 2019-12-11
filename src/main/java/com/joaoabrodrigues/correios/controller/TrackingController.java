package com.joaoabrodrigues.correios.controller;

import com.joaoabrodrigues.correios.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/track")
public class TrackingController {

	private TrackingService trackingService;

	@Autowired
	public TrackingController (TrackingService trackingService) {
		this.trackingService = trackingService;
	}
	
	@CrossOrigin
	@GetMapping(path = "/{object}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getTrackInfo(@PathVariable("object") String object) {
		return trackingService.getTrackInformation(object);
	}
}