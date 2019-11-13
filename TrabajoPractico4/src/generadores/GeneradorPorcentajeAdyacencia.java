package generadores;

import java.io.IOException;

import grafos.Grafo;
import utilitarios.Archivo;

public class GeneradorPorcentajeAdyacencia extends Generador {

	public GeneradorPorcentajeAdyacencia(int cantidadDeNodos, double porcentajeAdyacencia) {
		super(cantidadDeNodos, porcentajeAdyacencia);

	}

	@Override
	public Grafo generar(String path) {
		int aristas = (int) Math
				.ceil((getCantidadDeNodos() * (getCantidadDeNodos() - 1) / 2) * (getPorcentajeAdyacencia() / 100));
		int cantidadMaxima = getCantidadDeNodos() * (getCantidadDeNodos() - 1) / 2;
		int gradoMaximo = 0;
		int gradoMinimo = 0;
		int temporal;
		int z = 0;
		int[] grados = new int[getCantidadDeNodos()];
		int nodos = getCantidadDeNodos();
		for (int i = 0; i < getCantidadDeNodos(); i++) {
			grados[i] = 0;
		}
		while (z < aristas) {
			temporal = ((int) Math.ceil((Math.random() * Integer.MAX_VALUE)) % (cantidadMaxima - 1));
			System.out.println(temporal);
			if (this.matriz.getElemento(temporal) == 0) {
				this.matriz.setValor(temporal, 1);
				z++;
			}
		}

		for (int i = 0; i < getCantidadDeNodos(); i++) {
			for (int j = i + 1; j < getCantidadDeNodos(); j++) {

				grados[i]++;
				grados[j]++;
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
		grafoResultante = new Grafo(getCantidadDeNodos(), aristas, this.matriz);
		grafoResultante.setPorcentajeAdyacencia(getPorcentajeAdyacencia());
		grafoResultante.setGradoMaximo(gradoMaximo);
		grafoResultante.setGradoMinimo(gradoMinimo);

		Archivo archivo = new Archivo(path);
		try {
			archivo.guardarGrafo(grafoResultante);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se puede abrir el archivo.");
		}
		return grafoResultante;
	}

}
