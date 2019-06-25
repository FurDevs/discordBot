package de.furdevs.discordBot.sharedLib.discord;


import de.furdevs.discordBot.sharedLib.configuration.model.Bot;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class DiscordAPIConnector {

    private String token;
    private JDA client;
    private CommandEventHandler handler;


    public DiscordAPIConnector(Bot bot) throws LoginException {
        this.handler = new CommandEventHandler(bot.getCommandPrefix(),bot.getCommands());
        this.client = new JDABuilder(bot.getToken()).build();
        this.client.addEventListener(handler);
    }

    public void startApi() throws InterruptedException {

        this.client.awaitReady();
    }

    public CommandEventHandler getHandler() {
        return handler;
    }

}