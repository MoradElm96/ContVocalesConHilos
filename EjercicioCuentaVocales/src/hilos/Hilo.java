package hilos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import contador.Contador;

//clase hilo cuenta palabra
public class Hilo implements Runnable {

	String nombreFichero;
	char vocal;
	Contador contador;

	public Hilo(String nombreFichero,char vocal, Contador contador) {

		this.nombreFichero = nombreFichero;
		this.vocal=vocal;
		this.contador = contador;

	}

	@Override
	public void run() {
		

		File f = new File(nombreFichero);
		FileReader fr = null;
		
		leerFichero(f, fr, contador, nombreFichero, vocal);

	}

	public static void leerFichero(File f, FileReader fr, Contador contador, String nombreFich,char vocal) {

		try {

			fr = new FileReader(f);
			
			int caracterLeido = fr.read();

			
			while (caracterLeido != -1) {
				char letras = (char) Character.toLowerCase(caracterLeido);

				if (letras == vocal) {

					contador.incrementar();
				}

				caracterLeido = fr.read();

			}


			//System.out.println("La LETRA  " + vocal + "  aparece " + contador.getCont() + " veces");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
	}
}
