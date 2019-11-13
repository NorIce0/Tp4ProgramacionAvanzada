package generadores;

public class Arista {

	private int desde;
	private int hasta;
	private int valor;
	
	public Arista(int desde, int hasta) {
		this.desde = desde;
		this.hasta = hasta;
		this.valor = 1;
	}

	public int getDesde() {
		return desde;
	}

	public void setDesde(int desde) {
		this.desde = desde;
	}

	public int getHasta() {
		return hasta;
	}

	public void setHasta(int hasta) {
		this.hasta = hasta;
	}
	
}
