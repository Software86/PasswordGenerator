package examen;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author NiclasPC
 */
public class NextDoor {

    char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    char[] cLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    char[] charactersAndNumbers = {'/', '*', '-', '+', '%', '&', '@', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '!', '?'};

    Map<Character, char[]> compatibility = new HashMap<Character, char[]>();

    public String generate() {
        Random rand = new Random();
        fillHashMap();
        int lenght = rand.nextInt(6) + 4;
        boolean placeCharEnd = rand.nextBoolean();
        int numberOfChar = rand.nextInt(3) + 1;
        char result[] = new char[lenght];
        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                result[i] = getLetter();
            } else {
                char[] temp = compatibility.get(result[i-1]);
                result[i] = temp[rand.nextInt(temp.length)];
            }
        }
        return String.valueOf(result);
    }

    public char getLetter() {
        Random rand = new Random();
        return letters[rand.nextInt(letters.length)];
    }

    public void fillHashMap() {
        for (int i = 0; i < letters.length; i++) {
            compatibility.put(letters[i], cArr[i]);
        }
    }


    //'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
    char[][] cArr = {
        //a
        {'b', 'j', 'k', 'l', 'm', 'n', 'p', 'r', 's', 't', 'v', 'w', 'x', 'z'},
        //b 
        {'a', 'e', 'i', 'l', 'o', 'r', 'u'},
        //c
        {'a', 'i', 'o', 't', 'u', 'v', 'w', 'x', 'y'},
        //d
        {'a','e', 'i', 'o', 'u', 'y',},
        //e  
        {'b', 'd', 'f', 'g', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'},
        //f
        {'a', 'e', 'h', 'i', 'l', 'o', 'r', 'u'},
        //g
        {'a', 'e', 'i', 'j', 'l', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'},
        //h 
        {'a', 'e', 'i', 'o', 'u', 'y'},
        //i
        {'a', 'c', 'd', 'f', 'g', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'r', 's', 't', 'x', 'z'},
        //j
        {'a', 'e', 'o', 'u', 'x', 'y'},
        //k
        {'a', 'e', 'i', 'l', 'o', 'u', 'y'},
        //l
        {'a', 'e', 'i', 'o','t', 'u', 'y'},
        //m
        {'a', 'c', 'e', 'i', 'o', 's', 't', 'u'},
        //n
        {'a', 'e', 'g', 'i', 'k', 'l', 'm', 'o', 'p', 'r', 's', 't', 'u', 'w', 'x', 'y', 'z'},
        //o
        {'a', 'b', 'd', 'f', 'g', 'j', 'k', 'l', 'm', 'n', 'p', 'r', 's', 't', 'v', 'w'},
        //p
        {'a', 'e', 'h', 'i', 'j', 'l', 'o', 's', 'u'},
        //q
        {'u'},
        //r
        {'a', 'e', 'i', 'o', 'u'},
        //s
        {'a', 'e','i', 'j', 'k', 'm', 'n', 'o','t', 'u'},
        //t
        {'a', 'e','i','l', 'm', 'o', 'r', 'u'},
        //u
        {'m', 'n','p','r', 's', 't','v', 'w', 'x'},
        //v
        {'a', 'e', 'i', 'l','o', 'u'},
        //w 
        {'a', 'e', 'i', 'l','o', 'u'},
        //x
        {'e', 'i', 'o', 'u', 'y'},
        //y
        {'d', 'k', 'l', 'm', 'n', 'r', 's', 'v', 'w'},
        //z
        {'a', 'e', 'i', 'o', 'u'}};
}
//String[] a = compatibility.get('A');

