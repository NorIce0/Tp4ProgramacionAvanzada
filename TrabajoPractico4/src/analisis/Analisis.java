package analisis;

import java.io.File;
import java.io.FileWriter;
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
	static int numero = 1;
	FileWriter salida;
	int res;
	
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
		salida = new FileWriter(new File("estadisticas_" + numero + "_aleatorio_WP_" + ".txt"));
		numero++;
		salida.write("");
		for(int i = 0; i < iteraciones; i++) {
			Coloreo coloreo = new Coloreo(grafo);
			coloreo.setGrafo(grafo);
			res = coloreo.coloreoWellshPowell();
			System.out.println(res);
			salida.append("" + i + " " + res + "\n");
//			System.out.println(p.programaProbador(grafo));
			
		}
		salida.close();
		
		salida = new FileWriter(new File("estadisticas_" + numero + "_aleatorio_M_" + ".txt"));
		numero++;
		salida.write("");
		System.out.println("TERMINO WP");
		for(int i = 0; i < iteraciones; i++) {
			Coloreo coloreo = new Coloreo(grafo);
			coloreo.setGrafo(grafo);
			res = coloreo.coloreoMatula();
			System.out.println(res);
			salida.append("" + i + " " + res + "\n");
		}
		salida.close();
		
		salida = new FileWriter(new File("estadisticas_" + numero +"_aleatorio_A_"+ ".txt"));
		numero++;
		salida.write("");
		System.out.println("TERMINO MAT");
		for(int i = 0; i < iteraciones; i++) {
			Coloreo coloreo = new Coloreo(grafo);
			coloreo.setGrafo(grafo);
			res = coloreo.coloreoAleatorio();
			System.out.println(res);
			salida.append("" + i + " " + res + "\n");
		}
		salida.close();
	}

		public void startAnalisisGrafosReg(int cantidadDeNodos, double porcentajeAdyacencia, int iteraciones) throws IOException{
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
			
			salida = new FileWriter(new File("estadisticas_" + numero + "_regular_WP_" + ".txt"));
			numero++;
			salida.write("");
			for(int i = 0; i < iteraciones; i++) {
				Coloreo coloreo = new Coloreo(grafo);
				coloreo.setGrafo(grafo);
				res = coloreo.coloreoWellshPowell();
				System.out.println(res);
				salida.append("" + i + " " + res + "\n");
			}
			salida.close();
			
			salida = new FileWriter(new File("estadisticas_" + numero + "_regular_MAT_" + ".txt"));
			numero++;
			salida.write("");
			System.out.println("TERMINO WP");
			for(int i = 0; i < iteraciones; i++) {
				Coloreo coloreo = new Coloreo(grafo);
				coloreo.setGrafo(grafo);
				res = coloreo.coloreoMatula();
				System.out.println(res);
				salida.append("" + i + " " + res + "\n");
			}
			salida.close();
			
			salida = new FileWriter(new File("estadisticas_" + numero + "_regular_A_" + ".txt"));
			numero++;
			salida.write("");
			System.out.println("TERMINO MAT");
			for(int i = 0; i < iteraciones; i++) {
				Coloreo coloreo = new Coloreo(grafo);
				coloreo.setGrafo(grafo);
				res = coloreo.coloreoAleatorio();
				System.out.println(res);
				salida.append("" + i + " " + res + "\n");
			}
			salida.close();

	}
}
