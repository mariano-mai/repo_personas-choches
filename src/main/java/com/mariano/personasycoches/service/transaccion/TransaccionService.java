package com.mariano.personasycoches.service.transaccion;

import java.util.Optional;

import com.mariano.personasycoches.dto.transaccion.TransaccionCreateDto;
import com.mariano.personasycoches.dto.transaccion.TransaccionDto;

public interface TransaccionService {
	
	Optional<TransaccionDto> createTransaccion(TransaccionCreateDto transaccionCreateDto);

}
