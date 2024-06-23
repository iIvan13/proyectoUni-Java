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
        Movie movie = SelectMovie(user.isLogin());
        System.out.println(movie);

        // seleccion de combo
        ViewCombo();

        scan.close();
    }

}
