package com.mariano.personasycoches.service.persona.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mariano.personasycoches.domain.Persona;
import com.mariano.personasycoches.dto.persona.PersonaCreateDto;
import com.mariano.personasycoches.dto.persona.PersonaCreatedDto;
import com.mariano.personasycoches.mapper.persona.PersonaMapper;
import com.mariano.personasycoches.repository.persona.PersonaRepository;
import com.mariano.personasycoches.service.persona.PersonaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonaServiceImpl implements PersonaService{
	
	private PersonaMapper personaMapper;
	private PersonaRepository personaRepository;
	
	@Override
	public Optional<PersonaCreatedDto> createPersona(PersonaCreateDto personaCreateDto) {
		Persona newPersona = personaMapper.personaCreateDtoToPersona(personaCreateDto);
		return Optional.of(personaMapper.personaToPersonaCreatedDto(personaRepository.save(newPersona)));
	}
	
	

}
