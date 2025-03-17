package com.mariano.personasycoches.service.persona;

import java.util.Optional;
import java.util.UUID;

import com.mariano.personasycoches.dto.persona.PersonaCreateDto;
import com.mariano.personasycoches.dto.persona.PersonaCreatedDto;

public interface PersonaService {
	
	Optional<PersonaCreatedDto> createPersona(PersonaCreateDto personaCreateDto);
	
	void addTransaccion(String personaId, UUID transaccionId);

}
