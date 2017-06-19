package demoProject.web.services.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pythondev on 6/18/17.
 */

@Configuration
public class MongDbServceProperties {

    @Value("${mongodb.host}")
    private String host;

    @Value("${mongodb.port}")
    private int port;

    @Value("${mongodb.db}")
    private String db;

    @Value("${mongodb.collection.name}")
    private String collection;

    @Value("${mongodb.passwd}")
    private String password;

    @Value("${mongodb.username}")
    private String username;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getDb() {
        return db;
    }

    public String getCollection() {
        return collection;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
