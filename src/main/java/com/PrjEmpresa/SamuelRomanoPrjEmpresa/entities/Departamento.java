package com.PrjEmpresa.SamuelRomanoPrjEmpresa.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="departamento")
public class Departamento {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long depcodigo;
	
	@NotBlank
	@NotNull
	@Size(max = 50, message = "Máximo de 50 caracteres")
	private String depnome;

	
	public Long getDepcodigo() {
		return depcodigo;
	}

	public void setDepcodigo(Long depcodigo) {
		this.depcodigo = depcodigo;
	}

	public String getDepnome() {
		return depnome;
	}

	public void setDepnome(String depnome) {
		this.depnome = depnome;
	}


}
