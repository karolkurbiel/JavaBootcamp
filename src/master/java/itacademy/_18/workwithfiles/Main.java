package itacademy._18.workwithfiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private static final String fileName = "HelloWorldFile.txt";
    private static final String text = "Hello File World!";

    public static void main(String[] args) throws IOException {

        try {
            storeText(text);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(loadText());
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String loadText() throws IOException {
        Path path = Paths.get(fileName);
        BufferedReader br = Files.newBufferedReader(path);

        String output;

        output = br.readLine();
        br.close();

        return output;
    }

    private static void storeText(String input) throws IOException {
        Path path = Paths.get(fileName);
        BufferedWriter bw = Files.newBufferedWriter(path);

        bw.write(input);
        bw.close();
    }
}
