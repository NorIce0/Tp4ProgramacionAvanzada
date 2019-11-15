package analisis;

import java.io.IOException;

import coloreo.Coloreo;
import generadores.Generador;
import generadores.GeneradorPorcentajeAdyacencia;
import grafos.Grafo;
import grafos.GrafoNDNP;

public class Analisis {
	int cantidadDeNodos;
	Generador gen;

	
	public void startAnalisisGrafos(int cantidadDeNodos, double porcentajeAdyacencia, int iteraciones){
		gen = new GeneradorPorcentajeAdyacencia(cantidadDeNodos, porcentajeAdyacencia);
		Grafo g;
		GrafoNDNP grafo = null;
		try {
			g = gen.generar("grafo_01.in");
			g.getMatrizDeAdayacencia().mostrarMatriz();
			grafo = new GrafoNDNP(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < iteraciones; i++) {
			Coloreo coloreo = new Coloreo(grafo);
			coloreo.setGrafo(grafo);
			System.out.println("Iteracion numero: " + i + " con cantidad de colores:" + coloreo.coloreoMatula());
		}

	}
}
