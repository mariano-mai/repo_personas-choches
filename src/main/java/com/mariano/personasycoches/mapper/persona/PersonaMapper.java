package com.mariano.personasycoches.mapper.persona;

import com.mariano.personasycoches.domain.Persona;
import com.mariano.personasycoches.dto.persona.PersonaAutomovilUpdatedDto;
import com.mariano.personasycoches.dto.persona.PersonaByIdDto;
import com.mariano.personasycoches.dto.persona.PersonaCreateDto;
import com.mariano.personasycoches.dto.persona.PersonaCreatedDto;
import com.mariano.personasycoches.dto.persona.PersonaNewCarDto;

public interface PersonaMapper {
	
	Persona personaCreateDtoToPersona(PersonaCreateDto personaCreateDto);
	
	PersonaCreatedDto personaToPersonaCreatedDto(Persona persona);
	
	PersonaByIdDto personaToPersonaByIdDto(Persona persona);
	
	PersonaNewCarDto personaToPersonaNewCarDto(String patente);
	
	PersonaAutomovilUpdatedDto personaToPersonaAutomovilUpdatedDto(Persona persona);

}
