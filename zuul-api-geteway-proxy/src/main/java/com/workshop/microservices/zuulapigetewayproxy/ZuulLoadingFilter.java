package com.workshop.microservices.zuulapigetewayproxy;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Log4j
@Component
public class ZuulLoadingFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        log.info("request -> {" + request + "}, uri -> {" + request.getRequestURI() + "}");
        return null;
    }
}
