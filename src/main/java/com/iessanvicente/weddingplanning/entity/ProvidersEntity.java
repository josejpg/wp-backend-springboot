package com.iessanvicente.weddingplanning.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@ApiModel( "Model Providers" )
@Table( name = "proveedores", schema = "proyectobd" )
public class ProvidersEntity {
	
	@Id
	@NotNull
	@ApiModelProperty( value = "The ID" )
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@NotNull
	@ApiModelProperty( value = "Name", required = true )
	@Column( name = "nombre", nullable = false )
	private String name;
	
	@ApiModelProperty( value = "CIF/NIF" )
	@Column( name = "cif" )
	private String cif;
	
	@ApiModelProperty( value = "Address" )
	@Column( name = "direccion" )
	private String address;
	
	@ApiModelProperty( value = "Town" )
	@Column( name = "poblacion" )
	private String town;
	
	@ApiModelProperty( value = "Province" )
	@Column( name = "provincia" )
	private String province;
	
	@ApiModelProperty( value = "Postal code" )
	@Column( name = "cp" )
	private String postalCode;
	
	@NotNull
	@ApiModelProperty( value = "Email", required = true )
	@Column( name = "email", nullable = false )
	private String email;
	
	@NotNull
	@ApiModelProperty( value = "Password", required = true )
	@Column( name = "password", nullable = false )
	private String password;
	
	@ApiModelProperty( value = "Phone number" )
	@Column( name = "telefono" )
	private String phone;
	
	@ApiModelProperty( value = "Mobile number" )
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
	 * @param id provider ID
	 */
	public void setId( long id ) {
		this.id = id;
	}
	
	/**
	 * Get the provider name
	 *
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set a new name to the provider
	 *
	 * @param name provider name
	 */
	public void setName( String name ) {
		this.name = name;
	}
	
	/**
	 * Get the CIF
	 *
	 * @return String
	 */
	public String getCif() {
		return cif;
	}
	
	/**
	 * Set a new CIF to the provider
	 *
	 * @param cif provider CIF
	 */
	public void setCif( String cif ) {
		this.cif = cif;
	}
	
	/**
	 * Get the provider address
	 *
	 * @return String
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Set a new address to a provider
	 *
	 * @param address provider address
	 */
	public void setAddress( String address ) {
		this.address = address;
	}
	
	/**
	 * Get the provider town
	 *
	 * @return String
	 */
	public String getTown() {
		return town;
	}
	
	/**
	 * Se a new town to the provider
	 *
	 * @param town provider town
	 */
	public void setTown( String town ) {
		this.town = town;
	}
	
	/**
	 * Get the provider province
	 *
	 * @return String
	 */
	public String getProvince() {
		return province;
	}
	
	/**
	 * Set a new province to the provider
	 *
	 * @param province province town
	 */
	public void setProvince( String province ) {
		this.province = province;
	}
	
	/**
	 * Get the provider postal code
	 *
	 * @return String
	 */
	public String getPostalCode() {
		return postalCode;
	}
	
	/**
	 * Set a new postal code
	 *
	 * @param postalCode provider postal code
	 */
	public void setPostalCode( String postalCode ) {
		this.postalCode = postalCode;
	}
	
	/**
	 * Get the provider email
	 *
	 * @return String
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Set a new email to the provider
	 *
	 * @param email provider email
	 */
	public void setEmail( String email ) {
		this.email = email;
	}
	
	/**
	 * Get the provider password
	 *
	 * @return String
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Set a new password to the provider
	 *
	 * @param password provider password
	 */
	public void setPassword( String password ) {
		this.password = password;
	}
	
	/**
	 * Get the provider phone
	 *
	 * @return String
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Set a new phone to the provider
	 *
	 * @param phone phone number
	 */
	public void setPhone( String phone ) {
		this.phone = phone;
	}
	
	/**
	 * Get the provider mobile phone
	 *
	 * @return String
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * Set a new mobile to the provider
	 *
	 * @param mobile mobile number
	 */
	public void setMobile( String mobile ) {
		this.mobile = mobile;
	}
}
