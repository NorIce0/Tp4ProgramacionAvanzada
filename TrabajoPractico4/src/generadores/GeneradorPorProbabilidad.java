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
	
	public Grafo generar() {
		int aristas = 0;
		int gradoMaximo = 0;
		int gradoMinimo = 0;
		int []grados = new int[cantidadDeNodos];
		for(int i = 0; i < cantidadDeNodos; i++) {
			grados[i] = 0;
		}
		
		for(int i = 0; i < cantidadDeNodos; i++) {
			for(int j = i + 1; j < cantidadDeNodos; j++) {
				
				if(Math.random() < probabilidad) {
					aristas++;
					matriz.setValor(i, j, 1);
					grados[i] += 1;
					if(grados[i] > gradoMaximo) {
						gradoMaximo = grados[i];
					}
					if(grados[i] < gradoMinimo){
						gradoMinimo = grados[i];
					}
				}
				
			}
		}
		grafoResultante = new Grafo(cantidadDeNodos,  aristas, this.matriz);
		grafoResultante.setPorcentajeAdyacencia((aristas/(cantidadDeNodos*(cantidadDeNodos-1)/2))*100);
		grafoResultante.setGradoMaximo(gradoMaximo);
		grafoResultante.setGradoMinimo(gradoMinimo);
		Archivo archivo = new Archivo("grafo.in");
		try {
			archivo.guardarGrafo(grafoResultante);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se puede abrir el archivo.");
		}
		return grafoResultante;
	}
	
}
