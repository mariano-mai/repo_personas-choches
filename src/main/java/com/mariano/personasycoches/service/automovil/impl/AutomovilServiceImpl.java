package com.mariano.personasycoches.service.automovil.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mariano.personasycoches.domain.Automovil;
import com.mariano.personasycoches.dto.automovil.AutomovilCreateDto;
import com.mariano.personasycoches.dto.automovil.AutomovilCreatedDto;
import com.mariano.personasycoches.mapper.automovil.AutomovilMapper;
import com.mariano.personasycoches.repository.automovil.AutomovilRepository;
import com.mariano.personasycoches.service.automovil.AutomovilService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AutomovilServiceImpl implements AutomovilService{
	
	private AutomovilMapper automovilMapper;
	private AutomovilRepository automovilRepository;

	@Override
	public Optional<AutomovilCreatedDto> createAutomovil(AutomovilCreateDto automovilCreateDto) {
		Automovil newAutomovil = automovilMapper.automovilCreateDtoToAutomovil(automovilCreateDto);
		return Optional.of(automovilMapper.automovilToAutomovilCreatedDto(automovilRepository.save(newAutomovil)));
	}

}
