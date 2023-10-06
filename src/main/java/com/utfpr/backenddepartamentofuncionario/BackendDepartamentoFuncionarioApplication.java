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

			Log.info("1 - Listar um funcionário pelo seu nome e quantidade de dependentes utilizando consulta\n"
					+ "por palavras-chaves.");
			Log.info("---------------------------------");
			for (Funcionario funcionario : funcionarioService.findByNomeFuncionarioAndQtdDependente("João", 3))
				Log.info(funcionario.toString());
			Log.info("");

			Log.info("2 - Listar todos os funcionários de um determinado departamento por JPQL via @Query");
			Log.info("---------------------------------");
			for(Funcionario funcionario : funcionarioService.findAllByNomeDepartamento("Finanças"))
				Log.info(funcionario.toString());
			Log.info("");
			
			Log.info("3- Listar o primeiro departamento cadastrado");
			Log.info("---------------------------------");
			Log.info(departamentoService.findFirstBy().toString());
			Log.info("");
			
			Log.info("4- Listar o primeiro funcionário que tem o maior salário");
			Log.info("---------------------------------");
			Log.info(funcionarioService.findTopByOrderBySalarioDesc().toString());
			Log.info("");
			
			Log.info("5. Listar os 3 (três) primeiros funcionários que tem os maiores salários.");
			Log.info("----------------------------------");
			for (Funcionario funcionario : funcionarioService.findFirst3ByOrderBySalarioDesc())
				Log.info(funcionario.toString());
			Log.info("");
			
			Log.info("6 - Listar os funcionários que não tem dependentes em ordem crescente de nome por JPQL via @Query.");
			Log.info("----------------------------------");
			for(Funcionario funcionario : funcionarioService.findByFuncionarioSemQtdDependente())
				Log.info(funcionario.toString());
			Log.info("");
			
			Log.info("7 - Listar os funcionários que tem salário maior que um determinado valor por"
					+ " JPQL sobrescrevendo palavras-chaves @Query.");
			Log.info("----------------------------------");
			for(Funcionario funcionario : funcionarioService.findByFuncionarioMaiorSalario(2000.0F))
				Log.info(funcionario.toString());
			Log.info("");
			
			Log.info("8 - Listar os funcionários que tem salário maior que um determinado valor por @Query com native query.");
			Log.info("----------------------------------");
			for(Funcionario funcionario : funcionarioService.findByFuncionarioMaiorSalarioNative(4000.0F))
				Log.info(funcionario.toString());
			Log.info("");
			
			Log.info("9 - Alterar a classe Funcionario e criar uma consulta para listar os funcionários com uma determinada "
					+ "quantidade de dependentes por @NamedQuery.");
			Log.info("----------------------------------");
			for(Funcionario funcionario : funcionarioService.findByQtdDependente(2))
				Log.info(funcionario.toString());
			Log.info("");
			
			Log.info("10 - Alterar a classe Funcionario e criar uma consulta para listar os funcionários que contenham em qualquer "
					+ "parte do seu nome um determinado nome por@NamedNativeQuery.");
			Log.info("----------------------------------");
			for(Funcionario funcionario : funcionarioService.findByNomeFuncionario("an"))
				Log.info(funcionario.toString());
			Log.info("");
				
	};
		};
		
			
	
	}
