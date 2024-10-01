package app_prosjekt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;


public class CSVBioTest {
    
    private CSVBio csvBio;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        csvBio = new CSVBio(tempDir.resolve("test_bio").toString()); //tempDir oppretter midlertidige filer som ikke vil påvirke noe
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(tempDir.resolve("test_bio.csv"));
    }

    @Test
    void saveAndReadBio() throws IOException {
        String bio = "This is a test biography. COOl hey";
        csvBio.saveBio(bio);
        String readBio = csvBio.readBio();
        assertEquals(bio, readBio);
    }

    @Test
    void saveAndReadEmptyBio() throws IOException {
        String bio = "";
        csvBio.saveBio(bio);
        String readBio = csvBio.readBio();
        assertEquals(bio, readBio);
    }

    @Test
    void saveAndReadNullBio() {
        assertThrows(NullPointerException.class, () -> csvBio.saveBio(null));
    }
}
