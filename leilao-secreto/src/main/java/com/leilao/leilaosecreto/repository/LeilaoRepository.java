package com.leilao.leilaosecreto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leilao.leilaosecreto.model.Leilao;

public interface LeilaoRepository extends JpaRepository<Leilao, Long> {

}
