package grafos;

import java.util.ArrayList;

public class MatrizSimetrica {
	
	public int vec[];
	private int filas;
	private int cantidadDeElementos;
	
	public MatrizSimetrica(int filas) {

		this.filas = filas;
		this.cantidadDeElementos = (filas * (filas-1))/2;
		vec = new int[cantidadDeElementos];
		for(int i = 0; i < cantidadDeElementos; i++ ) {
			vec[i] = 0;
	}
	}
	
	public int getValor(int f, int c) {
		return this.vec[getIndice(f, c)];
	}

	public void cargarMatriz(ArrayList<Integer> elementos) {
		for(int i = 0; i < cantidadDeElementos; i++ ) {
				vec[i] = elementos.get(i);
		}
	}

	public void cargarMatriz(MatrizSimetrica elementos) {
		this.vec = elementos.vec;
	}
	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getCantidadDeElementos() {
		return cantidadDeElementos;
	}

	public void setCantidadDeElementos(int cantidadDeElementos) {
		this.cantidadDeElementos = cantidadDeElementos;
	}

	public void mostrarMatriz() {
		for(int i = 0; i < (filas * (filas-1))/2; i++ ) {
				System.out.print(vec[i] + " ");
		}
	}
	
	
	public int getIndice(int fila, int columna) {

		int temp;
		
		if(fila > columna) {
			temp = fila;
			fila = columna;
			columna = temp;
		}
		
		return fila * this.getFilas() + columna - ( fila * (fila + 3) + 2 ) / 2;
		
	}
	
	public void setValor(int fila, int columna, int valor) {
		vec[getIndice(fila, columna)] = valor;
	}
	
	public int getElemento(int fila, int columna){
		return vec[getIndice(fila, columna)];
	}
	
}
