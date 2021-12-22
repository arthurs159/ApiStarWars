package desafio.apiStarWars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.apiStarWars.dto.PageableResponse;
import desafio.apiStarWars.dto.PeopleDTO;
import desafio.apiStarWars.services.PeopleService;

@RestController
@RequestMapping(value = "/people")
public class PeopleController {

	@Autowired
	private PeopleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PeopleDTO> findById(@PathVariable Long id){
		PeopleDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<PageableResponse<PeopleDTO>> findAll(){
		PageableResponse<PeopleDTO> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
}
