package app_prosjekt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ScreenplayComparatorTest {

    private Screenplay movie1;
    private Screenplay movie2;
    private Screenplay show1;

    @BeforeEach
    public void setUp() {
        movie1 = new Movie("The Dark Knight", 2008, new ArrayList<String>(Arrays.asList("Christian Bale", "Heath Ledger")), 9.0, "Crime/Drama", 152);
        movie2 = new Movie("The Godfather", 1972, new ArrayList<String>(Arrays.asList("Marlon Brando", "Al Pacino")), 9.2, "Crime/Drama", 175);
        show1 = new Show("Chernobyl", 2019, new ArrayList<String>(Arrays.asList("Jessie Buckley","Jared Harris")), 9.3, "Drama/History", 5);
    }


    @Test
    public void testConstructor() {
        try {
            new ScreenplayComparator("Type");
            new ScreenplayComparator("Year");
            new ScreenplayComparator("Rating");
            assertTrue(true); // Bekrefter at ingen unntak ble kastet
        } catch (IllegalArgumentException e) {
            fail("Konstruktøren skal ikke kaste et unntak for gyldige sorteringsmetoder.");
        }
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {new ScreenplayComparator("Invalid"); });
        assertEquals("Ugyldig sorteringsmetode", exception.getMessage());
    }

     @Test
    void testValidSortByYear() {
        ScreenplayComparator comparator = new ScreenplayComparator("Year");
        assertTrue(comparator.compare(movie1, movie2) > 0, "Nye filmer skal komme etter gamle");
        assertTrue(comparator.compare(movie2, movie1) < 0, "Gamle filmer skal komme før nye");
    }

    @Test
    void testValidSortByRating() {
        ScreenplayComparator comparator = new ScreenplayComparator("Rating");
        assertTrue(comparator.compare(movie1, movie2) < 0, "Lavere rating skal komme etter høyere rating");
    }

    @Test
    void shouldCorrectlySortMovieAndShow() {
        ScreenplayComparator typeComparator = new ScreenplayComparator("Type");
        int comparisonResult = typeComparator.compare(movie1, show1);
         // Bekreft at filmen er rangert før showet, som vil gi et negativt tall
        assertTrue(comparisonResult < 0, "Filmen skal komme før showet basert på typen.");
    }



}
