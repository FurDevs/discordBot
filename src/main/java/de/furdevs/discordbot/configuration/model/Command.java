package de.furdevs.discordbot.configuration.model;

public class Command {

    private String name;
    private String handler;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }
}
