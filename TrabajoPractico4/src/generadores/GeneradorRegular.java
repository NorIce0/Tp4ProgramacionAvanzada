package generadores;

import java.io.IOException;

import utilitarios.Archivo;
import grafos.Grafo;

public class GeneradorRegular extends Generador{

	public GeneradorRegular(int cantidadDeNodos,int grado) {
		super(cantidadDeNodos);
		this.setGradoMin(grado);
		this.setGradoMax(grado);
	}

	@Override
	public Grafo generar() throws IOException {
		if ((gradoMax % 2 != 0 && cantidadDeNodos % 2 != 0) || cantidadDeNodos <= gradoMax) {
			return null;
		}
		
		int listagrados[] = new int[cantidadDeNodos], grado = gradoMax;
		int mitad = cantidadDeNodos / 2;
		
		if (grado % 2 == 1) {
			for (int i = 0; i < mitad; i++) {
				this.matriz.setValor(i, mitad + i, 1);
				cantArista++;
				listagrados[i]++;
				listagrados[mitad + i]++;
			}
			grado -= 1;
		}
		
		// circulo
		if (grado > 1) { 
			int salteo = 1;
			while (grado <= this.gradoMax && grado>0) {
				for (int i = 0; i < cantidadDeNodos; i++) {
					this.matriz.setValor(i, (i + salteo) % cantidadDeNodos, 1);
					cantArista++;
					listagrados[i]++;
					listagrados[(i+salteo) % cantidadDeNodos]++;	
				}
				salteo++;
				grado-=2; 
			}
		}
		
			grafoResultante = new Grafo(getCantidadDeNodos(),  cantArista, this.matriz);
			grafoResultante.setPorcentajeAdyacencia((int)((float)cantArista/(cantidadDeNodos*(cantidadDeNodos-1)/2)*100));
			grafoResultante.setGradoMaximo(this.getGradoMax());
			grafoResultante.setGradoMinimo(this.getGradoMin());
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

