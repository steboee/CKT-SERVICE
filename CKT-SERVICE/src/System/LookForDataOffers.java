package System;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LookForDataOffers {


    public static String GetName(String index) throws FileNotFoundException {
        File my = new File("src/Database/DatabaseOfOrders.txt");
        Scanner read = new Scanner(my);
        String riadok = "";
        String name = "";
        String INDEX = "";
        while (read.hasNextLine() == true) {
            riadok = read.nextLine();
            char znak;
            name = "";
            INDEX = "";
            for (int i = 0; i < riadok.length(); i++) {
                znak = riadok.charAt(i);
                if (znak == ';') {
                    if (INDEX.equals(index)) {
                        for (int j = i + 1; riadok.charAt(j) != ';'; j++) {
                            znak = riadok.charAt(j);
                            name = name + znak;
                        }
                        return name;
                    } else {
                        break;
                    }

                } else {
                    INDEX = INDEX + znak;
                }

            }


        }
        return null;
    }

    public static String GetSurname(String index) throws FileNotFoundException {
        File my = new File("src/Database/DatabaseOfOrders.txt");
        Scanner read = new Scanner(my);
        String riadok = "";
        String surname = "";
        String INDEX = "";
        while (read.hasNextLine() == true) {
            riadok = read.nextLine();
            char znak;
            int count = 0;
            surname = "";
            INDEX = "";
            for (int i = 0; i < riadok.length(); i++) {
                znak = riadok.charAt(i);
                if (znak == ';') {
                    count++;
                    if (INDEX.equals(index)) {
                        if (count == 2) {
                            for (int j = i + 1; riadok.charAt(j) != ';'; j++) {
                                znak = riadok.charAt(j);
                                surname = surname + znak;
                            }
                            return surname;
                        }
                    } else {
                        break;
                    }
                } else {
                    if (count == 0) {
                        INDEX = INDEX + znak;
                    }
                }
            }
        }
        return null;
    }

    public static String GetBrand(String index) throws FileNotFoundException {
        File my = new File("src/Database/DatabaseOfOrders.txt");
        Scanner read = new Scanner(my);
        String riadok = "";
        String brand = "";
        String INDEX = "";
        while (read.hasNextLine() == true) {
            riadok = read.nextLine();
            char znak;
            int count = 0;
            brand = "";
            INDEX = "";
            for (int i = 0; i < riadok.length(); i++) {
                znak = riadok.charAt(i);
                if (znak == ';') {
                    count++;
                    if (INDEX.equals(index)) {
                        if (count == 3) {
                            for (int j = i + 1; riadok.charAt(j) != ';'; j++) {
                                znak = riadok.charAt(j);
                                brand = brand + znak;
                            }
                            return brand;
                        }
                    } else {
                        break;
                    }
                } else {
                    if (count == 0) {
                        INDEX = INDEX + znak;
                    }
                }
            }
        }
        return null;
    }

    public static String GetFuel(String index) throws FileNotFoundException {
        File my = new File("src/Database/DatabaseOfOrders.txt");
        Scanner read = new Scanner(my);
        String riadok = "";
        String fuel = "";
        String INDEX = "";
        while (read.hasNextLine() == true) {
            riadok = read.nextLine();
            char znak;
            int count = 0;
            fuel = "";
            INDEX = "";
            for (int i = 0; i < riadok.length(); i++) {
                znak = riadok.charAt(i);
                if (znak == ';') {
                    count++;
                    if (INDEX.equals(index)) {
                        if (count == 4) {
                            for (int j = i + 1; riadok.charAt(j) != ';'; j++) {
                                znak = riadok.charAt(j);
                                fuel = fuel + znak;
                            }
                            return fuel;
                        }
                    } else {
                        break;
                    }
                } else {
                    if (count == 0) {
                        INDEX = INDEX + znak;
                    }
                }
            }
        }
        return null;
    }

    public static String GetEngine(String index) throws FileNotFoundException {
        File my = new File("src/Database/DatabaseOfOrders.txt");
        Scanner read = new Scanner(my);
        String riadok = "";
        String engine = "";
        String INDEX = "";
        while (read.hasNextLine() == true) {
            riadok = read.nextLine();
            char znak;
            int count = 0;
            engine = "";
            INDEX = "";
            for (int i = 0; i < riadok.length(); i++) {
                znak = riadok.charAt(i);
                if (znak == ';') {
                    count++;
                    if (INDEX.equals(index)) {
                        if (count == 5) {
                            for (int j = i + 1; riadok.charAt(j) != ';'; j++) {
                                znak = riadok.charAt(j);
                                engine = engine + znak;
                            }
                            return engine;
                        }
                    } else {
                        break;
                    }
                } else {
                    if (count == 0) {
                        INDEX = INDEX + znak;
                    }
                }
            }
        }
        return null;
    }

    public static String GetIndex(int i) throws FileNotFoundException {
        File my = new File("src/Database/DatabaseOfOrders.txt");
        Scanner read = new Scanner(my);
        String riadok = "";
        String Index = "";
        int count=0;
        while (read.hasNextLine() == true) {
            riadok = read.nextLine();
            count++;
            if (count == i){
                char znak;
                for (int j = 0; j < riadok.length(); j++) {
                    znak = riadok.charAt(j);
                    if (znak == ';') {
                        return Index;
                    }
                    else{
                        Index = Index + znak;
                    }

                }
            }

        }



        return null;
    }

    public static String GetCip(String index) throws FileNotFoundException {
        File my = new File("src/Database/DatabaseOfOrders.txt");
        Scanner read = new Scanner(my);
        String riadok = "";
        String surname = "";
        String INDEX = "";
        while (read.hasNextLine() == true) {
            riadok = read.nextLine();
            char znak;
            int count = 0;
            surname = "";
            INDEX = "";
            for (int i = 0; i < riadok.length(); i++) {
                znak = riadok.charAt(i);
                if (znak == ';') {
                    count++;
                    if (INDEX.equals(index)) {
                        if (count == 6) {
                            for (int j = i + 1; riadok.charAt(j) != ';'; j++) {
                                znak = riadok.charAt(j);
                                surname = surname + znak;
                            }
                            return surname;
                        }
                    } else {
                        break;
                    }
                } else {
                    if (count == 0) {
                        INDEX = INDEX + znak;
                    }
                }
            }
        }
        return null;
    }

    public static String GetID(String name,String surname,int i) throws FileNotFoundException {
        File my = new File("src/Database/DatabaseOfOrders.txt");
        Scanner read = new Scanner(my);
        String riadok = "";
        int pocitadlo=0;
        while (read.hasNextLine() == true) {
            riadok = read.nextLine();
            String[] s;
            if (pocitadlo == i){
                s = riadok.split(";",6);
                if (s[1].equals(name)){
                    if (s[2].equals(surname)){
                        return s[0];
                    }
                    else{
                        return "false";
                    }
                }
                else{
                    return "false";
                }
            }
            else{
                pocitadlo++;
            }
        }
        return "end";
    }

    public static String GetElektroIndex(String ide) throws FileNotFoundException {
        File my = new File("src/Database/DatabaseZaznamy.txt");
        Scanner read = new Scanner(my);
        String riadok = "";
        String Index = "";
        int count=0;
        while (read.hasNextLine() == true) {
            riadok = read.nextLine();
            String[]s = riadok.split(";",10);
            if (ide.equals(s[0])){
                char znak;
                if (s[1].length() !=0 && s[5].length()==0){
                    return s[0];
                }
                else{
                    return null;
                }
            }
            count++;

        }

        return null;
    }

    public static String stav(String index) throws FileNotFoundException {
        File my = new File("src/Database/DatabaseZaznamy.txt");
        Scanner read = new Scanner(my);
        String riadok = "";
        int pocitadlo=0;
        while (read.hasNextLine() == true) {
            riadok = read.nextLine();
            String[] s;
            s = riadok.split(";",9);
            if (s[0].equals(index)){
                if (s[5].isEmpty()){
                    return "U_Elektromechanika";
                }
                else if (s[6].isEmpty()){
                    return "DruhyTest";
                }
                else{
                    return "Dokončená";
                }
            }
            continue;



        }
        return "Neotvorená";

    }

    public static boolean Getchip(String index) throws FileNotFoundException {
        File my = new File("src/Database/DatabaseZaznamy.txt");
        Scanner read = new Scanner(my);
        String riadok = "";
        int pocitadlo=0;
        while (read.hasNextLine() == true) {
            riadok = read.nextLine();
            String[] s;
            s = riadok.split(";", 9);
            if (s[5].isEmpty()) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public static String Startstop(String index) throws FileNotFoundException {
        File my = new File("src/Database/DatabaseOfOrders.txt");
        Scanner read = new Scanner(my);
        String riadok = "";
        while (read.hasNextLine() == true) {
            riadok = read.nextLine();
            String[] s;
            s = riadok.split(";",10);
            if (s[0].equals(index)) {
                return s[7];
            }
        }
        return null;
    }

    public static String Mapy(String index) throws FileNotFoundException {
        File my = new File("src/Database/DatabaseOfOrders.txt");
        Scanner read = new Scanner(my);
        String riadok = "";
        while (read.hasNextLine() == true) {
            riadok = read.nextLine();
            String[] s;
            s = riadok.split(";",10);
            if (s[0].equals(index)) {
                return s[8];
                }

        }
        return null;
    }
}
