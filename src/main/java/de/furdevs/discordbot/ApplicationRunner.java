package de.furdevs.discordbot;

import de.furdevs.discordbot.configuration.ConfigurationManagerFactory;
import de.furdevs.discordbot.configuration.model.Application;
import de.furdevs.discordbot.configuration.model.Bot;
import de.furdevs.discordbot.discord.DiscordAPIConnector;

import javax.security.auth.login.LoginException;
import java.util.logging.Logger;

public class ApplicationRunner {


    Logger LOG = Logger.getLogger(getClass().getName());

    public void startApplication(String[] args){
        try {
            ConfigurationManagerFactory f = new ConfigurationManagerFactory();
            Application a = f.loadConfiguration().getApp();

            for (Bot b : a.getDiscord().getBots()) {
                DiscordAPIConnector api = new DiscordAPIConnector(b);
                LOG.info("Bot Module: "+ b.getName()+" started");
            }
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

}
