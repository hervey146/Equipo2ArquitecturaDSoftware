package EventBus;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.Vector;

/**
 * 
 * Implementacion de Guava EventBus pero sencillo, sin colecciones ni 
 * nada complicado
 *
 * @author tonyo
 */
public class EventBus {

    private Map<Class<?>, List<Publisher>> invocations;
    private String name;

    public EventBus(String name) {
        this.name = name;
        invocations = new ConcurrentHashMap<>();
    }

    public void post(Object object) {
        Class<?> clazz = object.getClass();
        if (invocations.containsKey(clazz)) {
            invocations.get(clazz).forEach(invocation -> invocation.invoke(object));
        }
    }

    public void register(Object object) {
        Class<?> currentClass = object.getClass();
        //Aqui intentamos navegar el object tree hacia el objeto para ver 
        //si hay alguna anotacion de @Subscribe
        while (currentClass != null) {
            List<Method> subscribeMethods = findSubscriptionMethods(currentClass);
            for (Method method : subscribeMethods) {
                // Sabemos que solo tiene un parametro 
                Class<?> type = method.getParameterTypes()[0];
                if (invocations.containsKey(type)) {
                    invocations.get(type).add(new Publisher(method, object));
                } else {
                    List<Publisher> temp = new Vector<>();
                    temp.add(new Publisher(method, object));
                    invocations.put(type, temp);
                }
            }
            currentClass = currentClass.getSuperclass();
        }
    }

    private List<Method> findSubscriptionMethods(Class<?> type) {
        List<Method> subscribeMethods = Arrays.stream(type.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Subscribe.class))
                .collect(Collectors.toList());
        checkSubscriberMethods(subscribeMethods);
        return subscribeMethods;
    }

    private void checkSubscriberMethods(List<Method> subscribeMethods) {
        boolean hasMoreThanOneParameter = subscribeMethods.stream()
                .anyMatch(method -> method.getParameterCount() != 1);
        if (hasMoreThanOneParameter) {
            throw new IllegalArgumentException(
                    "Method annotated with @Susbscribe has more than one parameter");
        }
    }

    public Map<Class<?>, List<Publisher>> getInvocations() {
        return invocations;
    }

    public String getName() {
        return name;
    }
}
