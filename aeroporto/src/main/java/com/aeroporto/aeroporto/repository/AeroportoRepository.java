package com.aeroporto.aeroporto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aeroporto.aeroporto.model.Aeroporto;

public interface AeroportoRepository extends JpaRepository<Aeroporto, Long> {

}
