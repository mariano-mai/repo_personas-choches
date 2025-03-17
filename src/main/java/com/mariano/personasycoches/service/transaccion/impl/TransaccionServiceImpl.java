package com.mariano.personasycoches.service.transaccion.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mariano.personasycoches.domain.Transaccion;
import com.mariano.personasycoches.repository.automovil.AutomovilRepository;
import com.mariano.personasycoches.repository.persona.PersonaRepository;
import com.mariano.personasycoches.repository.transaccion.TransaccionRepository;
import com.mariano.personasycoches.service.transaccion.TransaccionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransaccionServiceImpl implements TransaccionService{
	
	private AutomovilRepository autoRepo;
	private PersonaRepository personaRepo;
	private TransaccionRepository transaccionRepo;

	@Override
	public Optional<Transaccion> createTransaccion(String personaId, String patente) {
		Transaccion newTransaccion = new Transaccion();
		newTransaccion.setFecha(LocalDate.now());
		newTransaccion.setAutomovil(autoRepo.getReferenceById(patente));
		newTransaccion.setPersona(personaRepo.getReferenceById(personaId));
		return Optional.of(transaccionRepo.save(newTransaccion));
	}

}
