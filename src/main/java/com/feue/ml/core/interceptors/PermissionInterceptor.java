package com.feue.ml.core.interceptors;

import com.feue.ml.core.LocalUser;
import com.feue.ml.core.annotation.Admin;
import com.feue.ml.entity.User;
import com.feue.ml.exception.UnAuthenticatedException;
import com.feue.ml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @author Feue
 * @create 2022-04-18 13:56
 */
public class PermissionInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUrl = request.getRequestURI();
        if ("/user/register".equals(requestUrl)) {
            return true;
        }
        Optional<Admin> admin = getAdmin(handler);
        String idString = request.getHeader("Authorization");
        if (idString == null || !idString.matches("[0-9]+")) {
            throw new UnAuthenticatedException(10004);
        }
        Long uid = Long.parseLong(idString);
        Optional<User> optionalUser = userService.findById(uid);
        if (optionalUser.isEmpty()) {
            throw new UnAuthenticatedException(10004);
        }
        boolean valid = true;
        if (admin.isPresent()) {
            valid = optionalUser.get().getType().equals('0');
        }
        if (valid) {
            LocalUser.setUser(optionalUser.get());
        } else {
            throw new UnAuthenticatedException(10005);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LocalUser.clear();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    private Optional<Admin> getAdmin(Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Admin admin = handlerMethod.getMethodAnnotation(Admin.class);
            if (admin == null) {
                return Optional.empty();
            }
            return Optional.of(admin);
        }
        return Optional.empty();
    }
}
