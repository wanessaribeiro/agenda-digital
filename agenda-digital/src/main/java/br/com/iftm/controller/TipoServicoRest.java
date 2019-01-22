package br.com.iftm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iftm.entity.TipoServico;

@RestController // Habilita Classe com um serviço rest
@RequestMapping(value="/tiposervico") // Nome do serviço
public class TipoServicoRest {
	private List<TipoServico> lista = new ArrayList<>();
	private int indice = 1;
	
	// Create
	@PostMapping
	public ResponseEntity<?> create(@RequestBody TipoServico tipoServico){
		if(StringUtils.isEmpty(tipoServico.getNome())) {
			return ResponseEntity.badRequest().body("Nome Requerido!");
		}
		
		tipoServico.setCodigo(indice++);
		
		lista.add(tipoServico);
		
		return ResponseEntity.ok(tipoServico);
	}
	
	// Read
	@GetMapping
	public ResponseEntity<?> read(){
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/filtro/nome")
	public ResponseEntity<?> readByName(@PathParam("nome") String nome){
		if(StringUtils.isEmpty(nome)) {
			return ResponseEntity.badRequest().body("Nome Requerido!");
		}
		
		List<TipoServico> temp = new ArrayList<>();
		
		for (TipoServico tipoServico : lista) {
			if(tipoServico.getNome().toLowerCase().contains(nome.toLowerCase())) {
				temp.add(tipoServico);
			}
		}
		
		return ResponseEntity.ok(temp);
	}
	
	
	// Update
	@PutMapping
	public ResponseEntity<?> update(@RequestBody TipoServico tipoServico){
		if(tipoServico.getCodigo() == null) {
			return ResponseEntity.badRequest().body("Codigo Requerido!");
		}
		
		if(StringUtils.isEmpty(tipoServico.getNome())) {
			return ResponseEntity.badRequest().body("Nome Requerido!");
		}
		
		for (TipoServico tipoServico2 : lista) {
			if(tipoServico2.getCodigo().equals(tipoServico.getCodigo())){
				tipoServico2.setNome(tipoServico.getNome());
			}
		}
		
		return ResponseEntity.ok(tipoServico);
	}
	
	// Delete
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		if(id == null) {
			return ResponseEntity.badRequest().body("Codigo Requerido!");
		}
		
		for (int i=0; i < lista.size(); i++) {
			if(lista.get(i).getCodigo().equals(id)){
				lista.remove(i);
				break;
			}
		}
		
		return ResponseEntity.ok().build();
	}
}
