package furdevs.discordBot.sharedLib.discoord;

import net.dv8tion.jda.core.events.Event;

@FunctionalInterface
public interface DiscordEvent {

    void onEvent(Event event);

}
