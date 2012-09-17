package core.security;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

/**
 * Date: 13/09/12
 * Time: 09:00
 */
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@InterceptorBinding
public @interface Secured {
    //TODO rethink the defaukt
    String permission() default "*";
}
