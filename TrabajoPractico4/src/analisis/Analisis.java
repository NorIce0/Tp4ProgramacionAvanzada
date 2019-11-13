package analisis;

import generadores.Generador;
import generadores.GeneradorPorcentajeAdyacencia;

public class Analisis {
	int cantidadDeNodos;
	Generador gen;

	
	public void startAnalisisGrafosAleatorios(int cantidadDeNodos, double porcentajeAdyacencia, String pathIn,String pathOut){
		gen = new GeneradorPorcentajeAdyacencia(cantidadDeNodos, porcentajeAdyacencia, pathIn);
	}
}
