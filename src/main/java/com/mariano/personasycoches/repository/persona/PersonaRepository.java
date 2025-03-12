package com.mariano.personasycoches.repository.persona;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariano.personasycoches.domain.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String>{}
