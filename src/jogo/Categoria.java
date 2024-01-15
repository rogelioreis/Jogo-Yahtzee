package jogo;

import dados.Jogador;

import java.util.Arrays;

import dados.Cartela;

public class Categoria {
	
	Cartela cartela = new Cartela();
	
	private String[] vetNomes = cartela.vetorNomes();
	
	private int[] vetBonus = new int[Jogador.getQuantJogadores()];
		
	public Categoria() {
        reiniciarVetorBonus();
    }

    public void reiniciarVetorBonus() {
    	for(int index = 0; index < vetBonus.length; index++) {
    		
    		vetBonus[index] = -63;
    			
    	}
    }
	
	
	public int uns(int[] dados, int indexDoJogador){
		
		int pontos = 0;
		
		int categoriaEscolhida = 1;
		
		for(int index = 0; index < dados.length; index++) {
			
			if(dados[index] == 1) {
				
				pontos += 1;
				
			}
		}
		
		bonus(pontos, indexDoJogador);
		
		cartela.atualizarCartela(vetNomes[indexDoJogador], indexDoJogador, pontos, vetBonus, categoriaEscolhida);
		
		return pontos;
	}
	
	public int dois(int[] dados, int indexDoJogador){
		
		int categoriaEscolhida = 2;
		
		int pontos = 0;
		
		for(int index = 0; index < dados.length; index++) {
			
			if(dados[index] == 2) {
				
				pontos += 2;
				
			}
		}
		
		bonus(pontos, indexDoJogador);
		
		cartela.atualizarCartela(vetNomes[indexDoJogador], indexDoJogador, pontos, vetBonus, categoriaEscolhida);
		
		return pontos;
	}
		
	
	public int tres(int[] dados, int indexDoJogador){
		
		int pontos = 0;
		
		int categoriaEscolhida = 3;

		for(int index = 0; index < dados.length; index++) {
			
			if(dados[index] == 3) {
				
				pontos += 3;
				
			}
		}
		
		bonus(pontos, indexDoJogador);
		
		cartela.atualizarCartela(vetNomes[indexDoJogador], indexDoJogador, pontos, vetBonus, categoriaEscolhida);
		
		return pontos;
	}
	
	public int quatros(int[] dados, int indexDoJogador){

		int pontos = 0;
		
		int categoriaEscolhida = 4;

		for(int index = 0; index < dados.length; index++) {
			
			if(dados[index] == 4) {
				
				pontos += 4;
				
			}
		}
		
		bonus(pontos, indexDoJogador);
		
		cartela.atualizarCartela(vetNomes[indexDoJogador], indexDoJogador, pontos, vetBonus, categoriaEscolhida);
		
		return pontos;
	}
	
	public int cincos(int[] dados, int indexDoJogador){

		int pontos = 0;
		
		int categoriaEscolhida = 5;

		for(int index = 0; index < dados.length; index++) {
			
			if(dados[index] == 5) {
				
				pontos += 5;
				
			}
		}
		
		bonus(pontos, indexDoJogador);
		
		cartela.atualizarCartela(vetNomes[indexDoJogador], indexDoJogador, pontos, vetBonus, categoriaEscolhida);
		
		return pontos;
	}
	
	public int seis(int[] dados, int indexDoJogador){

		int pontos = 0;
		
		int categoriaEscolhida = 6;

		for(int index = 0; index < dados.length; index++) {
			
			if(dados[index] == 6) {
				
				pontos += 6;
				
			}
		}
		
		bonus(pontos, indexDoJogador);
		
		cartela.atualizarCartela(vetNomes[indexDoJogador], indexDoJogador, pontos, vetBonus, categoriaEscolhida);
		
		return pontos;
	}
	
	public void bonus(int pontos, int indexDoJogador){
		
		vetBonus[indexDoJogador] += pontos;
		
		if (vetBonus[indexDoJogador] >= 0) {
			
			vetBonus[indexDoJogador] = 35;
		}
		
	}
	
	public int trinca(int[] dados, int indexDoJogador){
		
		int pontos = 0;
		
	    int categoriaEscolhida = 8;

	    for (int numero = 1; numero <= 6; numero++) {
	    	
	        int contador = 0;

	        for (int dado : dados) {
	        	
	            if (dado == numero) {
	            	
	                contador++;
	            }
	        }

	        if (contador >= 3) {
	            
	            for (int dado : dados) {
	                pontos += dado;
	            }
	            
	            break; 
	        }
	    }
		
		cartela.atualizarCartela(vetNomes[indexDoJogador], indexDoJogador, pontos, vetBonus, categoriaEscolhida);
		
		return pontos;
		
	}
	
