package com.utfpr.backenddepartamentofuncionario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utfpr.backenddepartamentofuncionario.entity.Departamento;
import com.utfpr.backenddepartamentofuncionario.repository.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository repository;
	
	public List<Departamento> buscarTodos(){
		return repository.findAll();
	}

	/*
	public Departamento[] buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}*/
}
