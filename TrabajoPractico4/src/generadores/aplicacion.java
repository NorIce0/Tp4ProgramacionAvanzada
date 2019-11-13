package generadores;


import java.io.IOException;

import grafos.Grafo;

public class aplicacion {
	public static void main(String[] args) {
		int n = 15;
		GeneradorNPartitos gen1 = new GeneradorNPartitos(n, 4);
		Grafo g1 = gen1.generar("grafo.in");
//		g1.getMatrizDeAdayacencia().mostrarMatriz();
	}
}
