package generadores;

import java.io.IOException;

import grafos.Grafo;
import utilitarios.Archivo;

public class GeneradorNPartitos extends Generador {

	private int nPartes;

	public GeneradorNPartitos(int cantidadDeNodos, int nPartes) {
		super(cantidadDeNodos);
		this.nPartes = nPartes;
	}

	@Override
	public Grafo generar(String path) {
		int aristas = 0;
		int gradoMaximo = 0;
		int gradoMinimo = getCantArista();

		int[] grados = new int[getCantidadDeNodos()];
		for (int i = 0; i < getCantidadDeNodos(); i++) {
			grados[i] = 0;
		}

		for (int i = 0; i < getCantidadDeNodos(); i++) {
			for (int j = i + 1; j < getCantidadDeNodos(); j++) {
				if ((i % nPartes) == (j % nPartes)) {
					matriz.setValor(i, j, 1);
					aristas++;
					grados[i]++;
					grados[j]++;
				}
			}
		}
		gradoMaximo = grados[0];
		gradoMinimo = grados[0];
		for (int i = 0; i < getCantidadDeNodos(); i++) {
			for (int j = i + 1; j < getCantidadDeNodos(); j++) {
					if (grados[i] > gradoMaximo) {
						gradoMaximo = grados[i];
					}
					if (grados[j] > gradoMaximo) {
						gradoMaximo = grados[j];
					}
					if (grados[i] < gradoMinimo) {
						gradoMinimo = grados[i];
					}
					if (grados[j] < gradoMinimo) {
						gradoMinimo = grados[j];
					}
			}
		}
		matriz.mostrarMatriz();

		grafo = new Grafo(getCantidadDeNodos(), aristas, this.matriz);
		grafo
				.setPorcentajeAdyacencia((aristas / (getCantidadDeNodos() * (getCantidadDeNodos() - 1)) / 2) * 100);
		grafo.setGradoMaximo(gradoMaximo);
		grafo.setGradoMinimo(gradoMinimo);

		try {
			Archivo archivo = new Archivo(path);
			archivo.guardarGrafo(grafo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se puede abrir el archivo.");
		}
		return new Grafo(0, 0);
	}

}
