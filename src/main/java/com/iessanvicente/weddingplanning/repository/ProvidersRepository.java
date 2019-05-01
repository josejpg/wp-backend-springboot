package com.iessanvicente.weddingplanning.repository;

import com.iessanvicente.weddingplanning.entity.ProvidersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidersRepository extends JpaRepository<ProvidersEntity, Long> {}