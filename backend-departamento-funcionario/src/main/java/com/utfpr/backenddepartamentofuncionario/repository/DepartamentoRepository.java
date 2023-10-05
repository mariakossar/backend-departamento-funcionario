package com.utfpr.backenddepartamentofuncionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utfpr.backenddepartamentofuncionario.entity.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
