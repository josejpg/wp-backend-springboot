package com.iessanvicente.weddingplanning.repository;

import com.iessanvicente.weddingplanning.entity.ClientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientsRepository extends JpaRepository<ClientsEntity, Long> {
	
	@Query( value="SELECT DISTINCT cliente " +
					"FROM proyectobd.clientes cliente " +
					"WHERE cliente.email = :email " +
					"AND cliente.password = :password", nativeQuery = true )
	Optional<ClientsEntity> findByLogin( @Param( "email" ) final String email, @Param( "password" ) final String
	password );
	
	@Query( value="SELECT DISTINCT cliente " +
					"FROM proyectobd.clientes cliente " +
					"WHERE cliente.email = :email",
			nativeQuery = true )
	Optional<List<ClientsEntity>> findByEmail( @Param( "email" ) final String email );
}