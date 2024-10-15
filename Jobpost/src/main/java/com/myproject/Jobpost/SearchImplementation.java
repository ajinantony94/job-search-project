package com.myproject.Jobpost;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.myproject.Jobpost.Model.Post;
import com.myproject.Jobpost.Repository.SearchRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class SearchImplementation implements SearchRepository {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    public List<Post> findbytext(String text){
        final List<Post> posts= new ArrayList<>();
        //copied pipelines from the mongo cloud!!!

        MongoDatabase database = client.getDatabase("Joblisting");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text", new Document("query", text)
                                        .append("path", Arrays.asList("tech", "description", "profile")))),
                        new Document("$sort",
                        new Document("experience", 1L)),
                        new Document("$limit", 4L)));

        result.forEach(doc ->posts.add(converter.read(Post.class,doc)));

        return posts;
    }

}
