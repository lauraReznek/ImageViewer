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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laura
 */
public class ShowData extends Exit {
//felesleges k�t t�mb
    private final int[] menuNumbers = new int[2];
    private String[] menuOptions = {"BACK", "MODIFY"};
    Scanner scan = new Scanner(System.in);

    public String read(String path) {
        exit();
        System.out.println("Current data: ");
        System.out.println();

        String result = "";
        int index =0;
        
        try {
            InputStreamReader reader = new FileReader(path);
            BufferedReader br = new BufferedReader(reader);
            String line = "";
 
            //model oszt�ly l�trehoz�sa ehelyett
            //Image oszt�ly legyen
            while ((line = br.readLine()) != null) {
               //index++ + "\t" + 
                result += line.replace(";", "\t");
                result += System.lineSeparator();
            }           
            reader.close();
            br.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ShowData.class.getName()).log(Level.SEVERE, null, ex);
            //felhaszn�l�i t�j�koztat�s hi�nya
        } catch (IOException ex) {
            Logger.getLogger(ShowData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public void printOut() {
        //abszol�t helyett relat�v hivatkoz�s
        //hangzatosabb nevek
        System.out.println(read("D:\\Java tanfolyam\\Java SE\\_Itthoni munk�k\\Temp\\FileData.txt"));
    }

    public void showMenu() {
        for (int i = 0; i < menuNumbers.length; i++) {
            System.out.println((i + 1) + ". " + menuOptions[i]);
        }
        
        System.out.println();
        System.out.println("Menu number: ");
        int menuCode = scan.nextInt();
        
        switch (menuCode) {
            case 1:
                exit();
                MainMenu main = new MainMenu();
                main.foMenu();
                break;
            case 2:
                ModifyData modify = new ModifyData();
                modify.manualModify();
                break;        
        }
    }
}
