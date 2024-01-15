package dados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import jogo.Categoria;

public class Cartela {
	
	public String[] vetorNomes(){
		
		String[] vetNomes = new String[Jogador.getQuantJogadores()];
		
		int index = 0;
		
		try{
			
			File arquivo = new File("cartela-jogadores.txt");
			Scanner leitor = new Scanner(arquivo);
			
			while(leitor.hasNextLine()) {
				
				String linha = leitor.nextLine();
				
				String[] elementos = linha.split(";");
				String nome = elementos[0];
				
				vetNomes[index] = nome;
				
				index++;
            
			}
			
			leitor.close();
		}
		
		catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
            e.printStackTrace();
        }
		
		return vetNomes;
		
	}
	
	public void atualizarCartela(String nome, int indexDoJogador, int pontos, int[] vetorBonus, int categoriaEscolhida) {
		
		int pontosDeBonus = vetorBonus[indexDoJogador];
		
		try{
			
			File arquivo = new File("cartela-jogadores.txt");
			Scanner leitor = new Scanner(arquivo);
			
			StringBuilder novoConteudo = new StringBuilder();
			
			while(leitor.hasNextLine()) {
				
				String linha = leitor.nextLine();
				
				if(linha.startsWith(nome)) {
					
					String[] elementos = linha.split(";");
					
					elementos[categoriaEscolhida] = String.valueOf(pontos);
					elementos[7] = String.valueOf(pontosDeBonus);
					int totalDePontos = 0;
					
					for (int index = 1; index < 14; index++) {
	                    
						try {
	                        
							int valor = Integer.parseInt(elementos[index]);
	                        
	                        if (valor >= 0) {
	                            totalDePontos += valor;
	                        }
	                    }
	                    
	                    catch (NumberFormatException e) {
	                        continue;
	                    }
	                }
					
					elementos[15] = Integer.toString(totalDePontos);
					
					String linhaAtualizada = String.join(";", elementos);
					
					novoConteudo.append(linhaAtualizada);
					
					if (leitor.hasNextLine()) {
	                    novoConteudo.append("\n");
	                }
					
				}
				
				else {
					
					novoConteudo.append(linha);
					
					if (leitor.hasNextLine()) {
						novoConteudo.append("\n");
					}
				}
			}
			
			leitor.close();
			
			FileWriter escritor = new FileWriter(arquivo);
	        escritor.write(novoConteudo.toString());
	        escritor.close();
			
		}
		
		catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
            e.printStackTrace();
        }
		
		catch (IOException e) {
            System.out.println("Erro de I/O ao escrever no arquivo!");
            e.printStackTrace();
        }
		
	}
	
	
	public String[] cartelaJogador(String nomeJogador) {
		
        try {
        	
            File arquivo = new File("cartela-jogadores.txt");
            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {
            	
                String linha = leitor.nextLine();
                String[] elementos = linha.split(";");

                if (elementos[0].equals(nomeJogador)) {
                	
                    leitor.close();
                    return elementos;
                }
            }

            leitor.close();
            
            
        } 
        
        catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
            e.printStackTrace();
        }

        return null;
    }
	
	public void reiniciarCartela(String[] vetorNomes) {
		
		try {
	        File arquivo = new File("cartela-jogadores.txt");
	        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
	        StringBuilder novoConteudo = new StringBuilder();
	
	        String linha;
	        
	        while ((linha = leitor.readLine()) != null) {
	            
	        	for (String nome : vetorNomes) {
	                
	        		if (linha.startsWith(nome)) {
	                    
	        			String[] elementos = linha.split(";");
	                    
	        			for (int index = 1; index < elementos.length - 2; index++) {
	        	            
	        				elementos[index] = "x";
	        	        }
	                    
	        			elementos[7] = "-63";
	                    
	        			elementos[15] = "0";
	                    
	        			novoConteudo.append(String.join(";", elementos));
	        			
	        			if (!nome.equals(vetorNomes[vetorNomes.length - 1])) {
	                        novoConteudo.append("\n");
	                    }
	        			
	                    break;
	                }
	            }
	        }
	
	        leitor.close();
	
	        FileWriter escritor = new FileWriter(arquivo);
	        escritor.write(novoConteudo.toString());
	        escritor.close();
	
	        Categoria categoria = new Categoria();
	        categoria.reiniciarVetorBonus();
	    }
		
		catch (FileNotFoundException e) {
	        System.out.println("Arquivo não encontrado!");
	        e.printStackTrace();
	    }
		
		catch (IOException e) {
	        System.out.println("Erro de I/O ao escrever no arquivo!");
	        e.printStackTrace();
	    }
	}
		
}


