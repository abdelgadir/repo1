package core.security;

import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Date: 13/09/12
 * Time: 09:01
 */
@Secured
@Interceptor
public class SecurityInterceptor {
    @Inject
    private Subject subject;
    @Inject
    private SecurityManager securityManager;
    Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);

    @AroundInvoke
    public Object interceptGet(InvocationContext ctx) throws Exception {
        logger.info("Securing {} {}", new Object[]{ctx.getMethod(), ctx.getParameters()});
        logger.debug("Principal is: {}", subject.getPrincipal());

        final Class<? extends Object> runtimeClass = ctx.getTarget().getClass();
        logger.debug("Runtime extended classes: {}", runtimeClass.getClasses());
        logger.debug("Runtime implemented interfaces: {}", runtimeClass.getInterfaces());
        logger.debug("Runtime annotations ({}): {}", runtimeClass.getAnnotations().length, runtimeClass.getAnnotations());

        final Class<?> declaringClass = ctx.getMethod().getDeclaringClass();
        logger.debug("Declaring class: {}", declaringClass);
        logger.debug("Declaring extended classes: {}", declaringClass.getClasses());
        logger.debug("Declaring annotations ({}): {}", declaringClass.getAnnotations().length, declaringClass.getAnnotations());

        String permission;
        Secured secured = runtimeClass.getAnnotation(Secured.class);
        permission = secured.permission();
        logger.info("Checking permission '{}' for user '{}'", permission, subject.getPrincipal());

        try {
            subject.checkPermission(permission);
        } catch (Exception e) {
            logger.error("Access denied - {}: {}", e.getClass().getName(), e.getMessage());
            throw e;
        }
        return ctx.proceed();
    }
}
