/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Laura
 */
public class MainMenu {
    //nem szükséges két tömb
    private final int[] sorszam = new int[5];
    String[] menuPoints = {"SHOW", "ADD", "SEARCH", "DELETE", "EXIT"};
    Scanner scan = new Scanner(System.in);

    public void foMenu() {
        for (int i = 0; i < sorszam.length; i++) {
            System.out.println((i + 1) + ". " + menuPoints[i]);
        }
        System.out.println("");
        System.out.println("Menu number: ");
        int menuSzama = scan.nextInt();

        switch (menuSzama) {
            case 1:
                ShowData show = new ShowData();
                show.printOut();
                show.showMenu();
                break;
            case 2:
                AddData add = new AddData();
                add.addNewData();
                break;
            case 3:
                SearchData search = new SearchData();
                search.sout();
                break;
            case 4:
                DeleteData delete = new DeleteData();
                delete.sout();
                break;
            default:
                Exit exit = new Exit();
                exit.exit();
                break;
        }

    }
}
