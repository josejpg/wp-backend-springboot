package com.iessanvicente.weddingplanning.repository;

import com.iessanvicente.weddingplanning.entity.ServicesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<ServicesEntity, Long> {}