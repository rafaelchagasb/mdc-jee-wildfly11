package br.com.rafaelchagasb.mdc.interceptors;

import java.util.UUID;

import javax.interceptor.AroundTimeout;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.jboss.logging.MDC;

@Interceptor
public class TracingInterceptor {

	@AroundTimeout
	public Object configureMDC(InvocationContext context) throws Exception {
		MDC.put("correlation-id", UUID.randomUUID().toString());
		return context.proceed();
	}
}
