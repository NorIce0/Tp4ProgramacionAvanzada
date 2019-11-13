package generadores;


import java.io.IOException;

import grafos.Grafo;
import grafos.MatrizSimetrica;

public abstract class  Generador  {
	
	protected int cantidadDeNodos;
	private int gradoMin;
	protected int gradoMax;
	protected int cantArista;
	private double probabilidad; // Entre 0 y 1
	protected double porcentajeAdyacencia;

	MatrizSimetrica matriz;

	Grafo grafoResultante;
	
	public Generador(int cantidadDeNodos, double porcentaje){
		this.cantidadDeNodos = cantidadDeNodos;
		this.porcentajeAdyacencia = porcentaje;
		this.matriz = new MatrizSimetrica(cantidadDeNodos);
	}
	
	public Generador(int cantidadDeNodos) {
		this.probabilidad = 1;
		this.cantidadDeNodos = cantidadDeNodos;
		matriz = new MatrizSimetrica(cantidadDeNodos);
	}

	public abstract Grafo generar(String path) throws IOException;

	
//	Getters y Setters
	
	public int getCantidadDeNodos() {
		return cantidadDeNodos;
	}

	public void setCantidadDeNodos(int cantidadDeNodos) {
		this.cantidadDeNodos = cantidadDeNodos;
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

	public int getCantArista() {
		return cantArista;
	}

	public void setCantArista(int cantArista) {
		this.cantArista = cantArista;
	}

	public double getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(double probabilidad) {
		this.probabilidad = probabilidad;
	}

	public double getPorcentajeAdyacencia() {
		return porcentajeAdyacencia;
	}

	public void setPorcentajeAdyacencia(double porcentajeAdyacencia) {
		this.porcentajeAdyacencia = porcentajeAdyacencia;
	}
	 
}

