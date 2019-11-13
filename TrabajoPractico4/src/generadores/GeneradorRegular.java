package generadores;

import java.io.IOException;

import grafos.Grafo;

public class GeneradorRegular extends Generador{

	public GeneradorRegular(int cantidadDeNodos,int grado) {
		super(cantidadDeNodos);
		this.setGradoMin(grado);
		this.setGradoMax(grado);
	}

	@Override
	public Grafo generar() throws IOException {
		
		for(int i = 0; i < getCantidadDeNodos(); i++) {
			for(int j = i + 1; i < getCantidadDeNodos(); j++) {
				
			}
		}
		
		return null;
	}

}
