package com.myproject.Jobpost.Controller;

import com.myproject.Jobpost.Model.Post;
import com.myproject.Jobpost.Repository.PostRepository;
import com.myproject.Jobpost.Repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;

    @GetMapping("/allPosts")
    public ResponseEntity<List<Post>> getAllPost(){
        return ResponseEntity.ok(repo.findAll());
    }

    //to search some datas!!!
    @GetMapping("/posts/{text}")

    public ResponseEntity<List<Post>> search(@PathVariable String text){
        return ResponseEntity.ok(srepo.findbytext(text));
    }

    @PostMapping("/post")

    public ResponseEntity<Post> postPost(@RequestBody Post post){
        return ResponseEnitity.ok(repo.save(post));
    }


}
