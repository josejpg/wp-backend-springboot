package com.iessanvicente.weddingplanning.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@ApiModel( "Model Events" )
@Table( name = "eventos", schema = "proyectobd" )
public class EventsEntity {
	
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
}
