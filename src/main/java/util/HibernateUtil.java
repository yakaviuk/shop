package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import pojo.Goods;
import pojo.Indent;
import pojo.User;

import java.io.*;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Logger log = LogManager.getRootLogger();

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                try (FileInputStream input = new FileInputStream("c:\\Users\\Ilya\\github\\repos\\projectShop\\src\\main\\resources\\jdbc.properties")) {
                    settings.load(input);
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
                //      settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                //       settings.put(Environment.URL, "jdbc:mysql://localhost:3306/project?useSSL=false");
                //      settings.put(Environment.USER, "ilyaa");
                //       settings.put(Environment.PASS, "3082211");
                //      configuration.addResource("src/main/resources/jdbc.properties");
//                             settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//                settings.put(Environment.SHOW_SQL, "true");
//                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Indent.class);
                configuration.addAnnotatedClass(Goods.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return sessionFactory;
    }
}