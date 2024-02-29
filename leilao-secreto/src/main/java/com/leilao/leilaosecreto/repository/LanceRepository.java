package com.leilao.leilaosecreto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.leilao.leilaosecreto.controller.dto.LanceDTO;
import com.leilao.leilaosecreto.model.Lance;

public interface LanceRepository extends JpaRepository<Lance, Long> {
	
	@Query("SELECT l FROM Lance l WHERE l.leilao.id = :leilaoId")
    public List<Lance> getLancesByLeilaoId(@Param("leilaoId") Long leilaoId);
    
    @Query("SELECT l FROM Lance l WHERE l.concorrente.id = :concorrenteId")
    public List<Lance> getLancesByConcorrenteId(@Param("concorrenteId") Long concorrenteId);
    
    @Query("SELECT COUNT(l) > 0 FROM Lance l WHERE l.leilao.id = :leilaoId")
	public Boolean leilaoExists(@Param("leilaoId") Long leilaoId);
	
	@Query("SELECT COUNT(l) > 0 FROM Lance l WHERE l.concorrente.id = :concorrenteId")
	public Boolean concorrenteExists(@Param("concorrenteId") Long concorrenteId);
	
	@Query("SELECT l.leilao.status FROM Lance l WHERE l.leilao.id = :leilaoId AND l.leilao.status = 'FECHADO'")
	public Boolean isLeilaoFechado(@Param("leilaoId") Long leilaoId);
	
	void deleteById(Long id);

}
