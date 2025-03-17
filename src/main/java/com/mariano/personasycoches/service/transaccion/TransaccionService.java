package com.mariano.personasycoches.service.transaccion;

import java.util.Optional;

import com.mariano.personasycoches.domain.Transaccion;

public interface TransaccionService {
	
	Optional<Transaccion> createTransaccion(String personaId, String patente);

}
