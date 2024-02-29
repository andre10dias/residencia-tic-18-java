package com.leilao.leilaosecreto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.leilao.leilaosecreto.controller.dto.VencedorLeilaoDTO;
import com.leilao.leilaosecreto.model.Leilao;

public interface LeilaoRepository extends JpaRepository<Leilao, Long> {
	
//	@Query("""
//			   SELECT le, max(la.valor) as valor_max_lance, co
//				FROM Leilao le
//				INNER JOIN Lance la ON le.id = la.id_leilao
//				INNER JOIN Concorrente co ON la.id_concorrente = co.id
//				WHERE le.id = :leilaoId
//				GROUP BY le.id, le.descricao, le.valorMinimo, le.status, co.id, co.nome, co.cpf
//            """)
//	List<Leilao> getVencedorLeilao(Long leilaoId);

}
