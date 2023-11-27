package com.PrjEmpresa.SamuelRomanoPrjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrjEmpresa.SamuelRomanoPrjEmpresa.entities.Funcionario;
import com.PrjEmpresa.SamuelRomanoPrjEmpresa.repositories.FuncionarioRepository;



@Service
public class FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;
	
	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public Funcionario getFuncionarioById(Long Id) {
		return funcionarioRepository.findById(Id).orElse(null);
	}
	
	public Funcionario saveFuncionario(Funcionario Funcionario) {
		return funcionarioRepository.save(Funcionario);
	}
	
	public List<Funcionario> getAllFuncionarios(){
		return funcionarioRepository.findAll();
	}
	
	public void deleteFuncionario(Long id) {
		funcionarioRepository.deleteById(id);
	}
	
	public Funcionario updateFuncionario(Long id, Funcionario novoFuncionario) {
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
        if (funcionarioOptional.isPresent()) {
        	Funcionario funcionarioExistente = funcionarioOptional.get();
        	funcionarioExistente.setFunnome(novoFuncionario.getFunnome());          
        	funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());          
        	funcionarioExistente.setFunsalario(novoFuncionario.getFunsalario());          
            return funcionarioRepository.save(funcionarioExistente); 
        } else {
            return null; 
        }
    }
	
}
