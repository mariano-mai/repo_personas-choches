package com.mariano.personasycoches.mapper.automovil;

import com.mariano.personasycoches.domain.Automovil;
import com.mariano.personasycoches.dto.automovil.AutomovilCreateDto;
import com.mariano.personasycoches.dto.automovil.AutomovilCreatedDto;

public interface AutomovilMapper {
	
	Automovil automovilCreateDtoToAutomovil(AutomovilCreateDto automovilCreateDto);
	
	AutomovilCreatedDto automovilToAutomovilCreatedDto(Automovil automovil);

}
