package generadores;

import java.io.IOException;

import grafos.Grafo;
import utilitarios.Archivo;

public class GrafoRegularPorcentajeAdyacencia extends Generador{
	public GrafoRegularPorcentajeAdyacencia(int cantidadDeNodos, int grado, double porcentajeDeAdyacencia) {
		super(cantidadDeNodos, porcentajeDeAdyacencia);
		this.setGradoMin(grado);
		this.setGradoMax(grado);
	}

	@Override
	public Grafo generar(String path) {
		int aristas = (int) Math.ceil((getCantidadDeNodos() * (getCantidadDeNodos() - 1) / 2) 
										* (getPorcentajeAdyacencia() / 100));
		int grado = this.getGradoMax();
		int cantidadDeAristas = 0;
		for (int i = 1; i < grado; i++) {
			int j;
			for (j = 0; j < getCantidadDeNodos() - i; j++) {
				if(cantidadDeAristas < aristas) {
					matriz.setValor(j + i, j, 1);
					cantidadDeAristas++;
				}
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
		grafoResultante.setPorcentajeAdyacencia(getPorcentajeAdyacencia());
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
