package app_prosjekt;

import java.util.ArrayList;
import java.util.Objects;

public class Show extends Screenplay{
    private final int episodes;

    public Show(String title, int year, ArrayList<String> cast, double rating, String genre, int episodes) {
        super(title, "Show", year, genre, rating, cast);
        this.episodes = Objects.requireNonNull(episodes); //hva betyr det her
    }

    @Override
    public String toString() {
        return "" + getTitle() + ": " + getYear() + ", " + getGenre() + ", " + "Rating: " + getRating() + ", " + "Cast: " + getCast() + ", " + "Episodes: " + getEpisodes(); 
    }

    public int getEpisodes() {
        return this.episodes;
    }


}
