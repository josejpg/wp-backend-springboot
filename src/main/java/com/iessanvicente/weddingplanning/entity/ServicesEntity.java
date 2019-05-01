package com.iessanvicente.weddingplanning.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@ApiModel( "Model Services" )
@Table( name = "servicios", schema = "proyectobd" )
public class ServicesEntity {
	
	@Id
	@NotNull
	@ApiModelProperty( value = "The ID" )
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@NotNull
	@ApiModelProperty( value = "Name", required = true )
	@Column( name = "nombre", nullable = false )
	private String service;
	
	/**
	 * Get the ID
	 *
	 * @return Long
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Set the ID
	 *
	 * @param id event ID
	 */
	public void setId( long id ) {
		this.id = id;
	}
	
	/**
	 * Get the service name
	 *
	 * @return String
	 */
	public String getService() {
		return service;
	}
	
	/**
	 * Set the service name
	 *
	 * @param service service name
	 */
	public void setService( String service ) {
		this.service = service;
	}
	
}
