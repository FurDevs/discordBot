package de.furdevs.discordBot.sharedLib.configuration.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Discord {

    private List<Bot> bots;

    @SerializedName("core_bot")
    private Bot coreBot;

    public List<Bot> getBots() {
        return bots;
    }

    public void setBots(List<Bot> bots) {
        this.bots = bots;
    }

    public Bot getCoreBot() {
        return coreBot;
    }

    public void setCoreBot(Bot coreBot) {
        this.coreBot = coreBot;
    }
}
