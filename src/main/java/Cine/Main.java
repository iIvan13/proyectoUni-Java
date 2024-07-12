package Cine;

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
import static Cine.UserInterface.*;
import Cine.Models.*;
import static Cine.Controllers.*;

public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Inicio
        Welcome();
        User user = NewUser();

        // Seleccion de película
        Movie movie = SelectMovie(user.isLogin());
        user.setSelectedMovie(movie);
        user.setTotal(movie.getPrice());

        // Seleccion de asiento
        String seat = SelectSeat();
        user.setSelectedSeat(seat);

        // Selección de Combo
        System.out.println("Desea seleccionar un combo?");
        System.out.println("1. Si");
        System.out.println("2. No");
        int option = scan.nextInt();
        Combo combo = SelectCombo(option);

        // Mostrar la boleta de compra
        if (combo != null) {
            user.setSelectedCombo(combo);
            user.setTotal(user.getTotal() + combo.getPrice());
            GetTicked(user);
        } else {
            System.out.println("No se ha seleccionado un combo");
            GetTicked(user);
        }
    }

}
