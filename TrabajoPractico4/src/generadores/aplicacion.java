package generadores;


import java.io.IOException;

import analisis.Analisis;
import analisis.Probador;
import coloreo.Coloreo;
import grafos.Grafo;
import grafos.GrafoNDNP;
import utilitarios.Archivo;

public class aplicacion {
	public static void main(String[] args) throws IOException {
		int n = 6;
		
		double porcentaje = 100.0;
		
		Generador gen = new GeneradorPorcentajeAdyacencia(n, porcentaje);
		
		Grafo grafo = gen.generar("grafo.in");
		grafo.getMatrizDeAdayacencia().mostrarMatriz();
		GrafoNDNP g1 = new GrafoNDNP(grafo);
		Coloreo coloreador = new Coloreo(g1);
		coloreador.coloreoWellshPowell();
		if(Probador.programaProbador(coloreador))
			System.out.println("Funciono Bien");
		else
			System.out.println("\nNo anda");
		
//		porcentaje = 40.0;
//		Analisis analizador1 = new Analisis();
//		analizador1.startAnalisisGrafos(n, porcentaje, 10);
		
		
//		porcentaje = 60.0;
//		Analisis analizador2 = new Analisis();
//		analizador2.startAnalisisGrafos(n, porcentaje, 10000);
//		
//		porcentaje = 90.0;
//		Analisis analizador3 = new Analisis();
//		analizador3.startAnalisisGrafos(n, porcentaje, 10000);
////		g1.getMatrizDeAdayacencia().mostrarMatriz();
		
		
		///////////////////////////////////////
		
//		n = 1000;
//		
//		porcentaje = 50.0;
//		Analisis analizadorReg1 = new Analisis();
//		analizadorReg1.startAnalisisGrafos(n, porcentaje, 10000);
//		
//		porcentaje = 75.0;
//		Analisis analizadorReg2 = new Analisis();
//		analizadorReg2.startAnalisisGrafos(n, porcentaje, 10000);
	}
}
