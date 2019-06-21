package de.furdevs.discordbot.discord;

import de.furdevs.discordbot.configuration.model.Command;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class CommandEventHandler extends ListenerAdapter {

    Logger LOG = Logger.getLogger(getClass().getName());

    private Map<String, IDCCommandListener> commandHandler = new HashMap<>();
    private String commandPrefix;

    public void addCommand(String command, IDCCommandListener handler) {

    }

    private void loadHandler(List<Command> handler) {
        for (Command command : handler) {
            try {
                Class loaded = Class.forName(command.getHandler());
                if (IDCCommandListener.class.isAssignableFrom(loaded)){
                    commandHandler.put(command.getName(), (IDCCommandListener) loaded.getDeclaredConstructor().newInstance());
                } else {

                }
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public CommandEventHandler(String commandPrefix, List<Command> commands) {
        this.commandPrefix = commandPrefix;
        loadHandler(commands);
        System.out.println("Started");
    }

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
            LOG.info("New Message from: " + event.getAuthor().getName() + " : " + event.getMessage().getContentDisplay());
            var msg = event.getMessage().getContentDisplay();
            if (msg.startsWith(this.commandPrefix)){
               var trimed = msg.substring(1);
               var handler = commandHandler.get(trimed);
               if (handler != null){
                    handler.onDCMessage(event);
               }
            }

    }

    @Override
    public void onReady(@Nonnull ReadyEvent event) {

    }

}