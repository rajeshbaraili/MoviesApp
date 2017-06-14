package com.example.rajesh.moviesapp.Database;

public class Contact {


    public Contact() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //private variables
	private int id;

    public Contact(int id, String name, String email, String url) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.url = url;
    }

    private  String name;
    private String email;
    private  String url;




}
