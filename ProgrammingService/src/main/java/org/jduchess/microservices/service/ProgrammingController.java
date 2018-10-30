package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.Event;
import org.jduchess.microservices.domain.EventSeating;
import org.jduchess.microservices.domain.Location;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programming")
public class ProgrammingController {
    private LocationRepository locationRepository;
    private EventRepository eventRepository;
    private EventSeatingRepository eventSeatingRepository;

    public ProgrammingController(LocationRepository locationRepository, EventRepository eventRepository,
                                 EventSeatingRepository eventSeatingRepository) {
        this.locationRepository = locationRepository;
        this.eventRepository = eventRepository;
        this.eventSeatingRepository = eventSeatingRepository;
    }

    @CrossOrigin
    @RequestMapping(value = "/getLocations", method = RequestMethod.GET)
    public List<Location> getLocations() {
        return (List<Location>) locationRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/addEvent", method = RequestMethod.POST)
    public Event addEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @CrossOrigin
    @RequestMapping(value = "/updateEvent", method = RequestMethod.POST)
    public Event updateEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }


    @CrossOrigin
    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    public List<Event> getEvents() { return (List<Event>) eventRepository.findAll();}

    @CrossOrigin
    @RequestMapping(value = "/deleteEvent", method = RequestMethod.DELETE)
    public void deleteEvent(Event event) {
        eventRepository.delete(event);
    }

    @CrossOrigin
    @RequestMapping(value = "/addSeating", method = RequestMethod.POST)
    public EventSeating addSeating(@RequestBody EventSeating seating) {
        return eventSeatingRepository.save(seating);
    }
}
