package EventBus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Clase envolvente que contiene los metodos de invocacion y hacia quien va dirigido,
 * esto sirve como valores invocables para el usuario dentro del EventBus
 * 
 *
 * @author tonyo
 */
final class Publisher {

    private final Method handler;

    private final Object targetObject;

    public Publisher(Method handler, Object targetObject) {
        this.handler = handler;
        this.targetObject = targetObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Publisher that = (Publisher) o;
        return Objects.equals(handler, that.handler)
                && Objects.equals(targetObject, that.targetObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(handler, targetObject);
    }

    public void invoke(Object object) {
        try {
            handler.invoke(targetObject, object);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
