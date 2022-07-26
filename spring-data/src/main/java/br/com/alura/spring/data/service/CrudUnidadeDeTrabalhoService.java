package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.UnidadeDeTrabalho;
import br.com.alura.spring.data.repository.UnidadeDeTrabalhoRepository;

@Service
public class CrudUnidadeDeTrabalhoService {

	private Boolean system = true;
	private final UnidadeDeTrabalhoRepository unidadeDeTrabalhoRepository;

	public CrudUnidadeDeTrabalhoService(UnidadeDeTrabalhoRepository unidadeDeTrabalhoRepository) {
		this.unidadeDeTrabalhoRepository = unidadeDeTrabalhoRepository;
	}
	
	public void inicial(Scanner scanner) {
		
		while(system) {
			System.out.println("Qual ação de cargo deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(scanner);
				break;

			default:
				system = false;
				break;
			}
		}
		
		
	}

	private void salvar(Scanner scanner) {
		System.out.println("Digite o nome da Unidade");
		String nome = scanner.next();
		
		System.out.println("Digite o endereço");
		String endereco = scanner.next();
		
		UnidadeDeTrabalho unidadeDeTrabalho = new UnidadeDeTrabalho();
		unidadeDeTrabalho.setDescricao(nome);
		unidadeDeTrabalho.setEndereco(endereco);
		
		
		unidadeDeTrabalhoRepository.save(unidadeDeTrabalho);
		System.out.println("Salvo");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("Digite o Id");
		Integer id = scanner.nextInt();
		
		System.out.println("Digite o nome da unidade");
		String nome = scanner.next();
		
		System.out.println("Digite o endereço");
		String endereco = scanner.next();
		
		UnidadeDeTrabalho unidadeDeTrabalho = new UnidadeDeTrabalho();
		unidadeDeTrabalho.setId(id);
		unidadeDeTrabalho.setDescricao(nome);
		unidadeDeTrabalho.setEndereco(endereco);
		
		unidadeDeTrabalhoRepository.save(unidadeDeTrabalho);
		System.out.println("Alterado");
	}
	
	private void visualizar() {
		Iterable<UnidadeDeTrabalho> unidades = unidadeDeTrabalhoRepository.findAll();
		unidades.forEach(unidade -> System.out.println(unidade));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		unidadeDeTrabalhoRepository.deleteById(id);
		System.out.println("Deletado");
	}
}
