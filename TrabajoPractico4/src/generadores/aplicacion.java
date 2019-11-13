package generadores;


import grafos.Grafo;

public class aplicacion {
	public static void main(String[] args) {
		
		int n = 5;
		GeneradorPorProbabilidad gen1 = new GeneradorPorProbabilidad(n, 0.75);
		Grafo g1 = gen1.generar();
		System.out.println(g1.getMatrizDeAdayacencia().getElemento(2, 3));
		g1.getMatrizDeAdayacencia().mostrarMatriz();
	}
}
