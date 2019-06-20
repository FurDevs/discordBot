package de.furdevs.discordbot.configuration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Bot {

    @JsonProperty("name")
    private String name;

    @JsonProperty("token")
    private String token;

    @JsonProperty("commandPrefix")
    private String commandPrefix;

    @JsonProperty("commands")
    private List<Command> commands;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCommandPrefix() {
        return commandPrefix;
    }

    public void setCommandPrefix(String commandPrefix) {
        this.commandPrefix = commandPrefix;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }
}
