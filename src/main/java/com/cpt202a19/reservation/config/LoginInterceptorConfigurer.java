package com.cpt202a19.reservation.config;

import com.cpt202a19.reservation.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;

/** Coding for registering interceptor */
@Configuration // Load interceptor
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {}

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {}

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {}

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {}

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {}

    /** 
     * Configure the interceptor
     * @param registry registered interceptor
     * @return added interceptor
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        HandlerInterceptor interceptor = new LoginInterceptor(); // Create an interceptor object

        List<String> patterns = new ArrayList<String>(); // Whitelist for contents that does not need to be blocked
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/index.html");
        patterns.add("/web/product.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");
        patterns.add("/dmg/**");

        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(patterns); // Add interceptor via registration tool
        
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {}

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {}

    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {}

    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {}

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {}

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {}

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {}

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {}

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {}

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {}

    @Override
    public Validator getValidator() { return null; }

    @Override
    public MessageCodesResolver getMessageCodesResolver() { return null; }

}
