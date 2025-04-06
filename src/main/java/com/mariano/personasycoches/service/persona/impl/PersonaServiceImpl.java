package com.mariano.personasycoches.service.persona.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mariano.personasycoches.domain.Persona;
import com.mariano.personasycoches.dto.persona.PersonaAutomovilUpdatedDto;
import com.mariano.personasycoches.dto.persona.PersonaByIdDto;
import com.mariano.personasycoches.dto.persona.PersonaCreateDto;
import com.mariano.personasycoches.dto.persona.PersonaCreatedDto;
import com.mariano.personasycoches.mapper.persona.PersonaMapper;
import com.mariano.personasycoches.repository.automovil.AutomovilRepository;
import com.mariano.personasycoches.repository.persona.PersonaRepository;
import com.mariano.personasycoches.repository.transaccion.TransaccionRepository;
import com.mariano.personasycoches.service.persona.PersonaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonaServiceImpl implements PersonaService{
	
	private PersonaMapper personaMapper;
	private PersonaRepository personaRepository;
	private TransaccionRepository transaccionRepo;
	private AutomovilRepository autoRepo;
	
	@Override
	public Optional<PersonaCreatedDto> createPersona(PersonaCreateDto personaCreateDto) {
		Persona newPersona = personaMapper.personaCreateDtoToPersona(personaCreateDto);
		return Optional.of(personaMapper.personaToPersonaCreatedDto(personaRepository.save(newPersona)));
	}

	@Override
	public void addTransaccion(String personaId, UUID transaccionId) {
		Persona newPersona = personaRepository.getReferenceById(personaId);
		newPersona.getTransacciones().add(transaccionRepo.getReferenceById(transaccionId));
	}

	@Override
	public Optional<PersonaByIdDto> getPersonaById(String id) {
		Persona persona = personaRepository.getReferenceById(id);
		return Optional.of(personaMapper.personaToPersonaByIdDto(persona));
	}

	@Override
	public Optional<PersonaAutomovilUpdatedDto> addAutomovil(String personaId, String patente) {
		Persona newPersonaa = personaRepository.getReferenceById(personaId);
		newPersonaa.setAutomovil(autoRepo.getReferenceById(patente));
		return Optional.of(personaMapper.personaToPersonaAutomovilUpdatedDto(personaRepository.save(newPersonaa)));
	}
	
}
