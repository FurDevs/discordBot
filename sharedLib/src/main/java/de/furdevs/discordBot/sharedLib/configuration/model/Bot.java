package de.furdevs.discordBot.sharedLib.configuration.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Bot {

    @SerializedName("name")
    private String name;

    @SerializedName("token")
    private String token;

    @SerializedName("commandPrefix")
    private String commandPrefix;

    @SerializedName("commands")
    private List<Command> commands;

    @SerializedName("description")
    private StringBuilder description;

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

    public StringBuilder getDescription() {
        return description;
    }

    public void setDescription(StringBuilder description) {
        this.description = description;
    }
}
