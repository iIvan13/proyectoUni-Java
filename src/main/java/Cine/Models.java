package Cine;

public class Models {

    //Clase para representar un Usuario del sistema.
    public static class User {

        // Atributos de la clase Usuario
        private String nombre;
        private String email;
        private String dni;
        private boolean isLogin = false;

        // Constructor de la clase Usuario
        public User(String nombre, String email, String dni) {
            this.nombre = nombre;
            this.email = email;
            this.dni = dni;
            this.isLogin = true;
        }

        // Metodo para comprar tickets de la clase User
        public void BuyTicket() {

            System.out.println("Se ha realizado la compra de su boleto!");
        }

        // Métodos getters y setters para acceder y modificar los atributos
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return dni;
        }

        public void setPassword(String dni) {
            this.dni = dni;
        }

        public boolean isLogin() {
            return isLogin;
        }

        public void setLogin(boolean login) {
            isLogin = login;
        }

        // Método toString para representar la información del usuario 
        @Override
        public String toString() {
            return "Usuario{"
                    + "nombre='" + nombre + '\''
                    + ", email='" + email + '\''
                    + ", password='" + dni + '\''
                    + ", isLogin=" + isLogin
                    + '}';
        }
    }

    // Clase para representar una Película.
    public static class Movie {

        // Atributos de la clase Movie
        private String title;
        private int year;
        private String director;

        // Constructor de la clase Movie
        public Movie(String title, int year, String director) {
            this.title = title;
            this.year = year;
            this.director = director;
        }

        // Métodos getters y setters para acceder y modificar los atributos
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        // Método toString para representar la información de la película
        @Override
        public String toString() {
            return "Movie{"
                    + "title='" + title + '\''
                    + ", year=" + year
                    + ", director='" + director + '\''
                    + '}';
        }
    }

}
