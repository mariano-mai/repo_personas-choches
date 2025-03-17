package com.mariano.personasycoches.service.automovil;

import java.util.Optional;
import java.util.UUID;

import com.mariano.personasycoches.dto.automovil.AutomovilCreateDto;
import com.mariano.personasycoches.dto.automovil.AutomovilCreatedDto;

public interface AutomovilService {
	
	Optional<AutomovilCreatedDto> createAutomovil(AutomovilCreateDto automovilCreateDto);
	
	void addTransaccion(String patente, UUID transaccionId);

}
