package grafos;

import grafos.MatrizSimetrica;

public class GrafoNDNP extends MatrizSimetrica{
	
	private int []grados;
	private int gradoMin;
	private int gradoMax;
	private int cantAristas;
	private double porcentaje;
	
	public GrafoNDNP(int filas) {
		super(filas);
	}
	
	
	
	public GrafoNDNP(int cantDeNodos, int gradoMin, int gradoMax, int cantArista,
			double porcentaje) {
		super(cantDeNodos);
		this.gradoMin = gradoMin;
		this.gradoMax = gradoMax;
		this.cantAristas = cantArista;
		this.porcentaje = porcentaje;
		this.grados = new int [cantDeNodos];
	}

	
	public GrafoNDNP(Grafo g) {
		super(g.getCantidadDeNodos());
		super.cargarMatriz(g.getMatrizDeAdayacencia());
		this.gradoMax = g.getGradoMaximo();
		this.gradoMin = g.getGradoMinimo();
		this.cantAristas = g.getCantidadDeAristas();
		this.porcentaje = g.getPorcentajeAdyacencia();
		this.grados = g.getGrados();
	}


	public int getGradoMin() {
		return gradoMin;
	}



	public void setGradoMin(int gradoMin) {
		this.gradoMin = gradoMin;
	}



	public int getGradoMax() {
		return gradoMax;
	}



	public void setGradoMax(int gradoMax) {
		this.gradoMax = gradoMax;
	}



	public int getCantAristas() {
		return cantAristas;
	}



	public void setCantAristas(int cantAristas) {
		this.cantAristas = cantAristas;
	}



	public double getPorcentaje() {
		return porcentaje;
	}



	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	public int[] getGrado(){
		return grados;
	}
	
	public void setGrado(int []grados){
		setGrado(grados);;
	}

}
