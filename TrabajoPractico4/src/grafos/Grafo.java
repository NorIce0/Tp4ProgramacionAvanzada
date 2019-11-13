package grafos;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import generadores.Arista;

public class Grafo {
	
	private int cantidadDeNodos;
	private MatrizSimetrica matrizDeAdayacencia;
	private int cantidadDeAristas;
	private double porcentajeAdyacencia;
	private int gradoMinimo;
	private int gradoMaximo;
	
	public Grafo(int cantidadDeNodos, int cantidadDeAristas) {
		
		this.cantidadDeAristas = cantidadDeAristas;
		this.cantidadDeNodos = cantidadDeNodos;
		this.gradoMinimo = 0;
		this.gradoMaximo = 0;
		this.porcentajeAdyacencia = 0;
		this.matrizDeAdayacencia = new MatrizSimetrica(cantidadDeNodos);
	}
	
	
	public Grafo(int cantidadDeNodos, int cantidadDeAristas, MatrizSimetrica matrizDeAdacencia) {
		
		this.cantidadDeAristas = cantidadDeAristas;
		this.cantidadDeNodos = cantidadDeNodos;
		this.matrizDeAdayacencia = new MatrizSimetrica(cantidadDeNodos);
		this.matrizDeAdayacencia.cargarMatriz(matrizDeAdacencia);
		this.gradoMinimo = 0;
		this.gradoMaximo = 0;
		this.porcentajeAdyacencia = 0;
		
	}
	
	public Grafo(int cantidadDeNodos, int cantidadDeAristas, ArrayList<Arista> listaDeAristas) {
		
		this.cantidadDeAristas = cantidadDeAristas;
		this.cantidadDeNodos = cantidadDeNodos;
		this.cargarListaDeAristas(listaDeAristas);
		this.matrizDeAdayacencia = new MatrizSimetrica(cantidadDeNodos);
		this.gradoMinimo = 0;
		this.gradoMaximo = 0;
		this.porcentajeAdyacencia = 0;
		
	}
	
	
	public void cargarListaDeAristas(ArrayList<Arista> listaDeAristas) {
		System.out.println(listaDeAristas.get(6).getDesde() + " " + listaDeAristas.get(6).getHasta());
		for(Arista aristaActual : listaDeAristas) {
			this.crearArista(aristaActual);
		}
		
	}


	public MatrizSimetrica getMatrizDeAdayacencia() {
		return matrizDeAdayacencia;
	}


	public void crearArista(Arista arista) {
		if(matrizDeAdayacencia.getElemento(arista.getDesde(), arista.getHasta()) == 1) {
			System.out.println("Arista existente.");
		} else {
			this.matrizDeAdayacencia.setValor(arista.getDesde(), arista.getHasta(), 1);
		}
	}

//	Getters y Setters

	public int getCantidadDeAristas() {
		return cantidadDeAristas;
	}


	public int getCantidadDeNodos() {
		return cantidadDeNodos;
	}


	public void setCantidadDeNodos(int cantidadDeNodos) {
		this.cantidadDeNodos = cantidadDeNodos;
	}


	public void setCantidadDeAristas(int cantidadDeAristas) {
		this.cantidadDeAristas = cantidadDeAristas;
	}


	public double getPorcentajeAdyacencia() {
		return porcentajeAdyacencia;
	}


	public void setPorcentajeAdyacencia(double d) {
		this.porcentajeAdyacencia = d;
	}


	public int getGradoMinimo() {
		return gradoMinimo;
	}


	public void setGradoMinimo(int gradoMinimo) {
		this.gradoMinimo = gradoMinimo;
	}


	public int getGradoMaximo() {
		return gradoMaximo;
	}


	public void setGradoMaximo(int gradoMaximo) {
		this.gradoMaximo = gradoMaximo;
	}
	
	
}
