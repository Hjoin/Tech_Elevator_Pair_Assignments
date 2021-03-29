package com.techelevator.services;

import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatPicService implements CatPicService {

	private static final String API_URL = "https://random-cat-api.netlify.app/.netlify/functions/api";
	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public CatPic getPic() {

		CatPic pic = restTemplate.getForObject(API_URL, CatPic.class);

		return pic;
	}

}	
