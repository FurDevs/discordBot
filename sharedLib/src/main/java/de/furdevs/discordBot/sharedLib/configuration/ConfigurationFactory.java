package de.furdevs.discordBot.sharedLib.configuration;

import java.io.IOException;

public class ConfigurationFactory {


    /**
     * This Method loads the main configuration of the Core.
     *
     * This is the application.json file in the resources folder the the sharedLib project.
     *
     * @return
     */
    public Configuration loadConfiguration(){
        return this.loadConfiguration("application.json");
    }

    /**
     * This Method loads the passed configuration file.
     *
     * @param path The path of the configuration file.
     * @return
     */
    public Configuration loadConfiguration(String path){
        try {
            return new Configuration(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
