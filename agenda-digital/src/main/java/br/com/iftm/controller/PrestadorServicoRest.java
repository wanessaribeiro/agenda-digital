package br.com.iftm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.PrestadorServicoBusiness;
import br.com.iftm.entity.PrestadorServico;

@RestController
@RequestMapping(value = "/prestador")
public class PrestadorServicoRest {

	@Autowired
	private PrestadorServicoBusiness business;

	// Create
	@PostMapping
	public ResponseEntity<?> create(@RequestBody PrestadorServico preSer) {
		try {
			preSer = business.create(preSer);
			return ResponseEntity.ok(preSer);
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}

	// Read
	@GetMapping
	public ResponseEntity<?> read() {
		try {
			return ResponseEntity.ok(business.read());
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}

	// Update
	@PutMapping
	public ResponseEntity<?> update(@RequestBody PrestadorServico preSer) {
		try {
			return ResponseEntity.ok(business.update(preSer));
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}

	// Delete
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		try {
			business.delete(id);
			return ResponseEntity.ok().build();
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}

}
