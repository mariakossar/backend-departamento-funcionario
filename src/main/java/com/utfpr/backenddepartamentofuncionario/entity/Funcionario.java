package com.utfpr.backenddepartamentofuncionario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.Data;

@Entity
@Table(name = "funcionario")
@Data
@NamedQuery(
	name = "Funcionario.byQtdDependente",
	query = "from Funcionario f WHERE f.qtdDependente = ?1")
@NamedNativeQuery(
	name = "Funcionario.byNomeFuncionario",
	query = "SELECT * from Funcionario f WHERE nomeFuncionario like '%' ?1 '%'",
	resultClass = Funcionario.class)
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

	@OneToOne
	@JoinColumn(name = "cod_departamento", nullable = false)
	private Departamento departamento;	
	
	@Override
	public String toString() {
		return "Funcionario [id=" + this.id + ", nome=" + this.nomeFuncionario + ", qtdDependente=" + this.qtdDependente
				+ ", salario=" + this.salario + ", cargo=" + this.cargo + ", departamento=" + this.departamento + "]";
	}

}
