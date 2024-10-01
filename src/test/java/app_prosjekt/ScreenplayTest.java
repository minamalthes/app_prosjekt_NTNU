package app_prosjekt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScreenplayTest {

    ArrayList<String> cast;
    private Screenplay screenplay;

    @BeforeEach
    void setup(){
        cast = new ArrayList<>();
        cast.add("Actor1");
        cast.add("Actor2");
        screenplay = new Screenplay("Title", "Movie", 2022, "Action", 8.5, cast);
    }
    
    @Test
    void getTitle(){
        assertEquals("Title", screenplay.getTitle());
    }

    @Test
    void getType(){
        assertEquals("Movie", screenplay.getType());
    }

    @Test
    void getYear(){
        assertEquals(2022, screenplay.getYear());
    }

    @Test
    void getGenre(){
        assertEquals("Action", screenplay.getGenre());
    }

    @Test
    void getRating(){
        assertEquals(8.5, screenplay.getRating());
    }
    
    @Test
    void getCast(){
        List<String> expectedCast = new ArrayList<>();
        expectedCast.add("Actor1");
        expectedCast.add("Actor2");
        assertEquals(expectedCast, screenplay.getCast());
    }

    @Test
    void validateYear_ValidYear() {
        assertTrue(screenplay.validateYear(2022));
    }

    @Test
    void validateYear_InvalidYear() {
        assertFalse(screenplay.validateYear(1880));
    }

    @Test
    void validateYear_EdgeYear() {
        assertFalse(screenplay.validateYear(1888));
        assertFalse(screenplay.validateYear(2024));
    }

    @Test
    void toStringTest() {
        String expectedString = "Title: 2022, Action, Rating: 8.5, Cast: [Actor1, Actor2] ";
        assertEquals(expectedString, screenplay.toString());
    }






}
