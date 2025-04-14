package com.mariano.personasycoches.mapper.transaccion.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.mariano.personasycoches.domain.Transaccion;
import com.mariano.personasycoches.dto.transaccion.TransaccionCreateDto;
import com.mariano.personasycoches.dto.transaccion.TransaccionDto;
import com.mariano.personasycoches.mapper.transaccion.TransaccionMapper;
import com.mariano.personasycoches.repository.persona.PersonaRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TransaccionMapperImpl implements TransaccionMapper{
	
	private PersonaRepository personaRepo;

	@Override
	public TransaccionDto transaccionToTransaccionDto(Transaccion transaccion) {
		// TODO Auto-generated method stub
		return new TransaccionDto(
				transaccion.getId(),
				nombreCompleto(transaccion),
				patenteDelAutomovil(transaccion),
				transaccion.getFecha(),
				transaccion.getOperacion());
	}
	
	private String nombreCompleto(Transaccion transaccion) {
		return transaccion.getPersona().getNombre()+" "+transaccion.getPersona().getApellido();
	}
	
	private String patenteDelAutomovil(Transaccion transaccion) {
		return transaccion.getPersona().getAutomovil().getPatente();
	}

	@Override
	public Transaccion transaccionCreateDtoToTransaccion(TransaccionCreateDto transaccionCreateDto) {
		Transaccion newTransaccion = new Transaccion();
		newTransaccion.setFecha(LocalDate.now());
		newTransaccion.setPersona(personaRepo.getReferenceById(transaccionCreateDto.personaId()));
		newTransaccion.setOperacion(transaccionCreateDto.operacion());
		return newTransaccion;
	}

}
