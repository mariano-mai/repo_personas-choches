package com.mariano.personasycoches.dto.transaccion;

import com.mariano.personasycoches.enums.TipoTranEnum;

public record TransaccionCreateDto(
		String personaId, 
		String patente, 
		TipoTranEnum operacion) {

}
