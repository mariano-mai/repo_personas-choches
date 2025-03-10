package com.mariano.personasycoches.domain;

import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.mariano.personasycoches.idcustom.persona.PersonaId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
	
	@Id
	@PersonaId
	@JdbcTypeCode(SqlTypes.CHAR)
	@Column(length = 30, columnDefinition = "varchar(30)", updatable = false, nullable = false)
	private String id;
	private String nombre;
	private String apellido;
	private List<Automovil> vehiculos;

}
