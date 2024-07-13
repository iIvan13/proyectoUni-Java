package Cine;

import Cine.Models.*;
import java.util.Arrays;

public class Data {
    public static Movie[] GetMovies() {
        Movie[] movies = {
                new Movie("El Señor de los Anillos: La Comunidad del Anillo", "Peter Jackson", 120,
                        "Acción", 15,
                        "En un mundo fantástico lleno de magia y criaturas extraordinarias, un humilde hobbit llamado Frodo Baggins se embarca en una épica aventura para destruir un poderoso Anillo Único que amenaza con sumir a la Tierra Media en la oscuridad eterna.",
                        Arrays.asList("3:00", "7:00")),
                new Movie("La Isla de los Secretos", "Sofía Martínez", 120, "Acción", 15,
                        "En un futuro distópico donde los secretos y las conspiraciones gobiernan el mundo, una joven valiente descubre la verdad detrás de una isla misteriosa que promete revelar los secretos más oscuros de la humanidad.",
                        Arrays.asList("3:00", "7:00")),
                new Movie("Titanic", "James Cameron", 195, "Romance", 12,
                        "Basada en hechos reales, esta película cuenta la trágica historia de amor entre Jack y Rose, dos jóvenes de diferentes clases sociales que se conocen a bordo del Titanic, el barco de pasajeros más grande y lujoso de su tiempo, que eventualmente se hunde en el Atlántico Norte.",
                        Arrays.asList("3:00", "7:00")),
                new Movie("Interestelar", "Christopher Nolan", 169, "Sci-Fi", 10,
                        "En un futuro donde la Tierra está al borde del colapso ambiental, un grupo de astronautas se embarca en un viaje interestelar a través de un agujero de gusano recientemente descubierto. Su misión es encontrar un nuevo hogar para la humanidad más allá de nuestro sistema solar, enfrentando peligros cósmicos y desafíos impredecibles.",
                        Arrays.asList("3:00", "7:00")),
                new Movie("El Padrón", "Sofía Martínez", 120, "Acción", 15,
                        "En un mundo fantástico lleno de magia y criaturas extraordinarias, un humilde hobbit llamado Frodo Baggins se embarca en una épica aventura para destruir un poderoso Anillo Único que amenaza con sumir a la Tierra Media en la oscuridad eterna.",
                        Arrays.asList("3:00", "7:00"))
        };

        return movies;
    }

    public static Entry[] GetEntries() {
        Entry[] entries = {
                new Entry("General", 20),
                new Entry("Mayores 60 años", 15),
                new Entry("Niños", 13)
        };

        return entries;
    };

    public static Combo[] GetCombos() {
        Combo[] combos = {
                new Combo("Canchita Grande con Sal", 20,
                        "1 Canchita Grande con sal + 2 Gaseosas Medianas"),
                new Combo("Pizza Familiar Especial", 30,
                        "1 Pizza Familiar + 1 Ensalada + 1 Gaseosa Grande"),
                new Combo("Hamburguesa Doble con Queso", 25,
                        "2 Hamburguesas Dobles + Papas Fritas + 1 Gaseosa Mediana"),
                new Combo("Hot Dog Clásico", 15, "2 Hot Dogs + 1 Gaseosa Pequeña"),
                new Combo("Sándwich de Pollo BBQ", 18,
                        "1 Sándwich de Pollo BBQ + 1 Ensalada + 1 Jugo Natural"),
        };

        return combos;
    }
}
