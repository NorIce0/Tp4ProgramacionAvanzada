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
//		int[] grados = new int[getCantidadDeNodos()];
//		for (int i = 0; i < getCantidadDeNodos(); i++)
//			grados[i] = 0;
//		int gradoFinal;
		int aristas = (int) Math
				.ceil(((getCantidadDeNodos() * (getCantidadDeNodos() - 1)) / 2) * (getPorcentajeAdyacencia() / 100));
//		for (gradoFinal = 0; (gradoFinal * (gradoFinal - 1)) / 2 < aristas; gradoFinal++);
//		int grado = gradoFinal-1;
		int grado = (getCantidadDeNodos()%aristas) -1;
//		int cantidadDeAristas = 0;
//		for (int i = 1; i < grado; i++) {
//			int j;
//			for (j = 0; j < getCantidadDeNodos() - i; j++) {
//				matriz.setValor(j, j + i, 1);
//				cantidadDeAristas++;
//				grados[j] += 1;
//				grados[i+j] += 1;
//				matriz.setValor( i - 1, j, 1);
//			}
//			
//			grados[i-1]+=1;
//			grados[j]+=1;
////			if(gradoFinal % 2 == 1)
////				grado -= 1;
//		}
////		for (int i = 1; i < grado; i++) {
////			int j;
////			for (j = 0; j < getCantidadDeNodos() - i; j++) {
////				matriz.setValor(j + i, j, 1);
////				cantidadDeAristas++;
////			}
////			grado -= 1;
////		}
////		int []grados = new int[cantidadDeNodos];
////		for(int i = 0; i < cantidadDeNodos; i++) {
////			grados[i] = grado;
////		}
//
//		setGradoMax(grados[0]);
//		setGradoMin(grados[0]);
//		for (int i = 0; i < getCantidadDeNodos(); i++) {
//			if (grados[i] > getGradoMax()) {
//				setGradoMax(grados[i]);
//			}
//			if (grados[i] < getGradoMin()) {
//				setGradoMin(grados[i]);
//			}
//
//		}
//		for (int i = 0; i < getCantidadDeNodos(); i++)
//			System.out.println(grados[i]);
		
		int cantnodos = getCantidadDeNodos();
		if (grado % 2 != 0 && cantnodos % 2 != 0 || cantnodos <= grado) { //Si grado y nodo son impar Ó grado es mayor a nodo, salgo.
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
		if (grado > 1) { // Si el grado es 1 ó 0, ni me molesto porque ya esta todo. Si fuese 0, no dibujo nada. Si fuese 1, ya pinte en la anterior. 
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
