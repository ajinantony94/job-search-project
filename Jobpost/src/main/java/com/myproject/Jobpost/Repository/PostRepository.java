package com.myproject.Jobpost.Repository;

import com.myproject.Jobpost.Model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {

}
