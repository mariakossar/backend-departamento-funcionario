package com.utfpr.backenddepartamentofuncionario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utfpr.backenddepartamentofuncionario.entity.Departamento;
import com.utfpr.backenddepartamentofuncionario.repository.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository repository;
	
	//3- Listar o primeiro departamento cadastrado
		public Departamento findFirstBy(){
			return repository.findFirstBy();
		}
		

}
