package com.mariano.personasycoches.mapper.persona;

import com.mariano.personasycoches.domain.Persona;
import com.mariano.personasycoches.dto.persona.PersonaCreateDto;
import com.mariano.personasycoches.dto.persona.PersonaCreatedDto;

public interface PersonaMapper {
	
	Persona personaCreateDtoToPersona(PersonaCreateDto personaCreateDto);
	
	PersonaCreatedDto personaToPersonaCreatedDto(Persona persona);

}
