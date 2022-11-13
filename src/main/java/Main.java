import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        MongoClient mongoClient = MongoClients.create("mongodb+srv://kubao:mietek@cluster0.24ev6aq.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("Pojazdy");
        MongoCollection col1 = database.getCollection("Osobówki");
        MongoCollection col2 = database.getCollection("Motocykle");
        MongoCollection col3 = database.getCollection("Ciężarowe");

        Document osobowy1 = new Document("nazwa", "osobowy")
                .append("Rodzaj", new Document("Osobówka", "Fiat"))
                .append("moc", "140KM");

        Document osobowy2 = new Document("nazwa", "osobowy")
                .append("Rodzaj", new Document("Osobówka", "BMW"))
                .append("moc", "320KM");

        Document osobowy3 = new Document("nazwa", "osobowy")
                .append("Rodzaj", new Document("Osobówka", "Mazda"))
                .append("moc", "160KM");
        Document motocykl1 = new Document("id", 1)
                .append("marka", "BMW")
                .append("model", "moto32")
                .append("rok produkcji", "2005")
                .append("stan", "nowy");

        Document motocykl2 = new Document("id", 2)
                .append("marka", "Yamaha")
                .append("model", "Yamaha23")
                .append("rok produkcji", "2001")
                .append("stan", "używany");

        Document motocykl3 = new Document("id", 3)
                .append("marka", "Suzuki")
                .append("model", "Suzuki09")
                .append("rok produkcji", "2010")
                .append("stan", "nowy");

        List<Document> motocykle = new ArrayList<>();
        motocykle.add(motocykl1);
        motocykle.add(motocykl2);
        motocykle.add(motocykl3);

        col2.insertMany(motocykle);

        Document ciezarowka1 = new Document("id", 1)
                .append("marka", "Scania")
                .append("model", "ScaniaGT")
                .append("rok produkcji", "2014")
                .append("stan", "używany");

        Document ciezarowka2 = new Document("id", 2)
                .append("marka", "MAN")
                .append("model", "MANgtx")
                .append("rok produkcji", "2018")
                .append("stan", "nowy");

        Document ciezarowka3 = new Document("id", 3)
                .append("marka", "Jelcz")
                .append("model", "Jelcz-Laskowice")
                .append("rok produkcji", "2022")
                .append("stan", "nowy");

        List<Document> ciezarowki = new ArrayList<>();
        ciezarowki.add(ciezarowka1);
        ciezarowki.add(ciezarowka2);
        ciezarowki.add(ciezarowka3);

        col3.insertMany(ciezarowki);
        Bson query = eq("id", 2);
        DeleteResult result = col2.deleteOne(query);
        System.out.println("Deleted document count: " + result.getDeletedCount());


        Logger logger = LoggerFactory.getLogger("MyApp");
        logger.error("Logging an Error");

    }
}
