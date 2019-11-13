package utilitarios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import generadores.Arista;
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
//	, ArrayList<Arista> listaDeAristas
	public void guardarGrafo(Grafo grafo) throws IOException {
		FileWriter fw = new FileWriter(pathName);
		fw.write(grafo.getCantidadDeNodos() + " " + grafo.getCantidadDeAristas() + " " +
				grafo.getPorcentajeAdyacencia() + " " + grafo.getGradoMaximo() + " " + grafo.getGradoMinimo() + "\n");
//		for(Arista aristaTemporal : listaDeAristas) {
//			fw.write(aristaTemporal.getDesde() + " " + aristaTemporal.getHasta() + "\n");
//		}
		fw.close();
	}
	
}
