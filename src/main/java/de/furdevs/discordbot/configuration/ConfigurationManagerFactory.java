package de.furdevs.discordbot.configuration;

import java.io.IOException;

public class ConfigurationManagerFactory {


    /**
     * This Method loads the main configuration of the Core.
     *
     * This is the application.json file in the resources folder the the sharedLib project.
     *
     * @return
     */
    public ConfigurationManager loadConfiguration(){
        return this.loadConfiguration("application.json");
    }

    /**
     * This Method loads the passed configuration file.
     *
     * @param path The path of the configuration file.
     * @return
     */
    public ConfigurationManager loadConfiguration(String path){
        try {
            return new ConfigurationManager(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
