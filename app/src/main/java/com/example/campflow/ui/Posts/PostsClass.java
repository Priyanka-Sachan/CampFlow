package com.example.campflow.ui.Posts;

public class PostsClass {
    private String post_id;
    private String post_head;
    private String post_author;
    private String post_description;
    private String post_image;
    private String post_web;

    public PostsClass(String post_id, String post_head, String post_author, String post_description, String post_image, String post_web) {
        this.post_id = post_id;
        this.post_head = post_head;
        this.post_author = post_author;
        this.post_description = post_description;
        this.post_image = post_image;
        this.post_web = post_web;
    }

    public String getPost_id() {
        return post_id;
    }

    public String getPost_head() {
        return post_head;
    }

    public String getPost_author() {
        return post_author;
    }

    public String getPost_description() {
        return post_description;
    }

    public String getPost_image() {
        return post_image;
    }

    public String getPost_web() {
        return post_web;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public void setPost_head(String post_head) {
        this.post_head = post_head;
    }

    public void setPost_author(String post_author) {
        this.post_author = post_author;
    }

    public void setPost_description(String post_description) {
        this.post_description = post_description;
    }

    public void setPost_image(String post_image) {
        this.post_image = post_image;
    }

    public void setPost_web(String post_web) {
        this.post_web = post_web;
    }
}
