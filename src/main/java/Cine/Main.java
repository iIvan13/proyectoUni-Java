package Cine;

import java.util.List;

/**
 * @author { 
 *  - Ivan Moises Todelano Toledo
 *  - Sebastian Yamir Choquehuanca Cerna
 *  - Jim Menly Romani Pariona
 *  - Mikel Cayllahua Morales
 *  - Jair Alexander Porras Palpa
 *  - Jordy Jorge Chuco Ortega
 * }
*/

import java.util.Scanner;
import Cine.Models.*;
import static Cine.Controllers.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            // Inicio
            Cine cineSantaClara = Welcome();
            User user = NewUser();
            if (user != null) {
                System.out.println("Usuario creado:");
                System.out.println("Nombre: " + user.getName());
                System.out.println("DNI: " + user.getDni());
            }

            // Seleccion de película
            Movie movie = SelectMovie(cineSantaClara.getMovies());
            if (movie != null) {
                System.out.println("Película seleccionada: " + movie.getTitle());
            }

            // Selección de la hora de la pelicula
            Movie currentMovie = SelectSchedule(movie);
            user.setSelectedMovie(currentMovie);
            if (currentMovie != null) {
                System.out.println("Horario seleccionado para " + currentMovie.getTitle() + "a las "
                        + currentMovie.getMovieSchedules().get(0));
            }

            // Seleccion de asiento
            List<String> seats = selectSeats();
            user.setSelectedSeats(seats);
            if (seats.size() > 0) {
                System.out.println("Asientos seleccionados:");
                System.out.println(seats);
            }

            // Seleccion de la cantidad de Boletas a comprar (la cantidad depende de cuantos
            // asientos se seleccionaron)
            Entry[] entries = SelectEntries(seats.size());
            user.setEntries(entries);
            if (entries.length > 0) {
                System.out.println("Entradas seleccionadas:");
                for (Entry entry : entries) {
                    System.out.println(entry.getName() + " - " + entry.getPrice() + " s/");
                }
            }

            // Selección de Combo
            System.out.println("¿Desea seleccionar un combo?");
            System.out.println("1. Sí");
            System.out.println("2. No");

            int option = 0;
            while (option != 1 && option != 2) {
                System.out.print("Ingrese 1 o 2: ");
                if (scan.hasNextInt()) {
                    option = scan.nextInt();
                    if (option != 1 && option != 2) {
                        System.out.println("Opción inválida. Por favor, ingrese 1 o 2.");
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                    scan.next(); // Consumir el valor inválido
                }
            }

            if (option == 1) {
                Combo combo = SelectCombo();
                user.setSelectedCombo(combo);
                System.out.println("Combo seleccionado: " + combo.getName() + " - " + combo.getPrice() + " s/");
            } else {
                System.out.println("No se ha seleccionado un combo.");
            }

            // Mostrar la boleta de compra
            GetTicked(user);
        } catch (Exception error) {
            System.err.println("Ha ocurrido un error: " + error.getMessage());
        }
    }

}
