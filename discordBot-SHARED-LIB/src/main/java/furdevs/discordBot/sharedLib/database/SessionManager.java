package furdevs.discordBot.sharedLib.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager {
    void a(){
        SessionFactory s = new Configuration().configure().buildSessionFactory();

    }
}
