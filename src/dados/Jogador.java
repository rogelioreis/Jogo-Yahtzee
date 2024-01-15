package dados;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Jogador {

	Scanner input =  new Scanner(System.in);

	private static int quantJogadores;
	private String nomeJogador;
	
	public String getNomeJogador(){
		return nomeJogador;
	}
	
	public void setNomeJogador(String nomeJogador){
		this.nomeJogador = nomeJogador;
	}
	
	public static int getQuantJogadores() {
		return quantJogadores;
	}

	public void cadastrarJogador() {
		
		System.out.print("Digite quantos jogadores: ");
		quantJogadores = input.nextInt();
		
		
		PrintWriter escrever = null;
		
		if(quantJogadores > 1) {
			
			try {
				
				FileWriter out = new FileWriter("cartela-jogadores.txt");
				escrever = new PrintWriter(out);
				
				for(int index = 0; index < quantJogadores; index++) {
					
					System.out.printf("\nNome do JOGADOR %d: ", index + 1);
					nomeJogador = input.next();
					
					if(index != quantJogadores - 1){
						escrever.println(nomeJogador+";x;x;x;x;x;x;-63;x;x;x;x;x;x;x;0");
					}
					
					else{
						escrever.print(nomeJogador+";x;x;x;x;x;x;-63;x;x;x;x;x;x;x;0");
					
					}
				
				}
			
			}
			
			catch(Exception e) {
				System.out.println(e);
			}
			
			finally{ 
				escrever.close();
			}
			
			System.out.println("\nJogadores cadastrados! Retornando ao menu...\n");
			return;
		}
		
		else {
			
			System.out.println("\nSó é possivel jogar com mais de 1 jogador!"
					+ "\nTente Novamente!\n");
			
			cadastrarJogador();
		}
		
	}

}
