package generadores;


import java.io.IOException;

import analisis.Analisis;
import grafos.Grafo;
import utilitarios.Archivo;

public class aplicacion {
	public static void main(String[] args) {
		int n = 5;
		double porcentaje = 40.0;
		Analisis analizador = new Analisis();
		analizador.startAnalisisGrafos(n, porcentaje, 1);
//		g1.getMatrizDeAdayacencia().mostrarMatriz();
	}
}
