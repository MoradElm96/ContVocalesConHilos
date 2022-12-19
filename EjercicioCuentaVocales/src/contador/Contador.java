package contador;

public class Contador {

	private int cont=0;
	
	

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public Contador(int valor) {
		
		this.cont = valor;
	}
	
	public synchronized void incrementar() {
		cont++;
	}


	
	
}
