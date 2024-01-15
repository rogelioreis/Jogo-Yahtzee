package jogo;

import dados.Jogador;
import java.util.Scanner;

public class Menu {
	
	Scanner input = new Scanner(System.in);
	
	Jogador jogador =  new Jogador();
	Jogo jogo =  new Jogo();

	public void apresentacao() {
		
		System.out.println("\n=========================="
				+ "\n== BEM-VINDO AO YAHTZEE =="
				+ "\n==========================\n");
	}
	
	public boolean menuOpcoes() {
		
		int opcao;
		
		System.out.print("1-CADASTRAR JOGADORES"
				+ "\n2-JOGAR"
				+ "\n0-SAIR"
				+ "\nOpção: ");
		opcao = input.nextInt();
		
		while(opcao != 0) {
		
			switch(opcao) {
			
				case 1:
					
					System.out.println();
					jogador.cadastrarJogador();
					break;
				
				case 2:
					
					System.out.println();
					jogo.jogar();
					break;
					
				default:
					System.out.println("\nOpção inválida, tente novamente!\n");
					break;
	
			}
			
			System.out.print("1-CADASTRAR JOGADORES"
					+ "\n2-JOGAR"
					+ "\n0-SAIR"
					+ "\nOpção: ");
			opcao = input.nextInt();
		
		}
		
		System.out.print("\n==================================="
				+ "\n== PROGRAMA ENCERRADO! ATÉ A PROXIMA :) =="
				+ "\n===================================");

		return false;
	}
	
}
