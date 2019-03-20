/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.io.IOException;

/**
 *
 * @author NiclasPC
 */
public class Examen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        NextDoor n  = new NextDoor();
        System.out.println(n.generate());
    }
    
}
