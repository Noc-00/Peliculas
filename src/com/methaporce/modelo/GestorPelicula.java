package com.methaporce.modelo;

import java.util.ArrayList;
import java.util.List;

public class GestorPelicula {
    private List<Pelicula> peliculas;

    public GestorPelicula() {
        this.peliculas = new ArrayList<>();
    }

    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public void eliminarPelicula(int id) {
        peliculas.removeIf(p -> p.getId() == id);
    }

    public List<Pelicula> obtenerPeliculas() {
        return new ArrayList<>(peliculas);
    }

    public List<Pelicula> obtenerPeliculasDisponibles() {
        List<Pelicula> disponibles = new ArrayList<>();
        for (Pelicula p : peliculas) {
            if (p.isDisponible()) {
                disponibles.add(p);
            }
        }
        return disponibles;
    }

    public List<Pelicula> obtenerPeliculasNoDisponibles() {
        List<Pelicula> noDisponibles = new ArrayList<>();
        for (Pelicula p : peliculas) {
            if (!p.isDisponible()) {
                noDisponibles.add(p);
            }
        }
        return noDisponibles;
    }

    public void marcarPeliculaComoDisponible(int id) {
        for (Pelicula p : peliculas) {
            if (p.getId() == id) {
                p.setDisponible(true);
                break;
            }
        }
    }
}