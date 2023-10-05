package com.utfpr.backenddepartamentofuncionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utfpr.backenddepartamentofuncionario.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
