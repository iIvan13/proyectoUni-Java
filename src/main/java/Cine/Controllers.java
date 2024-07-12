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

        System.out.println("Ingrese su DNI:");
        String dni = scan.nextLine();

        if (dni.length() < 8) {
            System.out.println("DNI menor a 8 digitos o el DNI es incorrecto");
            return null;
        }

        return new User(name, dni, null, null, null, 0.0);
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
                System.out.println("   Duración: " + movies[i].getDuration() + " minutos");
                System.out.println("   Precio: s/" + movies[i].getPrice());
                System.out.println();
            }

            System.out.println("Seleccione una película para ver más información ingresando el número correspondiente:");
            System.out.println();

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

    @SuppressWarnings("resource")
    public static Combo SelectCombo(int option) {
        Scanner scan = new Scanner(System.in);

        if (option == 2) return null; 

        Combo[] combos = Data.GetCombos();
        Combo returnCombo = null;

        if (option == 1) {
            System.out.println("************************************************************");
            System.out.println("                      Combos Disponibles                    ");
            System.out.println("************************************************************");
            System.out.println();

            for (int i = 0; i < combos.length; i++) {
                System.out.println((i + 1) + ". " + combos[i].getName().toUpperCase());
                System.out.println("   " + combos[i].getDescription());
                System.out.println("   Precio: s/" + combos[i].getPrice());
                System.out.println();
            }

            System.out.println("Seleccione un combo ingresando el número correspondiente:");
            System.out.println();

            int selectCombo = scan.nextInt();
            ViewDetailsCombo(combos[selectCombo - 1]);
            
            System.out.println("Opciones:");
            System.out.println("1. Continuar con la compra de la boleto");
            System.out.println("2. Volver");
            option = scan.nextInt();

            switch (option) {
                case 1 -> returnCombo = combos[selectCombo - 1];
                case 2 -> {
                    return SelectCombo(1);
                }
                default -> {
                    System.out.println("Opción incorrecta. Intente de nuevo.");
                    ViewDetailsCombo(combos[selectCombo - 1]);
                }
            }
        }
        return returnCombo;
    }

    public static void GetTicked(User user) {
        if (user == null) return;
        
        System.out.println("**************************************************");
        System.out.println("                     Boleta                       ");
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Nombre: " + user.getName());
        System.out.println("DNI: " + user.getDni());
        System.out.println("Pelicula: " + user.getSelectedMovie().getTitle());
        System.out.println("Asiento: " + user.getSelectedSeat());

        if (user.getSelectedCombo() != null) {
            System.out.println("Combo: " + user.getSelectedCombo().getName());
        }
        
        System.out.println("**************************************************");
        System.out.println("Total: s/" + user.getTotal());

        System.out.println("**************************************************");
        System.out.println("               Gracias por su compra               ");
        System.out.println("**************************************************");
    }
}
