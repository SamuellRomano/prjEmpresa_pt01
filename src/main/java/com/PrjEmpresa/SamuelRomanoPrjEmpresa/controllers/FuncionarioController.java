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

import com.PrjEmpresa.SamuelRomanoPrjEmpresa.entities.Funcionario;
import com.PrjEmpresa.SamuelRomanoPrjEmpresa.services.FuncionarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Funcionarios", description = "API REST DE GERENCIAMENTO DE FUNCIONÁRIOS")
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}
	
	
	private final FuncionarioService funcionarioService;
	

	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	
	
	@PostMapping
	@Operation(summary ="Cadastra um funcionario")
	public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioService.saveFuncionario(funcionario);
	}
	
	@GetMapping("/{id}")
	@Operation(summary ="Localiza funcionario por ID")
	public ResponseEntity<Funcionario> getFuncionario(@PathVariable Long id){
		Funcionario funcionario = funcionarioService.getFuncionarioById(id);
		if(funcionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@GetMapping
	@Operation(summary ="Apresenta funcionario por ID")
	public ResponseEntity<List<Funcionario>> getAllFuncionarios(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Funcionario> funcionario = funcionarioService.getAllFuncionarios();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(funcionario);
	}
	
	@PutMapping("/{id}")
	@Operation(summary ="Altera um funcionario")
	public Funcionario updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
	    return funcionarioService.updateFuncionario(id, funcionario);
	}
	
	

	
	@DeleteMapping("/{id}")
	@Operation(summary ="Exclui um funcionario")
	public void deleteFuncionario(@PathVariable Long id) {
		funcionarioService.deleteFuncionario(id);
	}
	



}
