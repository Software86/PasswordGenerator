package examen;

import java.io.BufferedReader;
import java.io.DataInputStream;
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
public class Word {

    List<String> words = new ArrayList<>();
    String result = null;

    public String generate() throws IOException {
        fillWords();
        mixWords();
        numbers();
        return result;
    }

    public void fillWords() throws IOException {
        File file = new File("ordlista.txt");
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(file);
            InputStreamReader in = new InputStreamReader(fin, "ISO-8859-1");
            BufferedReader buf = new BufferedReader(in);
            String word;
            while ((word = buf.readLine()) != null) {
                if (word.length() < 6) {
                    words.add(word);
                }
            }
            in.close();
            buf.close();
            fin.close();
        } catch (FileNotFoundException ex) {
            // error
        }

    }

    public void mixWords() {
        Random rand = new Random();
        int first = rand.nextInt(words.size());
        int second = rand.nextInt(words.size());
        String firstW = words.get(first);
        String secondW = words.get(second);

        this.result = firstW + secondW;

    }

    public void numbers() {
        Random rand = new Random();
        int lenght = rand.nextInt(3) + 2;
        String result = null;
        for (int i = 0; i < lenght; i++) {
            if (result == null) {
                result = String.valueOf(rand.nextInt(10));
            } else {
                result = result + rand.nextInt(10);
            }
        }
        if (rand.nextInt(2) == 0) {
            this.result = this.result + result;
        } else {
            this.result = result + this.result ;
        }
    }

}
