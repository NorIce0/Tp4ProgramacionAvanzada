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

		Archivo archivo = new Archivo("grafo.in");
		try {
			archivo.guardarGrafo(grafoResultante);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se puede abrir el archivo.");
		}

		grafoResultante = new Grafo(getCantidadDeNodos(), cantArista, this.matriz);
		grafoResultante.setPorcentajeAdyacencia(
				(int) ((float) cantArista / (cantidadDeNodos * (cantidadDeNodos - 1) / 2) * 100));
		grafoResultante.setGradoMaximo(this.getGradoMax());
		grafoResultante.setGradoMinimo(this.getGradoMin());
		Archivo file = new Archivo(path);
		try {
			file.guardarGrafo(grafoResultante);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se puede abrir el archivo.");
		}
		return grafoResultante;

	}
}
