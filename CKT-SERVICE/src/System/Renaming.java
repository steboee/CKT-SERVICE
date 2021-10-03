package System;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Renaming {

    public static void UpdateFile(String ID,String Ko_kw,String Ko_hp,String Ko_Nm) throws IOException {

        String filePath = "src/Database/DatabaseZaznamy.txt";

        Scanner sc = new Scanner(new File(filePath));

        StringBuffer buffer = new StringBuffer();

        while (sc.hasNextLine()) {
            String riadok = sc.nextLine();
            String[] a = riadok.split(";",10);
            int velkost = a.length;
            if (a[0].equals(ID)==true){
                buffer.append(a[0]+";"+a[1]+";"+a[2]+";"+a[3]+";"+a[4]+ ";" + a[5] + ";"+Ko_kw+";"+Ko_hp+";"+Ko_Nm+";\n");
            }
            else{
                if(a[5].length()!=0 ){
                    if (velkost>7){
                        buffer.append(a[0] + ";" + a[1] + ";" + a[2] + ";" + a[3] + ";" + a[4] + ";" + a[5] + ";" + a[6] + ";" + a[7] + ";" + a[8] + ";\n");
                    }
                    else{
                        buffer.append(a[0]+";"+a[1]+";"+a[2]+";"+a[3]+";"+a[4]+";"+a[5]+";\n");
                    }

                }
                else{
                    buffer.append(a[0]+";"+a[1]+";"+a[2]+";"+a[3]+";"+a[4]+";\n");
                }
            }


        }
        String fileContents = buffer.toString();

        sc.close();


        FileWriter writer = new FileWriter(filePath);
        writer.append(fileContents);
        writer.flush();

    }

    public static void DeleteZaznam(String ID) throws IOException {
        String filePath = "src/Database/DatabaseZaznamy.txt";
        Scanner sc = new Scanner(new File(filePath));

        StringBuffer buffer = new StringBuffer();

        while (sc.hasNextLine()) {
            String riadok = sc.nextLine();
            String[] a = riadok.split(";",10);
            int velkost = a.length;
            if (a[0].equals(ID)!=true){
                buffer.append(riadok+"\n");
                /*if(a[5].length()!=0 ){
                    if (velkost>7){
                        buffer.append(a[0] + ";" + a[1] + ";" + a[2] + ";" + a[3] + ";" + a[4] + ";" + a[5] + ";" + a[6] + ";" + a[7] + ";" + a[8] + ";\n");
                    }
                    else{
                        buffer.append(a[0]+";"+a[1]+";"+a[2]+";"+a[3]+";"+a[4]+";"+a[5]+";\n");
                    }

                }
                else{
                    buffer.append(a[0]+";"+a[1]+";"+a[2]+";"+a[3]+";"+a[4]+";\n");
                }*/
            }
            else{
                continue;

            }


        }
        String fileContents = buffer.toString();

        sc.close();


        FileWriter writer = new FileWriter(filePath);
        writer.append(fileContents);
        writer.flush();

    }

    public static void FakturaPayed(String index) throws IOException {
        String filePath = "src/Database/DatabaseFaktury.txt";

        Scanner sc = new Scanner(new File(filePath));

        StringBuffer buffer = new StringBuffer();

        while (sc.hasNextLine()) {
            String riadok = sc.nextLine();
            String[] a = riadok.split(";",10);
            int velkost = a.length;
            if (a[0].equals(index)){
                buffer.append(riadok+"ZAPLATENA;\n");
            }
            else{
                buffer.append(riadok);
            }



        }
        String fileContents = buffer.toString();

        sc.close();


        FileWriter writer = new FileWriter(filePath);
        writer.append(fileContents);
        writer.flush();

    }
}
