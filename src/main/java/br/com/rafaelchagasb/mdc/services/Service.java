package br.com.rafaelchagasb.mdc.services;

import java.util.logging.Logger;

import javax.ejb.Stateless;

@Stateless
public class Service {

	private static final Logger LOGGER = Logger.getLogger("Service");
	
	public void writeLog() {
		LOGGER.info("Service running");
		
	}
	
}
