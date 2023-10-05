package com.utfpr.backenddepartamentofuncionario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "departamento")
@Data
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_departamento", nullable = false)
	private Long id;
	
	/*
	@Column(nullable = false, unique = true, length = 50)
	private String codigoDepartamento;*/
	
	@Column (name = "nome",nullable = false, length = 100)
	private String nomeDepartamento;

	public Departamento() {	
	}
	
	public Departamento(String nome) {
		this.nomeDepartamento = nome;
	}
	
	public String getNome() {
		return nomeDepartamento;
	}
	public void setNome(String nome) {
		this.nomeDepartamento = nome;
	}
	
	@Override
	public String toString() {
		return "Departamento [id=" + this.id + ", nome=" + this.nomeDepartamento + "]";
	}
}
