package com.joaoabrodrigues.correios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joaoabrodrigues.correios.service.TrackService;

@RestController
@RequestMapping("/v1/tracking")
public class TrackController {
	
	@Autowired
	private TrackService trackService;
	
	@CrossOrigin
	@RequestMapping(path = "/{object}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String updateAccountLimit(@PathVariable("object") String object) {
		return trackService.getTrackInformation(object);
	}
}