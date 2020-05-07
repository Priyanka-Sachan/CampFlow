package com.example.campflow.ui.EventsNearMe;

public class EventsNearMeClass {

    private int event_id;
    private String event_head;
    private String event_location;
    private String event_description;
    private String event_image;
    private String event_web;
    private int event_interested;

    public EventsNearMeClass(int event_id, String event_head, String event_location, String event_description, String event_image, String event_web, int event_interested) {
        this.event_id = event_id;
        this.event_head = event_head;
        this.event_location = event_location;
        this.event_description = event_description;
        this.event_image = event_image;
        this.event_web = event_web;
        this.event_interested = event_interested;
    }

    public int getEvent_id() {
        return event_id;
    }

    public String getEvent_head() {
        return event_head;
    }

    public String getEvent_location() {
        return event_location;
    }

    public String getEvent_description() {
        return event_description;
    }

    public String getEvent_image() {
        return event_image;
    }

    public String getEvent_web() {
        return event_web;
    }

    public int getEvent_interested() {
        return event_interested;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public void setEvent_head(String event_head) {
        this.event_head = event_head;
    }

    public void setEvent_location(String event_location) {
        this.event_location = event_location;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public void setEvent_image(String event_image) {
        this.event_image = event_image;
    }

    public void setEvent_web(String event_web) {
        this.event_web = event_web;
    }

    public void setEvent_interested(int event_interested) {
        this.event_interested = event_interested;
    }

}
