package generadores;


import java.io.IOException;

import analisis.Analisis;
import grafos.Grafo;
import utilitarios.Archivo;

public class aplicacion {
	public static void main(String[] args) throws IOException {
		int n = 600;
//		
		double porcentaje;
//		
//		porcentaje = 40.0;
//		Analisis analizador1 = new Analisis();
//		analizador1.startAnalisisGrafos(n, porcentaje, 10000);
		
		porcentaje = 40.0;
		Analisis analizador1 = new Analisis();
		analizador1.startAnalisisGrafos(n, porcentaje, 10);
		
//		porcentaje = 60.0;
//		Analisis analizador2 = new Analisis();
//		analizador2.startAnalisisGrafos(n, porcentaje, 10000);
		
//		porcentaje = 90.0;
//		Analisis analizador3 = new Analisis();
//		analizador3.startAnalisisGrafos(n, porcentaje, 10000);
		
		
		///////////////////////////////////////
		
		n = 6;
		
		porcentaje = 100.0;
		Analisis analizadorReg1 = new Analisis();
		analizadorReg1.startAnalisisGrafosReg(n, porcentaje, 10000);
//		
//		porcentaje = 75.0;
//		Analisis analizadorReg2 = new Analisis();
//		analizadorReg2.startAnalisisGrafos(n, porcentaje, 10000);
	}
}
