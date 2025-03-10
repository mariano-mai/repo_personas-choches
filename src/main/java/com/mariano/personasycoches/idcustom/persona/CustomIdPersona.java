package com.mariano.personasycoches.idcustom.persona;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdPersona implements IdentifierGenerator {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int counter=1;

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		String prefix = "PER";
		String suffix = String.format("%05d", counter++);
		return prefix+suffix;
	}

}
