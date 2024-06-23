package Cine;

public class UserInterface {

    public static void Welcome() {
        System.out.println("**************************************************");
        System.out.println("                                                  ");
        System.out.println("     Bienvenido a CinePlanet Santa Clara          ");
        System.out.println("                                                  ");
        System.out.println("**************************************************");
        System.out.println("                                                  ");
        System.out.println("  - Inicie Sesión Para Continuar                  ");
        System.out.println("                                                  ");
        System.out.println("**************************************************");
    }

    public static void MovieListings(boolean isLogin) {
        if (!isLogin) {
            return;
        }
        System.out.println("************************************************************");
        System.out.println("                                                            ");
        System.out.println("           Cartelera de Películas                           ");
        System.out.println("                                                            ");
        System.out.println("************************************************************");

        Controllers.SelectMovie();

    }

    public static void InterfaceSeats(Models.User user, int col, int block) {
        String name = user.getNombre().toUpperCase();

        boolean[][] seats = new boolean[9][9];
        String[] row = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I"};


        if (col > 0 && block > 0) {
            seats[block - 1][col - 1] = true;
        }

        System.out.println("**************************************************");
        System.out.println("              Bienvenido, " + name + "!             ");
        System.out.println("              Seleccione su asiento               ");
        System.out.println("**************************************************");
        System.out.println("                  Asientos                        ");
        System.out.println("**************************************************");

        // Matriz de asientos
        for (int i = 0; i < seats.length; i++) {
            System.out.print(row[i] + "  ");
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j]) {
                    System.out.print("[x]"); // Asiento ocupado
                } else {
                    System.out.print("[ ]"); // Asiento libre
                }
            }
            System.out.println("  " + row[i]);
        }

        System.out.println("**************************************************");
    }

    public static void ViewCombo() {

    }

}
