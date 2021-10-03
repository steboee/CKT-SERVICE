package Model.Zamestnanci;

import Model.Suciastky.Suciastka;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The type Elektromechanik.
 */
public class Elektromechanik extends Employes {

    /**
     * Instantiates a new Elektromechanik.
     *
     * @param Username the username
     * @param Password the password
     */
    public Elektromechanik(String Username, String Password) {
        super(Username, Password);
    }

    /**
     * Instantiates a new Elektromechanik.
     */
    public Elektromechanik() {

    }


    /**
     * funkcia zapiše info do txt súboru DatabaseZaznamy
     *
     * @param index the index
     * @param Cip   the cip
     * @throws IOException the io exception
     */
    public static void WriteInfo(String index, String Cip) throws IOException { // zapíše údaje o čipedo databazy
        String filePath = "src/Database/DatabaseZaznamy.txt";

        Scanner sc = new Scanner(new File(filePath));

        StringBuffer buffer = new StringBuffer();

        while (sc.hasNextLine()) {
            String riadok = sc.nextLine();
            String[] a = riadok.split(";",10);
            int velkost = a.length;
            if (a[0].equals(index)==true){
                buffer.append(a[0]+";"+a[1]+";"+a[2]+";"+a[3]+";"+a[4]+";"+Cip+";\n");
            }
            else if(a[5].length()!=0 ){
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
        String fileContents = buffer.toString();

        sc.close();


        FileWriter writer = new FileWriter(filePath);
        writer.append(fileContents);
        writer.flush();
    }

    /**
     * Info.
     */
    public static void info(){
        ArrayList<Suciastka> list;
        list   =  Suciastka.create();
        list.get(1).vypisinfo();
    }


    @Override
    public ArrayList<String> prepni_obrazovku() { // polymorfia na prepinanie okien
        ArrayList<String> s = new ArrayList<>();
        s.add("/View/Zamestnanci/ElektromechanikView.fxml");
        s.add("CKT-SERVIS Elektromechanik");
        return s;
    }
}
