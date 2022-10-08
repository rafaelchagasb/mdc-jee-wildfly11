package br.com.rafaelchagasb.mdc.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.UUID;

import org.jboss.logging.MDC;


@WebFilter("/*")
public class MDCFilter implements javax.servlet.Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	 
        MDC.put("correlation-id", UUID.randomUUID().toString());
        chain.doFilter(request, response);  // invokes next filter in the chain
        
    }

    @Override
    public void destroy() {

    }
}
