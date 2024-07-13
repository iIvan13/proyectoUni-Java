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

            // Seleccion de película
            Movie movie = SelectMovie(cineSantaClara.getMovies());

            // Selección de la hora
            Movie currentMovie = SelectSchedule(movie);
            user.setSelectedMovie(currentMovie);

            // Seleccion de asiento
            List<String> seats = selectSeats();
            user.setSelectedSeats(seats);

            // Seleccion de la cantidad de Boletas a comprar (la cantidad depende de cuantos
            // asientos se seleccionaron)
            Entry[] entries = SelectEntries(seats.size());
            user.setEntries(entries);

            // Selección de Combo
            System.out.println("Desea seleccionar un combo?");
            System.out.println("1. Si");
            System.out.println("2. No");
            int option = scan.nextInt();
            if (option == 1) {
                Combo combo = SelectCombo();
                user.setSelectedCombo(combo);
            } else {
                System.out.println("No se ha seleccionado un combo");
            }

            // Mostrar la boleta de compra
            GetTicked(user);
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error: " + e.getMessage());
        }
    }

}
