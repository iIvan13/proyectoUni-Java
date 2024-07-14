package Cine;

import java.util.ArrayList;
import java.util.List;

public class Models {

    // CLASE PARA REPRESENTAR EL CINE (1. CINE)
    public static class Cine {
        // Atributos de la clase Cine
        private final String name;
        private final Movie[] movies;

        // Constructor de la clase Cine
        public Cine(String name, Movie[] movies) {
            this.name = name;
            this.movies = movies;
        }

        // Métodos getters para acceder a los atributos
        public String getName() {
            return name;
        }

        public Movie[] getMovies() {
            return movies;
        }

    }

    // CLASE PARA REPRESENTAR UN USUARIO (2. USUARIO)
    public static class User {

        // Atributos de la clase Usuario
        private String name;
        private String dni;
        private Movie selectedMovie;
        private List<String> selectedSeats = new ArrayList<>();
        private Entry[] entries;
        private Combo selectedCombo;
        private double total;

        // Constructor de la clase Usuario
        public User(String name, String dni, Movie movie, List<String> seat, Entry[] entries, Combo combo) {
            this.name = name;
            this.dni = dni;
            this.selectedMovie = movie;
            this.selectedSeats = seat;
            this.entries = entries;
            this.selectedCombo = combo;
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

        public Movie getSelectedMovie() {
            return selectedMovie;
        }

        public void setSelectedMovie(Movie selectedMovie) {
            this.selectedMovie = selectedMovie;
        }

        public List<String> getSelectedSeat() {
            return selectedSeats;
        }

        public void setSelectedSeats(List<String> seats) {
            this.selectedSeats = seats;
        }

        public Entry[] getEntries() {
            return entries;
        }

        public void setEntries(Entry[] entries) {
            this.entries = entries;
        }

        public Combo getSelectedCombo() {
            return selectedCombo;
        }

        public void setSelectedCombo(Combo selectedCombo) {
            this.selectedCombo = selectedCombo;
        }

        public double getTotal() {
            for (Entry entry : entries) {
                this.total += entry.getPrice();
            }
            double priceCombo = this.selectedCombo != null ? this.selectedCombo.getPrice() : 0;
            this.total = this.total + priceCombo;
            return total;
        }

    }

    // CLASE PARA REPRESENTAR UNA PELÍCULA (3. PELÍCULA)
    public static class Movie {

        // Atributos de la clase Movie
        private final String title;
        private final String director;
        private final int duration;
        private final String genre;
        private final int minAge;
        private final String synopsis;
        private List<String> movieSchedules;
        private final String img;
        private final String typeThread;

        // Constructor de la clase Movie
        public Movie(String title, String director, int duration, String genre, int minAge, String synopsis,
                List<String> movieSchedules, String img, String typeThread) {
            this.title = title;
            this.director = director;
            this.duration = duration;
            this.genre = genre;
            this.minAge = minAge;
            this.synopsis = synopsis;
            this.movieSchedules = movieSchedules;
            this.img = img;
            this.typeThread = typeThread;
        }

        // Métodos getters para acceder a los atributos
        public String getTitle() {
            return title;
        }

        public String getDirector() {
            return director;
        }

        public int getDuration() {
            return duration;
        }

        public String getGenre() {
            return genre;
        }

        public int getMinAge() {
            return minAge;
        }

        public String getSynopsis() {
            return synopsis;
        }

        public List<String> getMovieSchedules() {
            return movieSchedules;
        }
        
        public String getImg() {
            return img;
        }

        public String getTypeThread() {
            return typeThread;
        }

        public void setMovieSchedules(List<String> movieSchedules) {
            this.movieSchedules = movieSchedules;
        }
    }

    // CLASE PARA REPRESENTAR UNA ENTRADA (4. ENTRADA)
    public static class Entry {
        private final String name;
        private final double price;

        public Entry(String name, double price) {
            this.name = name;
            this.price = price;
        }

        // Getters
        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public void getView() {
            System.out.println(name + " - " + price + " s/");
        }
    }

    // CLASE PARA REPRESENTAR UN COMBO (5. COMBO)
    public static class Combo {
        private final String name;
        private final String description;
        private final double price;

        public Combo(String name, double price, String description) {
            this.name = name;
            this.price = price;
            this.description = description;
        }

        // Getters
        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public String getDescription() {
            return description;
        }
    }

}
