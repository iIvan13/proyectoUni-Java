package Cine;

import java.util.Scanner;
import static Cine.UserInterface.*;
import Cine.Models.*;
import static Cine.Controllers.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Inicio
        Welcome();

        User user = NewUser();

        // Seleccion de película
        Movie movie = SelectMovie(user.isLogin());
        System.out.println(movie);

        // Seleccion de asiento
        String seat = SelectSeat();
        System.out.println(seat);

        // seleccion de combo
        ViewCombo();

        // Retorno del ticked en html

        // Cierre del programa
        scan.close();
    }

}
