package com.volapp.events;

/*import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;*/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;


@Entity
@Table(name="events")
public class Events{


    private String eventName;
    private String eventStreet;
    private String eventCity;
    private String eventState;
    private String eventZip;
    private String eventDate;
    private String eventTime;
    private String eventDescription;
    private String charityName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    public Events() {}
    
    public Events(Events events) {
    	this.id = events.id;
    	this.charityName = events.charityName;
    	this.eventName = events.eventName;
    	this.eventStreet = events.eventStreet;
    	this.eventCity = events.eventCity;
    	this.eventState = events.eventState;
    	this.eventZip = events.eventZip;
    	this.eventDate = events.eventDate;
    	this.eventTime = events.eventTime;
    	this.eventDescription = events.eventDescription;
    }
    
    public Events (Long id, String charityName, String eventName, String eventStreet, String eventCity, String eventState, String eventZip, String eventDate, String eventTime, String eventDescription) {
    	this.id = id;
    	this.charityName = charityName;
    	this.eventName = eventName;
    	this.eventStreet = eventStreet;
    	this.eventCity = eventCity;
    	this.eventState = eventState;
    	this.eventZip = eventZip;
    	this.eventDate = eventDate;
    	this.eventTime = eventTime;
    	this.eventDescription = eventDescription;
    }
    


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCharityName() {
		return charityName;
	}


	public void setCharityName(String charityName) {
		this.charityName = charityName;
	}


	public String getEventName() {
		return eventName;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	public String getEventStreet() {
		return eventStreet;
	}

	public void setEventStreet(String eventStreet) {
		this.eventStreet = eventStreet;
	}
	
	public String getEventCity() {
		return eventCity;
	}

	public void setEventCity(String eventCity) {
		this.eventCity = eventCity;
	}

	public String getEventState() {
		return eventState;
	}

	public void setEventState(String eventState) {
		this.eventState = eventState;
	}

	public String getEventZip() {
		return eventZip;
	}

	public void setEventZip(String eventZip) {
		this.eventZip = eventZip;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
    
}
