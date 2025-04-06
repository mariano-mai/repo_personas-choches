package com.mariano.personasycoches.controller.automovil;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mariano.personasycoches.dto.automovil.AutomovilCreateDto;
import com.mariano.personasycoches.dto.automovil.AutomovilCreatedDto;
import com.mariano.personasycoches.service.automovil.AutomovilService;

@RestController
public class AutomovilController {
	
	@Autowired
	private AutomovilService automovilService;
	
	@PostMapping("/api/v1/automovil")
	public ResponseEntity<?> createAutomovil(
			@RequestBody AutomovilCreateDto automovilCreateDto){
		Optional<AutomovilCreatedDto> automovilCreatedDto = automovilService.createAutomovil(automovilCreateDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(automovilCreatedDto.get());
	}

}
