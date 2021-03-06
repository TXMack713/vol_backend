package com.volapp.events;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/charity")
public class EventsController {

	@Autowired
	EventsRepository eventsRepo;
	
	@PostMapping("/events")
	public ResponseEntity<Object> Events(@Valid @RequestBody Events events) throws Exception{
		Events newEvent = new Events(events.getId(), events.getCharityName(), events.getEventName(), events.getEventStreet(), events.getEventCity(), events.getEventState(), events.getEventZip(), events.getEventDate(), events.getEventTime(), events.getEventDescription());
		
		eventsRepo.save(newEvent);
		return ResponseEntity.ok().body(events);
	}
	
	@GetMapping("/events/{eventName}")
	public Events find(@PathVariable("eventName") String eventName){
		return eventsRepo.findByEventName(eventName);
	}
	
	@GetMapping("/events")
	public List<Events> findAll(){
		return eventsRepo.findAll();
	}
	
	@PutMapping("/events/{eventName}")
	public ResponseEntity<Events> putEvent(@PathVariable(value="eventName") String eventName, @RequestBody Events events) throws Exception{
		Events foundEvents= eventsRepo.findByEventName(eventName);
		
		if(foundEvents == null) {
			return ResponseEntity.notFound().header("Message", "Event not found").build();
			}
		else {
			foundEvents.setCharityName(events.getCharityName());
			foundEvents.setEventName(events.getEventName());
			foundEvents.setEventStreet(events.getEventStreet());
			foundEvents.setEventCity(events.getEventCity());
			foundEvents.setEventState(events.getEventState());
			foundEvents.setEventZip(events.getEventZip());
			foundEvents.setEventDate(events.getEventDate());
			foundEvents.setEventTime(events.getEventTime());
			foundEvents.setEventDescription(events.getEventDescription());
			eventsRepo.save(foundEvents);
		}
		return ResponseEntity.ok(foundEvents);
		
	}
    @DeleteMapping("/events/{eventName}")
	public ResponseEntity<Events> deleteEvent(@PathVariable(value="eventName") String eventName) {
		Events foundEvent = eventsRepo.findByEventName(eventName);
		
		if(foundEvent == null) {
			return ResponseEntity.notFound().header("Message",  "Event not found").build();
		}
		else {
			eventsRepo.delete(foundEvent);
		}
		return ResponseEntity.ok().build();
	}
}
