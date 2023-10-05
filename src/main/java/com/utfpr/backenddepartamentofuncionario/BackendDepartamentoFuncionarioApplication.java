package com.utfpr.backenddepartamentofuncionario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.utfpr.backenddepartamentofuncionario.entity.Departamento;
import com.utfpr.backenddepartamentofuncionario.entity.Funcionario;
import com.utfpr.backenddepartamentofuncionario.service.DepartamentoService;
import com.utfpr.backenddepartamentofuncionario.service.FuncionarioService;

@SpringBootApplication
public class BackendDepartamentoFuncionarioApplication {
	
	private static final Logger Log = LoggerFactory.getLogger(BackendDepartamentoFuncionarioApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendDepartamentoFuncionarioApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(DepartamentoService departamentoService,
									FuncionarioService funcionarioService) {
		return (arg) -> {
			
			Log.info("Listagem de todos os departamento");
			Log.info("---------------------------------");
			for(Departamento departamento : departamentoService.buscarTodos())
				Log.info(departamento.toString());
			Log.info("");
			
			Log.info("Listagem de todos os funcionários");
			Log.info("---------------------------------");
			for(Funcionario funcionario : funcionarioService.buscarTodos())
				Log.info(funcionario.toString());
			Log.info("");
			
		};
	}

}
