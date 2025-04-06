package com.mariano.personasycoches.controller.persona;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mariano.personasycoches.dto.persona.PersonaAutomovilUpdateDto;
import com.mariano.personasycoches.dto.persona.PersonaAutomovilUpdatedDto;
import com.mariano.personasycoches.dto.persona.PersonaByIdDto;
import com.mariano.personasycoches.dto.persona.PersonaCreateDto;
import com.mariano.personasycoches.dto.persona.PersonaCreatedDto;
import com.mariano.personasycoches.service.persona.PersonaService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PersonaController {
	
	private PersonaService personaService;
	
	@PostMapping("/api/v1/persona")
	public ResponseEntity<?> createPersona(
			@RequestBody PersonaCreateDto personaCreateDto){
		Optional<PersonaCreatedDto> personaCreatedDto = personaService.createPersona(personaCreateDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(personaCreatedDto.get());
	}
	
	@GetMapping("/api/v1/persona/{personaId}")
	public ResponseEntity<PersonaByIdDto> getPersonaById(
			@PathVariable("personaId") String personaId){
		Optional<PersonaByIdDto> personaDto = personaService.getPersonaById(personaId);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(personaDto.get());
	}
	
	@PutMapping("/api/v1/persona/{personaId}")
	public ResponseEntity<?> updateAutomovilOfPersona(
			@PathVariable(value="personaId") String personaId,
			@RequestBody PersonaAutomovilUpdateDto personaAutomovilUpdateDto){
		Optional<PersonaAutomovilUpdatedDto> personaUpdated = 
				personaService.addAutomovil(personaId, personaAutomovilUpdateDto.patente());
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(personaUpdated.get());
	}

}
