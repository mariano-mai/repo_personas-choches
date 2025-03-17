package com.mariano.personasycoches.repository.transaccion;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariano.personasycoches.domain.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, UUID>{}
