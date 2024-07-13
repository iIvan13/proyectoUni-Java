package Cine;

import Cine.Models.*;

public class UserInterface {

    public static void showMovieListings() {
        System.out.println("************************************************************");
        System.out.println("                      Lista de Películas                    ");
        System.out.println("************************************************************");
        System.out.println();
    }

    public static void displayMovieDetails(Movie movie) {
        String title = movie.getTitle();
        String director = movie.getDirector();
        int duration = movie.getDuration();
        String genre = movie.getGenre();
        int minAge = movie.getMinAge();
        String synopsis = movie.getSynopsis();

        System.out.println("**********************************************************");
        System.out.println("                   Detalles de la Película                ");
        System.out.println("**********************************************************");
        System.out.println();

        System.out.println("Título:    " + title);
        System.out.println("Director:  " + director);
        System.out.println("Duración:  " + duration + " minutos");
        System.out.println("Género:    " + genre);
        System.out.println("Edad mínima recomendada: " + minAge + "+");
        System.out.println();
        System.out.println("Sinopsis:");
        System.out.println("----------------------------------------------------------");
        System.out.println(synopsis);
        System.out.println("----------------------------------------------------------");
        System.out.println();
    }

    // Matriz de asientos
    private static boolean[][] seats = new boolean[9][9];

    public static void displaySeatMatrix(int col, String block) {
        String[] row = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };

        int currentblock = 0;

        switch (block.toUpperCase()) {
            case "A" -> currentblock = 1;
            case "B" -> currentblock = 2;
            case "C" -> currentblock = 3;
            case "D" -> currentblock = 4;
            case "E" -> currentblock = 5;
            case "F" -> currentblock = 6;
            case "G" -> currentblock = 7;
            case "H" -> currentblock = 8;
            case "I" -> currentblock = 9;
            default -> {
                System.out.println("");
            }
        }

        if (col > 0 && currentblock > 0) {
            seats[currentblock - 1][col - 1] = true;
        }

        // Imprimir la matriz de asientos
        System.out.print("   ");
        for (int i = 1; i < seats.length + 1; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();

        for (int i = 0; i < seats.length; i++) {
            System.out.print(row[i] + "  ");
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j]) {
                    System.out.print("[x]"); // Asiento ocupado
                } else {
                    System.out.print("[ ]"); // Asiento libre
                }
            }
            System.out.println();
        }

        System.out.println("**************************************************");
    }

    public static void displayComboDetails(Combo combo) {
        System.out.println("**********************************************************");
        System.out.println("                   Detalles del Combo                    ");
        System.out.println("**********************************************************");
        System.out.println();
        System.out.println("Combo: " + combo.getName());
        System.out.println("Descripción: " + combo.getDescription());
        System.out.println("Precio: s/" + combo.getPrice());
        System.out.println();
    }

}
