package de.furdevs.discordBot.sharedLib.discord;


import de.furdevs.discordBot.sharedLib.configuration.model.Bot;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

@FunctionalInterface
public interface IDCCommandListener {

    Bot currentBotCfg = null;

    void onDCMessage(MessageReceivedEvent event);

}
