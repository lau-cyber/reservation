package com.cpt202a19.reservation.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Define a handler interceptor */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * Check whether login part goes wrong
     * @exception/throws InformationNotFoundException
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("uid") == null) {
            response.sendRedirect("/web/login.html");
            return false;
        }
        return true;
    }

}
