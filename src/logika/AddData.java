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
        //túl zsúfolt
        //nem ideillõ felelõsségek
        //felesleges származtatás
        exit();
        writerData("D:\\Java tanfolyam\\Java SE\\_Itthoni munkák\\Temp\\FileData.txt", getInfoManually(), true);
        writerData("D:\\Java tanfolyam\\Java SE\\_Itthoni munkák\\Temp\\FileData.txt", addMoreData(), true);
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
            //miért van kétszer zárás?
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
        //itt az Y/N-t kezelje le mint linuxnál
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
    //miért van visszatérési értékben újra meghívva? így mindenképp le fog futni
        return getInfoManually();
    }
}
