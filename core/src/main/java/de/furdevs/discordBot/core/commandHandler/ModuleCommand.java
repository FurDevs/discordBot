package de.furdevs.discordBot.core.commandHandler;

import de.furdevs.discordBot.sharedLib.configuration.Configuration;
import de.furdevs.discordBot.sharedLib.configuration.ConfigurationFactory;
import de.furdevs.discordBot.sharedLib.discord.IDCCommandListener;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModuleCommand implements IDCCommandListener {

    Configuration cfg = new ConfigurationFactory().loadConfiguration();

    EmbedBuilder builder = new EmbedBuilder();

    Logger LOG = LogManager.getLogger(getClass());

    @Override
    public void onDCMessage(MessageReceivedEvent event) {

        builder.setDescription("Loaded Bots");

        cfg.getApp().getDiscord().getBots().forEach((el) -> {
            builder.addField("Name", el.getName(), false);
            builder.addField("Command Prefix", el.getCommandPrefix(),false);
            builder.addBlankField(false);
        });

        builder.addField("What now?", "If you want to know more about the specific bot. Just type [BotPrefix]module [BotName]",false);



        event.getChannel().sendMessage(builder.build()).queue();
    }
}
