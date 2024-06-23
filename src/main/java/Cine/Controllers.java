package Cine;

import static Cine.UserInterface.*;
import java.util.Scanner;
import Cine.Models.*;

public class Controllers {

    @SuppressWarnings("resource")
    public static User Login() {

        Scanner scan = new Scanner(System.in);
        String name, email, dni;

        System.out.println("Ingrese su nombre:");
        name = scan.nextLine();

        System.out.println("Ingrese su correo electrónico:");
        email = scan.nextLine();

        System.out.println("Ingrese su DNI:");
        dni = scan.nextLine();

        if (dni.length() < 8) {
            System.out.println("DNI menor a 8 digitos o el DNI es incorrecto");
            return null;
        } else {
            User user = new User(name, email, dni);
            return user;
        }
    }

    @SuppressWarnings("resource")
    public static Movie SelectMovie(boolean isLoggedIn) {
        boolean isSelectedMovie = false;

        Movie movie = null;
        Scanner scan = new Scanner(System.in);
        Movie[] movies = Data.GetMovies();

        while (!isSelectedMovie) {
            MovieListings(isLoggedIn);

            for (int i = 0; i < movies.length; i++) {
                System.out.println((i + 1) + ". Título: " + movies[i].getTitle());
                System.out.println("   Género: " + movies[i].getGenre());
                System.out.println("   Edad mínima: " + movies[i].getMinAge() + "+");
                System.out.println();
            }
            System.out.println("**************************************************");

            int movieIndex = scan.nextInt();
            DisplayMovieDetails(movies[movieIndex - 1]);

            int option = scan.nextInt();

            if (option == 1) {
                isSelectedMovie = true;
                movie = movies[movieIndex - 1];
            } else if (option == 2) {
                System.out.println("Puede seleccionar otro título");
                System.out.println();
                isSelectedMovie = false;

            } else {
                System.out.println("Opción incorrecta");
            }
        }

        return movie;
    }

    public static int SelectCombo() {
        return 0;
    }

    public static void Boleto() {
    }
}
