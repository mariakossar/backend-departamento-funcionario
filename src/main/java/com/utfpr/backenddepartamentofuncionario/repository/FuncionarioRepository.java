package com.utfpr.backenddepartamentofuncionario.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.utfpr.backenddepartamentofuncionario.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	String SELECT = null;
	// 1- . Uma procedure que aumenta o salário de todos os funcionários em X porcento, onde X é um número inteiro.
	@Procedure ("proc_aumentar_salario")
	void procAumentarSalario(Integer valorPorcentagem);
	
	//2. Uma consulta que lista todos os funcionários de um determinado departamento que não possuam dependentes utilizando parâmetros nomeados"
	@Query("SELECT f FROM Funcionario f WHERE f.departamento.id = :codDepartamento AND f.qtdDependente = 0")
	List<Funcionario> findByFuncionarioSemDependenteCodDepartamento(@Param("codDepartamento")Long codDepartamento);
	
	//3. Uma instrução de update que troca todos os funcionários de um determinado
	//departamento para outro departamento utilizando a anotação @Modifying.
	@Modifying
	@Transactional
	@Query("update Funcionario f set f.departamento.id = ?1 where f.departamento.id = ?2")
	int updateFuncionarioByDepartamento(Long codDepartamentoNew, Long codDepartamentoOld);
	
	//4. Uma instrução de delete que exclui todos os funcionários de um determinado
	//departamento utilizando a anotação @Modifying.
	@Modifying
	@Transactional 
	@Query("delete from Funcionario f where f.departamento.id = ?1")
	int deleteFuncionarioByDepartamentoCodDepartamento(Long codDepartamento);
	
	
}

