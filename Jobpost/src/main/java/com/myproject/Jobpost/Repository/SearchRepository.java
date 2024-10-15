package com.myproject.Jobpost.Repository;

import com.myproject.Jobpost.Model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findbytext(String text);
}
