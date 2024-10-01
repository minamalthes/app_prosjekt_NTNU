package app_prosjekt;

import java.util.List;
import java.util.Objects;

import javafx.stage.Screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ScreenplayList implements Iterable<Screenplay>{
    private List<Screenplay> listOfScreenplays;

    public ScreenplayList() {
        this.listOfScreenplays = new ArrayList<>();


        Show theOffice = new Show("The Office", 2005, new ArrayList<String>(Arrays.asList("Rain Wilsson", "Steve Carell")),4.0,"Comedy", 201);
        listOfScreenplays.add(theOffice);
        
        Show breakingBad = new Show("Breaking Bad", 2008, new ArrayList<String>(Arrays.asList("Bryan Cranston","Aaron Paul")),9.5, "Crime/Drama", 62);
        listOfScreenplays.add(breakingBad);

        Show planetEarth = new Show("Planet Earth", 2006, new ArrayList<String>(Arrays.asList("Sigourney Weaver","David Attenborough")),9.4, "Documentary", 11);
        listOfScreenplays.add(planetEarth);

        Movie forrestGump = new Movie("Forrest Gump", 1994, new ArrayList<String>(Arrays.asList("Tom Hanks", "Robin Wright")),8.8, "Comedy/Romance", 142);
        listOfScreenplays.add(forrestGump);

        Movie shawshankRedemption = new Movie("The Shawshank Redemption", 1994, new ArrayList<String>(Arrays.asList("Tim Robbins", "Morgan Freeman")), 9.3, "Drama", 142);
        listOfScreenplays.add(shawshankRedemption);

        Movie godFather = new Movie("The Godfather", 1972, new ArrayList<String>(Arrays.asList("Marlon Brando", "Al Pacino")), 9.2, "Crime/Drama", 175);
        listOfScreenplays.add(godFather);

        Movie darkKnight = new Movie("The Dark Knight", 2008, new ArrayList<String>(Arrays.asList("Christian Bale", "Heath Ledger")), 9.0, "Crime/Drama", 152);
        listOfScreenplays.add(darkKnight);

        Movie schindlersList = new Movie("Schindler's List", 1993, new ArrayList<String>(Arrays.asList("Liam Neeson", "Ralph Fiennes")), 9.0, "Drama/History", 195);
        listOfScreenplays.add(schindlersList);

        Movie pulpFiction = new Movie("Pulp Fiction", 1994, new ArrayList<String>(Arrays.asList("John Travolta", "Uma Thurman")), 8.9, "Crime/Drama", 154);
        listOfScreenplays.add(pulpFiction);

        Movie inception = new Movie("Inception", 2010, new ArrayList<String>(Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt")), 8.8, "Action", 148);
        listOfScreenplays.add(inception);

        Movie theMatrix = new Movie("The Matrix", 1999, new ArrayList<String>(Arrays.asList("Keanu Reeves", "Laurence Fishburne")), 8.9, "Action", 136);
        listOfScreenplays.add(theMatrix);

        Show chernobyl = new Show("Chernobyl", 2019, new ArrayList<String>(Arrays.asList("Jessie Buckley","Jared Harris")), 9.3, "Drama/History", 5);
        listOfScreenplays.add(chernobyl);

        Show theSopranos = new Show("The Sopranos", 1999, new ArrayList<String>(Arrays.asList("James Gandolfini","Lorraine Bracco")), 9.2, "Crime/Drama", 86);
        listOfScreenplays.add(theSopranos);

        Show gameOfThrones = new Show("Game of Thrones", 2011, new ArrayList<String>(Arrays.asList("Emilia Clarke","Peter Dinklage")),9.2, "Action", 74);
        listOfScreenplays.add(gameOfThrones);

        Show friends = new Show("Friends", 1994, new ArrayList<String>(Arrays.asList("Jennifer Aniston","Courteney Cox")), 8.9, "Comedy", 234);
        listOfScreenplays.add(friends);

    }

    /**
     * 
     * @return sum of movies and shows
     */
    public int getScreenplayCount() {
        return listOfScreenplays.size();
    }

    public Screenplay getScreenplay(int n) { 
        if (n >= 0 && n < listOfScreenplays.size()) { 
            return listOfScreenplays.get(n); 
        }
        else {
            throw new IllegalArgumentException("Ugyldig indeks"); 
        }
    }

    public Iterator<Screenplay> iterator() {
        return new ScreenplayIterator(this);
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<Movie>();//hvis man bruker movies så får man alle metoder til screenplay og movies, og ikke bare screenplay
        for (Screenplay s : listOfScreenplays) {
            if (s instanceof Movie movie) { //hvis s er en del av movieklassen så kall den m og legg den til 
                movies.add(movie);
            }
        }
        return movies;
    }

    public List<Show> getAllShows() {
        List<Show> shows = new ArrayList<Show>();
        for (Screenplay s : listOfScreenplays) {
            if (s instanceof Show show) {
                shows.add(show);
            }
        }
        return shows;
    }

    public List<Screenplay> getAllScreenplays() {
        return listOfScreenplays;
    }

    public ArrayList<Screenplay> sortType(ScreenplayComparator comparator){
        if (comparator == null) {
			throw new IllegalArgumentException("Må ha en comparator her");
		}
		ArrayList<Screenplay> screenPlayList2 = new ArrayList<Screenplay>();
        ScreenplayList screenplayList = new ScreenplayList();
        for (Screenplay screenplay : screenplayList) {
            screenPlayList2.add(screenplay);
        }
		Collections.sort(screenPlayList2, comparator);
        return screenPlayList2;
    }

    public ArrayList<Screenplay> sortYear(ScreenplayComparator comparator){
        if (comparator == null) {
			throw new IllegalArgumentException("Må ha en comparator her");
		}
		ArrayList<Screenplay> screenPlayList2 = new ArrayList<Screenplay>();
        ScreenplayList screenplayList = new ScreenplayList();
        for (Screenplay screenplay : screenplayList) {
            screenPlayList2.add(screenplay);
        }
		Collections.sort(screenPlayList2, comparator);
        System.out.println(screenPlayList2.get(1));
        return screenPlayList2;
    }

    public ArrayList<Screenplay> sortRating(ScreenplayComparator comparator){
        if (comparator == null) {
			throw new IllegalArgumentException("Må ha en comparator her");
		}
		ArrayList<Screenplay> screenPlayList2 = new ArrayList<Screenplay>();
        ScreenplayList screenplayList = new ScreenplayList();
        for (Screenplay screenplay : screenplayList) {
            screenPlayList2.add(screenplay);
        }
		Collections.sort(screenPlayList2, comparator);
        return screenPlayList2;
    }
    
    public static void main(String[] args) {
        ScreenplayList screenplayList = new ScreenplayList();
        ScreenplayComparator comparator = new ScreenplayComparator("Year");
        for (Screenplay screenplay : screenplayList.listOfScreenplays) { 
            System.out.println(screenplay);
        }

        screenplayList.sortYear(comparator);
    }

    

}

