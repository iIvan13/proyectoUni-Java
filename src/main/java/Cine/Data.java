package Cine;

import Cine.Models.Movie;

public class Data {
    public static Models.Movie[] GetMovies() {
        Movie[] movies = {
                new Movie("El Señor de los Anillos: La Comunidad del Anillo", "Peter Jackson", 120, "Action", 15,
                        "lorem ipsum dolor sit amet"),
                new Movie("La Isla de los Secretos", "Sofía Martínez", 120, "Action", 15, "lorem ipsum dolor sit amet"),
        };

        return movies;
    }
}
