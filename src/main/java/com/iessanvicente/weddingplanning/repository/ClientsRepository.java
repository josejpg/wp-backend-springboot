package com.iessanvicente.weddingplanning.repository;

import com.iessanvicente.weddingplanning.entity.ClientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<ClientsEntity, Long> {}