package jogo;

import dados.Dado;
import dados.Cartela;
import dados.Jogador;
import java.util.Scanner;

public class Jogo {
	
	private int[] dadosJogador = new int[5];
	private int indiceJogadorAtual = 0;
	
	Dado dado1 = new Dado();
	int dadoUm;
	Dado dado2 = new Dado();
	int dadoDois;
	Dado dado3 = new Dado();
	int dadoTres;
	Dado dado4 = new Dado();
	int dadoQuatro;
	Dado dado5 = new Dado();
	int dadoCinco;
	
	Cartela cartela = new Cartela();
	
	Scanner input = new Scanner(System.in);

	public void jogar(){
		
		if(Jogador.getQuantJogadores() == 0){
			System.out.println("Não é possivel iniciar o jogo sem jogadores!\n");
			return;
		}
		
		System.out.println("INICIANDO JOGO...");
		
		System.out.println();

		System.out.println("Digite 1: Começar jogo");
		System.out.print("Digite 0: Para sair"
				+ "\nEscolha: ");
		int escolhaJ = input.nextInt();
		
		Categoria categoria = new Categoria();
		
		System.out.println();
		
		while (escolhaJ == 1 && Jogador.getQuantJogadores() != 0) {
				
			int quantRodadasFeitas = 0;
			
			String nomeVencedor = "";
			int pontosVencedor = -1;
			
			while(quantRodadasFeitas < (Jogador.getQuantJogadores() * 13)){
				
				quantRodadasFeitas++;
				
				String[] vetNomes = cartela.vetorNomes();
				String nomeDaVez = vetNomes[indiceJogadorAtual];
				
				String[] cartelaJogador = cartela.cartelaJogador(nomeDaVez);
				
				System.out.println("================ RODADA " + quantRodadasFeitas + " ================\n");
				
				System.out.println("--> Vez de: " + nomeDaVez+"\n");
				
				System.out.print("======== CARTELA ========"
						+ "\n1 - Uns: " + cartelaJogador[1]
						+ "\n2 - Dois: " + cartelaJogador[2]
						+ "\n3 - Três: " + cartelaJogador[3]
						+ "\n4 - Quatros: " + cartelaJogador[4]
						+ "\n5 - Cincos: " + cartelaJogador[5]
						+ "\n6 - Seis: " + cartelaJogador[6]
						+ "\n---> BÔNUS: " + cartelaJogador[7]
						+ "\n7 - Trinca: " + cartelaJogador[8]
						+ "\n8 - Quadra: " + cartelaJogador[9]
						+ "\n9 - Full House: " + cartelaJogador[10]
						+ "\n10 - Sequência Curta: " + cartelaJogador[11]
						+ "\n11 - Sequência Longa: " + cartelaJogador[12]
						+ "\n12 - Yahtzee: " + cartelaJogador[13]
						+ "\n13 - Sorte: " + cartelaJogador[14]
						+ "\n---> TOTAL: " + cartelaJogador[15]
						+ "\n========================="
						+ "\n"
						+ "\nSEUS DADOS:\n\n");
				
				jogarDados();

				System.out.println("VOCÊ PODE MUDAR OS DADOS 2 VEZES\n");
				System.out.print("1 - Mudar dados"
						+ "\n2 - Manter os dados"
						+ "\nEscolha: ");
				int escolhaD = input.nextInt();
				
				while(escolhaD < 1 || escolhaD > 2) {
					
					System.out.println("\nOpção inválida, tente novamente!\n");
					System.out.print("Escolha: ");
					escolhaD = input.nextInt();
				}

				int contMudarDados = 2;

				while (escolhaD == 1 && contMudarDados != 0) {
					
					contMudarDados--;

					System.out.print("\nDigite quantos dados deseja mudar: ");
					int quantDadosMudar = input.nextInt();
					
					while(quantDadosMudar < 1 || quantDadosMudar > 5) {
						
						System.out.print("\n== Valor inválido! Tente novamente =="
								+ "\nDigite quantos dados deseja mudar: ");
						quantDadosMudar = input.nextInt();
						
					}
					
					if(quantDadosMudar < 5) {
					
						for (int index = 0; index < quantDadosMudar; index++) {
							
							if(index == 0) {
								System.out.println("\nSELECIONE O DADO QUE GOSTARIA DE ALTERAR:\n");
								System.out.println("1 - 1º Dado");
								System.out.println("2 - 2º Dado");
								System.out.println("3 - 3º Dado");
								System.out.println("4 - 4º Dado");
								System.out.println("5 - 5º Dado\n");
							}
							
							System.out.print(index + 1 + ") Escolha: ");
									
							int mudarDado = input.nextInt();

							switch (mudarDado) {
								case 1:
									dadoUm = dado1.girar();
									break;

								case 2:
									dadoDois = dado2.girar();
									break;

								case 3:
									dadoTres = dado3.girar();
									break;

								case 4:
									dadoQuatro = dado4.girar();
									break;

								case 5:
									dadoCinco = dado5.girar();
									break;

								default:

									while(mudarDado < 0 || mudarDado > 5){
										
										System.out.println("\nOpção inválida, tente novamente!\n");
										System.out.print(index + 1 + ") Escolha: ");
										mudarDado = input.nextInt();
									}
									break;
							}
						
						}
						
					}
					
					else {
						
						dadoUm = dado1.girar();
						dadoDois = dado2.girar();
						dadoTres = dado3.girar();
						dadoQuatro = dado4.girar();
						dadoCinco = dado5.girar();
					}
					
				
					if(contMudarDados != 0) {
						
						System.out.println("\nOS DADOS FICARAM ASSIM:\n");
						exibirDados();
						
						System.out.println("DESEJA MUDAR OS DADOS NOVAMENTE?\n");
						System.out.print("1 - Mudar dados"
								+ "\n2 - Manter os dados"
								+ "\nEscolha: ");
						escolhaD = input.nextInt();
					}
				}
				
				System.out.println("\nA VERSÃO FINAL DOS SEUS DADOS FICOU ASSIM:\n");
				exibirDados();
				
				this.dadosJogador[0] = dadoUm;
				this.dadosJogador[1] = dadoDois;
				this.dadosJogador[2] = dadoTres;
				this.dadosJogador[3] = dadoQuatro;
				this.dadosJogador[4] = dadoCinco;
				
				
				System.out.print("======== CARTELA ========"
						+ "\n1 - Uns: " + cartelaJogador[1]
						+ "\n2 - Dois: " + cartelaJogador[2]
						+ "\n3 - Três: " + cartelaJogador[3]
						+ "\n4 - Quatros: " + cartelaJogador[4]
						+ "\n5 - Cincos: " + cartelaJogador[5]
						+ "\n6 - Seis: " + cartelaJogador[6]
						+ "\n---> BÔNUS: " + cartelaJogador[7]
						+ "\n7 - Trinca: " + cartelaJogador[8]
						+ "\n8 - Quadra: " + cartelaJogador[9]
						+ "\n9 - Full House: " + cartelaJogador[10]
						+ "\n10 - Sequência Curta: " + cartelaJogador[11]
						+ "\n11 - Sequência Longa: " + cartelaJogador[12]
						+ "\n12 - Yahtzee: " + cartelaJogador[13]
						+ "\n13 - Sorte: " + cartelaJogador[14]
						+ "\n---> TOTAL: " + cartelaJogador[15]
						+ "\n========================="
						+ "\n"
						+ "\nCategoria: ");
				
				int escolhaCat = input.nextInt();
				
				System.out.println();
				
				if(escolhaCat < 7) {
					
					while (!cartelaJogador[escolhaCat].equals("x")) {
						
						System.out.println("Categoria já escolhida, tente novamente!\n");
						System.out.print("Categoria: ");
						escolhaCat = input.nextInt();
						
						System.out.println();
					}
				}
				
				else {
					
					while (!cartelaJogador[escolhaCat + 1].equals("x")) {
						
						System.out.println("Categoria já escolhida, tente novamente!\n");
						System.out.print("Categoria: ");
						escolhaCat = input.nextInt();
						
						System.out.println();
					}
				}
				
				int pontosAdquiridos = 0;
				
				switch(escolhaCat) {
					
					case 1:
						
						pontosAdquiridos = categoria.uns(dadosJogador, indiceJogadorAtual);
						break;
					
					case 2:
						
						pontosAdquiridos = categoria.dois(dadosJogador, indiceJogadorAtual);
						break;
					
					case 3:
						
						pontosAdquiridos = categoria.tres(dadosJogador, indiceJogadorAtual);
						break;
					
					case 4:
						
						pontosAdquiridos = categoria.quatros(dadosJogador, indiceJogadorAtual);
						break;
					
					case 5:
						
						pontosAdquiridos = categoria.cincos(dadosJogador, indiceJogadorAtual);
						break;
					
					case 6:
						
						pontosAdquiridos = categoria.seis(dadosJogador, indiceJogadorAtual);
						break;
						
					case 7:
						
						pontosAdquiridos = categoria.trinca(dadosJogador, indiceJogadorAtual);
						break;
					
					case 8:
						
						pontosAdquiridos = categoria.quadra(dadosJogador, indiceJogadorAtual);
						break;
						
					case 9:
						
						pontosAdquiridos = categoria.fullHouse(dadosJogador, indiceJogadorAtual);
						break;
					
					case 10:
						
						pontosAdquiridos = categoria.sequenciaCurta(dadosJogador, indiceJogadorAtual);
						break;

					case 11:
						
						pontosAdquiridos = categoria.sequenciaLonga(dadosJogador, indiceJogadorAtual);
						break;
						
					case 12:
						
						pontosAdquiridos = categoria.yahtzee(dadosJogador, indiceJogadorAtual);
						break;
						
					case 13:
						
						pontosAdquiridos = categoria.sorte(dadosJogador, indiceJogadorAtual);
						break;
						
					default:
						
						while(escolhaCat < 1 || escolhaCat > 13){
							System.out.println("\nOpção inválida, tente novamente!\n");
							System.out.print("Categoria: ");
							escolhaCat = input.nextInt();
						}
						
						break;
				}
				
				String[] cartelaJogadorAtualizada = cartela.cartelaJogador(nomeDaVez);
				
				System.out.println("Pontos adquiridos -> " + pontosAdquiridos + "\n");
				
				if(Integer.parseInt(cartelaJogadorAtualizada[15]) > pontosVencedor) {
					
					pontosVencedor = Integer.parseInt(cartelaJogadorAtualizada[15]);
					nomeVencedor = nomeDaVez;
					
				}
				
				indiceJogadorAtual = (indiceJogadorAtual + 1) % vetNomes.length;	
			}
			
			System.out.println("============== RESULTADO =============="
					+ "\nVENCEDOR: " + nomeVencedor
					+ "\nPONTUAÇÃO: " + pontosVencedor
					+ "\n=======================================\n");
			
			System.out.println("Fim de jogo!");
			System.out.print("\n1 - Reiniciar jogo"
					+ "\n2 - Voltar ao menu"
					+ "\nEscolha: ");
			int escolhaReiniciar = input.nextInt();
			
			while(escolhaReiniciar < 1 || escolhaReiniciar > 2) {
				
				System.out.print("\nOpção inválida, tente novamente!"
						+ "\n"
						+ "\n1 - Reiniciar jogo"
						+ "\n2 - Voltar ao menu"
						+ "\nEscolha: ");
				escolhaReiniciar = input.nextInt();
					
			}
	
			if(escolhaReiniciar == 1) {
				
				String[] vetNomes = cartela.vetorNomes();
				
				System.out.print("\nReiniciando jogo...\n\n");
				cartela.reiniciarCartela(vetNomes);
				
			}
			
			else{
				
				System.out.print("\nRetornando ao menu...\n\n");
				return;
			}
			
		}
		
		if(Jogador.getQuantJogadores() == 0 && escolhaJ == 1){
			System.out.println("Não é possivel iniciar o jogo sem jogadores!\n");
		}
		
	}

	public void exibirDados(){
		
		System.out.printf("| 1º Dado | 2º Dado | 3º Dado | 4º Dado | 5º Dado |"
				+ "\n|    %d    |    %d    |    %d    |    %d    |    %d    |",
				dadoUm, dadoDois, dadoTres, dadoQuatro, dadoCinco);
		System.out.println("\n");
	}

	public void jogarDados() {

		dadoUm = dado1.girar();
		dadoDois = dado2.girar();
		dadoTres = dado3.girar();
		dadoQuatro = dado4.girar();
		dadoCinco = dado5.girar();

		exibirDados();
		
	}
	
	public int getIndiceJogadorAtual() {
		
		return indiceJogadorAtual;
	}
}
