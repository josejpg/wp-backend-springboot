package com.iessanvicente.weddingplanning.controller;

import com.iessanvicente.weddingplanning.entity.EventsEntity;
import com.iessanvicente.weddingplanning.entity.ProvidersEntity;
import com.iessanvicente.weddingplanning.errors.ResourceNotFoundException;
import com.iessanvicente.weddingplanning.repository.EventsRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping( "/api/v1/events" )
@Api( value = "Events microservice", description = "This API has a CRUD for events" )
public class EventsController {
	
	@Autowired
	private EventsRepository eventsRepository;
	
	@PersistenceUnit
	private EntityManagerFactory emFactory;
	
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
	public ResponseEntity getEventByID( @PathVariable Long eventID ) throws ResourceNotFoundException {
		Map<String, String> response = new HashMap<>();
		try {
			final String sqlFindByProvider = String.format( "SELECT DISTINCT e FROM EventsEntity e JOIN e.clients c " +
					"JOIN e.providers p WHERE e.id = %d", eventID );
			EntityManager em = emFactory.createEntityManager();
			Query query = em.createQuery( sqlFindByProvider );
			List<EventsEntity> resultList = query.getResultList();
			return ResponseEntity.status( HttpStatus.FOUND ).body( resultList );
		} catch ( Exception e ) {
			response.put( "errorMessage", e.getMessage() );
			return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( e.getMessage() );
		}
	}
	
	/**
	 * Get events_provders_clients data by provider.
	 *
	 * @return the events_provders_clients
	 */
	@ApiOperation( value = "Find events by provider", notes = "Return data events with clients" )
	@RequestMapping( value = "/provider/{providerID}", method = RequestMethod.GET, produces = "application/json" )
	public ResponseEntity findByProvider( @PathVariable Long providerID ) {
		Map<String, String> response = new HashMap<>();
		try {
			final String sqlFindByProvider = String.format( "SELECT DISTINCT e FROM EventsEntity e JOIN e.clients c " +
					"JOIN e.providers p WHERE p.id = %d", providerID );
			EntityManager em = emFactory.createEntityManager();
			Query query = em.createQuery( sqlFindByProvider );
			List<EventsEntity> resultList = query.getResultList();
			
			return ResponseEntity.status( HttpStatus.FOUND ).body( resultList );
		} catch ( Exception e ) {
			response.put( "errorMessage", e.getMessage() );
			return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( response );
		}
	}
	
	/**
	 * Get events_provders_clients data by client.
	 *
	 * @return the events_provders_clients
	 */
	@ApiOperation( value = "Find events by client", notes = "Return data events with provider" )
	@RequestMapping( value = "/client/{clientID}", method = RequestMethod.GET, produces = "application/json" )
	public ResponseEntity findByClients( @PathVariable Long clientID ) {
		Map<String, String> response = new HashMap<>();
		try {
			final String sqlFindByClient = String.format( "SELECT DISTINCT e FROM EventsEntity e JOIN e.clients c " +
					"JOIN" +
					" e.providers p WHERE c.id = %d", clientID );
			
			EntityManager em = emFactory.createEntityManager();
			Query query = em.createQuery( sqlFindByClient );
			List<EventsEntity> resultList = query.getResultList();
			
			return ResponseEntity.status( HttpStatus.FOUND ).body( resultList );
		} catch ( Exception e ) {
			response.put( "errorMessage", e.getMessage() );
			return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( response );
		}
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
	public ResponseEntity updateEvent(
			@PathVariable( value = "eventID" ) Long eventID,
			@Valid @RequestBody EventsEntity dataEvent
	) throws ResourceNotFoundException {
		Map<String, String> response = new HashMap<>();
		try {
			EventsEntity event =
					eventsRepository
							.findById( eventID )
							.orElseThrow( () -> new ResourceNotFoundException( "Event", "ID", eventID ) );
			event.setEvent( dataEvent.getEvent() );
			event.setDate( dataEvent.getDate() );
			event.setActive( dataEvent.getActive() );
			event.setClients( dataEvent.getClients() );
			event.setProviders( dataEvent.getProviders() );
			
			final EventsEntity updatedEvent = eventsRepository.save( event );
			return ResponseEntity.ok( updatedEvent );
		} catch ( Exception e ) {
			response.put( "errorMessage", e.getMessage() );
			return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( response );
		}
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
	public ResponseEntity deleteEvent(
			@PathVariable( value = "eventID" ) Long eventID
	) throws Exception {
		try {
		EventsEntity event =
				eventsRepository
						.findById( eventID )
						.orElseThrow( () -> new ResourceNotFoundException( "Event", "ID", eventID ) );
			eventsRepository.delete( event );
			Map<String, Boolean> response = new HashMap<>();
			response.put( "deleted", Boolean.TRUE );
			return  ResponseEntity.status( HttpStatus.OK ).body( response );
		} catch ( Exception e ) {
			Map<String, String> response = new HashMap<>();
			response.put( "errorMessage", "Error deleting event " + eventID + ": " + e.getMessage() );
			return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( response );
		}
	}
}
