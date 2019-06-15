package com.iessanvicente.weddingplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@ApiModel( "Model Events" )
@Table( name = "eventos", schema = "y6CQ6X1U7Z" )
public class EventsEntity implements Serializable {
	
	@Id
	@NotNull
	@ApiModelProperty( value = "The ID" )
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@NotNull
	@ApiModelProperty( value = "Name", required = true )
	@Column( name = "nombre", nullable = false )
	private String event;
	
	@NotNull
	@ApiModelProperty( value = "Date", required = true )
	@Column( name = "fecha", nullable = false )
	private Integer date;
	
	@NotNull
	@ApiModelProperty( value = "Active", required = true )
	@Column( name = "activo", nullable = false )
	private Boolean active;
	
	@JsonIgnore
	@ManyToMany( fetch = FetchType.LAZY )
	@JoinTable(
			name = "proveedores_eventos_clientes",
			joinColumns = @JoinColumn( name = "ref_evento" ),
			inverseJoinColumns = @JoinColumn( name = "ref_proveedor" ) )
	private Set<ProvidersEntity> providers;
	
	@JsonIgnore
	@ManyToMany( fetch = FetchType.LAZY )
	@JoinTable(
			name = "proveedores_eventos_clientes",
			joinColumns = @JoinColumn( name = "ref_evento" ),
			inverseJoinColumns = @JoinColumn( name = "ref_cliente" ) )
	private Set<ClientsEntity> clients;
	
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
	 * Get the event name
	 *
	 * @return String
	 */
	public String getEvent() {
		return event;
	}
	
	/**
	 * Set the event name
	 *
	 * @param event event name
	 */
	public void setEvent( String event ) {
		this.event = event;
	}
	
	/**
	 * Get the event date
	 *
	 * @return Integer
	 */
	public Integer getDate() {
		return date;
	}
	
	/**
	 * Set the date
	 *
	 * @param date event date
	 */
	public void setDate( Integer date ) {
		this.date = date;
	}
	
	/**
	 * Get the active status
	 *
	 * @return Boolean
	 */
	public Boolean getActive() {
		return active;
	}
	
	/**
	 * Set the active status
	 *
	 * @param active status
	 */
	public void setActive( Boolean active ) {
		this.active = active;
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
	
	/**
	 * Get the client list
	 * @return Set<ClientsEntity>
	 */
	public Set<ClientsEntity> getClients() {
		return clients;
	}
	
	/**
	 * Set a new list of clients
	 * @param clients list
	 */
	public void setClients( Set<ClientsEntity> clients ) {
		this.clients = clients;
	}
}
