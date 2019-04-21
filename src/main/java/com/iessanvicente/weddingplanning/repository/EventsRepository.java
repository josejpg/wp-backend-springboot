package com.iessanvicente.weddingplanning.repository;

import com.iessanvicente.weddingplanning.entity.EventsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<EventsEntity, Long> {}