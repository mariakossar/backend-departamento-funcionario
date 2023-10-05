package com.utfpr.backenddepartamentofuncionario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

	@Column(name = "nome", nullable = false, length = 100)
	private String nomeFuncionario;

	@Column(name = "qtd_dependente")
	private int qtdeDependentes;

	@Column(name = "salario")
	private double salario;

	@Column(name = "cargo", length = 100)
	private String cargo;

	@OneToOne
	@JoinColumn(name = "cod_departamento", nullable = false)
	private Departamento departamento;

	public Funcionario() {

	}

	public Funcionario(String codigoFuncionario, String nomeFuncionario, int qtdeDependentes, double salario,
			String cargo, Departamento departamento) {
		this.nomeFuncionario = nomeFuncionario;
		this.qtdeDependentes = qtdeDependentes;
		this.salario = salario;
		this.cargo = cargo;
		this.departamento = departamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public int getQtdeDependentes() {
		return qtdeDependentes;
	}

	public void setQtdeDependentes(int qtdeDependentes) {
		this.qtdeDependentes = qtdeDependentes;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		cargo = cargo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	@Override
	public String toString() {
		return "Funcionario [id=" + this.id + ", nome=" + this.nomeFuncionario + ", qtdDependente=" + this.qtdeDependentes
				+ ", salario=" + this.salario + ", cargo=" + this.cargo + ", departamento=" + this.departamento + "]";
	}

}
