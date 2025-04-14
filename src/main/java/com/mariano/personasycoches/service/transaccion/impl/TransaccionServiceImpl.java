package com.mariano.personasycoches.service.transaccion.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mariano.personasycoches.domain.Transaccion;
import com.mariano.personasycoches.dto.transaccion.TransaccionCreateDto;
import com.mariano.personasycoches.dto.transaccion.TransaccionDto;
import com.mariano.personasycoches.mapper.transaccion.TransaccionMapper;
import com.mariano.personasycoches.repository.transaccion.TransaccionRepository;
import com.mariano.personasycoches.service.transaccion.TransaccionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransaccionServiceImpl implements TransaccionService{
	
	private TransaccionRepository transaccionRepo;
	private TransaccionMapper transaccionMapper;

	@Override
	public Optional<TransaccionDto> createTransaccion(TransaccionCreateDto transaccionCreateDto) {
		Transaccion newTransaccion = transaccionMapper.transaccionCreateDtoToTransaccion(transaccionCreateDto);
		return Optional.of(transaccionMapper.transaccionToTransaccionDto(transaccionRepo.save(newTransaccion)));
	}

}
