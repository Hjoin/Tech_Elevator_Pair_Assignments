package com.techelevator.services;

import com.techelevator.model.CatPic;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService {
	private static final String API_IRL = "https://cat-fact.herokuapp.com/facts/random";
	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public CatFact getFact() {

		CatFact fact = restTemplate.getForObject(API_IRL, CatFact.class);

		return fact;
	}

}
