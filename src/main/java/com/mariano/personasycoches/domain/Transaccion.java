package com.mariano.personasycoches.domain;

import java.time.LocalDate;
import java.util.UUID;

import com.mariano.personasycoches.enums.TipoTranEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Transaccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private LocalDate fecha;
	
	@ManyToOne
	@JoinColumn(name = "automovil_patente")
	private Automovil automovil;
	
	@ManyToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;
	
	@Enumerated(EnumType.STRING)
	private TipoTranEnum operacion;

}
