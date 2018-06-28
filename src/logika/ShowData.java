/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laura
 */
public class ShowData extends Exit{
    
    public void read(String path){
        exit();
        System.out.println("Current data: ");
        System.out.println();
        
        String result = "";
        try {
            InputStreamReader reader = new FileReader(path);
            BufferedReader br = new BufferedReader(reader);
            String line =";";
            
            try {
                while ((line=br.readLine())!=null) {
                    result+=line;
                    result+=System.lineSeparator();
                }
                reader.close();
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(ShowData.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ShowData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
