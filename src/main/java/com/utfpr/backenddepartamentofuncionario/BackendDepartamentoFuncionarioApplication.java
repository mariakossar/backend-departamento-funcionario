package com.utfpr.backenddepartamentofuncionario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	public CommandLineRunner demo(DepartamentoService departamentoService, FuncionarioService funcionarioService) {
		return (arg) -> {
			
			Log.info("");
			Log.info("");
			Log.info("============= Listagem de todos os FUNCIONARIOS =============");
			for (Funcionario funcionario : funcionarioService.listarTodosFuncionarios())
				Log.info(funcionario.toString());
			
			Log.info("");
			Log.info("");
			Log.info("1 -  Uma procedure que aumenta o salário de todos os funcionários em X porcento, \"\n"
					+ "					+ \"onde X é um número inteiro.");
			funcionarioService.aumentarSalario(10);
			
			Log.info("");
			Log.info("");
			Log.info("============= Listagem de todos os FUNCIONARIOS após executar Procedure =============");
			for (Funcionario funcionario : funcionarioService.listarTodosFuncionarios())
				Log.info(funcionario.toString());
			
			Log.info("");
			Log.info("");
			Log.info("============= 2. Uma consulta que lista todos os funcionários de um determinado departamento "
					+ "que não possuam dependentes utilizando parâmetros nomeados. =============");
			for (Funcionario funcionario : funcionarioService.findByFuncionarioSemDependenteCodDepartamento(1L))
				Log.info(funcionario.toString());
			
			Log.info("");
			Log.info("");
			Log.info("============= //3. Uma instrução de update que troca todos os funcionários de um determinado\n"
					+ "	departamento para outro departamento utilizando a anotação @Modifying.");
			int registrosAfetadosUpdate = funcionarioService.updateFuncionarioByDepartamentoCodDepartamento(1L, 2L);
			Log.info("Registros afetados update: " + registrosAfetadosUpdate);
			

			Log.info("");
			Log.info("");
			Log.info("============= 4. Uma instrução de delete que exclui todos os funcionários de um determinado\n"
					+ "departamento utilizando a anotação @Modifying");
			int registrosAfetadosDelete = funcionarioService.deleteFuncionarioByDepartamentoCodDepartamento(1L);
			Log.info("Registros afetados delete: " + registrosAfetadosDelete);
			
	};
		};
		
			
	
	}
