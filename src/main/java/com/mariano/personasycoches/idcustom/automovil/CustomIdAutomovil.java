package com.mariano.personasycoches.idcustom.automovil;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.mariano.personasycoches.bootstrap.Constantes;

public class CustomIdAutomovil implements IdentifierGenerator, Constantes {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int counter=1;

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		char letra1 = letraGenerator();
		char letra2 = letraGenerator();
		String medio = String.format("%005d", counter++);
		char letra3 = letraGenerator();
		char letra4 = letraGenerator();
		return letra1+letra2+medio+letra3+letra4;
	}
	
	private char letraGenerator() {
		return LETRAS[numeroRandom(1,26)];
	}
	
	private int numeroRandom(int min, int max) {
		return (int)((Math.random()*(max-min))+min);
	}

}
