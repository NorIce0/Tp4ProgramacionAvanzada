package analisis;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import coloreo.Coloreo;
import coloreo.NodoColor;
import generadores.Generador;
import grafos.Grafo;
import grafos.GrafoNDNP;

public class Probador {

	public static boolean programaProbador(Coloreo coloreador) throws IOException {

		int cantNodos = coloreador.getGrafo().getFilas();
		int[] nodosColoreados = new int[cantNodos];
		GrafoNDNP g = coloreador.getGrafo();
		ArrayList<NodoColor> nodoConColor = coloreador.getNodosConColor();

		// Nodos adyacentes diferente color
		for (int i = 0; i < cantNodos - 1; i++) {
			System.out.println("\t" + i + "\t");
			for (int j = i + 1; j < cantNodos; j++) {
				System.out.println(i + " " + j);
				if (g.getElemento(i, j) == 1) {
					if (nodoConColor.get(i).getColor() == nodoConColor.get(j).getColor()) {
						return false;
					}
				}
			}
		}
		// Todos Los nodos estan coloreados
		for (int j = 0; j < cantNodos; j++)
			if (nodoConColor.get(j).getColor() == 0)
				return false;
		return true;
	}

}
