package Cine;

import Cine.Models.*;

public class Data {
    public static Movie[] GetMovies() {
        Movie[] movies = {
                new Movie("El Señor de los Anillos: La Comunidad del Anillo", "Peter Jackson", 120, "Acción", 15,
                        "En un mundo fantástico lleno de magia y criaturas extraordinarias, un humilde hobbit llamado Frodo Baggins se embarca en una épica aventura para destruir un poderoso Anillo Único que amenaza con sumir a la Tierra Media en la oscuridad eterna.", 10),
                new Movie("La Isla de los Secretos", "Sofía Martínez", 120, "Acción", 15,
                        "En un futuro distópico donde los secretos y las conspiraciones gobiernan el mundo, una joven valiente descubre la verdad detrás de una isla misteriosa que promete revelar los secretos más oscuros de la humanidad.", 20),
                new Movie("Titanic", "James Cameron", 195, "Romance", 12,
                        "Basada en hechos reales, esta película cuenta la trágica historia de amor entre Jack y Rose, dos jóvenes de diferentes clases sociales que se conocen a bordo del Titanic, el barco de pasajeros más grande y lujoso de su tiempo, que eventualmente se hunde en el Atlántico Norte.", 15),
                new Movie("Interestelar", "Christopher Nolan", 169, "Sci-Fi", 10,
                        "En un futuro donde la Tierra está al borde del colapso ambiental, un grupo de astronautas se embarca en un viaje interestelar a través de un agujero de gusano recientemente descubierto. Su misión es encontrar un nuevo hogar para la humanidad más allá de nuestro sistema solar, enfrentando peligros cósmicos y desafíos impredecibles.", 10),
                new Movie("El Padrino", "Francis Ford Coppola", 175, "Drama", 18,
                        "Esta icónica película narra la historia de la familia mafiosa Corleone en Nueva York. Don Vito Corleone, el patriarca, debe manejar el legado de su imperio criminal mientras lucha por mantener el equilibrio entre la lealtad familiar, la violencia despiadada y su deseo de legitimidad en una sociedad cambiante." , 15),
                new Movie("Toy Story", "John Lasseter", 81, "Animation", 0,
                        "En el cuarto de Andy, los juguetes tienen vida propia cuando los humanos no están mirando. Cuando el vaquero Woody se ve amenazado por la llegada del moderno Buzz Lightyear, comienza una aventura para restaurar la armonía entre los juguetes y recuperar el corazón de su dueño." , 10),
                new Movie("Matrix", "Lana Wachowski, Lilly Wachowski", 136, "Sci-Fi", 15,
                        "En un mundo controlado por máquinas, un hacker llamado Neo descubre la verdad detrás de su existencia y se une a la resistencia para liberar a la humanidad de su opresión tecnológica.", 20),
                new Movie("La La Land", "Damien Chazelle", 128, "Drama", 10,
                        "En la ciudad de Los Ángeles, dos artistas apasionados, Mia y Sebastian, luchan por perseguir sus sueños mientras navegan por el amor y las dificultades del éxito en la industria del entretenimiento.", 15),
                new Movie("Avatar", "James Cameron", 162, "Sci-Fi", 12,
                        "En el planeta Pandora, un exmarine discapacitado se embarca en una misión para integrarse con los nativos Na'vi y proteger su hogar de la explotación de recursos por parte de los humanos.", 20),
                new Movie("El Resplandor", "Stanley Kubrick", 146, "Horror", 18,
                        "Un escritor acepta un trabajo como cuidador de un hotel aislado durante el invierno, donde su cordura comienza a desmoronarse bajo la influencia maligna del lugar.", 15),
        };

        return movies;
    }

    public static Combo[] GetCombos() {
        Combo[] combos = {
                new Combo("Canchita Grande con Sal", 20, "1 Canchita Grande con sal + 2 Gaseosas Medianas"),
                new Combo("Pizza Familiar Especial", 30, "1 Pizza Familiar + 1 Ensalada + 1 Gaseosa Grande"),
                new Combo("Hamburguesa Doble con Queso", 25,
                        "2 Hamburguesas Dobles + Papas Fritas + 1 Gaseosa Mediana"),
                new Combo("Hot Dog Clásico", 15, "2 Hot Dogs + 1 Gaseosa Pequeña"),
                new Combo("Sándwich de Pollo BBQ", 18, "1 Sándwich de Pollo BBQ + 1 Ensalada + 1 Jugo Natural"),
                new Combo("Combo Vegetariano", 20, "Wrap Vegetariano + 1 Porción de Frutas + 1 Agua Mineral"),
                new Combo("Menú Ejecutivo", 22, "1 Plato del Día + 1 Bebida (a elegir) + 1 Postre"),
                new Combo("Combo Fitness", 17, "Ensalada Mixta + Agua Mineral + Frutas Frescas"),
                new Combo("Desayuno Energético", 12, "1 Batido de Frutas + 1 Porción de Pan Integral con Mermelada"),
                new Combo("Merienda Dulce", 10, "1 Porción de Tarta + 1 Café o Té")
        };

        return combos;
    }
}
