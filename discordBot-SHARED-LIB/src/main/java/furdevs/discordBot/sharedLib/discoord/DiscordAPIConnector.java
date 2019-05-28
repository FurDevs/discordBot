package furdevs.discordBot.sharedLib.discoord;


import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;

import javax.security.auth.login.LoginException;

public class DiscordAPIConnector implements EventListener {

    private JDA jda;
    private String apiToken;

    public DiscordAPIConnector() {

    }

    public DiscordAPIConnector(String apiToken) {
        this.apiToken = apiToken;
    }


    public void startApi(String token){
        JDABuilder builder = new JDABuilder(token);
        try {
            this.jda = builder.build();
            this.jda.addEventListener(this);
        } catch (LoginException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onEvent(Event event) {
        if (event instanceof MessageReceivedEvent){
            MessageReceivedEvent mre = (MessageReceivedEvent) event;

        }
    }
}
