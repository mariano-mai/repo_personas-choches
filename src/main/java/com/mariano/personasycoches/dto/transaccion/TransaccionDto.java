package com.mariano.personasycoches.dto.transaccion;

import java.time.LocalDate;
import java.util.UUID;

public record TransaccionDto(
		UUID id, 
		String nombrePersona, 
		String patente, 
		LocalDate fecha) {

}
