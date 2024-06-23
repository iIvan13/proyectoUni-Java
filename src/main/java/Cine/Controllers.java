package Cine;

import static Cine.UserInterface.*;
import java.util.Scanner;
import Cine.Models.*;

public class Controllers {

    @SuppressWarnings("resource")
    public static User NewUser() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese su nombre:");
        String name = scan.nextLine();
        
        System.out.println("Ingrese su correo electrónico:");
        String email = scan.nextLine();

        System.out.println("Ingrese su DNI:");
        String dni = scan.nextLine();

        if (dni.length() < 8) {
            System.out.println("DNI menor a 8 digitos o el DNI es incorrecto");
            return null;
        }

        return new User(name, email, dni);
    }

    @SuppressWarnings("resource")
    public static Movie SelectMovie(boolean isLoggedIn) {
        Scanner scan = new Scanner(System.in);

        Movie[] movies = Data.GetMovies();

        while (true) {
            MovieListings(isLoggedIn);

            for (int i = 0; i < movies.length; i++) {
                System.out.println((i + 1) + ". Título: " + movies[i].getTitle());
                System.out.println("   Género: " + movies[i].getGenre());
                System.out.println("   Edad mínima: " + movies[i].getMinAge() + "+");
                System.out.println();
            }
            System.out.println("**************************************************");

            int movieIndex = scan.nextInt();
            if (movieIndex < 1 || movieIndex > movies.length) {
                System.out.println("Opción incorrecta. Intente de nuevo.");
                continue;
            }

            DisplayMovieDetails(movies[movieIndex - 1]);

            int option = scan.nextInt();
            if (option == 1) {
                return movies[movieIndex - 1];
            } else if (option == 2) {
                System.out.println("");
                System.out.println("Puede elegir otra pelicula");
                System.out.println();
            }
        }
    }

    @SuppressWarnings("resource")
    public static String SelectSeat() {
        Scanner scan = new Scanner(System.in);

        System.out.println("**************************************************");
        System.out.println("              Seleccione su asiento               ");
        System.out.println("**************************************************");
        System.out.println("                  Asientos                        ");
        System.out.println("**************************************************");
        InterfaceSeats(0, "");

        System.out.println("Ingrese la fila y el número del asiento");
        System.out.println("Fila (A - I):");
        String block = scan.nextLine();
        System.out.println("Numero de asiento (1 - 9):");
        int col = scan.nextInt();

        InterfaceSeats(col, block);

        return block.toUpperCase() + "-" + col;
    }

    public static int SelectCombo() {
        return 0;
    }

    public static void Boleto() {
    }
}
