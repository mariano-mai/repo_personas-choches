package com.mariano.personasycoches.service.transaccion;

import java.util.Optional;

import com.mariano.personasycoches.domain.Transaccion;
import com.mariano.personasycoches.dto.transaccion.TransaccionCreateDto;

public interface TransaccionService {
	
	Optional<Transaccion> createTransaccion(TransaccionCreateDto transaccionCreateDto);

}
