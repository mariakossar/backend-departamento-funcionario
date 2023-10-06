package com.utfpr.backenddepartamentofuncionario.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "departamento")
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	@Column (name = "nome_departamento", nullable = false, length = 100)
	private String nomeDepartamento;

	@Override
	public String toString() {
		return "Departamento [id=" + this.id + ", nome=" + this.nomeDepartamento + "]";
	}
}