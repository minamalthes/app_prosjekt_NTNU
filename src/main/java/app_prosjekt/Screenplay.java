package app_prosjekt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Screenplay {
    private final String title;
    private final String type;
    private final int year;
    private final String genre;
    private final double rating;
    private final ArrayList<String> cast;

    
    public Screenplay(String title, String type, int year, String genre, double rating, ArrayList<String> cast){
        this.title = Objects.requireNonNull(title); 
        this.type = Objects.requireNonNull(type);
        this.year = Objects.requireNonNull(year);
        this.genre = Objects.requireNonNull(genre);
        this.rating = Objects.requireNonNull(rating);
        this.cast = Objects.requireNonNull(cast);
    }

    private ArrayList<Screenplay> listOfScreenplays = new ArrayList<>();

    public List<Screenplay> getScreenplays() {
        return Collections.unmodifiableList(this.listOfScreenplays); //stopper endringer, gjør at man må bruke addMovies/addShow for å legge til ting  listen 
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public int getYear() {
        return this.year;
    }

    public String getGenre() {
        return this.genre;
    }

    public double getRating() {
        return this.rating;
    }

    public ArrayList<String> getCast() {
        return this.cast;
    }

    public boolean validateYear(int year) {
        if (this.year > 1888 && this.year < 2024) { 
            return false;
        }
        return true;
    }


    public String toString() {
        return "" + getTitle() + ": " + getYear() + ", " + getGenre() + ", " + "Rating: " + getRating() + ", " + "Cast: " + getCast() + " "; 
    }

    


}
