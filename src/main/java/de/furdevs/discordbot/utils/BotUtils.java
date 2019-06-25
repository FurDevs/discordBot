package de.furdevs.discordbot.utils;

import de.furdevs.discordBot.sharedLib.configuration.Configuration;
import de.furdevs.discordBot.sharedLib.configuration.ConfigurationFactory;
import de.furdevs.discordBot.sharedLib.configuration.model.Bot;

public class BotUtils {

    public final String CORE_BOT_NAME = "Core_Bot";

    public void getCoreBot(){
        Configuration cfg = new ConfigurationFactory().loadConfiguration();

        for (Bot b : cfg.getApp().getDiscord().getBots()){

        }
    }

}
