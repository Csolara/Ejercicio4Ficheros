package Controladores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String rutaArchivo = "C:\\Users\\Profesor\\Desktop\\eje4.txt";

		System.out.println("Introduze el numero de linea en el que desea escribir.");
		int numeroLinea = Integer.parseInt(sc.nextLine());

		System.out.println("Introduze el numero de posicion en el que desea escribir.");
		int numeroPosicion = Integer.parseInt(sc.nextLine());

		System.out.println("Inserte el texto que desea escribir.");
		String texto = sc.nextLine();	

		try {
			// Leer el archivo línea por línea y guardar cada línea en un StringBuilder
			BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
			StringBuilder contenido = new StringBuilder();
			String lineaActual;
			int contador = 0;
			while ((lineaActual = lector.readLine()) != null) {
				contador++;
				if (contador == numeroLinea) {
					// Modificar la línea deseada
					contenido.append(lineaActual.substring(0, numeroPosicion)).append(texto)
							.append(lineaActual.substring(numeroPosicion));
				} else {
					contenido.append(lineaActual);
				}
				contenido.append(System.lineSeparator());
			}
			lector.close();

			// Escribir el contenido modificado en el archivo
			BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo));
			escritor.write(contenido.toString());
			escritor.close();

			System.out.println("Se ha escrito en la posición específica de la línea exitosamente.");

		} catch (IOException e) {
			System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
