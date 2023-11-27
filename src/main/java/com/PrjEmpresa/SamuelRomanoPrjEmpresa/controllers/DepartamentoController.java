package com.PrjEmpresa.SamuelRomanoPrjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PrjEmpresa.SamuelRomanoPrjEmpresa.entities.Departamento;
import com.PrjEmpresa.SamuelRomanoPrjEmpresa.services.DepartamentoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Departamentos", description = "API REST DE GERENCIAMENTO DE DEPARTAMENTOS")
@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}
	
	
	private final DepartamentoService departamentoService;
	

	@Autowired
	public DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}
	
	@PostMapping
	@Operation(summary ="Cadastra um departamento")
	public Departamento createDepartamento(@RequestBody Departamento departamento) {
		return departamentoService.saveDepartamento(departamento);
	}
	
	@GetMapping("/{id}")
	@Operation(summary ="Localiza departamento por ID")
	public ResponseEntity<Departamento> getDepartamento(@PathVariable Long id){
		Departamento departamento = departamentoService.getDepartamentoById(id);
		if(departamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@GetMapping
	@Operation(summary ="Cadastra um departamento")
	public ResponseEntity<List<Departamento>> getAllDepartamentos(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Departamento> departamento = departamentoService.getAllDepartamentos();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(departamento);
	}
	
	@PutMapping("/{id}")
	@Operation(summary ="Altera um departamento")
	public Departamento updateDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
	    return departamentoService.updateDepartamento(id, departamento);
	}
	
	

	
	@DeleteMapping("/{id}")
	@Operation(summary ="Exclui um deparamento")
	public void deleteDepartamento(@PathVariable Long id) {
		departamentoService.deleteDepartamento(id);
	}
	


}
