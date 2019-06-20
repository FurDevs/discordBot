package de.furdevs.discordbot.discord;


import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

@FunctionalInterface
public interface IDCCommandListener {

    void onDCMessage(MessageReceivedEvent event);

}
