package de.furdevs.discordBot.core;

import de.furdevs.discordBot.sharedLib.configuration.ConfigurationFactory;
import de.furdevs.discordBot.sharedLib.configuration.model.Application;
import de.furdevs.discordBot.sharedLib.configuration.model.Bot;
import de.furdevs.discordBot.sharedLib.configuration.model.Command;
import de.furdevs.discordBot.sharedLib.discord.DiscordAPIConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;

public class ApplicationRunner {


    private final String HELP_COMMAND_PATH = "de.furdevs.discordBot.core.commandHandler.HelpCommand";

    Logger LOG = LogManager.getLogger(getClass().getName());


    private Bot loadCoreCommands(Bot bot) {
        if (bot.getCommands() == null) {
            bot.setCommands(new ArrayList<>());
        }
        bot.getCommands().add(new Command("help", HELP_COMMAND_PATH));
        return bot;
    }

    public void startApplication(String[] args) {
        try {
            ConfigurationFactory f = new ConfigurationFactory();
            Application a = f.loadConfiguration().getApp();
            loadCoreCommands(a.getDiscord().getCoreBot());
            DiscordAPIConnector coreApi = new DiscordAPIConnector(a.getDiscord().getCoreBot());
            LOG.info("Core Bot loaded");
            if (a.getDiscord().getBots() != null) {
                for (Bot b : a.getDiscord().getBots()) {
                    DiscordAPIConnector api = new DiscordAPIConnector(b);
                    LOG.info("Bot Module: " + b.getName() + " started");
                }
            } else {
                LOG.warn("No Module Loaded");
            }
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

}
