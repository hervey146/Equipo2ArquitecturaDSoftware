package EventBus;

public final class EventBusFactory {

    private static EventBus eventBus;

    private EventBusFactory() {
    }

    public static synchronized EventBus getDefault() {
        if (eventBus == null) {
            eventBus = new EventBus("default");
        }
        return eventBus;
    }

}
