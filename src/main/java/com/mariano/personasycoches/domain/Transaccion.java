package com.mariano.personasycoches.domain;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class Transaccion {
	
	private UUID id;
	private LocalDate fecha;
	private Automovil automovil;
	
	@ManyToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;

}