	public int quadra(int[] dados, int indexDoJogador){
		
		int pontos = 0;
		
		int categoriaEscolhida = 9;

	    for (int numero = 1; numero <= 6; numero++) {
	    	
	        int contador = 0;

	        for (int dado : dados) {
	        	
	            if (dado == numero) {
	            	
	                contador++;
	            }
	        }

	        if (contador >= 4) {
	            
	            for (int dado : dados) {
	                pontos += dado;
	            }
	            
	            break; 
	        }
	    }
		
		cartela.atualizarCartela(vetNomes[indexDoJogador], indexDoJogador, pontos, vetBonus, categoriaEscolhida);
		
		return pontos;
	}
	
	public int fullHouse(int[] dados, int indexDoJogador){
		
		int pontos = 0;
		
		int categoriaEscolhida = 10;
		
		boolean trinca = false;
		boolean par = false;
		
		for (int numero = 1; numero <= 6; numero++) {
	    	
	        int contador = 0;

	        for (int dado : dados) {
	        	
	            if (dado == numero) {
	            	
	                contador++;
	            }
	        }

	        if (contador == 3) {
	            
	            trinca = true;
	            break; 
	        }
	    }
		
		if (trinca) {
	        for (int numero = 1; numero <= 6; numero++) {
	        	
	            int contador = 0;

	            for (int dado : dados) {
	            	
	                if (dado == numero) {
	                    contador++;
	                }
	            }

	            if (contador >= 2 && numero != dados[0]) {
	                par = true;
	                break;
	            }
	        }
	    }
		
		if(trinca && par) {
			
			pontos = 25;
		}
		
		cartela.atualizarCartela(vetNomes[indexDoJogador], indexDoJogador, pontos, vetBonus, categoriaEscolhida);
		
		return pontos;
	}
	
	
	
	public int sequenciaCurta(int[] dados, int indexDoJogador){
		
		int pontos = 0;
		
		int categoriaEscolhida = 11;
		
		Arrays.sort(dados);

		int contadorSequencia = 1;

		for (int index = 0; index < dados.length - 1; index++) {
		        
			if (dados[index] + 1 == dados[index + 1]) {
				contadorSequencia++;
			}
		        
			else if (dados[index] != dados[index + 1]) {
		            
				contadorSequencia = 1;
			}

		        
			if (contadorSequencia >= 4) {
				
				pontos = 30; 
		        break;
		    }
		}
		
		cartela.atualizarCartela(vetNomes[indexDoJogador], indexDoJogador, pontos, vetBonus, categoriaEscolhida);
		
		return pontos;
	}

	public int sequenciaLonga(int[] dados, int indexDoJogador){
	
		int pontos = 0;
		
		int categoriaEscolhida = 12;
		
		Arrays.sort(dados);

	    int contadorSequencia = 1;

	    for (int index = 0; index < dados.length - 1; index++) {
	        
	    	if (dados[index] + 1 == dados[index + 1]) {
	            contadorSequencia++;
	        }
	        
	        else if (dados[index] != dados[index + 1]) {
	            
	            contadorSequencia = 1;
	        }

	        if (contadorSequencia == 5) {
	            
	        	pontos = 40;
	            break;
	        }
	    }
	    
	    cartela.atualizarCartela(vetNomes[indexDoJogador], indexDoJogador, pontos, vetBonus, categoriaEscolhida);
		return pontos;
	}
	
	public int yahtzee(int[] dados, int indexDoJogador){
		
		int pontos = 0;
		
		int categoriaEscolhida = 13;
		
		int contador = 1;
		
		for (int index = 0; index < dados.length - 1; index++) {
	        
	    	if (dados[index] == dados[index + 1]) {
	    		contador++;
	        }

	        if (contador == 5) {
	            
	        	pontos = 50;
	            break;
	        }
	    }
		
		
		cartela.atualizarCartela(vetNomes[indexDoJogador], indexDoJogador, pontos, vetBonus, categoriaEscolhida);
		return pontos;
	}
	
	public int sorte(int[] dados, int indexDoJogador){
		
		int pontos = 0;
		
		int categoriaEscolhida = 14;
		
		for (int dado : dados) {
            pontos += dado;
        }
		
		cartela.atualizarCartela(vetNomes[indexDoJogador], indexDoJogador, pontos, vetBonus, categoriaEscolhida);
		return pontos;
	}
	
	
}
