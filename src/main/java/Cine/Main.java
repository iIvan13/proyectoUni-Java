package Cine;

import java.util.Scanner;
import static Cine.UserInterface.*;
import Cine.Models.*;
import static Cine.Controllers.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Welcome();

        User user = Login();

        // Seleccion de película
        MovieListings(user.isLogin());

        // Seleccion de asiento
        InterfaceSeats(user, 0, 0);
        System.out.println("Ingrese la fila de su asiento (Total de Filas es 8):");
        int block = scan.nextInt();
        System.out.println("Ingrese la columna de su asiento (Total de Columnas es 8:)");
        int col = scan.nextInt();

        InterfaceSeats(user, col, block);
        System.out.println("Usted eligió el asiento de la fila " + block + " y la columna " + col);

        // seleccion de combo
        ViewCombo();

        scan.close();
    }

}
