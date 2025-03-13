package com.mariano.personasycoches.repository.automovil;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariano.personasycoches.domain.Automovil;

public interface AutomovilRepository extends JpaRepository<Automovil, String>{}
