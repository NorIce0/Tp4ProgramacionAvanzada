package generadores;

import java.io.IOException;
import java.util.ArrayList;

import grafos.Grafo;
import grafos.MatrizSimetrica;
import utilitarios.Archivo;

public class GeneradorPorProbabilidad extends Generador{
	private double probabilidad; // Entre 0 y 1
	private int cantidadDeNodos;
	public ArrayList<Arista> listaDeAristas;
	MatrizSimetrica matrizTemporal;
	Grafo grafoResultante;
	
	public GeneradorPorProbabilidad(int cantidadDeNodos) {
//		this.probabilidad = 1;
//		this.cantidadDeNodos = cantidadDeNodos;
//		matrizTemporal = new MatrizSimetrica(cantidadDeNodos);
		super(cantidadDeNodos);
	}
	
	public GeneradorPorProbabilidad(int cantidadDeNodos, double probabilidad) {
//		this.probabilidad = probabilidad;
//		this.cantidadDeNodos = cantidadDeNodos;
//		matrizTemporal = new MatrizSimetrica(cantidadDeNodos);
		super(cantidadDeNodos, probabilidad);
	}
	
	public Grafo generar() {
		int aristas = 0;
		int gradoMaximo = 0;
		int gradoMinimo = 0;
		int []grados = new int[cantidadDeNodos];
		for(int i = 0; i < cantidadDeNodos; i++) {
			grados[i] = 0;
		}
		
		listaDeAristas = new ArrayList<Arista>();
		for(int i = 0; i < cantidadDeNodos; i++) {
			for(int j = i + 1; j < cantidadDeNodos; j++) {
				
				if(Math.random() < probabilidad) {
					aristas++;
					matrizTemporal.setValor(i, j, 1);
//					listaDeAristas.add(new Arista(i, j));
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
		grafoResultante = new Grafo(cantidadDeNodos,  aristas, matrizTemporal);
//		grafoResultante.setPorcentajeAdyacencia((listaDeAristas.size()/(cantidadDeNodos*(cantidadDeNodos-1)/2))*100);
//		grafoResultante.setGradoMaximo(gradoMaximo);
//		grafoResultante.setGradoMinimo(gradoMinimo);
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
