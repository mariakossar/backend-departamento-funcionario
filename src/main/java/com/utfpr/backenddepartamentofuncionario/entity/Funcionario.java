package com.utfpr.backenddepartamentofuncionario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "funcionario")
@Data
public class Funcionario {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_funcionario", nullable = false)
	private Long id;

	@Column(name = "nome_funcionario", nullable = false, length = 100)
	private String nomeFuncionario;

	@Column(name = "qtd_dependente")
	private Integer qtdDependente;

	@Column(name = "salario")
	private float salario;

	@Column(name = "cargo", length = 100)
	private String cargo;

	@ManyToOne
	@JoinColumn(name = "cod_departamento", nullable = false)
	private Departamento departamento;	
	
	@Override
	public String toString() {
		return "Funcionario [id=" + this.id + ", nome=" + this.nomeFuncionario + ", qtdDependente=" + this.qtdDependente
				+ ", salario=" + this.salario + ", cargo=" + this.cargo + ", departamento=" + this.departamento + "]";
	}

}
