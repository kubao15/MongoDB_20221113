import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        MongoClient mongoClient = MongoClients.create("mongodb+srv://kubao:mietek@cluster0.24ev6aq.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("Java");
        MongoCollection col = database.getCollection("Java");
        Document nowyDokument = new Document("id", "1").append("imie", "Jan Kowalski");
        col.insertOne(nowyDokument);
        Logger logger = LoggerFactory.getLogger("MyApp");
        logger.error("Logging an Error");

    }
}
