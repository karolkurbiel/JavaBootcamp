package itacademy._21.annotatedmethod;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface Execute {
    int times() default 1;
}
