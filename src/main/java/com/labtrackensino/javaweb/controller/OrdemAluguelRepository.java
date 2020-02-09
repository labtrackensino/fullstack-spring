package com.labtrackensino.javaweb.controller;

import com.labtrackensino.javaweb.model.OrdemAluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemAluguelRepository extends JpaRepository<OrdemAluguel, Long> {
}
