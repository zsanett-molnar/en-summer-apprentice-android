package com.example.tms.model;

import java.util.Date;

public class Event {

    private Integer imageID;
    private String eventTypeName;
    private String eventDescription;
    private String eventName;
    private Date startDate;
    private Date endDate;

    public Event(Integer imageID, String eventTypeName, String eventDescription, String eventName, Date startDate, Date endDate) {
        this.imageID = imageID;
        this.eventTypeName = eventTypeName;
        this.eventDescription = eventDescription;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
