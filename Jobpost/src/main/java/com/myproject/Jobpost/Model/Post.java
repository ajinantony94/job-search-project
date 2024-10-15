package com.myproject.Jobpost.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;


@Document(collection = "JobPost")
public class Post {
    //the variables or field that we have mentioned in the database
    private String profile;
    private String description;
    private String experience;

    private String tech[];

    public Post() {
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String[] getTech() {
        return tech;
    }

    public void setTech(String[] tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Post{" +

                ", description='" + description + '\'' +
                ", experience='" + experience + '\'' +
                ", profile='" + profile + '\'' +
                ", tech=" + Arrays.toString(tech) +
                '}';
    }
}
