import com.mongodb.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sample.User;
import java.net.UnknownHostException;

public class mongoDB {

    public static void main(String[] args) throws UnknownHostException, ParseException {

        User a = new User("gs","01",5,"cs","a",123,"pass123");
        DBObject doc = createDBObject(a);

        // Creating a Mongo client
        MongoClient mongo = new MongoClient( "10.1.2.175" , 27017 );
        DB db = mongo.getDB("me");

        DBCollection col = db.getCollection("user");
        WriteResult result = col.insert(doc);
        System.out.println(result.getUpsertedId());
        System.out.println(result.getN());
        System.out.println(result.isUpdateOfExisting());
        System.out.println(result.getLastConcern());

        DBObject query = BasicDBObjectBuilder.start().add("name", "gh").get();
        DBCursor cursor = col.find(query);
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }

    private static DBObject createDBObject(User user) {
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
        docBuilder.append("name", user.getName());
        docBuilder.append("usn", user.getUsn());
        docBuilder.append("sem", user.getSem());
        docBuilder.append("branch", user.getBranch());
        docBuilder.append("address", user.getAddress());
        docBuilder.append("pno", user.getPno());
        return docBuilder.get();
    }

}