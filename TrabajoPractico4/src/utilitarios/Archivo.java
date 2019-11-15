package utilitarios;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import grafos.Grafo;
import grafos.MatrizSimetrica;

public class Archivo {
	private String pathName;
	private int N;
	private int CCol;
	private int CA;
	private double Ady;
	private int grMax;
	private int grMin;
	private MatrizSimetrica ms;

	
	public Archivo(String path) {
		this.pathName = path;
	}
	
	public Grafo leerGrafo() throws IOException{
		Scanner sc = new Scanner(new FileReader(pathName));
		sc.useLocale(Locale.ENGLISH);
		N = sc.nextInt();
		CA = sc.nextInt();
		Ady = sc.nextDouble(); // ACA va a dar error
		grMax = sc.nextInt();
		grMin = sc.nextInt();
		ms = new MatrizSimetrica(N);
		for(int i = 0; i < CA; i++) {
			ms.setValor(sc.nextInt(), sc.nextInt(), 1);
		}
		
		sc.close();
		return new Grafo(N,CA, ms);
	}
	
	public void guardarGrafo(Grafo grafo) throws IOException {
		FileWriter fw = new FileWriter(pathName);
		fw.write(grafo.getCantidadDeNodos() + " " + grafo.getCantidadDeAristas() + " " +
				grafo.getPorcentajeAdyacencia() + " " + grafo.getGradoMaximo() + " " + grafo.getGradoMinimo() + "\n");
		for(int i = 0; i < grafo.getCantidadDeNodos(); i++) {
			for(int j = i + 1; j < grafo.getCantidadDeNodos(); j++) {
				if( grafo.getMatrizDeAdayacencia().getElemento(i, j) == 1 ){
					fw.write(j + " " + i + "\n");
				}
			}
		}
		fw.close();
	}
	
}
