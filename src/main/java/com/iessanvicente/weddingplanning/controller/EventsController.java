package com.iessanvicente.weddingplanning.controller;

import com.iessanvicente.weddingplanning.entity.EventsEntity;
import com.iessanvicente.weddingplanning.errors.ResourceNotFoundException;
import com.iessanvicente.weddingplanning.repository.EventsRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping( "/api/v1/events" )
@Api( value = "Events microservice", description = "This API has a CRUD for events" )
public class EventsController {
	
	@Autowired
	private EventsRepository eventsRepository;
	
	/**
	 * Get all events list.
	 *
	 * @return the event list
	 */
	@ApiOperation( value = "Find all events", notes = "Return a list of events" )
	@RequestMapping( method = RequestMethod.GET )
	public List<EventsEntity> getAllEvents() {
		return eventsRepository.findAll();
	}
	
	/**
	 * Get a event by ID.
	 *
	 * @param eventID the event id
	 *
	 * @return the event by id
	 *
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@ApiOperation( value = "Find event by ID", notes = "Return a event" )
	@RequestMapping( value = "/{eventID}", method = RequestMethod.GET )
	public EventsEntity getEventByID( @PathVariable Long eventID ) throws ResourceNotFoundException {
		return eventsRepository.findById( eventID )
				.orElseThrow( () -> new ResourceNotFoundException( "Event not found on :: " + eventID ) );
	}
	
	/**
	 * Create new event.
	 *
	 * @param dataEvent the data event
	 *
	 * @return the event
	 */
	@ApiOperation( value = "Create a new event", notes = "Return a event created" )
	@RequestMapping( method = RequestMethod.POST )
	public EventsEntity createEvent( @Valid @RequestBody EventsEntity dataEvent ) {
		return eventsRepository.save( dataEvent );
	}
	
	/**
	 * Update event response entity.
	 *
	 * @param eventID   the event id
	 * @param dataEvent the event details
	 *
	 * @return the response entity
	 *
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@ApiOperation( value = "Update data event", notes = "Return a updated data event" )
	@RequestMapping( value = "/{eventID}", method = RequestMethod.PUT )
	public ResponseEntity<EventsEntity> updateEvent(
			@PathVariable( value = "eventID" ) Long eventID,
			@Valid @RequestBody EventsEntity dataEvent
	) throws ResourceNotFoundException {
		EventsEntity event =
				eventsRepository
						.findById( eventID )
						.orElseThrow( () -> new ResourceNotFoundException( "Event not found on :: " + eventID ) );
		event.setEvent( dataEvent.getEvent() );
		event.setDate( dataEvent.getDate() );
		
		final EventsEntity updatedEvent = eventsRepository.save( event );
		return ResponseEntity.ok( updatedEvent );
	}
	
	/**
	 * Delete event.
	 *
	 * @param eventID the event id
	 *
	 * @return the map
	 *
	 * @throws ResourceNotFoundException the exception
	 */
	@ApiOperation( value = "Delete event by ID", notes = "Return true or exception" )
	@RequestMapping( value = "/{eventID}", method = RequestMethod.DELETE )
	public Map<String, Boolean> deleteEvent(
			@PathVariable( value = "eventID" ) Long eventID
	) throws Exception {
		EventsEntity event =
				eventsRepository
						.findById( eventID )
						.orElseThrow( () -> new ResourceNotFoundException( "Event not found on :: " + eventID ) );
		try {
			eventsRepository.delete( event );
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}catch ( Exception ex ){
			throw new Exception( "Error deleting event " + eventID + ": " + ex.getMessage() );
		}
	}
}
