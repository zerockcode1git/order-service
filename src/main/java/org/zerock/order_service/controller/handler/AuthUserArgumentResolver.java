package org.zerock.order_service.controller.handler;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.zerock.order_service.config.anno.AuthUser;
import org.zerock.order_service.dto.AuthenticatedUser;

// Servlet (HTTP 요청 객체) import
import jakarta.servlet.http.HttpServletRequest; 
// 참고: Spring Boot 2.x 이하를 사용 중이라면 javax.servlet.http.HttpServletRequest 로 변경하세요.



public class AuthUserArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(AuthUser.class)
                && parameter.getParameterType().equals(AuthenticatedUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                   ModelAndViewContainer mavContainer,
                                   NativeWebRequest webRequest,
                                   WebDataBinderFactory binderFactory) {

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        boolean authenticated = Boolean.parseBoolean(request.getHeader("X-Authenticated"));
        String userId = request.getHeader("X-User-Id");
        String userRole = request.getHeader("X-User-Role");

        return new AuthenticatedUser(authenticated, userId, userRole);
    }
}