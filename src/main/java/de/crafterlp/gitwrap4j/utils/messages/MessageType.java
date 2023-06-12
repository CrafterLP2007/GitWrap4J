package de.crafterlp.gitwrap4j.utils.messages;

public enum MessageType {

    INFO("[INFO]: "),
    SUCCESS("[SUCCESS]: "),
    ERROR("[ERROR]: "),
    WARNING("[WARNING]: ");

    private String prefix;

    MessageType(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
