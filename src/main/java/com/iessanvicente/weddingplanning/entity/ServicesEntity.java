package com.iessanvicente.weddingplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@ApiModel( "Model Services" )
@Table( name = "servicios", schema = "y6CQ6X1U7Z" )
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
	
	@JsonIgnore
	@ManyToMany( fetch = FetchType.LAZY )
	@JoinTable(
			name = "proveedores_servicios",
			joinColumns = @JoinColumn( name = "ref_servicio" ),
			inverseJoinColumns = @JoinColumn( name = "ref_proveedor" ) )
	private Set<ProvidersEntity> providers;
	
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
	
	/**
	 * Get the providers list
	 * @return Set<ProvidersEntity>
	 */
	public Set<ProvidersEntity> getProviders() {
		return providers;
	}
	
	/**
	 * Set a new list of providers
	 * @param providers list
	 */
	public void setProviders( Set<ProvidersEntity> providers ) {
		this.providers = providers;
	}
	
}
