package de.crafterlp.gitwrap4j.actions;

import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public abstract class Action {

    private Map<Action, String> actions = new HashMap<>();

    public abstract void execute();

    @SneakyThrows
    public Action(String description) {
        super();
        registerAction(Action.class.newInstance(), description);
    }

    public void registerAction(Action action, String description) {
        if (actions.containsKey(action) && actions.containsValue(description)) {
            actions.remove(action);
        }
        actions.put(action, description);
    }

    @SneakyThrows
    public String getDescription(Action action) {
        if (actions.containsKey(action)) {
            return actions.get(action);
        }
        return null;
    }

    public static void executeAction(Action action) {
        action.execute();
    }

}
