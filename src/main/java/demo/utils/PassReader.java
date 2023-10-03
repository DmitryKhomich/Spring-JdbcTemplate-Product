package demo.utils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PassReader {

    public static String readPass(){

        String pass;
        try {
            pass = Files.readString(Path.of("INFO/pass.txt"));
        } catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
        return pass;
    }
}
