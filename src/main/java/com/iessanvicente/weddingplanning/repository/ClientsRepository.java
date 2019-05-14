package com.iessanvicente.weddingplanning.repository;

import com.iessanvicente.weddingplanning.entity.ClientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientsRepository extends JpaRepository<ClientsEntity, Long> {
	String sqlFindByLogin = "SELECT " +
			"c.id," +
			"c.dni," +
			"c.email," +
			"c.password," +
			"c.nombre," +
			"c.apellidos," +
			"c.direccion," +
			"c.poblacion," +
			"c.provincia," +
			"c.cp," +
			"c.fnac," +
			"c.edad," +
			"c.telefono," +
			"c.movil " +
			"FROM " +
			"clientes c " +
			"WHERE  " +
			"c.email = ?1 " +
			"AND  " +
			"c.password = ?2";
	@Query( value=sqlFindByLogin, nativeQuery = true )
	Optional<ClientsEntity> findByLogin( String email, String password );
	
	String sqlFindByEmail = "SELECT " +
			"c.id," +
			"c.dni," +
			"c.email," +
			"c.nombre," +
			"c.apellidos," +
			"c.direccion," +
			"c.poblacion," +
			"c.provincia," +
			"c.cp," +
			"c.fnac," +
			"c.edad," +
			"c.telefono," +
			"c.movil " +
			"FROM " +
			"clientes c " +
			"WHERE  " +
			"c.email = ?1";
	@Query( value=sqlFindByEmail, nativeQuery = true )
	Optional<List<ClientsEntity>> findByEmail( String email );
}