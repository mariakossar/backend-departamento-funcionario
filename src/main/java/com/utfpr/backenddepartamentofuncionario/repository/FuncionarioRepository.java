package com.utfpr.backenddepartamentofuncionario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utfpr.backenddepartamentofuncionario.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	// 1- Listar um funcionário pelo seu nome e quantidade de dependentes utilizando consulta por palavras-chaves.
	List<Funcionario> findByNomeFuncionarioAndQtdDependente(String nomeFuncionario, Integer qtdDependente);
	
	//2- Listar todos os funcionários de um determinado departamento por JPQL via @Query
	@Query("SELECT f FROM Funcionario f WHERE f.departamento.nomeDepartamento = :nomeDepartamento")
    List<Funcionario> findAllByNomeDepartamento(@Param("nomeDepartamento") String nomeDepartamento);
	
	//4 - Listar o primeiro funcionário que tem o maior salário.
	Funcionario findTopByOrderBySalarioDesc();
	
	// 5 - Listar os 3 (três) primeiros funcionários que tem os maiores salários.
	List <Funcionario> findFirst3ByOrderBySalarioDesc();
	
	// 6 - Listar os funcionários que não tem dependentes em ordem crescente de nome por JPQL via @Query.
	@Query("SELECT f FROM Funcionario f WHERE qtdDependente <= 0 ORDER BY f.nomeFuncionario ASC")
	List<Funcionario> findByFuncionarioSemQtdDependente();
	
	// 7 - Listar os funcionários que tem salário maior que um determinado valor por JPQL sobrescrevendo palavras-chaves @Query.
	@Query("SELECT f FROM Funcionario f WHERE f.salario > ?1")
	List<Funcionario> findByFuncionarioMaiorSalario(Float salario);
	
	//8 - Listar os funcionários que tem salário maior que um determinado valor por @Query com native query.
	@Query(value = "SELECT * FROM Funcionario WHERE salario > ?1", nativeQuery = true)
	List<Funcionario> findByFuncionarioMaiorSalarioNative(Float salario);
	
	// 9 - Alterar a classe Funcionario e criar uma consulta para listar os funcionários com uma determinada quantidade de 
	//dependentes por @NamedQuery.
	@Query(name = "Funcionario.byQtdDependente ")
	List<Funcionario> findByQtdDependente(Integer qtdDependente);
	
	// 10 - Alterar a classe Funcionario e criar uma consulta para listar os funcionários que contenham em qualquer
	//parte do seu nome um determinado nome por@NamedNativeQuery.
	@Query(name = "funcionario.byNomeFuncionario")
	List<Funcionario> findByNomeFuncionario(String nomeFuncionario);
}
