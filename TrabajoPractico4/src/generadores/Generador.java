package generadores;


import java.io.IOException;

import grafos.Grafo;
import grafos.MatrizSimetrica;

public abstract class  Generador  {
	
	int cantidadDeNodos;
	int gradoMin;
	int gradoMax;
	int cantArista;
	double probabilidad; // Entre 0 y 1
	double porcentajeAdyacencia;
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

	public abstract Grafo generar() throws IOException;

	 
}

