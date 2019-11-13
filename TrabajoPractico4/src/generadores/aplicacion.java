package generadores;


import grafos.Grafo;

public class aplicacion {
	public static void main(String[] args) {
		int n = 5;
		GeneradorPorcentajeAdyacencia gen1 = new GeneradorPorcentajeAdyacencia(n, 55.9);
		Grafo g1 = gen1.generar();
		g1.getMatrizDeAdayacencia().mostrarMatriz();
	}
}
