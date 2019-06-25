package de.furdevs.discordBot.sharedLib.configuration;

import com.google.gson.Gson;
import de.furdevs.discordBot.sharedLib.configuration.model.Application;

import java.io.*;

public class Configuration {


    private InputStream _configurationFileInputStream;
    private Application app;

    protected Configuration(String resourcePath) throws IOException {

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
