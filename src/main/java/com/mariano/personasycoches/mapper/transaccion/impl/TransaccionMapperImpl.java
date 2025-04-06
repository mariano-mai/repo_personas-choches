package com.mariano.personasycoches.mapper.transaccion.impl;

import org.springframework.stereotype.Component;

import com.mariano.personasycoches.domain.Transaccion;
import com.mariano.personasycoches.dto.transaccion.TransaccionDto;
import com.mariano.personasycoches.mapper.transaccion.TransaccionMapper;

@Component
public class TransaccionMapperImpl implements TransaccionMapper{

	@Override
	public TransaccionDto transaccionToTransaccionDto(Transaccion transaccion) {
		// TODO Auto-generated method stub
		return new TransaccionDto(
				transaccion.getId(),
				nombreCompleto(transaccion),
				patenteDelAutomovil(transaccion),
				transaccion.getFecha(),
				transaccion.getOperacion());
	}
	
	private String nombreCompleto(Transaccion transaccion) {
		return transaccion.getPersona().getNombre()+" "+transaccion.getPersona().getApellido();
	}
	
	private String patenteDelAutomovil(Transaccion transaccion) {
		return transaccion.getPersona().getAutomovil().getPatente();
	}

}
