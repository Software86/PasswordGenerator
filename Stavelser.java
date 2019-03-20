
package examen;

import java.util.Random;

/**
 * @author NiclasPC
 */
public class Stavelser {
    
    String result = "";
    
    char[] vokaler = {'a', 'e', 'i', 'o', 'u', 'y', 'å', 'ä','ö'};
    char[] konsonanter = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v','w', 'x', 'z'};
    
    public String generate(){
        int lenght = new Random().nextInt(3)+2;
        for (int i = 0; i < lenght; i++) {
            add();
        }
        return result;
    }
    
    public void add(){
        String r = "";
        r = r + vokaler[new Random().nextInt(vokaler.length)];
        int amountOfKon = new Random().nextInt(5)+2;
        for (int i = 0; i < amountOfKon; i++) {
            r = r + konsonanter[new Random().nextInt(konsonanter.length)];
        }
        result = result + r;
    }
}
