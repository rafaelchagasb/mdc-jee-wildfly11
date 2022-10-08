package br.com.rafaelchagasb.mdc.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import br.com.rafaelchagasb.mdc.services.Service;

import java.util.logging.Logger;

@Path("hello")
public class HelloResource {

	private static final Logger LOGGER = Logger.getLogger("HelloResource");

	@Inject
	Service myService;
	
	@Path("{name}")
	@GET
	public Response hello() {
		LOGGER.info("Hello World");
		
		myService.writeLog();
		
		return Response.ok().build();
	}
}
