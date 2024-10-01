package app_prosjekt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

public class CSVBio {

    private final Path path;

    public CSVBio(String path){
        
        this.path = Objects.requireNonNull(Path.of(path+ ".csv"));
    }


    public void saveBio(String bio) throws IOException{
        try (BufferedWriter writer = Files.newBufferedWriter(this.path)){ //hvis filen eksisterer så tar vi den vekk, hvis ikke så oppretter vi ny
            writer.write(bio);
        }
    }

    public String readBio() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(this.path)){
            StringBuilder stringBuilder = new StringBuilder();
            reader.lines().forEach(line -> {
                stringBuilder.append(line);
                System.out.println(line);
            });
            return stringBuilder.toString();
        } 

    }

    public static void main(String[] args) {
        CSVBio bioHelena = new CSVBio("helena");
        CSVBio bioElias = new CSVBio("elias");
      
    
        try {
            bioHelena.saveBio("Halla. Jeg heter Helena og jeg elsker objekt blablablabla."); // Lagre biografien til filen
            System.out.println("Biografi lagret vellykket!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
}
