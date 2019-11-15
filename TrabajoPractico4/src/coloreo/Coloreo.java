package coloreo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import grafos.GrafoNDNP;
import grafos.MatrizSimetrica;

public class Coloreo {
	private GrafoNDNP grafo;
	private int gradMax;
	private int gradMin;
	private double porcentaje;
	private int cantNodos;
	private ArrayList<NodoColor> nodosConColor;

	public Coloreo(GrafoNDNP g) {
		grafo = g;
		gradMax = g.getGradoMax();
		gradMin = g.getGradoMin();
		porcentaje = g.getPorcentaje();
		cantNodos = g.getFilas();
		nodosConColor = new ArrayList<NodoColor>();
		cargarNodos(nodosConColor);
	}

	private void cargarNodos(ArrayList<NodoColor> nodos) {
		for (int i = 0; i < cantNodos; i++) {
			nodosConColor.add(new NodoColor(i, 0, 0));
		}

		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				if (grafo.getElemento(i, j) == 1) {
					nodosConColor.get(i).setGrado(nodosConColor.get(i).getGrado() + 1);
					nodosConColor.get(j).setGrado(nodosConColor.get(j).getGrado() + 1);
				}
			}
		}
	}

	public int pintarGrafo() {
		int colorAct = 1;
//		 instancio el array de colores
		int[] colores = new int[cantNodos];
		colores[0] = colorAct;
		for (int i = 0; i < cantNodos; i++) {
//			si el nodo actual no tiene color
			int nodoActual = nodosConColor.get(i).getNro();
			if (nodosConColor.get(i).getColor() == 0) {

				int colorTemporal = 1;
//				mientras color temporal este definido y sea adyacente al nodo actual, lo cambio
				while (colorTemporal <= colorAct
						&& esColorAdyacente(colorTemporal, nodosConColor.get(i).getNro(), grafo))
					colorTemporal++;//
//				 si el color temporal es menor al color actual, no es adyacente al nodo actual, asi que pinto el nodo con este color
				if (colorTemporal <= colorAct) {
					nodosConColor.get(i).setColor(colorTemporal);
				} else {
//					como todos los colores definidos son adyacentes creo uno nuevo y se lo pongo al nodo actual
					colores[colorAct] = ++colorAct;

					nodosConColor.get(i).setColor(colorAct);
				}
			}
		}
		
		System.out.println();
		for(int i = 0; i < cantNodos; i++) {
			System.out.println(nodosConColor.get(i).getColor() + " " + i + " " + nodosConColor.get(i).getNro() );
		}
		
		return colorAct;// devuelvo el total de colores
	}

	public int sinOrden() {
		return this.pintarGrafo();
	}
	
	public int coloreoAleatorio() {
		this.ordenarAleatoriamente();
		return this.pintarGrafo();
	}

	public int coloreoWellshPowell() {
		this.ordenarDescententemente();
		return this.pintarGrafo();
	}

	public int coloreoMatula() {
		this.ordenarAscendentemente();
		return this.pintarGrafo();
	}

	public void ordenarAleatoriamente() {
		for (int i = 0; i < cantNodos; i++) {
			int posA = (int) Math.floor((Math.random() * this.cantNodos));
			int posB = (int) Math.floor((Math.random() * this.cantNodos));

			NodoColor aux = nodosConColor.get(posB);
			nodosConColor.set(posB, nodosConColor.get(posA));
			this.nodosConColor.set(posA, aux);
		}
	}

	public void ordenarDescententemente() {

		nodosConColor.sort(new Comparator<NodoColor>() {

			@Override
			public int compare(NodoColor nodo1, NodoColor nodo2) {
				if(nodo2.getGrado() - nodo1.getGrado() != 0)
					return nodo2.getGrado() - nodo1.getGrado();
				return nodo2.getNro() - nodo1.getNro();
			}

		});
//		
//		for(int i = 0; i < this.cantNodos-1; i++)
//		{
//			for(int j = 0; j < this.cantNodos-1; j++)
//			{
//				if(this.nodosConColor.get(j).compareTo(this.nodosConColor.get(j+1))<0)
//				{
//					NodoColor aux = this.nodosConColor.get(j);
//					this.nodosConColor.set(j,this.nodosConColor.get(j+1));
//					this.nodosConColor.set(j+1, aux);
//					
//				}
//			}
//		}
	}

	public void ordenarAscendentemente() {

		nodosConColor.sort(new Comparator<NodoColor>() {

			@Override
			public int compare(NodoColor nodo1, NodoColor nodo2) {
				if(nodo1.getGrado() - nodo2.getGrado() != 0)
					return nodo1.getGrado() - nodo2.getGrado();
				return nodo1.getNro() - nodo2.getNro();
			}

		});
//		for (int i = 0; i < this.cantNodos - 1; i++) {
//			for (int j = 0; j < this.cantNodos - 1; j++) {
//				if (this.nodosConColor.get(j).compareTo(this.nodosConColor.get(j + 1)) > 0) {
//					NodoColor aux = this.nodosConColor.get(j);
//					this.nodosConColor.set(j, this.nodosConColor.get(j + 1));
//					this.nodosConColor.set(j + 1, aux);
//
//				}
//			}
//		}
	}

	private boolean esColorAdyacente(int color, int nodoEvaluado, GrafoNDNP adyacencias) {
		for (int i = 0; i < cantNodos; i++) {
			if (nodosConColor.get(i).getNro() != nodoEvaluado && ((adyacencias.getElemento(nodoEvaluado, nodosConColor.get(i).getNro()) == 1 ||  ( adyacencias.getElemento(nodosConColor.get(i).getNro(), nodoEvaluado) == 1 )))) {
				if (color == nodosConColor.get(i).getColor())
					return true;
			}
		}
		return false;
	}

	public GrafoNDNP getGrafo() {
		return grafo;
	}

	public void setGrafo(GrafoNDNP grafo) {
		this.grafo = grafo;
	}

}
