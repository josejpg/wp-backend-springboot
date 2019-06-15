package com.iessanvicente.weddingplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@ApiModel( "Model Client" )
@Table( name = "clientes", schema = "y6CQ6X1U7Z" )
@EntityListeners( AuditingEntityListener.class )
public class ClientsEntity {
	
	@Id
	@NotNull
	@ApiModelProperty( value = "The ID" )
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@NotNull
	@ApiModelProperty( value = "the client email", required = true )
	@Column( name = "email", nullable = false )
	private String email;
	
	@JsonIgnore
	@NotNull
	@ApiModelProperty( value = "the client password", required = true )
	@Column( name = "password", nullable = false )
	private String password;
	
	@NotNull
	@ApiModelProperty( value = "Name", required = true )
	@Column( name = "nombre", nullable = false )
	private String name;
	
	@ApiModelProperty( value = "the client last name" )
	@Column( name = "apellidos" )
	private String lastName;
	
	@ApiModelProperty( value = "the client birthday date" )
	@Column( name = "fnac" )
	private Integer birthDate;
	
	@ApiModelProperty( value = "the client phone number" )
	@Column( name = "telefono" )
	private String phone;
	
	@ApiModelProperty( value = "the client mobile phone number" )
	@Column( name = "movil" )
	private String mobile;
	
	@ApiModelProperty( value = "the client address" )
	@Column( name = "direccion" )
	private String address;
	
	@ApiModelProperty( value = "the client town" )
	@Column( name = "poblacion" )
	private String town;
	
	@ApiModelProperty( value = "the client province" )
	@Column( name = "provincia" )
	private String province;
	
	@ApiModelProperty( value = "the client postal code" )
	@Column( name = "cp" )
	private String postalCode;
	
	@ManyToMany( mappedBy = "clients", fetch = FetchType.LAZY )
	private Set<EventsEntity> events;
	
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
	 * @param id client ID
	 */
	public void setId( long id ) {
		this.id = id;
	}
	
	/**
	 * Get the client name
	 *
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set a new name to the client
	 *
	 * @param name client name
	 */
	public void setName( String name ) {
		this.name = name;
	}
	
	/**
	 * Get the client last name
	 *
	 * @return String
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Set a new last name to the client
	 *
	 * @param lastName client last name
	 */
	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}
	
	/**
	 * Get the client address
	 *
	 * @return String
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Set a new address to the client
	 *
	 * @param address client address
	 */
	public void setAddress( String address ) {
		this.address = address;
	}
	
	/**
	 * Get the client town
	 *
	 * @return String
	 */
	public String getTown() {
		return town;
	}
	
	/**
	 * Set a new town to the client
	 *
	 * @param town client Town
	 */
	public void setTown( String town ) {
		this.town = town;
	}
	
	/**
	 * Get the client province
	 *
	 * @return String
	 */
	public String getProvince() {
		return province;
	}
	
	/**
	 * Set a new province to the client
	 *
	 * @param province client province
	 */
	public void setProvince( String province ) {
		this.province = province;
	}
	
	/**
	 * Get a client postal code
	 *
	 * @return String
	 */
	public String getPostalCode() {
		return postalCode;
	}
	
	/**
	 * Set a new postal code to the client
	 *
	 * @param postalCode client postal code
	 */
	public void setPostalCode( String postalCode ) {
		this.postalCode = postalCode;
	}
	
	/**
	 * Get the client email
	 *
	 * @return String
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Set a new email to the client
	 *
	 * @param email client email
	 */
	public void setEmail( String email ) {
		this.email = email;
	}
	
	/**
	 * Get the client password
	 *
	 * @return String
	 */
	public String getPassword() { return password; }
	
	/**
	 * Set a new password to the client
	 *
	 * @param password client password
	 */
	public void setPassword( String password ) { this.password = password; }
	
	/**
	 * Get the client birth date in time
	 *
	 * @return Integer
	 */
	public Integer getBirthDate() {
		return birthDate;
	}
	
	/**
	 * Set a new birth date to the client
	 *
	 * @param birthDate client birthday date
	 */
	public void setBirthDate( Integer birthDate ) {
		this.birthDate = birthDate;
	}
	
	/**
	 * Get the client phone number
	 *
	 * @return String
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Set a new phone number to a client
	 *
	 * @param phone client phone number
	 */
	public void setPhone( String phone ) {
		this.phone = phone;
	}
	
	/**
	 * Get the client mobile phone number
	 *
	 * @return String
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * Set a new mobile number to the client
	 *
	 * @param mobile client mobile phone number
	 */
	public void setMobile( String mobile ) {
		this.mobile = mobile;
	}
	
	/**
	 * Get the events list
	 *
	 * @return Set<EventsEntity>
	 */
	public Set<EventsEntity> getEvents() {
		return events;
	}
	
	/**
	 * Set a new events list
	 *
	 * @param events Set<EventsEntity>
	 */
	public void setEvents( Set<EventsEntity> events ) {
		this.events = events;
	}
}
