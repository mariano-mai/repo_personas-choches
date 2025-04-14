package com.mariano.personasycoches.controller.transaccion;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mariano.personasycoches.dto.transaccion.TransaccionCreateDto;
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
	
	@PostMapping("/api/v1/transaccion")
	public ResponseEntity<?> adquireVehicle(
			@RequestBody TransaccionCreateDto transaccionCreateDto){
		Optional<TransaccionDto> newTransaccion = transaccionServ.createTransaccion(transaccionCreateDto);
		personaService.addAutomovil(transaccionCreateDto.personaId(), transaccionCreateDto.patente());
		personaService.addTransaccion(transaccionCreateDto.personaId(), newTransaccion.get().id());
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(newTransaccion.get());
	}

}
