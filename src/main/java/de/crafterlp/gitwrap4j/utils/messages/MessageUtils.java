package de.crafterlp.gitwrap4j.utils.messages;

import de.crafterlp.gitwrap4j.GitWrap4J;

public class MessageUtils {


    public static void sendMessage(MessageType type, Object message) {
        if (GitWrap4J.debug) {
            System.out.println(type.getPrefix() + message);
        }
    }

    public static void sendMessage(Object message) {
        if (GitWrap4J.debug) {
            System.out.println(message);
        }
    }

}
