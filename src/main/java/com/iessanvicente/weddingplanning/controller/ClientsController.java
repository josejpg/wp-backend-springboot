package com.iessanvicente.weddingplanning.controller;

import com.iessanvicente.weddingplanning.entity.ClientsEntity;
import com.iessanvicente.weddingplanning.errors.ResourceNotFoundException;
import com.iessanvicente.weddingplanning.repository.ClientsRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/api/v1/clients" )
@Api( value = "Clients microservice", description = "This API has a CRUD for clients" )
public class ClientsController {
	
	@Autowired
	private ClientsRepository clientsRepository;
	private Logger logger;
	
	/**
	 * Get all clients list.
	 *
	 * @return the client list
	 */
	@ApiOperation( value = "Find all clients", notes = "Return a list of clients" )
	@RequestMapping( method = RequestMethod.GET, produces = "application/json" )
	public List<ClientsEntity> getAllClients() {
		return clientsRepository.findAll();
	}
	
	/**
	 * Get client login.
	 *
	 * @return the client data
	 */
	@ApiOperation( value = "Find client by login", notes = "Return data client" )
	@RequestMapping( value = "/login", method = RequestMethod.GET, produces = "application/json" )
	public ResponseEntity findByLogin( @Valid @RequestBody Map<String, String> userData ) {
		Map<String, String> response = new HashMap<>();
		String email;
		String pws;
		try {
			email = userData.get( "email" );
			pws = userData.get( "password" );
		} catch (Exception e) {
			response.put( "errorMessage", "Params has errors" );
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( response );
		}
		
		try {
			ClientsEntity client = clientsRepository.findByLogin( email, pws )
					.orElseThrow( () -> new ResourceNotFoundException( "Client", "email", email ) );
			
			return ResponseEntity.status( HttpStatus.ACCEPTED ).body( client );
		}catch ( Exception e ){
			response.put( "errorMessage", e.getMessage() );
			return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( response );
		}
	}
	
	/**
	 * Get client data.
	 *
	 * @return the client data
	 */
	@ApiOperation( value = "Find client by email", notes = "Return data client" )
	@RequestMapping( value = "/find", method = RequestMethod.GET, produces = "application/json" )
	public ResponseEntity findByEmail( @Valid @RequestBody Map<String, String> userData ) {
		Map<String, String> response = new HashMap<>();
		String email;
		try {
			email = userData.get( "email" );
		} catch (Exception e) {
			response.put( "errorMessage", "Params has errors" );
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( response );
		}
		
		try {
			List<ClientsEntity> clients = clientsRepository.findByEmail( email )
					.orElseThrow( () -> new ResourceNotFoundException( "Clients", "email", email ) );
			
			return ResponseEntity.status( HttpStatus.FOUND ).body( clients );
		}catch ( Exception e ){
			response.put( "errorMessage", e.getMessage() );
			return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( response );
		}
	}
	
	/**
	 * Get a client by ID.
	 *
	 * @param clientID the client id
	 *
	 * @return the client by id
	 *
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@ApiOperation( value = "Find client by ID", notes = "Return a client" )
	@RequestMapping( value = "/{clientID}", method = RequestMethod.GET, produces = "application/json" )
	public ClientsEntity getClientByID( @PathVariable Long clientID ) throws ResourceNotFoundException {
		return clientsRepository.findById( clientID )
				.orElseThrow( () -> new ResourceNotFoundException( "Client", "ID", clientID ) );
	}
	
	/**
	 * Create new client.
	 *
	 * @param dataClient the data client
	 *
	 * @return the client
	 */
	@ApiOperation( value = "Create a new client", notes = "Return a client created" )
	@RequestMapping( method = RequestMethod.POST, produces = "application/json" )
	public ResponseEntity createUser( @Valid @RequestBody ClientsEntity dataClient ) {
		
		if( clientsRepository.findByEmail( dataClient.getEmail() ) != null ) {
			try {
				return ResponseEntity.status( HttpStatus.CREATED ).body( clientsRepository.save( dataClient ) );
			} catch ( Exception e ) {
				return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( e.getMessage() );
			}
		}
		return ResponseEntity.status( HttpStatus.CONFLICT ).body( "El email ya se encuentra registrado" );
	}
	
	/**
	 * Update client response entity.
	 *
	 * @param clientID   the user id
	 * @param dataClient the user details
	 *
	 * @return the response entity
	 *
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@ApiOperation( value = "Update data client", notes = "Return a updated data client" )
	@RequestMapping( value = "/{clientID}", method = RequestMethod.PUT, produces = "application/json" )
	public ResponseEntity<ClientsEntity> updateUser(
			@PathVariable( value = "clientID" ) Long clientID,
			@Valid @RequestBody ClientsEntity dataClient
	) throws ResourceNotFoundException {
		ClientsEntity client =
				clientsRepository
						.findById( clientID )
						.orElseThrow( () -> new ResourceNotFoundException( "Client", "ID", clientID ) );
		client.setName( dataClient.getName() );
		client.setSurname( dataClient.getSurname() );
		client.setEmail( dataClient.getEmail() );
		client.setAddress( dataClient.getAddress() );
		client.setTown( dataClient.getTown() );
		client.setProvince( dataClient.getProvince() );
		client.setPostalCode( dataClient.getPostalCode() );
		client.setBirthDate( dataClient.getBirthDate() );
		client.setPhone( dataClient.getPhone() );
		client.setMobile( dataClient.getMobile() );
		final ClientsEntity updatedClient = clientsRepository.save( client );
		return ResponseEntity.ok( updatedClient );
	}
	/**
	 * Update client password.
	 *
	 * @param clientID   the user id
	 * @param dataClient the user details
	 *
	 * @return the response entity
	 *
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@ApiOperation( value = "Update data client", notes = "Return a updated data client" )
	@RequestMapping( value = "/{clientID}/password", method = RequestMethod.PUT, produces = "application/json" )
	public ResponseEntity<ClientsEntity> updateUserPassword(
			@PathVariable( value = "clientID" ) Long clientID,
			@Valid @RequestBody ClientsEntity dataClient
	) throws ResourceNotFoundException {
		ClientsEntity client =
				clientsRepository
						.findById( clientID )
						.orElseThrow( () -> new ResourceNotFoundException( "Client", "ID", clientID ) );
		client.setPassword( dataClient.getPassword() );
		final ClientsEntity updatedClient = clientsRepository.save( client );
		return ResponseEntity.ok( updatedClient );
	}
	
	/**
	 * Delete client.
	 *
	 * @param clientID the client id
	 *
	 * @return the map
	 *
	 * @throws ResourceNotFoundException the exception
	 */
	@ApiOperation( value = "Delete client by ID", notes = "Return true or exception" )
	@RequestMapping( value = "/{clientID}", method = RequestMethod.DELETE, produces = "application/json" )
	public Map<String, Boolean> deleteUser(
			@PathVariable( value = "clientID" ) Long clientID
	) throws Exception {
		ClientsEntity client =
				clientsRepository
						.findById( clientID )
						.orElseThrow( () -> new ResourceNotFoundException( "Client", "ID", clientID ) );
		try {
			clientsRepository.delete( client );
			Map<String, Boolean> response = new HashMap<>();
			response.put( "deleted", Boolean.TRUE );
			return response;
		} catch ( Exception ex ) {
			throw new Exception( "Error deleting client " + clientID + ": " + ex.getMessage() );
		}
	}
}
