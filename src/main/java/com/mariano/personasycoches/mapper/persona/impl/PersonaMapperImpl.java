package com.mariano.personasycoches.mapper.persona.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mariano.personasycoches.domain.Automovil;
import com.mariano.personasycoches.domain.Persona;
import com.mariano.personasycoches.domain.Transaccion;
import com.mariano.personasycoches.dto.persona.PersonaAutomovilUpdatedDto;
import com.mariano.personasycoches.dto.persona.PersonaByIdDto;
import com.mariano.personasycoches.dto.persona.PersonaCreateDto;
import com.mariano.personasycoches.dto.persona.PersonaCreatedDto;
import com.mariano.personasycoches.dto.persona.PersonaNewCarDto;
import com.mariano.personasycoches.dto.transaccion.TransaccionDto;
import com.mariano.personasycoches.mapper.automovil.AutomovilMapper;
import com.mariano.personasycoches.mapper.persona.PersonaMapper;
import com.mariano.personasycoches.mapper.transaccion.TransaccionMapper;
import com.mariano.personasycoches.repository.automovil.AutomovilRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PersonaMapperImpl implements PersonaMapper{

	private AutomovilMapper autoMapper;
	private TransaccionMapper transMapper;
	private AutomovilRepository autoRepo;

	@Override
	public Persona personaCreateDtoToPersona(PersonaCreateDto personaCreateDto) {
		Persona newPersona = new Persona();
		newPersona.setNombre(personaCreateDto.nombre());
		newPersona.setApellido(personaCreateDto.apellido());
		newPersona.setAutomovil(autoRepo.save(genericCar()));
		return newPersona;
	}
	
	private Automovil genericCar() {
		return new Automovil();
	}

	@Override
	public PersonaCreatedDto personaToPersonaCreatedDto(Persona persona) {
		return new PersonaCreatedDto(
				persona.getId(),
				persona.getNombre(),
				persona.getApellido());
	}

	@Override
	public PersonaByIdDto personaToPersonaByIdDto(Persona persona) {
		return new PersonaByIdDto(
				persona.getId(),
				persona.getNombre(),
				persona.getApellido(),
				autoMapper.automovilToAutomovilCreatedDto(persona.getAutomovil()),
				listarTransaccionesDto(persona.getTransacciones()));
	}
	
	private List<TransaccionDto> listarTransaccionesDto(List<Transaccion> lista){
		List<TransaccionDto> transacciones = new ArrayList<>();
		lista.stream().forEach(transaccion -> transacciones.add(transMapper.transaccionToTransaccionDto(transaccion)));
		return transacciones;
	}

	@Override
	public PersonaNewCarDto personaToPersonaNewCarDto(String patente) {
		Automovil newAuto = autoRepo.getReferenceById(patente);
		return new PersonaNewCarDto(autoMapper.automovilToAutomovilCreatedDto(newAuto));
	}

	@Override
	public PersonaAutomovilUpdatedDto personaToPersonaAutomovilUpdatedDto(Persona persona) {
		return new PersonaAutomovilUpdatedDto(
				persona.getId(), 
				persona.getAutomovil().getPatente());
	}

}
