package com.mariano.personasycoches.dto.persona;

import java.util.List;

import com.mariano.personasycoches.dto.automovil.AutomovilCreatedDto;
import com.mariano.personasycoches.dto.transaccion.TransaccionDto;

public record PersonaByIdDto(
		String id, 
		String nombre, 
		String apellido, 
		AutomovilCreatedDto automovil, 
		List<TransaccionDto> transacciones) {

}
