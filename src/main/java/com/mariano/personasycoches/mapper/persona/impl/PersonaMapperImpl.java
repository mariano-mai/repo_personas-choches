package com.mariano.personasycoches.mapper.persona.impl;

import org.springframework.stereotype.Component;

import com.mariano.personasycoches.domain.Persona;
import com.mariano.personasycoches.dto.persona.PersonaCreateDto;
import com.mariano.personasycoches.dto.persona.PersonaCreatedDto;
import com.mariano.personasycoches.mapper.persona.PersonaMapper;

@Component
public class PersonaMapperImpl implements PersonaMapper{

	@Override
	public Persona personaCreateDtoToPersona(PersonaCreateDto personaCreateDto) {
		Persona newPersona = new Persona();
		newPersona.setNombre(personaCreateDto.nombre());
		newPersona.setApellido(personaCreateDto.apellido());
		return newPersona;
	}

	@Override
	public PersonaCreatedDto personaToPersonaCreatedDto(Persona persona) {
		return new PersonaCreatedDto(
				persona.getId(),
				persona.getNombre(),
				persona.getApellido());
	}

}
