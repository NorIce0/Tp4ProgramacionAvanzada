package analisis;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import generadores.Generador;
import grafos.GrafoNDNP;

public class Probador {
	
	public static boolean programaProbador(GrafoNDNP grafo) throws IOException{
		
		int cantNodos = grafo.getCantidadDeElementos();
		int[] nodosColoreados = new int [cantNodos];
		//Nodos adyacentes diferente color
		for(int i=0; i<cantNodos-1;i++) 
			for (int j = i+1; j < cantNodos; j++) {
				if(grafo.getValor(i, j) == 1|| nodosColoreados[i]==nodosColoreados[j])
				           return false;
			}
		
       //Todos Los nodos estan coloreados    
		for(int j=0 ;j<cantNodos;j++)
		if (nodosColoreados[j] == 0) 
			return false;
		
		
		return true;
	}

}
