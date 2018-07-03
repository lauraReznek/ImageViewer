package logika;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Laura
 */
public class AddData extends Exit {

    Scanner scan = new Scanner(System.in);

    public void addNewData() {
        //t�l zs�folt
        //nem ideill� felel�ss�gek
        //felesleges sz�rmaztat�s
        exit();
        writerData("D:\\Java tanfolyam\\Java SE\\_Itthoni munk�k\\Temp\\FileData.txt", getInfoManually(), true);
        writerData("D:\\Java tanfolyam\\Java SE\\_Itthoni munk�k\\Temp\\FileData.txt", addMoreData(), true);
    }

    void writerData(String path, ArrayList<String> text, boolean writeAfter) {
        try {
            FileWriter writer = new FileWriter(path, writeAfter);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (String incomingTex : text) {
                bufferedWriter.write(incomingTex);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            writer.close();
            //mi�rt van k�tszer z�r�s?
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(AddData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ArrayList<String> getInfoManually() {
        System.out.println("Add new data here: ");

        ArrayList<String> result = new ArrayList<>();
        System.out.println("Name: ");
        String name = scan.nextLine();
        System.out.println("Size: ");
        String size = scan.nextLine();
        System.out.println("Pixel data: ");
        String pixelData = scan.nextLine();
        System.out.println("Format: ");
        String format = scan.nextLine();
        result.add(name + ";" + size + ";" + pixelData + ";" + format + ";");
        
        //addMoreData();
        return result;
    }

    ArrayList<String> addMoreData() {
        System.out.println("Do you want to add more data?");
        //itt az Y/N-t kezelje le mint linuxn�l
        System.out.println("1. YES");
        System.out.println("2. NO");
        int addOption = scan.nextInt();

        while (addOption == 1) {
            getInfoManually();
        }
        MainMenu menu = new MainMenu();
        menu.foMenu();

//        if (addOption == 1) {
//            getInfoManually();
//        } else {
//            MainMenu menu = new MainMenu();
//            menu.foMenu();
//        }
    //mi�rt van visszat�r�si �rt�kben �jra megh�vva? �gy mindenk�pp le fog futni
        return getInfoManually();
    }
}
