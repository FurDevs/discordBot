package de.furdevs.discordbot.configuration;

import com.google.gson.Gson;
import de.furdevs.discordbot.configuration.model.Application;

import java.io.*;

public class ConfigurationManager {


    private InputStream _configurationFileInputStream;
    private Application app;

    protected ConfigurationManager(String resourcePath) throws IOException {

        FileReader fr = new FileReader(new File(getClass().getClassLoader().getResource(resourcePath).getFile()));
        BufferedReader br = new BufferedReader(fr);

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        Gson gson = new Gson();
        String res=  sb.toString();
        this.app = gson.fromJson(res, Application.class);


    }

    public Application getApp() {
        return app;
    }

    public void setApp(Application app) {
        this.app = app;
    }
}
