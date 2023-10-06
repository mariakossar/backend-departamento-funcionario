package com.utfpr.backenddepartamentofuncionario.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utfpr.backenddepartamentofuncionario.entity.Funcionario;
import com.utfpr.backenddepartamentofuncionario.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repository;
	
	// 1 - . Uma procedure que aumenta o salário de todos os funcionários em X porcento, onde X é um número inteiro.
	public void aumentarSalario(Integer valorPorcentagem) {
		repository.procAumentarSalario(valorPorcentagem);
	}
		
	// 2. Uma consulta que lista todos os funcionários de um determinado
	// departamento que não possuam dependentes utilizando parâmetros nomeados.
	
	public List<Funcionario> findByFuncionarioSemDependenteCodDepartamento(Long codDepartamento){
	return repository.findByFuncionarioSemDependenteCodDepartamento(codDepartamento);
	}
	
	// 3. Uma instrução de update que troca todos os funcionários de um determinado
	// departamento para outro departamento utilizando a anotação @Modifying.
	
	public int updateFuncionarioByDepartamentoCodDepartamento(Long codDepartamentoNew, Long codDepartamentoOld) {
		return repository.updateFuncionarioByDepartamento(codDepartamentoNew, codDepartamentoNew);	
	}
	
	//4. Uma instrução de delete que exclui todos os funcionários de um determinado
	//departamento utilizando a anotação @Modifying.
	
	public int deleteFuncionarioByDepartamentoCodDepartamento(Long codDepartamento) {
		return repository.deleteFuncionarioByDepartamentoCodDepartamento(codDepartamento);
	}
	
	
	
	



	public List<Funcionario> listarTodosFuncionarios() {
		return repository.findAll();
	}

	


}
