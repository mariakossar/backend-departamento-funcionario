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
	
	// 1 - Listar um funcionário pelo seu nome e quantidade de dependentes utilizando consulta por palavras-chaves.	
	public List<Funcionario> findByNomeFuncionarioAndQtdDependente(String nomeFuncionario, Integer qtdDependente){
		return repository.findByNomeFuncionarioAndQtdDependente(nomeFuncionario, qtdDependente);
	}
	
	//2 - Listar todos os funcionários de um determinado departamento por JPQL via @Query
	public List<Funcionario>findAllByNomeDepartamento(String nomeDepartamento){
		return repository.findAllByNomeDepartamento(nomeDepartamento);
	}
	
	//4 - Listar o primeiro funcionário que tem o maior salário.
	public Funcionario findTopByOrderBySalarioDesc() {
		return repository.findTopByOrderBySalarioDesc();
	}
	
	// 5 - Listar os 3 (três) primeiros funcionários que tem os maiores salários.
	public List<Funcionario> findFirst3ByOrderBySalarioDesc() {
		return repository.findFirst3ByOrderBySalarioDesc();
	}
	
	// 6 - Listar os funcionários que não tem dependentes em ordem crescente de nome por JPQL via @Query.
	public List<Funcionario> findByFuncionarioSemQtdDependente(){
		return repository.findByFuncionarioSemQtdDependente();
	}
	
	// 7 - Listar os funcionários que tem salário maior que um determinado valor por JPQL sobrescrevendo palavras-chaves @Query.
	public List<Funcionario> findByFuncionarioMaiorSalario(Float salario){
		return repository.findByFuncionarioMaiorSalario(salario);
	}
	
	//8 - Listar os funcionários que tem salário maior que um determinado valor por @Query com native query.
	public List<Funcionario> findByFuncionarioMaiorSalarioNative(Float salario){
		return repository.findByFuncionarioMaiorSalarioNative(salario);
	}
	
	// 9 - Alterar a classe Funcionario e criar uma consulta para listar os funcionários com uma determinada quantidade de dependentes por @NamedQuery.
	public List<Funcionario> findByQtdDependente(Integer qtdDependente){
		return repository.findByQtdDependente(qtdDependente);
	}
	
	// 10 - Alterar a classe Funcionario e criar uma consulta para listar os funcionários que contenham em qualquer
	//parte do seu nome um determinado nome por@NamedNativeQuery.
	public List<Funcionario> findByNomeFuncionario(String nomeFuncionario){
		return repository.findByNomeFuncionario(nomeFuncionario);
	}
	
	public List<Funcionario> buscarTodos(){
		return repository.findAll();
	}


}
