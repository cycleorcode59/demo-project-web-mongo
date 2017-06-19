package demoProject.web.services.database;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoCredential;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Arrays;
import javax.annotation.PostConstruct;

/**
 * Created by pythondev on 6/18/17.
 */

@Component
public class MongoDbService {

    private static Logger LOG = Logger.getLogger(MongoDbService.class);

    @Autowired
    private MongDbServceProperties dbServceProperties;

    private MongoClient mongoClient;
    private MongoDatabase database;

    /**
     * Factory
     * @return
     */
    public MongoDbService () {

    }

    /**
     * Fetch a single document from MongoDb Instance
     * @param docID
     * @return a JSON String; if document is not found an Empty string is returned.
     */
    public String getDocument( String docID ) {
        //TODO : add code to fetch document
        return "";
    }

    /**
     * Writes a document to MongoDB
     * @param document contains a Json string
     * @return the ID of the saved document.
     */
    public String saveDocument( String document ) {
        return "TBS";
    }

    @PostConstruct
    private void init() {


        MongoCredential credential = MongoCredential.createCredential(
                dbServceProperties.getUsername(),
                dbServceProperties.getDb(),
                dbServceProperties.getPassword().toCharArray());

        ServerAddress server = new ServerAddress(dbServceProperties.getHost(),dbServceProperties.getPort());
        List<MongoCredential> creds = Arrays.asList(credential);
        this.mongoClient = new MongoClient(server, creds);
        this.database =  mongoClient.getDatabase(dbServceProperties.getDb());


    }

}
