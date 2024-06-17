package net.salesianos.diccionario.palabras;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Palabras {
    private Map<Character, Set<String>> palabras = new HashMap<>();

    public boolean agregarPalabra(String palabra) {
        char inicial = palabra.charAt(0);
        return palabras.computeIfAbsent(inicial, k -> new HashSet<>()).add(palabra);
    }

    public boolean eliminarPalabra(String palabra) {
        char inicial = palabra.charAt(0);
        Set<String> conjuntoDePalabras = palabras.get(inicial);
        if (conjuntoDePalabras != null) {
            return conjuntoDePalabras.remove(palabra);
        }
        return false;
    }

    public boolean existePalabra(String palabra) {
        char inicial = palabra.charAt(0);
        Set<String> conjuntoDePalabras = palabras.get(inicial);
        return conjuntoDePalabras != null && conjuntoDePalabras.contains(palabra);
    }

    public Set<Character> obtenerInicialesDisponibles() {
        return palabras.keySet();
    }

    public Set<String> obtenerPalabrasPorInicial(char inicial) {
        return palabras.getOrDefault(inicial, Collections.emptySet());
    }
}
