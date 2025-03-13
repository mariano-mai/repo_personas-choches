package com.mariano.personasycoches.mapper.automovil.impl;

import org.springframework.stereotype.Component;

import com.mariano.personasycoches.domain.Automovil;
import com.mariano.personasycoches.dto.automovil.AutomovilCreateDto;
import com.mariano.personasycoches.dto.automovil.AutomovilCreatedDto;
import com.mariano.personasycoches.mapper.automovil.AutomovilMapper;

@Component
public class AutomovilMapperImpl implements AutomovilMapper{

	@Override
	public Automovil automovilCreateDtoToAutomovil(AutomovilCreateDto automovilCreateDto) {
		Automovil newAutomovil = new Automovil();
		newAutomovil.setMarca(automovilCreateDto.marca());
		newAutomovil.setModelo(automovilCreateDto.modelo());
		return newAutomovil;
	}

	@Override
	public AutomovilCreatedDto automovilToAutomovilCreatedDto(Automovil automovil) {
		return new AutomovilCreatedDto(
				automovil.getPatente(),
				automovil.getMarca(),
				automovil.getModelo());
	}

}
