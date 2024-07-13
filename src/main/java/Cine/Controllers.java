package Cine;

import static Cine.UserInterface.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import Cine.Models.*;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

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

        String userName = user.getName();
        String userDni = user.getDni();
        String timeEntry = user.getSelectedMovie().getMovieSchedules().get(0);
        double entryPrices = 0;
        for (Entry entry : user.getEntries()) {
            entryPrices += entry.getPrice();
        }
        String entryTotal = entryPrices + " s/";
        String selectedCombo = user.getSelectedCombo() == null ? "No" : user.getSelectedCombo().getName();
        String comboPrice = user.getSelectedCombo() == null ? "0.0" : user.getSelectedCombo().getPrice() + " s/";
        String movieTitle = user.getSelectedMovie().getTitle();
        String movieGenre = user.getSelectedMovie().getGenre();
        String synopsis = user.getSelectedMovie().getSynopsis();
        double total = user.getTotal();
        String allPayable = total + " s/";

        List<String> selectedSeats = user.getSelectedSeat();
        List<String> selectedEntries = new ArrayList<>();
        for (Entry entry : user.getEntries()) {
            selectedEntries.add(entry.getName() + " - " + entry.getPrice() + " s/");
        }

        String htmlSeat = generateHtmlList(selectedSeats);
        String htmlEntry = generateHtmlList(selectedEntries);

        String sala = user.getSelectedMovie().getTypeThread();
        String imageUrl = user.getSelectedMovie().getImg();

        String html = String.format(
                """
                        <!DOCTYPE html>
                        <html lang="en">

                        <head>
                            <meta charset="UTF-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                            <title>Cine Santa Clara</title>
                            <link rel="preconnect" href="https://fonts.googleapis.com">
                            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                            <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap" rel="stylesheet">
                            <script src="https://cdn.tailwindcss.com"></script>
                        </head>

                        <body class="bg-gray-100 flex flex-col items-center justify-center min-h-screen p-4">
                            <h1 class="font-bold text-4xl mb-6 text-gray-800">Cine Santa Clara</h1>
                            <div class="bg-white p-8 rounded-lg shadow-lg w-full max-w-2xl">
                                <div class="flex flex-col sm:flex-row justify-between gap-8">
                                    <div class="flex flex-col gap-6 w-full sm:w-1/2">
                                        <div class="flex flex-col gap-4">
                                            <div>
                                                <span class="font-semibold">Nombre:</span>
                                                <span>%s</span>
                                            </div>
                                            <div>
                                                <span class="font-semibold">DNI:</span>
                                                <span>%s</span>
                                            </div>
                                            <div>
                                                <span class="font-semibold">Hora de Entrada:</span>
                                                <span>%s</span>
                                            </div>
                                        </div>
                                        <div class="flex flex-col sm:flex-row gap-4">
                                            <div class="border rounded-lg p-4 w-full sm:w-auto">
                                                <span class="font-semibold">Asientos:</span>
                                                <ul class="mt-2">
                                                    %s
                                                </ul>
                                            </div>
                                            <div class="border rounded-lg p-4 w-full sm:w-auto">
                                                <span class="font-semibold">Entradas:</span>
                                                <ul class="mt-2">
                                                    %s
                                                </ul>
                                                <div class="mt-4 text-right">
                                                    <span class="font-semibold">Total:</span>
                                                    <span>%s</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div>
                                            <span class="font-semibold">Combo:</span>
                                            <span>%s</span>
                                            <div class="mt-2">
                                                <span class="font-semibold">Precio:</span>
                                                <span>%s</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="flex flex-col items-center w-full sm:w-1/2">
                                        <img class="w-full h-64 rounded-lg shadow-md object-cover"
                                            src="%s"
                                            alt="Avengers: Endgame">
                                        <div class="mt-4 text-center">
                                            <div class="mb-2">
                                                <span class="font-semibold">Película:</span>
                                                <span>%s</span>
                                            </div>
                                            <div class="mb-2">
                                                <span class="font-semibold">Género:</span>
                                                <span>%s</span>
                                            </div>
                                            <div class="mb-2">
                                                <span class="font-semibold">Tipo de Sala:</span>
                                                <span>%s</span>
                                            </div>
                                            <div>
                                                <span class="font-semibold">Sinopsis:</span>
                                                <p class="mt-1 text-sm text-gray-600">%s</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="mt-6 font-semibold text-lg flex justify-between">
                                    <h4 class="text-[#06D6A0]">Gracias por su compra</h4>
                                    <div>
                                        <span>Total a pagar: </span>
                                        <span>%s</span>
                                    </div>
                                </div>
                            </div>
                        </body>

                        </html>
                        """,
                userName, userDni, timeEntry, htmlSeat, htmlEntry, entryTotal, selectedCombo, comboPrice, imageUrl,
                movieTitle, movieGenre, sala, synopsis, allPayable);

        String rutaDelArchivo = "C:\\Users\\ivant\\OneDrive\\Escritorio\\Java - UTP\\ProyectoFinal\\informe.html"; // Reemplazar
                                                                                                                   // con
                                                                                                                   // la
                                                                                                                   // ruta
                                                                                                                   // deseada

        try (PrintWriter out = new PrintWriter(rutaDelArchivo)) {
            out.println(html);
            System.out.println("Informe HTML generado y guardado en: " + rutaDelArchivo);
        } catch (FileNotFoundException e) {
            System.err.println("Error: No se pudo crear el archivo " + rutaDelArchivo);
        }

    }

    private static String generateHtmlList(List<String> items) {
        StringBuilder htmlList = new StringBuilder();
        for (String item : items) {
            htmlList.append(String.format("<li class=\"border-b py-1\">%s</li>\n", item));
        }
        return htmlList.toString();
    }
}
