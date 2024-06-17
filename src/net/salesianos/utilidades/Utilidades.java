package net.salesianos.utilidades;

import java.util.Scanner;

import net.salesianos.diccionario.palabras.Palabras;

public class Utilidades {
    public static String sanitizar(String palabra) {
        return palabra.trim().toLowerCase();
    }
    public static Palabras diccionario = new Palabras();
    public static Scanner scanner = new Scanner(System.in);
}
