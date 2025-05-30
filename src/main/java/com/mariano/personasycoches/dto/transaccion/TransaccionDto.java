package com.mariano.personasycoches.dto.transaccion;

import java.time.LocalDate;
import java.util.UUID;

import com.mariano.personasycoches.enums.TipoTranEnum;

public record TransaccionDto(
		UUID id, 
		String nombrePersona, 
		String patente, 
		LocalDate fecha,
		TipoTranEnum operacion) {

}
