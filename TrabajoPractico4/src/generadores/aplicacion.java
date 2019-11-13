package generadores;


import java.io.IOException;

import grafos.Grafo;

public class aplicacion {
	public static void main(String[] args) throws IOException {
		int n = 5;
		GeneradorRegular gen1 = new GeneradorRegular(n, 5);
		Grafo g1 = gen1.generar();
		if (gen1 == null)
			return;
		g1.getMatrizDeAdayacencia().mostrarMatriz();
	}
}
