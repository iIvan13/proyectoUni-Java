package Cine;

import java.util.Scanner;

import Cine.Models.*;

public class Controllers {

    @SuppressWarnings("resource")
    public static User Login() {

        Scanner scan = new Scanner(System.in);
        String name = null, email = null, dni = null;

        System.out.println("Ingrese su nombre:");
        name = scan.nextLine();

        System.out.println("Ingrese su correo electrónico:");
        email = scan.nextLine();

        System.out.println("Ingrese su DNI:");
        dni = scan.nextLine();

        User user = new User(name, email, dni);

        return user;

    }

    public static Movie SelectMovie() {
        Movie[] movies = {
                new Movie("El Señor de los Anillos: La Comunidad del Anillo", 2021, "Peter Jackson"),
                new Movie("La Isla de los Secretos", 2023, "Sofía Martínez"),
                new Movie("Aventuras en el Espacio Profundo", 2022, "James Cameron"),
                new Movie("El Enigma del Tiempo Perdido", 2024, "Lucía López"),
                new Movie("El Último Guerrero Samurai", 2025, "Akira Kurosawa"),
                new Movie("Misterios del Antiguo Egipto", 2023, "Elena Ramírez"),
                new Movie("La Ciudad de las Sombras", 2024, "Gabriel Silva"),
                new Movie("El Secreto del Bosque Encantado", 2022, "María Fernández"),
                new Movie("Aventuras en la Tierra de los Dragones", 2023, "Carlos Ruiz"),
                new Movie("El Misterio del Mar Profundo", 2025, "Andrés Gómez")
        };

        for(int i = 0; i < movies.length; i++) {
            System.out.println((i + 1) + ". " + movies[i]);
            System.out.println();
        }
    
        return null;
    }

    public static int SelectCombo() {
        return 0;
    }

    public static void Boleto() {
    }
}
