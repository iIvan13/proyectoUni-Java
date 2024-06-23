package Cine;

import Cine.Models.Movie;

public class Data {
    public static Movie[] GetMovies() {
        Movie[] movies = {
                new Movie("El Señor de los Anillos: La Comunidad del Anillo", "Peter Jackson", 120, "Acción", 15,
                        "En un mundo fantástico lleno de magia y criaturas extraordinarias, un humilde hobbit llamado Frodo Baggins se embarca en una épica aventura para destruir un poderoso Anillo Único que amenaza con sumir a la Tierra Media en la oscuridad eterna."),
                new Movie("La Isla de los Secretos", "Sofía Martínez", 120, "Acción", 15,
                        "En un futuro distópico donde los secretos y las conspiraciones gobiernan el mundo, una joven valiente descubre la verdad detrás de una isla misteriosa que promete revelar los secretos más oscuros de la humanidad."),
                new Movie("Titanic", "James Cameron", 195, "Romance", 12,
                        "Basada en hechos reales, esta película cuenta la trágica historia de amor entre Jack y Rose, dos jóvenes de diferentes clases sociales que se conocen a bordo del Titanic, el barco de pasajeros más grande y lujoso de su tiempo, que eventualmente se hunde en el Atlántico Norte."),
                new Movie("Interestelar", "Christopher Nolan", 169, "Sci-Fi", 10,
                        "En un futuro donde la Tierra está al borde del colapso ambiental, un grupo de astronautas se embarca en un viaje interestelar a través de un agujero de gusano recientemente descubierto. Su misión es encontrar un nuevo hogar para la humanidad más allá de nuestro sistema solar, enfrentando peligros cósmicos y desafíos impredecibles."),
                new Movie("El Padrino", "Francis Ford Coppola", 175, "Drama", 18,
                        "Esta icónica película narra la historia de la familia mafiosa Corleone en Nueva York. Don Vito Corleone, el patriarca, debe manejar el legado de su imperio criminal mientras lucha por mantener el equilibrio entre la lealtad familiar, la violencia despiadada y su deseo de legitimidad en una sociedad cambiante."),
                new Movie("Toy Story", "John Lasseter", 81, "Animation", 0,
                        "En el cuarto de Andy, los juguetes tienen vida propia cuando los humanos no están mirando. Cuando el vaquero Woody se ve amenazado por la llegada del moderno Buzz Lightyear, comienza una aventura para restaurar la armonía entre los juguetes y recuperar el corazón de su dueño."),
                new Movie("Matrix", "Lana Wachowski, Lilly Wachowski", 136, "Sci-Fi", 15,
                        "En un mundo controlado por máquinas, un hacker llamado Neo descubre la verdad detrás de su existencia y se une a la resistencia para liberar a la humanidad de su opresión tecnológica."),
                new Movie("La La Land", "Damien Chazelle", 128, "Drama", 10,
                        "En la ciudad de Los Ángeles, dos artistas apasionados, Mia y Sebastian, luchan por perseguir sus sueños mientras navegan por el amor y las dificultades del éxito en la industria del entretenimiento."),
                new Movie("Avatar", "James Cameron", 162, "Sci-Fi", 12,
                        "En el planeta Pandora, un exmarine discapacitado se embarca en una misión para integrarse con los nativos Na'vi y proteger su hogar de la explotación de recursos por parte de los humanos."),
                new Movie("El Resplandor", "Stanley Kubrick", 146, "Horror", 18,
                        "Un escritor acepta un trabajo como cuidador de un hotel aislado durante el invierno, donde su cordura comienza a desmoronarse bajo la influencia maligna del lugar."),
        };

        return movies;
    }
}
