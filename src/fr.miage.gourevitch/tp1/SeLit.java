package fr.miage.gourevitch.tp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintStream;

public class SeLit {
    static public void main(String[] args) {
        PrintStream ps = System.out;
        File output = new File("./text.txt");
        try {
            output.createNewFile();
            System.setOut(new PrintStream(output));
        } catch (IOException e) {
            e.printStackTrace();
        }
        SeLit seLitIl = new SeLit();
        try {
            Scanner chemin = new Scanner(new File("./src/fr.miage.gourevitch/Filter.java"));
            System.out.println(chemin.toString());
            seLitIl.lecture(chemin);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(ps);
    }


    void lecture(Scanner source) {

        while (source.hasNextLine()) {
            String s = source.nextLine();
            System.out.println("LU:" + s);
            if ((s.trim().contains("\"//\"") || !s.trim().startsWith("//")) &&
                    !s.trim().contains("\"//\"") && s.trim().contains("//")) {
                System.out.println(s.split("//")[0]);
            }
            else
                {
                System.out.println(s);
            }
        }
    }
}