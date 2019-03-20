package examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author NiclasPC
 */
public class Lump {

    List<String> startLumps = new ArrayList<>();
    List<String> middleLumps = new ArrayList<>();
    List<String> endLumps = new ArrayList<>();

    public String generate() throws IOException {
        fillListsWithLumps();
        return join();
    }

    public void fillListsWithLumps() throws IOException {
        File file = new File("ordlista.txt");
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(file);
            InputStreamReader in = new InputStreamReader(fin, "ISO-8859-1");
            BufferedReader buf = new BufferedReader(in);
            String word;
            while ((word = buf.readLine()) != null) {
                if (word.length() <= 4) {
                    startLumps.add(word);
                } else if (word.length() == 5) {
                    startLumps.add(word.substring(0, 3));
                    endLumps.add(word.substring(word.length() - 2, word.length()));
                } else if (word.length() >= 6 && word.length() <= 8) {
                    startLumps.add(word.substring(0, 3));
                    startLumps.add(word.substring(0, 4));
                    endLumps.add(word.substring(word.length() - 3, word.length()));
                    endLumps.add(word.substring(word.length() - 4, word.length()));
                } else if (word.length() >= 9) {
                    startLumps.add(word.substring(0, 3));
                    startLumps.add(word.substring(0, 4));
                    startLumps.add(word.substring(0, 5));
                    endLumps.add(word.substring(word.length() - 3, word.length()));
                    endLumps.add(word.substring(word.length() - 4, word.length()));
                    endLumps.add(word.substring(word.length() - 5, word.length()));
                } else if (word.length() >= 9) {

                }
            }
            in.close();
            buf.close();
            fin.close();
        } catch (FileNotFoundException ex) {
            // error
        }
    }

    public String join() {
        String word = startLumps.get(new Random().nextInt(startLumps.size())) + endLumps.get(new Random().nextInt(endLumps.size()));
        int lenght = new Random().nextInt(3) + 2;
        String numbers = "";
        for (int i = 0; i < lenght; i++) {
            numbers = numbers + new Random().nextInt(10);
        }
        return word + numbers;
    }

}
