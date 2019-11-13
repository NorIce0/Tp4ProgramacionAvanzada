package generadores;

import java.io.File;
import java.io.FileNotFoundException;
//<<<<<<< HEAD
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;



import grafos.Grafo;
//=======
import grafos.MatrizSimetrica;

public abstract class  Generador  {
	
	int cantidadDeNodos;
	int gradoMin;
	int gradoMax;
	int cantArista;
	double probabilidad; // Entre 0 y 1
	double porcentajeAdyacencia;
	ArrayList <Arista>aristas=new ArrayList<Arista>();
	MatrizSimetrica matriz;

	public ArrayList<Arista> listaDeAristas;
	MatrizSimetrica matrizTemporal;
	Grafo grafoResultante;
	public Generador(int nodos, double porcentaje){
		this.cantidadDeNodos = nodos;
		this.porcentajeAdyacencia = porcentaje;
		this.matriz = new MatrizSimetrica(nodos);
		
	}
	public Generador(int cantidadDeNodos) {
		this.probabilidad = 1;
		this.cantidadDeNodos = cantidadDeNodos;
		matrizTemporal = new MatrizSimetrica(cantidadDeNodos);
	}

//	public void mostrarTodaAristas() {
//		
//		for(int k=0; k<matriz.getTamanio(); k++)
//			System.out.print(matriz.getValorIndiceVector(k) + " ");					
//	}
//	
//	public void mostrarAristasSeteadas() {
//		for(int i=0; i<matriz.getTamanio(); i++) {
//			if(matriz.getValorIndiceVector(i)==1)
//				System.out.print(matriz.getValorIndiceVector(i) + " ");	
//		}
//		System.out.println("");
//	}
	
	
	public abstract Grafo generar() throws IOException;

	
//		public static GrafoNDNP leer(String path) throws FileNotFoundException{
//			
//			Scanner sc = new Scanner(new File(path));
//			sc.useLocale(Locale.ENGLISH);
//			
//			int cantidadNodos = sc.nextInt();
//			int cantidadAristas = sc.nextInt();
//			double porcentajeAdy = sc.nextDouble();
//			int gradoMax = sc.nextInt();
//			int gradoMin = sc.nextInt();
//			GrafoNDNP grafo = new GrafoNDNP(cantidadNodos,gradoMin, gradoMax,cantidadAristas, porcentajeAdy);
//			for(int i=0;i<cantidadAristas;i++) {
//				grafo.setArista(sc.nextInt(), sc.nextInt());
//			}
//			 sc.close();
//			 return grafo;
//		}
		
	 
}

