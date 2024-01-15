package dados;

import java.util.Random;

public class Dado {
	
	private int dado;
	
	Random random = new Random();
	
	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}
	
	
	public int girar() {
		
		dado = random.nextInt(6) + 1;

		return dado;
	}
	
}
