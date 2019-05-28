package furdevs.discordBot.sharedLib.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class SessionManager {
    private Session session;

    public Session getSesstion() {
        if (this.session == null || !session.isOpen())
            this.session = new Configuration().configure(new File(getClass().getClassLoader().getResource("hibernate.cfg.xml").getFile())).buildSessionFactory().openSession();
        return this.session;
    }

}
