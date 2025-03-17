package com.mariano.personasycoches.mapper.transaccion;

import com.mariano.personasycoches.domain.Transaccion;
import com.mariano.personasycoches.dto.transaccion.TransaccionDto;

public interface TransaccionMapper {
	
	TransaccionDto transaccionToTransaccionDto(Transaccion transaccion);

}
