import net.salesianos.utilidades.Utilidades;




public class App {
    
    public static void main(String[] args) throws Exception {
        
        System.out.println("Bienvenido al gestor de palabras.");
        int opcion;
        do {
            mostrarMenu();
            opcion = Utilidades.scanner.nextInt();
            Utilidades.scanner.nextLine(); // Consumir el carácter de nueva línea
            manejarOpcionDelMenu(opcion);
        } while (opcion != 6);
    }   

    private static void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Añadir palabra");
        System.out.println("2. Eliminar palabra");
        System.out.println("3. Existe palabra");
        System.out.println("4. Mostrar iniciales disponibles");
        System.out.println("5. Ver palabras por inicial");
        System.out.println("6. Cerrar programa");
        System.out.print("Seleccione una opción: ");
    }

    private static void manejarOpcionDelMenu(int opcion) {
        switch (opcion) {
            case 1:
                System.out.print("Ingrese una palabra: ");
                String palabraParaAgregar = Utilidades.scanner.nextLine();
                if (Utilidades.diccionario.agregarPalabra(Utilidades.sanitizar(palabraParaAgregar))) {
                    System.out.println("Palabra añadida correctamente.");
                } else {
                    System.out.println("La palabra ya existe.");
                }
                break;
            case 2:
                System.out.print("Ingrese una palabra para eliminar: ");
                String palabraParaEliminar = Utilidades.scanner.nextLine();
                if (Utilidades.diccionario.eliminarPalabra(Utilidades.sanitizar(palabraParaEliminar))) {
                    System.out.println("Palabra eliminada correctamente.");
                } else {
                    System.out.println("La palabra no se encontró.");
                }
                break;
            case 3:
                System.out.print("Ingrese una palabra para buscar: ");
                String palabraParaBuscar = Utilidades.scanner.nextLine();
                if (Utilidades.diccionario.existePalabra(Utilidades.sanitizar(palabraParaBuscar))) {
                    System.out.println("La palabra existe en el diccionario.");
                } else {
                    System.out.println("La palabra no se encontró.");
                }
                break;
            case 4:
                System.out.println("Iniciales disponibles:");
                System.out.println(Utilidades.diccionario.obtenerInicialesDisponibles());
                break;
            case 5:
                System.out.print("Ingrese una inicial: ");
                char inicial = Utilidades.scanner.nextLine().charAt(0);
                System.out.println("Palabras con inicial " + inicial + ":");
                System.out.println(Utilidades.diccionario.obtenerPalabrasPorInicial(inicial));
                break;
            case 6:
                System.out.println("Saliendo del programa.");
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }
}
