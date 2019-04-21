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
	@ApiModelProperty( value = "the client's id" )
	@GeneratedValue( strategy = GenerationType.AUTO )
	private long id;
	
	@ApiModelProperty( value = "the client's name", required = true )
	@Column( name = "nombre", nullable = false )
	private String name;
	
	@ApiModelProperty( value = "the client's surname" )
	@Column( name = "apellidos" )
	private String surname;
	
	@ApiModelProperty( value = "the client's address" )
	@Column( name = "direccion" )
	private String address;
	
	@ApiModelProperty( value = "the client's town" )
	@Column( name = "poblacion" )
	private String town;
	
	@ApiModelProperty( value = "the client's province" )
	@Column( name = "provincia" )
	private String province;
	
	@ApiModelProperty( value = "the client's postal code" )
	@Column( name = "cp" )
	private String postalCode;
	
	@NotNull
	@ApiModelProperty( value = "the client's email", required = true )
	@Column( name = "email", nullable = false )
	private String email;
	
	@ApiModelProperty( value = "the client's birthday date" )
	@Column( name = "fnac" )
	private Integer birthDate;
	
	@ApiModelProperty( value = "the client's phone number" )
	@Column( name = "telefono" )
	private String phone;
	
	@ApiModelProperty( value = "the client's mobile phone number" )
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
	 * @param id Client's ID
	 */
	public void setId( long id ) {
		this.id = id;
	}
	
	/**
	 * Get the client's name
	 *
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set a new name to the client
	 *
	 * @param name Client's name
	 */
	public void setName( String name ) {
		this.name = name;
	}
	
	/**
	 * Get the client's surname
	 *
	 *@return String
	 */
	public String getSurname() {
		return surname;
	}
	
	/**
	 * Set a new surname to the client
	 * @param surname Client's surname
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
	 * @param address Client's address
	 */
	public void setAddress( String address ) {
		this.address = address;
	}
	
	/**
	 * Get the client's town
	 *
	 *@return String
	 */
	public String getTown() {
		return town;
	}
	
	/**
	 * Set a new town to the client
	 *
	 * @param town Client's Town
	 */
	public void setTown( String town ) {
		this.town = town;
	}
	
	/**
	 * Get the client's province
	 *
	 *@return String
	 */
	public String getProvince() {
		return province;
	}
	
	/**
	 * Set a new province to the client
	 *
	 * @param province Client's province
	 */
	public void setProvince( String province ) {
		this.province = province;
	}
	
	/**
	 * Get a client's postal code
	 *
	 *@return String
	 */
	public String getPostalCode() {
		return postalCode;
	}
	
	/**
	 * Set a new postal code to the client
	 *
	 * @param postalCode Client's postal code
	 */
	public void setPostalCode( String postalCode ) {
		this.postalCode = postalCode;
	}
	
	/**
	 * Get the client's email
	 *
	 *@return String
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Set a new email to the client
	 *
	 * @param email Client's email
	 */
	public void setEmail( String email ) {
		this.email = email;
	}
	
	/**
	 * Get the client's birth date in time
	 *
	 *@return Integer
	 */
	public Integer getBirthDate() {
		return birthDate;
	}
	
	/**
	 * Set a new birth date to the client
	 *
	 * @param birthDate Client's birthday date
	 */
	public void setBirthDate( Integer birthDate ) {
		this.birthDate = birthDate;
	}
	
	/**
	 * Get the client's phone number
	 *
	 *@return String
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Set a new phone number to a client
	 *
	 * @param phone Client's phone number
	 */
	public void setPhone( String phone ) {
		this.phone = phone;
	}
	
	/**
	 * Get the client's mobile phone number
	 *
	 *@return String
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * Set a new mobile number to the client
	 * @param mobile Client's mobile phone number
	 */
	public void setMobile( String mobile ) {
		this.mobile = mobile;
	}
	
}
