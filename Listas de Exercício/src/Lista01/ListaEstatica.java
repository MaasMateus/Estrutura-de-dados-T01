package Lista01;

public class ListaEstatica {

	private int[] info;
	private int tamanho;
	
	public ListaEstatica() {
		this.info = new int[3];
		this.tamanho = 0;
	}
	
	public void inserir(int valor) {

		if (info.length == tamanho) {
			this.redimensionar();
		}

		int i = 0;

		while (i < tamanho && valor > info[i]) {
			i++;
		}

		for (int j=tamanho; j>i;j--) {
			info[j] = info[j-1];
		}

		info[i] = valor;
		tamanho++;
	}
	
	private void redimensionar() {
		
		int[] novo = new int[info.length + 10];
		
		for (int i=0; i < tamanho; i++) {
			novo[i] = info[i];
		}
		  
		info = novo;
	}
	
	public void exibir() {
		System.out.println(this.toString());
	}
	
	public int buscar(int i) {
		
		for (int j=0;j<tamanho;j++) {
			if (i == info[j]) {
				return j;
			}
		}
		return -1;
	}

	public void retirar(int i) {
		
		int indexI = this.buscar(i);

		if (indexI != -1) {
			
			for (int j=indexI+1;j<tamanho-1;j++) {
				info[j-1] = info[j];
			}
			tamanho--;
		}

	}
	
	public void liberar() {
		info = new int[10];
		tamanho = 0;
	}
	
	public int obterElemento(int i) throws IndexOutOfBoundsException {
		
		if (i > tamanho -1) {
			throw new IndexOutOfBoundsException("Elemento não existe");
		} 
		return info[i];
	}
	
	public boolean estaVazia() {
		return tamanho == 0;
	}

	public int getTamanho() {
		return this.tamanho;
	}

	@Override
	public String toString() {

		String str = "";
		
		for (int i=0; i<tamanho;i++) {
			
			str += info[i];
			
			if (i != tamanho -1) {
				str += ",";
			}
		}
		
		return str;
	}
}
