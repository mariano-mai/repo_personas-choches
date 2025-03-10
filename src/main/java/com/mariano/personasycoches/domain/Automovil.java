package com.mariano.personasycoches.domain;

import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.mariano.personasycoches.idcustom.automovil.AutomovilId;

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
public class Automovil {
	
	@Id
	@AutomovilId
	@JdbcTypeCode(SqlTypes.CHAR)
	@Column(length = 7, columnDefinition = "varchar(7)", unique = true, nullable = false, updatable = false)
	private String patente;
	private String marca;
	private String modelo;
	private List<Persona> duenios;

}
