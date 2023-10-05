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
	
	public List<Funcionario> buscarTodos(){
		return repository.findAll();
	}

	/*
	public Funcionario[] buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}*/

}
