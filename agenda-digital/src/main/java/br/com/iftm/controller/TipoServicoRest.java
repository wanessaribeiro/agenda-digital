package br.com.iftm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iftm.entity.TipoServico;

@RestController // Habilita Classe com um serviço rest
@RequestMapping(value="/tiposervico") // Nome do serviço
public class TipoServicoRest {
	private List<TipoServico> lista = new ArrayList<>();
	
	// Create
	@PostMapping
	public ResponseEntity<?> create(@RequestBody TipoServico tipoServico){
		if(StringUtils.isEmpty(tipoServico.getNome())) {
			return ResponseEntity.badRequest().body("Nome Requerido!");
		}
		
		tipoServico.setCodigo(UUID.randomUUID().variant());
		
		lista.add(tipoServico);
		
		return ResponseEntity.ok(tipoServico);
	}
	// Read
	// Update
	// Delete
}
