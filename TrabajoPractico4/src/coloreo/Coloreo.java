package coloreo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import grafos.GrafoNDNP;

public class Coloreo {
	private GrafoNDNP grafo;
	private int gradMax;
	private int gradMin;
	private double porcentaje;
	private int cantNodos;
	private NodoColor[] colores;
	
	public void pintarGrafo()
	{
		int colorAct = 1;
		int contColores = 1;
		cantNodos = grafo.getCantidadDeElementos();
		int[] colores = new int [cantNodos];
		List <NodoColor> nodos = new ArrayList<NodoColor>();
		int ccol = 0;

		for (int i = 1; i <= cantNodos; i++)
		{
			int nodoAct = nodos.get(i).getNro();
			int colorI = nodos.get(i).getColor();
			if (colorI == 0) 
			{
				nodos.get(i).setColor(colorAct);
				colores[0] = nodoAct;
				ccol++;//

				for (int nodoComp = i + 1; nodoComp <= cantNodos; nodoComp++)
				{
					int nodoJ = nodos.get(nodoComp).getNro();
					int colorJ = nodos.get(nodoComp).getColor();
					if (nodoComp != i && !!esAdyacente(colores, contColores, nodoJ) && colorJ == 0)
						nodos.get(nodoComp).setColor(colorAct);
				}

				colorAct++;
			}
		}
	}

	
	public void coloreoAleatorio() 
	{	
		this.ordenarAleatoriamente();
		this.pintarGrafo();
	}

	public void coloreoWellshPowell() 
	{	
		this.ordenarDescententemente();
		this.pintarGrafo();
	}
	
	public void coloreoMatula() 
	{	
		this.ordenarAscendentemente();
		this.pintarGrafo();
	}
	
	public void ordenarAleatoriamente()
	{
		for(int i = 0; i < cantNodos; i++)
		{
			int posA = (int) (Math.random()*this.cantNodos);
			int posB = (int) (Math.random()*this.cantNodos);
			
			NodoColor aux = colores[posB];
			this.colores[posB] = this.colores[posA];
			this.colores[posA] = aux;
		}
	}
	
	public void ordenarDescententemente()
	{
		for(int i = 0; i < this.cantNodos-1; i++)
		{
			for(int j = 0; j < this.cantNodos-1; j++)
			{
				if(this.colores[j].compareTo(this.colores[j+1])<0)
				{
					NodoColor aux = this.colores[j];
					this.colores[j] = this.colores[j+1];
					this.colores[j+1] = aux;
					
				}
			}
		}
	}
	
	public void ordenarAscendentemente()
	{
		for(int i = 0; i < this.cantNodos-1; i++)
		{
			for(int j = 0; j < this.cantNodos-1; j++)
			{
				if(this.colores[j].compareTo(this.colores[j+1])>0)
				{
					NodoColor aux = this.colores[j];
					this.colores[j] = this.colores[j+1];
					this.colores[j+1] = aux;
					
				}
			}
		}
	}
	
	private boolean esAdyacente(int[] colores, int limite, int nodoJ) {
		boolean res = false;
		for(int nodoVisto =0;nodoVisto < limite;nodoVisto++) {
			if (grafo.getValor(nodoJ, colores[nodoVisto])==1)
				res = true;
		}
		return res;
	}
}
