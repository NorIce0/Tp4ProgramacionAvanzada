package generadores;

import java.io.IOException;

import grafos.Grafo;
import utilitarios.Archivo;

public class GeneradorRegular extends Generador{

	int grado;
	public GeneradorRegular(int cantidadDeNodos, int grado) {
		super(cantidadDeNodos);
		this.setGradoMin(grado);
		this.setGradoMax(grado);
		this.grado = grado;
	}

	@Override
	public Grafo generar() {
		int cantidadDeAristas = 0;
		for(int i = 1; i < grado; i++) {
			int j ;
			for(j = 0; j < getCantidadDeNodos() - i; j++) {
				matriz.setValor(j + i, j, 1);
				cantidadDeAristas++;
			}
			matriz.setValor(i - 1, j, 1);
		}
		grafoResultante = new Grafo(getCantidadDeNodos(),  cantidadDeAristas, this.matriz);
		grafoResultante.setPorcentajeAdyacencia((cantidadDeAristas/(getCantidadDeNodos()*(getCantidadDeNodos()-1)/2))*100);
		grafoResultante.setGradoMaximo(getGradoMax());
		grafoResultante.setGradoMinimo(getGradoMin());
		
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
