package generadores;

import java.io.IOException;

import utilitarios.Archivo;
import grafos.Grafo;

public class GeneradorRegular extends Generador {
	public GeneradorRegular(int cantidadDeNodos, int grado) {
		super(cantidadDeNodos);
		this.setGradoMin(grado);
		this.setGradoMax(grado);
	}

	@Override
	public Grafo generar(String path) {
		int grado = this.getGradoMax();
		int cantidadDeAristas = 0;
		for (int i = 1; i < grado; i++) {
			int j;
			for (j = 0; j < getCantidadDeNodos() - i; j++) {
				matriz.setValor(j + i, j, 1);
				cantidadDeAristas++;
			}
			grado -= 1;
		}
		int []grados = new int[cantidadDeNodos];
		for(int i = 0; i < cantidadDeNodos; i++) {
			grados[i] = grado;
		}

		grafo = new Grafo(getCantidadDeNodos(), cantArista, this.matriz);
		grafo.setPorcentajeAdyacencia(
				(int) ((float) cantArista / (cantidadDeNodos * (cantidadDeNodos - 1) / 2) * 100));
		grafo.setGradoMaximo(this.getGradoMax());
		grafo.setGradoMinimo(this.getGradoMin());
		grafo.setGrados(grados);
		Archivo file = new Archivo(path);
		try {
			file.guardarGrafo(grafo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se puede abrir el archivo.");
		}
		return grafo;

	}
}
