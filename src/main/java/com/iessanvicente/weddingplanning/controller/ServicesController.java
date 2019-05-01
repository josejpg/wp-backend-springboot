package com.iessanvicente.weddingplanning.controller;

import com.iessanvicente.weddingplanning.entity.ServicesEntity;
import com.iessanvicente.weddingplanning.errors.ResourceNotFoundException;
import com.iessanvicente.weddingplanning.repository.ServicesRepository;
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
@RequestMapping( "/api/v1/services" )
@Api( value = "Services microservice", description = "This API has a CRUD for services" )
public class ServicesController {
	
	@Autowired
	private ServicesRepository servicesRepository;
	
	/**
	 * Get all services list.
	 *
	 * @return the service list
	 */
	@ApiOperation( value = "Find all services", notes = "Return a list of services" )
	@RequestMapping( method = RequestMethod.GET )
	public List<ServicesEntity> getAllServices() {
		return servicesRepository.findAll();
	}
	
	/**
	 * Get a service by ID.
	 *
	 * @param serviceID the service id
	 *
	 * @return the service by id
	 *
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@ApiOperation( value = "Find service by ID", notes = "Return a service" )
	@RequestMapping( value = "/{serviceID}", method = RequestMethod.GET )
	public ServicesEntity getServiceByID( @PathVariable Long serviceID ) throws ResourceNotFoundException {
		return servicesRepository.findById( serviceID )
				.orElseThrow( () -> new ResourceNotFoundException( "Service not found on :: " + serviceID ) );
	}
	
	/**
	 * Create new service.
	 *
	 * @param dataService the data service
	 *
	 * @return the service
	 */
	@ApiOperation( value = "Create a new service", notes = "Return a service created" )
	@RequestMapping( method = RequestMethod.POST )
	public ServicesEntity createService( @Valid @RequestBody ServicesEntity dataService ) {
		return servicesRepository.save( dataService );
	}
	
	/**
	 * Update service response entity.
	 *
	 * @param serviceID   the service id
	 * @param dataService the service details
	 *
	 * @return the response entity
	 *
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@ApiOperation( value = "Update data service", notes = "Return a updated data service" )
	@RequestMapping( value = "/{serviceID}", method = RequestMethod.PUT )
	public ResponseEntity<ServicesEntity> updateEvent(
			@PathVariable( value = "serviceID" ) Long serviceID,
			@Valid @RequestBody ServicesEntity dataService
	) throws ResourceNotFoundException {
		ServicesEntity service =
				servicesRepository
						.findById( serviceID )
						.orElseThrow( () -> new ResourceNotFoundException( "Service not found on :: " + serviceID ) );
		service.setService( dataService.getService() );
		
		final ServicesEntity updatedService = servicesRepository.save( service );
		return ResponseEntity.ok( updatedService );
	}
	
	/**
	 * Delete service.
	 *
	 * @param serviceID the service id
	 *
	 * @return the map
	 *
	 * @throws ResourceNotFoundException the exception
	 */
	@ApiOperation( value = "Delete service by ID", notes = "Return true or exception" )
	@RequestMapping( value = "/{serviceID}", method = RequestMethod.DELETE )
	public Map<String, Boolean> deleteEvent(
			@PathVariable( value = "serviceID" ) Long serviceID
	) throws Exception {
		ServicesEntity event =
				servicesRepository
						.findById( serviceID )
						.orElseThrow( () -> new ResourceNotFoundException( "Event not found on :: " + serviceID ) );
		try {
			servicesRepository.delete( event );
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}catch ( Exception ex ){
			throw new Exception( "Error deleting service " + serviceID + ": " + ex.getMessage() );
		}
	}
}
