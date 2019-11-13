package grafos;

import grafos.MatrizSimetrica;

public class GrafoNDNP extends MatrizSimetrica{

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
	

}
