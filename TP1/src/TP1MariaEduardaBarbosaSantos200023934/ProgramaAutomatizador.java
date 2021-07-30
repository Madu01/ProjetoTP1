package TP1MariaEduardaBarbosaSantos200023934;
import java.util.Scanner;

public class ProgramaAutomatizador {
	
	public static void main(String[] args) {
		Clientes.clientJaCadastrados ();
		Produtos.prodJaCadastrados();
		
		menu();
		Scanner ler = new Scanner(System.in);
		int escolha = ler.nextInt();
		while (escolha != 7) {
			switch (escolha) {
			case 1:
				cadastrarClien();
				break;
			case 2:
				buscaClien();
				break;
			case 3:
				cadastroProd();
				break;
			case 4:
				buscaProd();
				break;
			case 5:
				cadastroVend();
				break;
			case 6:
				mostraEstoq();
				break;
			default:
				System.out.println(". . . Opção inválida! tente novamente . . .");
			}
			
			limpadorDeTela();
			
			menu();
			escolha = ler.nextInt();
		}
		ler.close();
	}
	
	public static void limpadorDeTela() {
		System.out.println("\n\n\n\n");
	}
	
	public static void menu() {
		System.out.print(
				  "==============AUTOMATIZADOR==============\n" 
				+ "+++++ Escolha uma das opções abaixo +++++\n"
				+ "-------------------MENU------------------ \n" 
				+ " {1} Cadastro de novo cliente \n"
				+ " {2} Busca por cliente \n" 
				+ " {3} Cadastro de novo produto \n" 
				+ " {4} Busca por produto \n"
				+ " {5} Cadastro de venda \n" 
				+ " {6} Mostrar produtos em estoque \n" 
				+ " {7} Sair \n"
				+ "----------------------------------------- \n" 
				+ "=========================================\n"
				+ "Insira o número da opção escolhida: ");

	}
		
	public static void cadastrarClien() {
		int numCad;
		Scanner ler = new Scanner(System.in);
		System.out.print("\nInsira a quantidade de clientes a serem cadastrados: ");
		numCad = ler.nextInt();
		ler.nextLine();	
		int indice = Clientes.tamanho;
		int n = 0;
		for (int i = indice; i < numCad+indice; i++) {
			System.out.print("\n=================== CADASTRO " 
					+ (n+1)
					+ " =================== \n" 
					+ "Digite o nome do cliente: ");
			String nome = ler.nextLine();
			Clientes.listaNom[i] = nome;
			System.out.print("-------------------------------------------------- \n" 
					+ "Digite o endereço do cliente: ");
			String endereco = ler.nextLine();
			Clientes.listaEnd[i]= endereco;
			System.out.print("-------------------------------------------------- \n"
					+ "Digite o telefone do cliente: ");
			String telefone = ler.nextLine();
			Clientes.listaTel[i]= telefone;
			System.out.println("\nCadastro feito com sucesso! . . .\n");
			Clientes.tamanho++;
			n++;
		}
	}
	
	public static void buscaClien() {	
		Scanner ler = new Scanner(System.in);
		System.out.println("\nDigite o nome do cliente para saber se ele esta cadastrado ou não: ");
		String nomeClient = ler.nextLine();
		boolean ComparaResult = Clientes.comparaClient(nomeClient);
		if (ComparaResult == true)
			Clientes.substitui(nomeClient);
		else if (ComparaResult == false)
			System.out.println("Cliente não encontrado!");
		
	}
	
	public static void cadastroProd() {
		int quantProdut;
		Scanner ler = new Scanner(System.in);
		System.out.print("\nInsira a quantidade de produtos a serem cadastrados: ");
		quantProdut = ler.nextInt();
		int indice = Produtos.tamanhoProd;
		int n = 0;
		for (int i = indice; i < quantProdut+indice; i++) {
			ler.nextLine();
			System.out.print("\n=================== CADASTRO " 
					+ (n+1)
					+ " =================== \n" 
					+ "Digite o nome do produto: \n");
			String nome = ler.nextLine();
			Produtos.listaNomProd[i] = nome;
			System.out.print("-------------------------------------------------- \n" 
					+ "Digite a descrição do produto: \n");
			String descricao = ler.nextLine();
			Produtos.listaDes[i] = descricao;
			System.out.print("-------------------------------------------------- \n"
					+ "Insira apenas (o número sem incluir o R$) do valor do produto: \n");
			int valor = ler.nextInt();
			Produtos.listaValComp[i] = valor;
			System.out.print("-------------------------------------------------- \n"
					+ "Insira apenas (o número sem incluir a %) da porcentagem de lucro: \n");
			int lucro = ler.nextInt();
			Produtos.listaLucro[i] = lucro;
			System.out.print("-------------------------------------------------- \n"
					+ "Insira apenas (o número) da quantidade em estoque: \n");
			int estoque = ler.nextInt();
			Produtos.listaQuantEstoq[i] = estoque;
			System.out.println("\nCadastro feito com sucesso! . . .\n");
			Produtos.tamanhoProd++;
			n++;
		}
	}

	public static void buscaProd() {
		Scanner ler = new Scanner(System.in);
		System.out.println("\nDigite o nome do Produto para saber se ele esta cadastrado ou não: ");
		String nomProduto = ler.nextLine();
		boolean ComparaResult = Produtos.comparaProd(nomProduto);
		if (ComparaResult == true)
			Produtos.substituiProd(nomProduto);
		else if (ComparaResult == false)
			System.out.println("Produto não encontrado!");

	}

	public static void cadastroVend() {
		Scanner ler = new Scanner(System.in);
		Clientes.tabelaClients();	
		System.out.println("\nInsira o NÚMERO DO CLIENTE escolhido: ");
		int escolhaClient = ler.nextInt();
		Clientes.pegaNom(escolhaClient);
		
		int termina = 0;
		int repete = 1;
		while(repete > termina) {
			Produtos.tabelaProduts();
			System.out.println("\n|Para sair inrisa {0}| ou Insira o NÚMERO DO PRODUTO escolhido: ");
			int escolhaProd = ler.nextInt();
			if (escolhaProd == termina)
				break;
			int estoqueProd = Produtos.listaQuantEstoq [escolhaProd-1];
			String nomProd = Produtos.listaNomProd [escolhaProd-1]; 
			
			System.out.println("\n|Para sair inrisa {0}| ou Insira o número da quantidade de vendas "
					+ "desse produto para o cliente em questão: ");
			int numVenda = ler.nextInt();
			if (numVenda == termina)
				break;
			int novaQuantEstoq = estoqueProd - numVenda; 
			Produtos.listaQuantEstoq[escolhaProd-1] = novaQuantEstoq;
			repete++;
		} 
	}

	public static void mostraEstoq() {
		Produtos.tabelaVend();
	}
}
