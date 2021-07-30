package TP1MariaEduardaBarbosaSantos200023934;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Produtos {
	
	static public String listaNomProd [] = new String[20];
	static public String listaDes [] = new String[20];
	static public int listaValComp [] = new int[20];
	static public int listaLucro [] = new int[20];
	static public int listaQuantEstoq [] = new int[20];
	static public List<String> listaProd = Arrays.asList(listaNomProd);
	static public int tamanhoProd = 0;
	
	
	static public void prodJaCadastrados() {
		addProd("shampoos", "da marca ABC", 20, 40, 30);
		addProd("pentes", "da marca g", 10, 50, 20);
		addProd("casacos", "super quente", 100, 52, 26);
		addProd("panelas", "duradoura", 40, 30, 50);
		addProd("blusas", "da cor vermelha", 20, 10, 30);
		addProd("pratos", "no formato quadrado", 15, 57, 70);
		addProd("tapetes", "tamanho grande", 100, 20, 6);
		addProd("vassouras", "verdes", 5, 30, 40);
		addProd("esmaltes", "todas as cores", 3, 60, 100);
		addProd("perfume", "da marca d", 33, 70, 80);
		
	}
	
	static public void addProd(String nome, String descricao, int valor, int lucro, int estoque) {
		if(tamanhoProd < listaNomProd.length)
			listaNomProd [tamanhoProd] = nome;
			listaDes [tamanhoProd] = descricao;
			listaValComp [tamanhoProd] = valor;
			listaLucro [tamanhoProd] = lucro;
			listaQuantEstoq [tamanhoProd] = estoque;
		tamanhoProd++;
	}
	
	static boolean comparaProd(String nome) {
		for (String noms : listaNomProd) {
			if(nome.equals(noms) == true)
				return true;
		}
		return false;
	}
	
	static public void  substituiProd(String nome) {
		Scanner ler = new Scanner(System.in);
		String element = nome;
		int posicao = listaProd.indexOf(element);
		String descricao = listaDes [posicao];
		int valor = listaValComp [posicao];
		int lucro = listaLucro [posicao];
		int estoque = listaQuantEstoq [posicao];
		System.out.print("Produto encontrado! . . .\n"
							+ "============ DADOS DO PRODUTO: ============"
							+ "\nNome do produto: " + nome
							+ "\nDescrição: " + descricao
							+ "\nValor: " + "R$ " + valor + ",00"
							+ "\nPorcentagem de lucro: " + lucro + " %" 
							+ "\nQuantidade em estoque: " + estoque
							+ "\n-----------------------------------------\n" );
		System.out.print("Deseja auterar os dados do { " + nome + " } ?" 
				+ "\n {1} Sim " 
				+ "\n {2} Não"
				+ "\n-----------------------------------------\n" 
				+ "Insira o número da opção escolhida: ");
		int opcao1 = ler.nextInt();
		switch (opcao1) {
		case 1:
			menuDoAuterarProd();
			ler.nextLine();
			int opcao2 = ler.nextInt();
			switch (opcao2) {
			case 1:
				ler.nextLine();
				System.out.println("Digite um nome do produto para substituir no atual: ");
				String novoNomProd = ler.nextLine();
				listaNomProd[posicao] = novoNomProd;
				break;
			case 2:
				ler.nextLine();
				System.out.println("Digite uma descrição para substituir no atual: ");
				String novaDes = ler.nextLine();
				listaDes[posicao] = novaDes;
				break;
			case 3:
				System.out.println("Insira apenas (o número sem incluir o R$)"
						+ " do valor para substituir no atual: ");
				int novoValComp = ler.nextInt();
				listaValComp[posicao] = novoValComp;
				break;
			case 4:
				System.out.println("Insira apenas (o número sem incluir a %)"
						+ " do lucro para substituir no atual: ");
				int novoLucro = ler.nextInt();
				listaLucro[posicao] = novoLucro;
				break;
			case 5:
				System.out.println("Insira apenas (o número) da quantidade "
						+ "para substituir no atual: ");
				int novaQuantEstoq = ler.nextInt();
				listaQuantEstoq[posicao] = novaQuantEstoq;
				break;
			case 6:
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
	
	static public void menuDoAuterarProd() {
		System.out.print("\n-----------------------------------------" 
				+"\n++++++++++++++ AUTERAR: +++++++++++++++++" 
				+ "\n {1} Nome do produto" 
				+ "\n {2} Descrição"
				+ "\n {3} Valor"
				+ "\n {4} Porcentagem de lucro"
				+ "\n {5} Quantidade em estoque"
				+ "\n {6} Sair"
				+ "\n-----------------------------------------\n" 
				+ "Insira o número da opção escolhida: ");
	}
	
	static public void tabelaVend() {
		for (int i=0; i<tamanhoProd; i++) {
			System.out.println("\n================ Estoque "
					+ (i+1)
					+ " ================\n"
					+ "\nNome do produto: " + listaNomProd[i]
					+ "\n-------------------------------------------"
					+ "\nQuantidade em estoque: " + listaQuantEstoq[i]);
		}
	}
	
	static public void tabelaProduts() {
		for (int i=0; i<tamanhoProd; i++) {
			System.out.println("\n================ Produto "
					+ (i+1)
					+ " ================\n"
					+ "+++++++++ NÚMERO DO PRODUTO: {" + (i+1) + "} ++++++++++"
					+ "\n-------------------------------------------"
					+ "\nNome do produto: " + listaNomProd[i]
					+ "\n-------------------------------------------"
					+ "\nDescrição: " + listaDes[i] 
					+ "\n-------------------------------------------"
					+ "\nValor: R$ " + listaValComp[i] + ",00"
					+ "\n-------------------------------------------"
					+ "\nPorcentagem de lucro: " + listaLucro[i] + " %" 
					+ "\n-------------------------------------------"
					+ "\nQuantidade em estoque: " + listaQuantEstoq[i]);
		}
	}
}
