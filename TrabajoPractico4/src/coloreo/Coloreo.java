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
		
		int setColor = 1; //El color con que arrancamos a pintar
		
		for (int i = 0; i < cantNodos; i++) {
//			 instancio el array de colores
			int[] colores = new int[cantNodos];
			
			int contadorColores = 1; //cuenta la cantidad de nodos que colorie en un iteracion para un color.
//			si el nodo actual no tiene color
			int nodoActual = nodosConColor.get(i).getNro();
			int colorActual = nodosConColor.get(i).getColor();
			if ( colorActual == 0) { //si nodo actual no esta coloreado
				colores[0] = nodoActual; //lo agrego a la lista de nodos coloreados
				nodosConColor.get(i).setColor(setColor); //seteo su color

				for(int j = i + 1; j < cantNodos;j++) { //viendo solo la triangular superior, hasta cantidad de nodos
					int nodoJ = nodosConColor.get(j).getNro(); 
					int colorJ = nodosConColor.get(j).getColor();
					if(nodoActual != nodoJ && !esAdyacente(colores, contadorColores, nodoJ) && colorJ == 0) { //si ese nodo es distinto de mi nodo actual Y no es adyacente Y no tiene color
						nodosConColor.get(j).setColor(setColor); //lo pinto
						colores[contadorColores] = nodoJ; //lo agrego a la lista de nodos coloreados
						contadorColores++; //
					}
				}
				setColor++;//Cambio al siguiente color
			}
			
			
			
		}
		return setColor-1; //devuelvo cantidad de colores 
		
//		System.out.println();
//		for(int i = 0; i < cantNodos; i++) {
//			System.out.println(nodosConColor.get(i).getColor() + " " + i + " " + nodosConColor.get(i).getNro() );
//		}
	}

	public int sinOrden() {
		Collections.shuffle(nodosConColor);
		return this.pintarGrafo();
	}
	
	public int coloreoAleatorio() {
		Collections.shuffle(nodosConColor);
		return this.pintarGrafo();
	}

	public int coloreoWellshPowell() {
		Collections.shuffle(nodosConColor);
		this.ordenarDescententemente();
		return this.pintarGrafo();
	}

	public int coloreoMatula() {
		Collections.shuffle(nodosConColor);
		this.ordenarAscendentemente();
		return this.pintarGrafo();
	}


	public void ordenarDescententemente() {

		nodosConColor.sort(new Comparator<NodoColor>() {

			@Override
			public int compare(NodoColor nodo1, NodoColor nodo2) {
				return nodo2.getGrado() - nodo1.getGrado();
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
				return nodo1.getGrado() - nodo2.getGrado();
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

//	private boolean esColorAdyacente(int color, int nodoEvaluado, GrafoNDNP adyacencias) {
//		for (int i = 0; i < cantNodos; i++) {
//			if (nodosConColor.get(i).getNro() != nodoEvaluado && ((adyacencias.getElemento(nodoEvaluado, nodosConColor.get(i).getNro()) == 1 ||  ( adyacencias.getElemento(nodosConColor.get(i).getNro(), nodoEvaluado) == 1 )))) {
//				if (color == nodosConColor.get(i).getColor())
//					return true;
//			}
//		}
//		return false;
//	}
	
	private boolean esAdyacente(int[] colores, int limite, int nodoJ) {
		boolean res = false;
		int nodoVisto = 0;
		while(nodoVisto < limite) {
			if (grafo.getValor(nodoJ, colores[nodoVisto])==1)
				res = true;
			nodoVisto++;
		}
		return res;
	}
	
	public GrafoNDNP getGrafo() {
		return grafo;
	}

	public void setGrafo(GrafoNDNP grafo) {
		this.grafo = grafo;
	}

	public ArrayList<NodoColor> getNodosConColor() {
		return nodosConColor;
	}

	public void setNodosConColor(ArrayList<NodoColor> nodosConColor) {
		this.nodosConColor = nodosConColor;
	}
	
}
