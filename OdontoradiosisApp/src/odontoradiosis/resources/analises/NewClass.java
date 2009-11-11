/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package odontoradiosis.resources.analises;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Beto
 */
public class NewClass {

    public static void main(String[] args) {
        try {
            
            ArrayList<String> a = new ArrayList<String>();
            a.add("Downs");
            a.add("Harvold");
            a.add("Steiner");
            
            FileOutputStream fileBaseDados = new FileOutputStream("src/odontoradiosis/resources/analises/preferencias.txt");
            ObjectOutputStream o = new ObjectOutputStream(fileBaseDados);

            FileInputStream fileBaseDados2 = new FileInputStream("src/odontoradiosis/resources/analises/preferencias.txt");
            ObjectInputStream o2 = new ObjectInputStream(fileBaseDados2);

            o.writeObject(a);
            ArrayList<String> aaa = (ArrayList<String>) o2.readObject();

            System.out.println(aaa);
        }
        catch(Exception e) {e.printStackTrace();}
    }

}
