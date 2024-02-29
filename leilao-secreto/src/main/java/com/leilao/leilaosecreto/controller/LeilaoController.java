package com.leilao.leilaosecreto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.leilao.leilaosecreto.controller.dto.LeilaoDTO;
import com.leilao.leilaosecreto.controller.dto.VencedorLeilaoDTO;
import com.leilao.leilaosecreto.controller.form.LeilaoForm;
import com.leilao.leilaosecreto.model.Leilao;
import com.leilao.leilaosecreto.repository.LeilaoRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/leilao")
public class LeilaoController {
	
	@Autowired
	LeilaoRepository repository;
	
	@GetMapping
	public List<Leilao> listarLeiloes() {
		List<Leilao> listaLeiloes = repository.findAll();
		return listaLeiloes;
	}
	
	@PostMapping()
	public ResponseEntity<LeilaoDTO> cadastrar(@RequestBody LeilaoForm form, UriComponentsBuilder uriBuilder) {
		Leilao leilao = form.toLeilao();
		repository.save(leilao);
		
		URI uri = uriBuilder.path("/leilao/{id}").buildAndExpand(leilao.getId()).toUri();
		return ResponseEntity.created(uri).body(new LeilaoDTO(leilao));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LeilaoDTO> pegarPorId(@PathVariable Long id) {
		//Optional -> Pode ser que tenha o registro pode ser que não tenha
		//Elimina o erro caso o parâmetro passado não exista
		Optional<Leilao> leilao = repository.findById(id);
		
		if (leilao.isPresent()) {
			return ResponseEntity.ok(new LeilaoDTO(leilao.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<LeilaoDTO> atualizar(@PathVariable Long id, @RequestBody LeilaoForm form) {
		Optional<Leilao> optional = repository.findById(id);
		
		if (optional.isPresent()) {
			Leilao leilao = form.atualizar(id, repository);
			return ResponseEntity.ok(new LeilaoDTO(leilao));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Leilao> optional = repository.findById(id);
		
		if (optional.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<VencedorLeilaoDTO> vencedorLeilao(@PathVariable Long id) {
//		// Verificar se o ID do leilão foi fornecido
//	    if (id == null) {
//	        return ResponseEntity.badRequest().build();
//	    }
//
//	    // Verificar se o leilão existe
//	    Optional<Leilao> optional = repository.findById(id);
//	    if (optional.isEmpty()) {
//	        return ResponseEntity.notFound().build();
//	    }
//
//	    // Verificar se o leilão está fechado
//	    Leilao leilao = optional.get();
//	    if ("Fechado".equals(leilao.getStatus())) {
//	        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
//	    }
//
//	    // Obter o vencedor do leilão
//	    List<VencedorLeilaoDTO> resultados = repository.getVencedorLeilao(id);
//	    if (!resultados.isEmpty()) {
//	        VencedorLeilaoDTO resultado = resultados.get(0); // Pegar o primeiro resultado, assumindo que apenas um é retornado
//	        return ResponseEntity.ok(resultado);
//	    }
//
//	    return ResponseEntity.notFound().build();
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VencedorLeilaoDTO> vencedorLeilao(@PathVariable Long id) {
		// Verificar se o ID do leilão foi fornecido
	    if (id == null) {
	        return ResponseEntity.badRequest().build();
	    }

	    // Verificar se o leilão existe
	    Optional<Leilao> optional = repository.findById(id);
	    if (optional.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }

	    // Verificar se o leilão está fechado
	    Leilao leilao = optional.get();
	    if ("Fechado".equals(leilao.getStatus())) {
	        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	    }

	    // Obter o vencedor do leilão
	    List<Leilao> resultados = repository.getVencedorLeilao(id);
	    if (!resultados.isEmpty()) {
	        Leilao resultado = resultados.get(0); // Pegar o primeiro resultado, assumindo que apenas um é retornado
	        
	        VencedorLeilaoDTO vencedor = new VencedorLeilaoDTO(resultado);
	        
	        return ResponseEntity.ok(vencedor);
	    }

	    return ResponseEntity.notFound().build();
	}
	
}
