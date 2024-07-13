package Cine;

import static Cine.UserInterface.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import Cine.Models.*;

public class Controllers {

    public static Cine Welcome() {
        Movie[] movies = Data.GetMovies();

        Cine cineSantaClara = new Cine("Cine Santa Clara", movies);
        String name = cineSantaClara.getName();

        System.out.println("**************************************************");
        System.out.println("                                                  ");
        System.out.println("     Bienvenido a Cine: " + name);
        System.out.println("                                                  ");
        System.out.println("**************************************************");

        return cineSantaClara;
    }

    public static User NewUser() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese su nombre:");
        String name = scan.nextLine();

        System.out.println("Ingrese su DNI:");
        String dni = scan.nextLine();

        if (dni.length() < 8) {
            System.out.println("DNI menor a 8 dígitos o el DNI es incorrecto");
            return null;
        }

        return new User(name, dni, null, null, null, null);
    }

    public static Movie SelectMovie(Movie[] movies) {
        Scanner scan = new Scanner(System.in);
        int movieIndex;

        do {
            showMovieListings();

            for (int i = 0; i < movies.length; i++) {
                System.out.println((i + 1) + ". Título: " + movies[i].getTitle());
                System.out.println("   Género: " + movies[i].getGenre());
                System.out.println("   Edad mínima: " + movies[i].getMinAge() + "+");
                System.out.println("   Duración: " + movies[i].getDuration() + " minutos");
                System.out.println();
            }

            System.out
                    .println("Seleccione una película para ver más información ingresando el número correspondiente:");
            movieIndex = scan.nextInt();

            if (movieIndex < 1 || movieIndex > movies.length) {
                System.out.println("Opción incorrecta. Intente de nuevo.");
            } else {
                displayMovieDetails(movies[movieIndex - 1]);
                System.out.println("¿Desea seleccionar esta película?");
                System.out.println("1. Sí");
                System.out.println("2. No");
            }
        } while (scan.nextInt() != 1);

        return movies[movieIndex - 1];
    }

    public static Movie SelectSchedule(Movie movie) {
        Scanner scan = new Scanner(System.in);
        List<String> schedules = movie.getMovieSchedules();

        System.out.println("**************************************************");
        System.out.println("              Seleccione su horario               ");
        System.out.println("**************************************************");

        for (int i = 0; i < schedules.size(); i++) {
            System.out.println((i + 1) + ". " + schedules.get(i));
        }

        System.out.println("Ingrese el horario (1 - " + schedules.size() + "):");
        int scheduleIndex = scan.nextInt();
        scan.nextLine();

        String selectedSchedule = schedules.get(scheduleIndex - 1);
        movie.setMovieSchedules(Collections.singletonList(selectedSchedule));
        return movie;
    }

    public static List<String> selectSeats() {
        Scanner scan = new Scanner(System.in);
        List<String> selectedSeats = new ArrayList<>();

        System.out.println("**************************************************");
        System.out.println("              Seleccione su asiento               ");
        System.out.println("**************************************************");

        do {
            displaySeatMatrix(0, "");

            System.out.println("Ingrese la fila de asiento (A - I):");
            String block = scan.nextLine().toUpperCase();

            System.out.println("Número de asiento (1 - 9):");
            int col = scan.nextInt();
            scan.nextLine();

            displaySeatMatrix(col, block);

            String seat = block + "-" + col;
            selectedSeats.add(seat);

            System.out.println("Asientos seleccionados: " + selectedSeats);
            System.out.println("¿Desea seleccionar otro asiento? (1: sí / 2: no)");
        } while (scan.nextLine().equalsIgnoreCase("1"));

        return selectedSeats;
    }

    public static Entry[] SelectEntries(int quantity) {
        Scanner scan = new Scanner(System.in);
        Entry[] entries = Data.GetEntries();
        Entry[] selectedEntries = new Entry[quantity];

        System.out.println("Seleccione el tipo de entrada:");

        for (int i = 0; i < entries.length; i++) {
            System.out.println((i + 1) + ". " + entries[i].getName() + " - " + entries[i].getPrice() + " s/");
        }

        for (int i = 0; i < quantity; i++) {
            int choice;
            do {
                System.out.print("Seleccione el tipo de entrada para la entrada " + (i + 1) + ": ");
                choice = scan.nextInt();

                if (choice < 1 || choice > entries.length) {
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            } while (choice < 1 || choice > entries.length);

            selectedEntries[i] = entries[choice - 1];
        }

        return selectedEntries;
    }

    public static Combo SelectCombo() {
        Scanner scan = new Scanner(System.in);
        Combo[] combos = Data.GetCombos();
        Combo selectedCombo = null;

        System.out.println("************************************************************");
        System.out.println("                      Combos Disponibles                    ");
        System.out.println("************************************************************");

        for (int i = 0; i < combos.length; i++) {
            System.out.println((i + 1) + ". " + combos[i].getName().toUpperCase());
            System.out.println("   " + combos[i].getDescription());
            System.out.println("   Precio: s/" + combos[i].getPrice());
            System.out.println();
        }

        int selectCombo;
        do {
            System.out.println("Seleccione un combo ingresando el número correspondiente:");
            selectCombo = scan.nextInt();

            if (selectCombo < 1 || selectCombo > combos.length) {
                System.out.println("Opción incorrecta. Intente de nuevo.");
            }
        } while (selectCombo < 1 || selectCombo > combos.length);

        displayComboDetails(combos[selectCombo - 1]);

        System.out.println("Opciones:");
        System.out.println("1. Continuar con la compra del boleto");
        System.out.println("2. Volver");

        int option;
        do {
            option = scan.nextInt();

            switch (option) {
                case 1 -> selectedCombo = combos[selectCombo - 1];
                case 2 -> {
                }
                default -> {
                    System.out.println("Opción incorrecta. Intente de nuevo.");
                    displayComboDetails(combos[selectCombo - 1]);
                }
            }
            // No hace falta hacer nada aquí, simplemente continuar
                    } while (option != 1 && option != 2);

        return selectedCombo;
    }

    public static void GetTicked(User user) {
        if (user == null) {
            return;
        }

        System.out.println("**************************************************");
        System.out.println("                     Boleta                       ");
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Nombre: " + user.getName());
        System.out.println("DNI: " + user.getDni());
        System.out.println("Pelicula: " + user.getSelectedMovie().getTitle());
        System.out.println("Asientos seleccionados: " + user.getSelectedSeat());
        System.out.println("Entradas: ");

        for (Entry entrie : user.getEntries()) {
            System.out.print("- ");
            entrie.getView();
        }

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
