package com.labtrackensino.javaweb.controller;

import com.labtrackensino.javaweb.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>,
		QuerydslPredicateExecutor<Carro> {
}
