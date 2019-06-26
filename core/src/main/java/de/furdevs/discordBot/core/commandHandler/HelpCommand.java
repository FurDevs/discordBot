package de.furdevs.discordBot.core.commandHandler;

import de.furdevs.discordBot.sharedLib.configuration.Configuration;
import de.furdevs.discordBot.sharedLib.configuration.ConfigurationFactory;
import de.furdevs.discordBot.sharedLib.configuration.model.Bot;
import de.furdevs.discordBot.sharedLib.discord.IDCCommandListener;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class HelpCommand implements IDCCommandListener {


    private EmbedBuilder builder = new EmbedBuilder();
    private Configuration cfg = new ConfigurationFactory().loadConfiguration();

    public HelpCommand() {
    }

    @Override
    public void onDCMessage(MessageReceivedEvent event) {

        builder.setDescription("Hi " + event.getAuthor().getName() + " your requested help\n This command will print all available bots\n to get more information about the specific bot just type\n```" +
                cfg.getApp().getDiscord().getCoreBot().getCommandPrefix() + "help [Name of bot]```");


        if (cfg.getApp().getDiscord().getBots() == null || cfg.getApp().getDiscord().getBots().isEmpty()) {
            builder.addField("Loaded Bots:", "No bots loaded", false);
        } else {
            StringBuilder builderName = new StringBuilder();
            StringBuilder builderDescription = new StringBuilder();

            for (Bot b : cfg.getApp().getDiscord().getBots()) {
                builderName.append(b.getName()+"\n\n");
                builderDescription.append(b.getDescription()+"\n\n");
            }

            builder.addField("Name", builderName.toString(), true);
            builder.addField("Description", builderDescription.toString(), true);

        }
        //builder.addField("")
        // Send all available commands back to the user
//        builder.addField("Commands", new StringBuilder()
//                .append("e621\n\n")
//                .append("support")
//                .toString(), true);
//
//        // Send the function of all available commands back to the user
//        builder.addField("Function", new StringBuilder()
//                .append("e621 Module to search on e621.net\n\n")
//                .append("Load the support module")
//                .toString(), true);


        builder.setColor(Color.cyan);

        event.getChannel().sendMessage(builder.build()).queue();
    }
}
