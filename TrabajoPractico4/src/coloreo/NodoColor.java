package coloreo;

public class NodoColor implements Comparable<NodoColor>{

	private int nro;
	private int grado;
	private int color;
	
	public NodoColor(int n, int g) {
		nro=n;
		grado=g;
	}

	@Override
	public int compareTo(NodoColor obj2)
	{
		if(this.grado<obj2.grado)
			return -1;
			
		if(this.grado>obj2.grado)
			return 1;

		return 0;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
}
