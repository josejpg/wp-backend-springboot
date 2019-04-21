package com.iessanvicente.weddingplanning.controller;

import com.iessanvicente.weddingplanning.entity.ClientsEntity;
import com.iessanvicente.weddingplanning.errors.ResourceNotFoundException;
import com.iessanvicente.weddingplanning.repository.ClientsRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping( "/api/v1/clients" )
@Api( value = "Clients microservice", description = "This API has a CRUD for clients" )
public class ClientsController {
	
	@Autowired
	private ClientsRepository clientsRepository;
	
	/**
	 * Get all clients list.
	 *
	 * @return the client's list
	 */
	@ApiOperation( value = "Find all clients", notes = "Return a list of clients" )
	@RequestMapping( method = RequestMethod.GET )
	public List<ClientsEntity> getAllClients() {
		return clientsRepository.findAll();
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
	@ApiOperation( value = "Find clients by ID", notes = "Return a list of clients" )
	@RequestMapping( value = "/{clientID}", method = RequestMethod.GET )
	public ClientsEntity getClientByID( @PathVariable Long clientID ) throws ResourceNotFoundException {
		return clientsRepository.findById( clientID )
				.orElseThrow( () -> new ResourceNotFoundException( "Client not found on :: " + clientID ) );
	}
	
	/**
	 * Create new client.
	 *
	 * @param dataClient the data client
	 *
	 * @return the client
	 */
	@ApiOperation( value = "Create a new client", notes = "Return a client created" )
	@RequestMapping( method = RequestMethod.POST )
	public ClientsEntity createUser( @Valid @RequestBody ClientsEntity dataClient ) {
		return clientsRepository.save( dataClient );
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
	@RequestMapping( value = "/{clientID}", method = RequestMethod.PUT )
	public ResponseEntity<ClientsEntity> updateUser(
			@PathVariable( value = "clientID" ) Long clientID,
			@Valid @RequestBody ClientsEntity dataClient
	) throws ResourceNotFoundException {
		ClientsEntity client =
				clientsRepository
						.findById( clientID )
						.orElseThrow( () -> new ResourceNotFoundException( "Client not found on :: " + clientID ) );
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
	 * Delete client.
	 *
	 * @param clientID the client id
	 *
	 * @return the map
	 *
	 * @throws ResourceNotFoundException the exception
	 */
	@ApiOperation( value = "Delete client by ID", notes = "Return true or exception" )
	@RequestMapping( value = "/{clientID}", method = RequestMethod.DELETE )
	public Map<String, Boolean> deleteUser(
			@PathVariable( value = "clientID" ) Long clientID
	) throws ResourceNotFoundException, Exception {
		ClientsEntity client =
				clientsRepository
						.findById( clientID )
						.orElseThrow( () -> new ResourceNotFoundException( "Client not found on :: " + clientID ) );
		try {
			clientsRepository.delete( client );
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}catch ( Exception ex ){
			throw new Exception( "Error deleting client " + clientID + ": " + ex.getMessage() );
		}
	}
}
