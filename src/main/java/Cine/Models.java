package Cine;

public class Models {

    //Clase para representar un Usuario del sistema.
    public static class User {

        // Atributos de la clase Usuario
        private String name;
        private String dni;
        private boolean isLogin = false;
        private Movie selectedMovie;
        private String selectedSeat;
        private Combo selectedCombo;
        private double total;

        // Constructor de la clase Usuario
        public User(String name, String dni, Movie movie, String seat, Combo combo, double total) {
            this.name = name;
            this.dni = dni;
            this.isLogin = true;
            this.selectedMovie = movie;
            this.selectedSeat = seat;
            this.selectedCombo = combo;
            this.total = total;
        }

        // Métodos getters y setters para acceder y modificar los atributos
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public boolean isLogin() {
            return isLogin;
        }

        public void setLogin(boolean login) {
            isLogin = login;
        }

        public Movie getSelectedMovie() {
            return selectedMovie;
        }

        public void setSelectedMovie(Movie selectedMovie) {
            this.selectedMovie = selectedMovie;
        }

        public String getSelectedSeat() {
            return selectedSeat;
        }

        public void setSelectedSeat(String selectedSeat) {  
            this.selectedSeat = selectedSeat;
        }

        public Combo getSelectedCombo() {
            return selectedCombo;
        }

        public void setSelectedCombo(Combo selectedCombo) {
            this.selectedCombo = selectedCombo;
        }    
        
        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

    }

    // Clase para representar una Película.
    public static class Movie {

        // Atributos de la clase Movie
        private String title;
        private String director;
        private int duration;
        private String genre;
        private int minAge;
        private String synopsis;
        private double price;

        // Constructor de la clase Movie
        public Movie(String title, String director, int duration, String genre, int minAge, String synopsis, double price) {
            this.title = title;
            this.director = director;
            this.duration = duration;
            this.genre = genre;
            this.minAge = minAge;
            this.synopsis = synopsis;
            this.price = price;
        }

        // Métodos getters y setters para acceder y modificar los atributos
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public int getMinAge() {
            return minAge;
        }

        public void setMinAge(int minAge) {
            this.minAge = minAge;
        }

        public String getSynopsis() {
            return synopsis;
        }

        public void setSynopsis(String synopsis) {
            this.synopsis = synopsis;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

    }

    // Clase para representar el Combo.
    public static class Combo {
        private String name;
        private String description;
        private double price;
        
        public Combo(String name, double price, String description) {
            this.name = name;
            this.price = price;
            this.description = description;
        }
        
        // Getters y Setters
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public double getPrice() {
            return price;
        }
    
        public void setPrice(double price) {
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
    
}
