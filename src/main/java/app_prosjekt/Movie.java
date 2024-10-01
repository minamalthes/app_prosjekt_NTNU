package app_prosjekt;

import java.util.ArrayList;

public class Movie extends Screenplay{
    private final int lengthMinutes;

    
    public Movie(String title, int year, ArrayList<String> cast, double rating, String genre, int lengthMinutes) {
        super(title, "Movie", year, genre, rating, cast); //kaller super sin konstruktør 
        this.lengthMinutes = lengthMinutes;
    }

    @Override
    public String toString() {
        return "" + getTitle() + ": " + getYear() + ", " + getGenre() + ", " + "Rating: " + getRating() + ", " + "Cast: " + getCast() + ", " + "Length in minutes: " + getLengthMinutes(); 
    }

    public int getLengthMinutes() {
        return this.lengthMinutes;
    }

    


}
