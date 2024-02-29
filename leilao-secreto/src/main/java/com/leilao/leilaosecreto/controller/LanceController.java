package com.leilao.leilaosecreto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.leilao.leilaosecreto.controller.dto.LanceDTO;
import com.leilao.leilaosecreto.controller.dto.LeilaoDTO;
import com.leilao.leilaosecreto.controller.form.LanceForm;
import com.leilao.leilaosecreto.model.Lance;
import com.leilao.leilaosecreto.repository.LanceRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/lance")
public class LanceController {
	
	@Autowired
	LanceRepository repository;
	
	@GetMapping
	public List<Lance> listarLances() {
		List<Lance> listaLances = repository.findAll();
		return listaLances;
	}
	
	@PostMapping()
	public ResponseEntity<LanceDTO> cadastrar(@RequestBody LanceForm form, UriComponentsBuilder uriBuilder) {
		Lance lance = form.toLance();
		repository.save(lance);
		
		URI uri = uriBuilder.path("/lance/{id}").buildAndExpand(lance.getId()).toUri();
		return ResponseEntity.created(uri).body(new LanceDTO(lance));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LanceDTO> pegarPorId(@PathVariable Long id) {
		//Optional -> Pode ser que tenha o registro pode ser que não tenha
		//Elimina o erro caso o parâmetro passado não exista
		Optional<Lance> lance = repository.findById(id);
		
		if (lance.isPresent()) {
			return ResponseEntity.ok(new LanceDTO(lance.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/leilao={id}")
	public ResponseEntity<List<LanceDTO>> pegarLancesPorIdLeilao(@PathVariable Long leilaoId) {
		List<Lance> lances = repository.getLancesByLeilaoId(leilaoId);
		
        if (lances.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        List<LanceDTO> lancesDTO = lances.stream().map(LanceDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(lancesDTO);
	}
	
	@GetMapping("/concorrente={id}")
	public ResponseEntity<List<LanceDTO>> pegarLancesPorIdConcorrente(@PathVariable Long concorrenteId) {
		List<Lance> lances = repository.getLancesByConcorrenteId(concorrenteId);
		
        if (lances.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        List<LanceDTO> lancesDTO = lances.stream().map(LanceDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(lancesDTO);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<LanceDTO> atualizar(@PathVariable Long id, @RequestBody LanceForm form) {
		Long idConcorrente = form.getConcorrente().getId();
		Long idLeilao = form.getLeilao().getId();
		
		// Verifica se o ID do lance está presente
        if (id == null) {
            return ResponseEntity.notFound().build();
        }
        
        // Verifica se o ID do leilão existe
        if (!repository.leilaoExists(idLeilao)) {
            return ResponseEntity.badRequest().build();
        }
        
        // Verifica se o ID do concorrente existe
        if (!repository.concorrenteExists(idConcorrente)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        // Verifica se o leilão está aberto
        if (repository.isLeilaoFechado(idLeilao)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        // Atualiza o lance e retorna o DTO atualizado
        Lance lance = form.atualizar(idLeilao, repository);
        if (lance == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(new LanceDTO(lance));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		// Verifica se o ID do lance está presente
        if (id == null) {
            return ResponseEntity.notFound().build();
        }
        
        // Verifica se o lance existe
        Optional<Lance> lance = repository.findById(id);
		
		if (!lance.isPresent()) {
			return ResponseEntity.notFound().build();
		}
        
        // Verifica se o leilão do lance está fechado
        if (lance.isPresent() && repository.isLeilaoFechado(lance.get().getLeilao().getId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        
        repository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
