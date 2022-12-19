package util;

import contador.Contador;
import hilos.Hilo;

public class LanzarPrograma {

	public static void main(String[] args) {

		// ------------------------------------------------------------------------------------------
		// si se quiere recibir por argumento el fichero de texto:
		// descomentar la linea de abajo. y comentar la siguiente
		// String nombreFicheroEntrada = args[0];

		// para recibir cinco palabras por argumento, previamente va el nombre del
		// fichero de texto
		/*
		 * char letra1=args[1]; char letra2=args[2]; char letra3=args[3]; char
		 * letra4=args[4]; char letra5=args[5];
		 */
		// ----------------------------------------------------------------------------------------------

		String nombreFicheroEntrada = "texto2.txt";
		// esta en la carpeta raiz por eso no se pone la ruta

		// los hilos reciben por parametros el nombre fichero y la letra vocal, en este
		// caso puede ser cualquier caracter

		char letra1 = 'a';
		char letra2 = 'e';
		char letra3 = 'i';
		char letra4 = 'o';
		char letra5 = 'u';

		Contador contador1 = new Contador(0);
		Contador contador2 = new Contador(0);
		Contador contador3 = new Contador(0);
		Contador contador4 = new Contador(0);
		Contador contador5 = new Contador(0);

		Hilo h1 = new Hilo(nombreFicheroEntrada, letra1, contador1);
		Hilo h2 = new Hilo(nombreFicheroEntrada, letra2, contador2);
		Hilo h3 = new Hilo(nombreFicheroEntrada, letra3, contador3);
		Hilo h4 = new Hilo(nombreFicheroEntrada, letra4, contador4);
		Hilo h5 = new Hilo(nombreFicheroEntrada, letra5, contador5);

		Thread t1 = new Thread(h1);
		Thread t2 = new Thread(h2);
		Thread t3 = new Thread(h3);
		Thread t4 = new Thread(h4);
		Thread t5 = new Thread(h5);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		// join para que esperar a que termine cada hilo
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();

		} catch (InterruptedException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Hilo " + t1.getName() + " cuenta  la letra: " + letra1 + "  aparece " + contador1.getCont()
				+ " veces");
		System.out.println("Hilo " + t2.getName() + " cuenta  la letra: " + letra2 + "  aparece " + contador2.getCont()
				+ " veces");
		System.out.println("Hilo " + t3.getName() + " cuenta  la letra: " + letra3 + "  aparece " + contador3.getCont()
				+ " veces");
		System.out.println("Hilo " + t4.getName() + " cuenta  la letra: " + letra4 + "  aparece " + contador4.getCont()
				+ " veces");
		System.out.println("Hilo " + t5.getName() + " cuenta  la letra: " + letra5 + "  aparece " + contador5.getCont()
				+ " veces");

		System.out.println("estado:" + t1.getName() + " " + t1.getState());
		System.out.println("estado:" + t2.getName() + " " + t2.getState());
		System.out.println("estado:" + t3.getName() + " " + t3.getState());
		System.out.println("estado:" + t4.getName() + " " + t4.getState());
		System.out.println("estado:" + t5.getName() + " " + t5.getState());

		System.out.println("Fin del programa");

	}

}



//otra opcion era hacer array de hilos, se intentó pero sin exito.
/*
* char[] vocales = { 'a', 'e', 'i', 'o', 'u' };
* 
* Hilo hilos = null; Thread[] thread = new Thread[4];
* 
* 
* for (int i = 0; i < thread.length; i++) {
* 
* 
* for (int j = 0; j < vocales.length; j++) { thread[i]= new Thread(new
* Hilo(nombreFicheroEntrada,vocales[j])); thread[i].start();
* 
* try { thread[i].join(); } catch (InterruptedException e) { // TODO
* Auto-generated catch block e.printStackTrace(); } }
* 
* 
* }
*/

