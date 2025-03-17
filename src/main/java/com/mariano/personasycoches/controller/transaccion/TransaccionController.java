package com.mariano.personasycoches.controller.transaccion;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mariano.personasycoches.domain.Transaccion;
import com.mariano.personasycoches.dto.transaccion.TransaccionDto;
import com.mariano.personasycoches.mapper.transaccion.TransaccionMapper;
import com.mariano.personasycoches.service.automovil.AutomovilService;
import com.mariano.personasycoches.service.persona.PersonaService;
import com.mariano.personasycoches.service.transaccion.TransaccionService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TransaccionController {
	
	TransaccionService transaccionServ;
	TransaccionMapper transaccionMapper;
	
	PersonaService personaService;
	
	AutomovilService automovilService;
	
	@PutMapping("/api/v1/transaccion")
	public ResponseEntity<?> adquireVehicle(
			@RequestParam(name = "persona_id") String persona_id,
			@RequestParam(name = "vehiculo_patente") String vehiculo_patente){
		Optional<Transaccion> newTransaccion = transaccionServ.createTransaccion(persona_id, vehiculo_patente);
		Optional<TransaccionDto> transaccionMade = Optional.of(transaccionMapper.transaccionToTransaccionDto(newTransaccion.get()));
		personaService.addTransaccion(persona_id, newTransaccion.get().getId());
		automovilService.addTransaccion(vehiculo_patente, newTransaccion.get().getId());
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(transaccionMade.get());
	}

}
