package de.furdevs.discordbot.configuration;

/**
 * This interface is used to interact with a configuration
 */
public interface Configuration {

    /**
     * This method finds the specified value in the configuration.
     *
     *
     * @param key
     * @return
     */
    Configuration requestConfigurationEntry(String key);

    /**
     * Returns the Value of the configuration entry
     * @return
     */
    Object value();

}
