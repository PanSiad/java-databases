package g_mongo;

import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import g_mongo.model.User;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class App {

    public static void main(String[] args) {
        List<ServerAddress> seeds = new ArrayList<>();
        seeds.add(new ServerAddress("localhost"));

        MongoCredential credential = MongoCredential.createScramSha1Credential("root", "admin", "example".toCharArray());
        MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder -> builder.hosts(seeds))
                        .credential(credential)
                        .build());

        MongoDatabase database = mongoClient.getDatabase("sample");
        MongoCollection<Document> collection = database.getCollection("sample");
        System.out.println(collection);


        /*** CREATE */
        /*User user = createUser();
        Document doc = createDBObject(user);
        collection.insertOne(doc);*/

        /*** READ */
        /*User user = findUser(collection);
        System.out.println(user);*/

        /*** UPDATE */
        /*User user = updateUser(collection);
        System.out.println(user);*/

        /*** DELETE */
        deleteUser(collection);

    }

    public static void printDatabases(MongoClient mongo) {
        MongoCursor<String> databases = mongo.listDatabaseNames().iterator();
        while (databases.hasNext()) {
            System.out.println(databases.next());
        }
    }

    private static Document createDBObject(User user) {
        Document userDoc = new Document("_id", new ObjectId());

        userDoc.append("name", user.getName())
                .append("id", user.getId());

        return userDoc;
    }

    private static User createUser() {
        User u = new User();
        u.setId(2);
        u.setName("Papadopoulos");
        return u;
    }

    private static User findUser(MongoCollection mongoCollection) {
        // find one document with new Document
        Document userDocument = (Document) mongoCollection.find(new Document("id", 2)).first();
        System.out.println("User 2: " + userDocument.toJson());
        User user1 = new User();
        user1.setId(userDocument.getInteger("id"));
        user1.setName(userDocument.getString("name"));

        return user1;
    }

    private static User updateUser(MongoCollection mongoCollection) {
        // update one document
        Bson filter = eq("name", "Papadopoulos");

        Bson updateOperation = set("comment", "you should fire him");

        UpdateResult updateResult = mongoCollection.updateOne(filter, updateOperation);
        Document userDocument = (Document)mongoCollection.find(filter).first();
        System.out.println(userDocument.toJson());
        System.out.println(updateResult);

        User user1 = new User();
        user1.setId(userDocument.getInteger("id"));
        user1.setName(userDocument.getString("name"));

        return user1;
    }

    private static void deleteUser(MongoCollection mongoCollection) {

        Bson filter = eq("name", "Papadopoulos");
        DeleteResult result = mongoCollection.deleteOne(filter);
        System.out.println(result);

    }




}
