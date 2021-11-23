package EventBus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotacion para anotar el metodo que se va invocar por el EventBus el cual 
 * es identificado por su valor
 *
 * @author tonyo
 */



@Repeatable(Subscribe.List.class)//Vamos a repetir el uso de esa clase
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)


public @interface Subscribe {

    String value() default "";

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface List {

        Subscribe[] value();
    }
}
