package TP1MariaEduardaBarbosaSantos200023934;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Clientes {
	
	static public String listaNom [] = new String[20];
	static public String listaEnd [] = new String[20];
	static public String listaTel [] = new String[20];
	static public List<String> listaClient = Arrays.asList(listaNom);
	static public int tamanho = 0;
	
	static public void clientJaCadastrados() {
		addClient("maria", "q1 c1 - df", "9111111");
		addClient("joao", "q2 c2 - df", "9222222");
		addClient("lucas", "q3 c3 - df", "9333333");
		addClient("luiza", "q4 c4 - df", "9444444");
		addClient("ju", "q5 c5 - df", "9555555");
		addClient("carla", "q6 c6 - df", "9666666");
		addClient("pedro", "q7 c7 - df", "9777777");
		addClient("vitor", "q8 c8 - df", "9888888");
		addClient("edina", "q9 c9 - df", "9999999");
		addClient("roberto", "q10 c10 - df", "9101010");
	}
	
	static public void addClient(String nome, String endereco, String telefone) {
		if(tamanho < listaNom.length)
			listaNom [tamanho]= nome;
			listaEnd [tamanho]= endereco;
			listaTel [tamanho]= telefone;
		tamanho++;
	}
	
	
	static boolean comparaClient(String nome) {
		for (String nomes : listaNom) {
			if(nome.equals(nomes) == true)
				return true;
		}
		return false;
	}
	
	static public void  substitui(String nome) {
		Scanner ler = new Scanner(System.in);
		String elemento = nome;
		int posicao = listaClient.indexOf(elemento); 
		String endereco = listaEnd [posicao];
		String telefone = listaTel [posicao];
		System.out.print("Cliente encontrado! . . .\n"
							+ "============ DADOS DO CLIENTE: ============"
							+ "\nNome: " + nome
							+ "\nEndereço: " + endereco
							+ "\nTelefone: " + telefone
							+ "\n-----------------------------------------\n");
		System.out.print("Deseja auterar os dados do { " + nome + " } ?" 
				+ "\n {1} Sim " 
				+ "\n {2} Não"
				+ "\n-----------------------------------------\n" 
				+ "Insira o número da opção escolhida: ");
		int opcao1 = ler.nextInt();
		ler.nextLine();
		switch (opcao1) {
		case 1:
			menuDoAuterar();
			int opcao2 = ler.nextInt();
			switch (opcao2) {
			case 1:
				ler.nextLine();
				System.out.println("Digite um nome para substituir no atual: ");
				String novoNome = ler.nextLine();
				listaNom[posicao] = novoNome;
				break;
			case 2:
				ler.nextLine();
				System.out.println("Digite um endereço para substituir no atual: ");
				String novoEndereco = ler.nextLine();
				listaEnd[posicao] = novoEndereco;
				break;
			case 3:
				ler.nextLine();
				System.out.println("Digite um telefone para substituir no atual: ");
				String novoTelefone = ler.nextLine();
				listaTel[posicao] = novoTelefone;
				break;
			case 4:
				break;
			default:
				System.out.println("Opção inválida! ");
			}
			
			break;
		case 2:
			break;
		default:
			System.out.println("Opção inválida! ");
		}
	}
	
	static public void menuDoAuterar() {
		System.out.print("\n-----------------------------------------" 
				+"\n++++++++++++++ AUTERAR: +++++++++++++++++" 
				+ "\n {1} Nome" 
				+ "\n {2} Endereço"
				+ "\n {3} Telefone"
				+ "\n {4} Sair"
				+ "\n-----------------------------------------\n" 
				+ "Insira o número da opção escolhida: ");
	}

	static public void pegaNom(int numero) {
		String nomeCliente = listaNom [numero-1];
		System.out.println("O nome escolhido foi: " + nomeCliente);
	}
	
	static public void tabelaClients() {
		for (int i=0; i<tamanho; i++) {
			System.out.println("\n============ Cliente "
					+ (i+1)
					+ " ==============\n"
					+ "++++++ NÚMERO DO CLIENTE: {" + (i+1) + "} +++++++"
					+ "\n-------------------------------------"
					+ "\nNome: " + listaNom[i] 
					+ "\n-------------------------------------"
					+ "\nEndereço: " + listaEnd[i]
					+ "\n-------------------------------------"
					+ "\nTelefone: " + listaTel[i]);
		}
	}
}
