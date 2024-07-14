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

        String name = null;
        String dni = null;

        while (true) {
            System.out.println("Ingrese su nombre:");
            name = scan.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("El nombre no puede estar vacío. Intente nuevamente.");
            } else if (!name.matches("[a-zA-Z\\s]+")) {
                System.out.println("El nombre solo puede contener letras y espacios. Intente nuevamente.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Ingrese su DNI:");
            dni = scan.nextLine().trim();

            if (dni.length() < 8 || dni.length() > 9) {
                System.out.println("El DNI debe tener 8 o 9 dígitos. Intente nuevamente.");
            } else {
                try {
                    Long.parseLong(dni);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("El DNI contiene caracteres no numéricos. Intente nuevamente.");
                }
            }
        }

        return new User(name, dni, null, null, null, null);
    }

    public static Movie SelectMovie(Movie[] movies) {
        Scanner scan = new Scanner(System.in);
        int movieIndex = -1;

        while (true) {
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

            try {
                movieIndex = Integer.parseInt(scan.nextLine());

                if (movieIndex < 1 || movieIndex > movies.length) {
                    System.out.println("Opción incorrecta. Intente de nuevo.");
                } else {
                    displayMovieDetails(movies[movieIndex - 1]);
                    System.out.println("¿Desea seleccionar esta película?");
                    System.out.println("1. Sí");
                    System.out.println("2. No");
                    while (true) {
                        try {
                            int confirm = Integer.parseInt(scan.nextLine());

                            if (confirm == 1) {
                                return movies[movieIndex - 1];
                            } else if (confirm == 2) {
                                break;
                            } else {
                                System.out.println("Opción incorrecta. Intente de nuevo.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada no válida. Por favor, ingrese un número.");
                        }
                    }

                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }
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

        int scheduleIndex = -1;
        while (true) {
            System.out.println("Ingrese el horario (1 - " + schedules.size() + "):");
            try {
                scheduleIndex = Integer.parseInt(scan.nextLine());

                if (scheduleIndex < 1 || scheduleIndex > schedules.size()) {
                    System.out.println("Opción incorrecta. Intente de nuevo.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }

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

        while (true) {
            displaySeatMatrix(0, "");

            String block = null;
            while (true) {
                System.out.println("Ingrese la fila de asiento (A - I):");
                block = scan.nextLine().toUpperCase();

                if (block.matches("[A-I]")) {
                    break;
                } else {
                    System.out.println("Fila incorrecta. Intente de nuevo.");
                }
            }

            int col = -1;
            while (true) {
                System.out.println("Número de asiento (1 - 9):");
                try {
                    col = Integer.parseInt(scan.nextLine());

                    if (col >= 1 && col <= 9) {
                        break;
                    } else {
                        System.out.println("Número de asiento incorrecto. Intente de nuevo.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
                }
            }

            displaySeatMatrix(col, block);

            String seat = block + "-" + col;
            selectedSeats.add(seat);

            System.out.println("Asientos seleccionados: " + selectedSeats);

            String continueSelection;
            while (true) {
                System.out.println("¿Desea seleccionar otro asiento? (1: sí / 2: no)");
                continueSelection = scan.nextLine();
                if (continueSelection.equals("1") || continueSelection.equals("2")) {
                    break;
                } else {
                    System.out.println("Opción incorrecta. Intente de nuevo.");
                }
            }

            if (continueSelection.equals("2")) {
                break;
            }
        }

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
            while (true) {
                System.out.print("Seleccione el tipo de entrada para la entrada " + (i + 1) + ": ");
                if (scan.hasNextInt()) {
                    choice = scan.nextInt();
                    scan.nextLine();
                    if (choice >= 1 && choice <= entries.length) {
                        break; // Opción válida
                    } else {
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                    }
                } else {
                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
                    scan.nextLine();
                }
            }

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
        while (true) {
            System.out.println("Seleccione un combo ingresando el número correspondiente:");
            if (scan.hasNextInt()) {
                selectCombo = scan.nextInt();
                scan.nextLine();
                if (selectCombo >= 1 && selectCombo <= combos.length) {
                    break;
                } else {
                    System.out.println("Opción incorrecta. Intente de nuevo.");
                }
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scan.nextLine();
            }
        }

        displayComboDetails(combos[selectCombo - 1]);

        System.out.println("Opciones:");
        System.out.println("1. Continuar con la compra del boleto");
        System.out.println("2. Volver");

        int option;
        while (true) {
            if (scan.hasNextInt()) {
                option = scan.nextInt();
                scan.nextLine();
                if (option == 1) {
                    selectedCombo = combos[selectCombo - 1];
                    break;
                } else if (option == 2) {
                    break;
                } else {
                    System.out.println("Opción incorrecta. Intente de nuevo.");
                    displayComboDetails(combos[selectCombo - 1]);
                    System.out.println("Opciones:");
                    System.out.println("1. Continuar con la compra del boleto");
                    System.out.println("2. Volver");
                }
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scan.nextLine();
            }
        }

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
        String selectedCombo = user.getSelectedCombo() == null ? "No se ha seleccionado un combo"
                : user.getSelectedCombo().getName();
        String comboPrice = user.getSelectedCombo() == null ? "0.0 s/" : user.getSelectedCombo().getPrice() + " s/";
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

        String rutaDelArchivo = "C:\\Users\\ivant\\OneDrive\\Escritorio\\Java - UTP\\ProyectoFinal\\informe.html";

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
