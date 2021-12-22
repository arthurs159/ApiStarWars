package desafio.apiStarWars.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import desafio.apiStarWars.dto.PageableResponse;
import desafio.apiStarWars.dto.PeopleDTO;

@Service
public class PeopleService {

	@Autowired
	private RestTemplate restTemplate;

	private String host = "https://swapi.dev/api";

	private String path = host + "/people";

	public PeopleDTO findById(Long id) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", id.toString());

		System.out.println(path + "/{id}");

		ResponseEntity<PeopleDTO> result = restTemplate.getForEntity(path + "/{id}", PeopleDTO.class, uriVariables);
		return result.getBody();
	}
	
	public PageableResponse<PeopleDTO> findAll() {
		ParameterizedTypeReference<PageableResponse<PeopleDTO>> responseType = new ParameterizedTypeReference<PageableResponse<PeopleDTO>>() { };
//		ResponseEntity<PageDTO<PeopleDTO>> result = restTemplate.exchange(path, HttpMethod.GET, null, responseType);
		ResponseEntity<PageableResponse<PeopleDTO>> eventsResponse = restTemplate.exchange(path,
                HttpMethod.GET, null, responseType);
		return eventsResponse.getBody();
	}
	
}
