package com.tracebucket.infrastructure.cqrs.support;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by ffl on 12-02-2015.
 */
@Component
public class CommandInterceptor extends HandlerInterceptorAdapter{
    private static final String COMMAND_ID = "COMMAND_ID";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if(request.getMethod().equals(RequestMethod.PUT.name()) || request.getMethod().equals(RequestMethod.POST.name()) || request.getMethod().equals(RequestMethod.DELETE.name())){

            request.setAttribute(COMMAND_ID, UUID.randomUUID().toString());
        }
        return true;
    }
}
