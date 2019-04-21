package com.iessanvicente.weddingplanning.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@ApiModel( "Model Client" )
@Table( name = "clientes", schema = "proyectobd" )
@EntityListeners( AuditingEntityListener.class )
public class ClientsEntity {
	
	@Id
	@NotNull
	@ApiModelProperty( value = "the client id" )
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@NotNull
	@ApiModelProperty( value = "the client name", required = true )
	@Column( name = "nombre", nullable = false )
	private String name;
	
	@ApiModelProperty( value = "the client surname" )
	@Column( name = "apellidos" )
	private String surname;
	
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
	
	@NotNull
	@ApiModelProperty( value = "the client email", required = true )
	@Column( name = "email", nullable = false )
	private String email;
	
	@ApiModelProperty( value = "the client birthday date" )
	@Column( name = "fnac" )
	private Integer birthDate;
	
	@ApiModelProperty( value = "the client phone number" )
	@Column( name = "telefono" )
	private String phone;
	
	@ApiModelProperty( value = "the client mobile phone number" )
	@Column( name = "movil" )
	private String mobile;
	
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
	 * Get the client surname
	 *
	 *@return String
	 */
	public String getSurname() {
		return surname;
	}
	
	/**
	 * Set a new surname to the client
	 * @param surname client surname
	 */
	public void setSurname( String surname ) {
		this.surname = surname;
	}
	
	/**
	 * Get the client address
	 *
	 *@return String
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
	 *@return String
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
	 *@return String
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
	 *@return String
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
	 *@return String
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
	 * Get the client birth date in time
	 *
	 *@return Integer
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
	 *@return String
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
	 *@return String
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * Set a new mobile number to the client
	 * @param mobile client mobile phone number
	 */
	public void setMobile( String mobile ) {
		this.mobile = mobile;
	}
	
}
