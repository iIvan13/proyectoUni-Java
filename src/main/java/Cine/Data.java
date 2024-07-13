package Cine;

import Cine.Models.*;
import java.util.Arrays;

public class Data {
    public static Movie[] GetMovies() {
        Movie[] movies = {
                new Movie("Deadpool Wolverine", "Shawn Levy", 120, "Acción", 15,
                        "Deadpool y Wolverine unen fuerzas en una misión llena de acción y humor. Juntos enfrentan nuevos enemigos y viejos conocidos en una aventura épica.",
                        Arrays.asList("11:00am", "1:00pm", "3:00pm", "5:00pm", "7:00pm",
                                "9:00pm"),
                        "https://i0.wp.com/www.tomosygrapas.com/wp-content/uploads/2024/04/Deadpool-3-poster-1.jpg?ssl=1",
                        "IMAX"),
                new Movie("Un Lugar en Silencio: Día 1", "John Krasinski", 100, "Terror", 12,
                        "El inicio de la invasión alienígena que sumerge al mundo en un silencio mortal. La humanidad lucha por sobrevivir sin hacer ruido.",
                        Arrays.asList("10:00am", "12:00pm", "2:00pm", "4:00pm", "6:00pm",
                                "8:00pm"),
                        "https://palomaynacho-1f321.kxcdn.com/wp-content/uploads/2024/05/Un-lugar-en-silencio-poster-1-scaled.jpg",
                        "REGULAR 2D"),
                new Movie("Furiosa", "George Miller", 130, "Acción", 15,
                        "Una precuela que cuenta la historia de Imperator Furiosa antes de los eventos de Mad Max: Fury Road. Un viaje lleno de acción en un mundo postapocalíptico.",
                        Arrays.asList("11:00am", "1:30pm", "4:00pm", "6:30pm", "9:00pm"),
                        "https://lh6.googleusercontent.com/proxy/FzzvnO-5Tml7D6wxLfjg1TMeBd3gRmkxJnbUO3TV5q7qfUD186K7jy7Sk9Qzfq7Ft1SbfLrZ452ey987bjVCftqT06-fI74InA",
                        "IMAX"),
                new Movie("Top Gun", "Tony Scott", 110, "Acción", 12,
                        "Un joven piloto de la Marina de los EE.UU., Maverick, ingresa a una escuela de élite de aviación, donde enfrenta desafíos tanto personales como profesionales.",
                        Arrays.asList("10:00am", "12:00pm", "2:00pm", "4:00pm", "6:00pm",
                                "8:00pm"),
                        "https://i.ebayimg.com/images/g/fsIAAOSwAuZmcV~u/s-l1600.jpg", "REGULAR 3D"),
                new Movie("La Monja", "Corin Hardy", 96, "Terror", 15,
                        "Un sacerdote con un pasado atormentado y una novicia a punto de tomar sus votos se enfrentan a una fuerza maligna en forma de una monja demoníaca.",
                        Arrays.asList("11:00am", "1:00pm", "3:00pm", "5:00pm", "7:00pm",
                                "9:00pm"),
                        "https://hips.hearstapps.com/es.h-cdn.co/fotoes/images/media/imagenes/recursos/la-monja-poster-pelicula/138144618-1-esl-ES/la-monja-poster-pelicula.jpg",
                        "IMAX")

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
