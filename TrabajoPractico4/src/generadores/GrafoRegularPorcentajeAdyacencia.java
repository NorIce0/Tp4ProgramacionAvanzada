package generadores;

import java.io.IOException;

import grafos.Grafo;
import utilitarios.Archivo;

public class GrafoRegularPorcentajeAdyacencia extends Generador {

	public GrafoRegularPorcentajeAdyacencia(int cantidadDeNodos, double porcentajeDeAdyacencia) {
		super(cantidadDeNodos, porcentajeDeAdyacencia);
	}

	@Override
	public Grafo generar(String path) {
		int[] grados = new int[getCantidadDeNodos()];
		for (int i = 0; i < getCantidadDeNodos(); i++)
			grados[i] = 0;
		int gradoFinal;
		int aristas = (int) Math
				.ceil(((getCantidadDeNodos() * (getCantidadDeNodos() - 1)) / 2) * (getPorcentajeAdyacencia() / 100));
		for (gradoFinal = 0; (gradoFinal * (gradoFinal - 1)) / 2 < aristas; gradoFinal++);
		int grado = gradoFinal-1;
//		int grado = aristas/getCantidadDeNodos();
		int cantidadDeAristas = 0;
		for (int i = 1; i < grado; i++) {
			int j;
			for (j = 0; j < getCantidadDeNodos() - i; j++) {
				matriz.setValor(j, j + i, 1);
				cantidadDeAristas++;
				grados[j] += 1;
				grados[i+j] += 1;
			}
			matriz.setValor( i - 1, j, 1);
			grados[i-1]+=1;
			grados[j]+=1;
			if(gradoFinal % 2 == 1)
				grado -= 1;
		}

		setGradoMax(grados[0]);
		setGradoMin(grados[0]);
		for (int i = 0; i < getCantidadDeNodos(); i++) {
			if (grados[i] > getGradoMax()) {
				setGradoMax(grados[i]);
			}
			if (grados[i] < getGradoMin()) {
				setGradoMin(grados[i]);
			}

		}
		for (int i = 0; i < getCantidadDeNodos(); i++)
			System.out.println(grados[i]);
		grafo = new Grafo(getCantidadDeNodos(), cantidadDeAristas, this.matriz);
		grafo.setPorcentajeAdyacencia(getPorcentajeAdyacencia());
		grafo.setGradoMaximo(this.getGradoMax());
		grafo.setGradoMinimo(this.getGradoMin());
		Archivo file = new Archivo(path);
		try {
			file.guardarGrafo(grafo);
		} catch (IOException e) {
			System.out.println("No se puede abrir el archivo.");
		}
		return grafo;

	}
}
