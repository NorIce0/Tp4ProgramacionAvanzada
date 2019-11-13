package utilitarios;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import grafos.Grafo;

public class Archivo {
	private String pathName;
	
	public Archivo(String path) {
		this.pathName = path;
	}
	
	public Grafo leerGrafo() throws IOException{
		Scanner sc = new Scanner(new FileReader(pathName));
		sc.close();
		return new Grafo(0,0);
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
