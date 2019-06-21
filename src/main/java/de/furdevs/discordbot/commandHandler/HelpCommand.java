package de.furdevs.discordbot.commandHandler;

import de.furdevs.discordbot.discord.IDCCommandListener;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class HelpCommand implements IDCCommandListener {

    public HelpCommand() {
    }

    @Override
    public void onDCMessage(MessageReceivedEvent event) {
        event.getChannel().sendMessage("This is Help").complete();
    }
}
