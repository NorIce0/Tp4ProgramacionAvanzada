package generadores;

import java.io.IOException;

import grafos.Grafo;
import utilitarios.Archivo;

public class GeneradorPorProbabilidad extends Generador{
	private double probabilidad; 
	Grafo grafoResultante;
	
	public GeneradorPorProbabilidad(int cantidadDeNodos, double probabilidad) {
		super(cantidadDeNodos, 100.0);
		this.probabilidad = probabilidad;
	}
	
	public Grafo generar(String path) {
		int aristas = 0;
		int gradoMaximo = 0;
		int gradoMinimo = 0;
		int []grados = new int[getCantidadDeNodos()];
		for(int i = 0; i < getCantidadDeNodos(); i++) {
			grados[i] = 0;
		}
		
		for(int i = 0; i < getCantidadDeNodos(); i++) {
			for(int j = i + 1; j < getCantidadDeNodos(); j++) {
				
				if(Math.random() < probabilidad) {
					aristas++;
					matriz.setValor(i, j, 1);
					grados[i] += 1;
					grados[j] += 1;
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
		grafoResultante = new Grafo(getCantidadDeNodos(),  aristas, this.matriz);
		grafoResultante.setPorcentajeAdyacencia((aristas/(getCantidadDeNodos()*(getCantidadDeNodos()-1)/2))*100);
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
