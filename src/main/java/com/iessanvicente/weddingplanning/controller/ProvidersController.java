package com.iessanvicente.weddingplanning.controller;

import com.iessanvicente.weddingplanning.entity.ProvidersEntity;
import com.iessanvicente.weddingplanning.errors.ResourceNotFoundException;
import com.iessanvicente.weddingplanning.repository.ProvidersRepository;
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
@RequestMapping( "/api/v1/providers" )
@Api( value = "Providers microservice", description = "This API has a CRUD for providers" )
public class ProvidersController {
	
	@Autowired
	private ProvidersRepository providersRepository;
	
	/**
	 * Get all providers list.
	 *
	 * @return the provider list
	 */
	@ApiOperation( value = "Find all providers", notes = "Return a list of providers" )
	@RequestMapping( method = RequestMethod.GET )
	public List<ProvidersEntity> getAllProviders() {
		return providersRepository.findAll();
	}
	
	/**
	 * Get a provider by ID.
	 *
	 * @param providerID the provider id
	 *
	 * @return the provider by id
	 *
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@ApiOperation( value = "Find provider by ID", notes = "Return a event" )
	@RequestMapping( value = "/{providerID}", method = RequestMethod.GET )
	public ProvidersEntity getEventByID( @PathVariable Long providerID ) throws ResourceNotFoundException {
		return providersRepository.findById( providerID )
				.orElseThrow( () -> new ResourceNotFoundException( "Event not found on :: " + providerID ) );
	}
	
	/**
	 * Create new provider.
	 *
	 * @param dataProvider the data provider
	 *
	 * @return the provider
	 */
	@ApiOperation( value = "Create a new provider", notes = "Return a provider created" )
	@RequestMapping( method = RequestMethod.POST )
	public ProvidersEntity createProvider( @Valid @RequestBody ProvidersEntity dataProvider ) {
		return providersRepository.save( dataProvider );
	}
	
	/**
	 * Update provider response entity.
	 *
	 * @param providerID   the provider id
	 * @param dataProvider the provider details
	 *
	 * @return the response provider
	 *
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@ApiOperation( value = "Update data provider", notes = "Return a updated data provider" )
	@RequestMapping( value = "/{providerID}", method = RequestMethod.PUT )
	public ResponseEntity<ProvidersEntity> updateEvent(
			@PathVariable( value = "providerID" ) Long providerID,
			@Valid @RequestBody ProvidersEntity dataProvider
	) throws ResourceNotFoundException {
		ProvidersEntity provider =
				providersRepository
						.findById( providerID )
						.orElseThrow( () -> new ResourceNotFoundException( "Provider not found on :: " + providerID ) );
		if ( dataProvider.getCif() != null ) {
			provider.setCif( dataProvider.getCif() );
		}
		if ( dataProvider.getName() != null ) {
			provider.setName( dataProvider.getName() );
		}
		if ( dataProvider.getEmail() != null ) {
			provider.setEmail( dataProvider.getEmail() );
		}
		if ( dataProvider.getPassword() != null ) {
			provider.setPassword( dataProvider.getPassword() );
		}
		if ( dataProvider.getPhone() != null ) {
			provider.setPhone( dataProvider.getPhone() );
		}
		if ( dataProvider.getMobile() != null ) {
			provider.setAddress( dataProvider.getMobile() );
		}
		if ( dataProvider.getAddress() != null ) {
			provider.setAddress( dataProvider.getAddress() );
		}
		if ( dataProvider.getProvince() != null ) {
			provider.setProvince( dataProvider.getProvince() );
		}
		if ( dataProvider.getTown() != null ) {
			provider.setTown( dataProvider.getTown() );
		}
		if ( dataProvider.getPostalCode() != null ) {
			provider.setPostalCode( dataProvider.getPostalCode() );
		}
		
		final ProvidersEntity updatedProvider = providersRepository.save( provider );
		return ResponseEntity.ok( updatedProvider );
	}
	
	/**
	 * Delete provider.
	 *
	 * @param providerID the provider id
	 *
	 * @return the map
	 *
	 * @throws ResourceNotFoundException the exception
	 */
	@ApiOperation( value = "Delete provider by ID", notes = "Return true or exception" )
	@RequestMapping( value = "/{providerID}", method = RequestMethod.DELETE )
	public Map<String, Boolean> deleteProvider(
			@PathVariable( value = "providerID" ) Long providerID
	) throws Exception {
		ProvidersEntity provider =
				providersRepository
						.findById( providerID )
						.orElseThrow( () -> new ResourceNotFoundException( "Event not found on :: " + providerID ) );
		try {
			providersRepository.delete( provider );
			Map<String, Boolean> response = new HashMap<>();
			response.put( "deleted", Boolean.TRUE );
			return response;
		} catch ( Exception ex ) {
			throw new Exception( "Error deleting provider " + providerID + ": " + ex.getMessage() );
		}
	}
}
