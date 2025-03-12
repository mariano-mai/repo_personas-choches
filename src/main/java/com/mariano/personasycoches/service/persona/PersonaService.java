package com.mariano.personasycoches.service.persona;

import java.util.Optional;

import com.mariano.personasycoches.dto.persona.PersonaCreateDto;
import com.mariano.personasycoches.dto.persona.PersonaCreatedDto;

public interface PersonaService {
	
	Optional<PersonaCreatedDto> createPersona(PersonaCreateDto personaCreateDto);

}
