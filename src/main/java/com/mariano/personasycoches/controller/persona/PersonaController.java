package com.mariano.personasycoches.controller.persona;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mariano.personasycoches.dto.persona.PersonaCreateDto;
import com.mariano.personasycoches.dto.persona.PersonaCreatedDto;
import com.mariano.personasycoches.service.persona.PersonaService;

@RestController
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@PostMapping("/api/v1/persona")
	public ResponseEntity<?> createPersona(
			@RequestBody PersonaCreateDto personaCreateDto){
		Optional<PersonaCreatedDto> personaCreatedDto = personaService.createPersona(personaCreateDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(personaCreatedDto.get());
	}
	
	

}
