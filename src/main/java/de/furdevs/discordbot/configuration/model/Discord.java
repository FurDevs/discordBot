package de.furdevs.discordbot.configuration.model;

import java.util.List;

public class Discord {

    private List<Bot> bots;

    public List<Bot> getBots() {
        return bots;
    }

    public void setBots(List<Bot> bots) {
        this.bots = bots;
    }
}
