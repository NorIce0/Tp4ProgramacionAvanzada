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
		
		/*
		 * Este codigo solamente conecta nodos en anillo. Y solamente llena el triangulo inferior de la matriz.
		 
//		int grado = this.getGradoMax();
//		int cantidadDeAristas = 0;
//		for (int i = 1; i <= grado; i++) {// recorre todo nodo y le otorga un grado
//			int j;
//			for (j = 0; j < getCantidadDeNodos() - i; j++) { //Conecta todas los nodos uno a lado del otro (menos el ultimo con el primero
//				matriz.setValor(j + i, j, 1);
//				cantidadDeAristas++;
//			}
////			grado -= 1;
//		}
//		int []grados = new int[cantidadDeNodos];
//		for(int i = 0; i < cantidadDeNodos; i++) {
//			grados[i] = grado;
//		}
 * */
 
		int grado = this.getGradoMax();
		int cantnodos = getCantidadDeNodos();
		if (grado % 2 != 0 && cantnodos % 2 != 0 || cantnodos <= grado) { //Si grado y nodo son impar � grado es mayor a nodo, salgo.
			return null;
		}
		
		int listagrados[] = new int[cantnodos]; //creo lista de grados
		
		int mitad = cantnodos / 2; //agarro la mitad de la cantidad de nodos, porque cuando hago la estrella, el numero del nodo mas la mitad de los nodos me da el nodo exacto que tiene de frente.
		
		if (grado % 2 == 1) { //si grado es impar
			for (int i = 0; i < mitad; i++) {//Voy armando la estrella en la matriz. 
				matriz.setValor(i, mitad + i, 1);
				cantArista++;
				listagrados[i]++;
				listagrados[mitad + i]++;
			}
			grado -= 1; //Ahora resto el grado por uno, porque ahora todos los nodos son de grado 1, y entonces necesitan menos aristas.
		}
		
		// circulo
		if (grado > 1) { // Si el grado es 1 � 0, ni me molesto porque ya esta todo. Si fuese 0, no dibujo nada. Si fuese 1, ya pinte en la anterior. 
			int salto = 1; //representa que cantidad de nodos saltare en cada iteracion.
			while (grado>0) {

				for (int i = 0; i < cantnodos; i++) {
					matriz.setValor(i, (i+salto)%cantnodos, 1);
					cantArista++;
					listagrados[i]++;
					listagrados[(i+salto)%cantnodos]++;	
				}
				salto++;
				grado-=2; //le resto dos porque a todos los nodos le agregue 2 grados
			}
		}

		grafo = new Grafo(getCantidadDeNodos(), cantArista, this.matriz);
		grafo.setPorcentajeAdyacencia(
				(int) ((float) (cantArista / (cantidadDeNodos * (cantidadDeNodos - 1) / 2)) * 100));
		grafo.setGradoMaximo(this.getGradoMax());
		grafo.setGradoMinimo(this.getGradoMin());
//		grafo.setGrados(grados);
		Archivo file = new Archivo(path);
		try {
			file.guardarGrafo(grafo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se puede abrir el archivo.");
		}
		return grafo;

	}
}
