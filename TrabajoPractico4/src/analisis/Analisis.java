package analisis;

import java.io.IOException;
import java.util.Scanner;

import coloreo.Coloreo;
import generadores.Generador;
import generadores.GeneradorPorcentajeAdyacencia;
import generadores.GrafoRegularPorcentajeAdyacencia;
import grafos.Grafo;
import grafos.GrafoNDNP;

public class Analisis {
	int cantidadDeNodos;
	Generador gen;

	
	public void startAnalisisGrafos(int cantidadDeNodos, double porcentajeAdyacencia, int iteraciones) throws IOException{
		gen = new GeneradorPorcentajeAdyacencia(cantidadDeNodos, porcentajeAdyacencia);
		Grafo g;
		GrafoNDNP grafo = null;
		try {
			g = gen.generar("grafo_01.in");
//			g.getMatrizDeAdayacencia().mostrarMatriz();
			grafo = new GrafoNDNP(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Probador p = new Probador();
		for(int i = 0; i < iteraciones; i++) {
			Coloreo coloreo = new Coloreo(grafo);
			coloreo.setGrafo(grafo);
			System.out.println(coloreo.coloreoWellshPowell());
//			System.out.println(p.programaProbador(grafo));
			
		}
		
		System.out.println("TERMINO WP");
		for(int i = 0; i < iteraciones; i++) {
			Coloreo coloreo = new Coloreo(grafo);
			coloreo.setGrafo(grafo);
			System.out.println(coloreo.coloreoMatula());
		}
		System.out.println("TERMINO MAT");
		for(int i = 0; i < iteraciones; i++) {
			Coloreo coloreo = new Coloreo(grafo);
			coloreo.setGrafo(grafo);
			System.out.println(coloreo.coloreoAleatorio());
		}
	}

		public void startAnalisisGrafosReg(int cantidadDeNodos, double porcentajeAdyacencia, int iteraciones){
			gen = new GrafoRegularPorcentajeAdyacencia(cantidadDeNodos, porcentajeAdyacencia);
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
				System.out.println(coloreo.coloreoWellshPowell());
			}
			System.out.println("TERMINO WP");
			for(int i = 0; i < iteraciones; i++) {
				Coloreo coloreo = new Coloreo(grafo);
				coloreo.setGrafo(grafo);
				System.out.println(coloreo.coloreoMatula());
			}
			System.out.println("TERMINO MAT");
			for(int i = 0; i < iteraciones; i++) {
				Coloreo coloreo = new Coloreo(grafo);
				coloreo.setGrafo(grafo);
				System.out.println(coloreo.coloreoAleatorio());
			}

	}
}
