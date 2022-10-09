package br.com.rafaelchagasb.mdc.services;

import java.util.logging.Logger;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import br.com.rafaelchagasb.mdc.interceptors.TracingInterceptor;

@Singleton
@Interceptors(TracingInterceptor.class)
public class ScheduleService {

	private static final Logger LOGGER = Logger.getLogger("ScheduleService");
	
	@Inject
	Service myService;
	
    @Schedule(minute = "*", hour = "*", persistent = false)
	public void execute() {
    	LOGGER.info("Start schedule");
    	myService.writeLog();
	}
	
}
