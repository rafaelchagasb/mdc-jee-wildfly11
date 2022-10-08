package br.com.rafaelchagasb.mdc.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

import org.jboss.logging.MDC;


@WebFilter("/*")
public class MDCFilter implements javax.servlet.Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	 
    	configureMDC(request);
        
        chain.doFilter(request, response);  // invokes next filter in the chain
    }

    private void configureMDC(ServletRequest request) {
    	
    	 HttpServletRequest httpRequest = (HttpServletRequest) request;

    	 String correlationId = httpRequest.getHeader("correlation-id");
    	 
    	 if(correlationId != null) {
    		 MDC.put("correlation-id", correlationId);
    	 } else {
    		 MDC.put("correlation-id", UUID.randomUUID().toString());
    	 }
	}

	@Override
    public void destroy() {

    }
}
