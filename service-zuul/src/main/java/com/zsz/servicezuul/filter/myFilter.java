package com.zsz.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sun.xml.internal.ws.client.ResponseContext;
import org.apache.http.protocol.RequestContent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

public class myFilter extends ZuulFilter{
    @Override
    public String filterType() {
        return "pre";//
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getParameter("token");
        if(token!=null && !"".equals(token)){
            requestContext.setResponseStatusCode(200);
            requestContext.setSendZuulResponse(true);
        }else {
            requestContext.setResponseStatusCode(400);
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseBody("token is empty!");
        }
        return null;
    }
}
