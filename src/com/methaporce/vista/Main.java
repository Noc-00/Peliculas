package com.methaporce.vista;

import com.methaporce.modelo.GestorPelicula;
import com.methaporce.modelo.Pelicula;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorPelicula gestor = new GestorPelicula();

        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Agregar película");
            System.out.println("2. Eliminar película");
            System.out.println("3. Marcar película como disponible");
            System.out.println("4. Mostrar todas las películas");
            System.out.println("5. Mostrar películas disponibles");
            System.out.println("6. Mostrar películas no disponibles");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer

            switch (opcion) {
                case 1:
                    System.out.print("ID de la película: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpia el buffer
                    System.out.print("Nombre de la película: ");
                    String nombre = scanner.nextLine();
                    System.out.print("¿Está disponible? (true/false): ");
                    boolean disponible = scanner.nextBoolean();
                    Pelicula nueva = new Pelicula(id, nombre, disponible);
                    gestor.agregarPelicula(nueva);
                    System.out.println("Película agregada.");
                    break;
                case 2:
                    System.out.print("ID de la película: ");
                    int idEliminar = scanner.nextInt();
                    gestor.eliminarPelicula(idEliminar);
                    System.out.println("Película eliminada.");
                    break;
                case 3:
                    System.out.print("ID de la película: ");
                    int idDisponible = scanner.nextInt();
                    gestor.marcarPeliculaComoDisponible(idDisponible);
                    System.out.println("Película marcada como disponible.");
                    break;
                case 4:
                    List<Pelicula> todas = gestor.obtenerPeliculas();
                    System.out.println("--- Todas las películas ---");
                    for (Pelicula p : todas) {
                        System.out.println(p);
                    }
                    break;
                case 5:
                    List<Pelicula> disponibles = gestor.obtenerPeliculasDisponibles();
                    System.out.println("--- Películas disponibles ---");
                    for (Pelicula p : disponibles) {
                        System.out.println(p);
                    }
                    break;
                case 6:
                    List<Pelicula> noDisponibles = gestor.obtenerPeliculasNoDisponibles();
                    System.out.println("--- Películas NO disponibles ---");
                    for (Pelicula p : noDisponibles) {
                        System.out.println(p);
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}