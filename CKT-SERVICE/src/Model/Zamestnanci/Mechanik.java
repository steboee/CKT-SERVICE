package Model.Zamestnanci;

import Model.Objednavka_atd.ZaznamVozidla;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static Model.Objednavka_atd.Objednavka.setZaznam;

/**
 * The type Mechanik.
 */
public class Mechanik extends Employes{
    /**
     * The Username.
     */
    String username = "mechanik";
    /**
     * The Password.
     */
    String password = "m1234";

    /**
     * Instantiates a new Mechanik.
     */
    public Mechanik(){
        super();

    }

    /**
     * Instantiates a new Mechanik.
     *
     * @param UserName the user name
     * @param Password the password
     * @param cislo    the cislo
     */
    public Mechanik(String UserName,String Password,int cislo){
        super(UserName,Password);
    }


    /**
     * Instantiates a new Mechanik.
     *
     * @param userName the user name
     * @param password the password
     */
    public Mechanik(String userName, String password) {
        super(userName, password);
    }

    /**
     * FUnkcia Vytvorí záznam o vozidle na zaklde info z GUI
     *
     * @param IdObjednavky the id objednavky
     * @param Model        the model
     * @param Poc_Kw       the poc kw
     * @param Poc_HP       the poc hp
     * @param Poc_Nm       the poc nm
     * @return the int
     * @throws IOException the io exception
     */
// vytvorí prvotný záznam o vozidle
    public static int VytvorZaznamVozidla(TextField IdObjednavky, TextField Model, TextField Poc_Kw, TextField Poc_HP, TextField Poc_Nm) throws IOException {
        ZaznamVozidla z = new ZaznamVozidla(IdObjednavky.getText(), Model.getText(),Poc_HP.getText(),Poc_Kw.getText(),Poc_Nm.getText());
        setZaznam(z);
        int kontrola = z.UlozData();
        return kontrola;
    }

    /**
     * Funkcia updatne databázu na základe info z GUI
     *
     * @param Id     the id
     * @param Model  the model
     * @param Poc_Kw the poc kw
     * @param Poc_hp the poc hp
     * @param Poc_Nm the poc nm
     * @param cip    the cip
     * @param Ko_kw  the ko kw
     * @param Ko_hp  the ko hp
     * @param Ko_Nm  the ko nm
     * @return the int
     * @throws IOException the io exception
     */
// DOPLI DO DATABAZY INFO o koncových
    public static int UpdateDatabase(String Id, String Model, String Poc_Kw, String Poc_hp, String Poc_Nm,String cip, String Ko_kw, String Ko_hp, String Ko_Nm) throws IOException {
        ZaznamVozidla z = new ZaznamVozidla(Id,Model,Poc_Kw,Poc_hp,Poc_Nm,cip,Ko_kw,Ko_hp,Ko_Nm);
        int i = z.Update();
        return i;
    }

    /**
     * Funkcia nájde zaznam vozidla na zákldde ID
     *
     * @param ID the id
     * @return the int
     * @throws FileNotFoundException the file not found exception
     */
    public static int LookForZaznam(String ID) throws FileNotFoundException { // hladá Záznam v databáze ak sa nachádza returne 0 ak nie tak 1
        File my = new File ("src/Database/DatabaseZaznamy.txt ");
        Scanner read = new Scanner(my);
        while(read.hasNextLine()){
            String riadok = read.nextLine();
            String[] a = riadok.split(";",9);
            for (int i = 0;i<5;i++){
                if (a[i].equals(ID)){
                    return 0;
                }
            }
        }
        return 1;
    }

    /**
     * Funkcia na zistenie či je záznam dokončený uplne/ len prvý test alebo vobec este nieje
     *
     * @param ID    the id
     * @param cislo the cislo
     * @return the string
     * @throws FileNotFoundException the file not found exception
     */
    public static String GetInfo(String ID,int cislo) throws FileNotFoundException { // Nájde daný údaj v databáze
        File my = new File ("src/Database/DatabaseZaznamy.txt ");
        Scanner read = new Scanner(my);
        while(read.hasNextLine()){
            String riadok = read.nextLine();
            String[] a = riadok.split(";",10);
            int velkost = a.length;
            if (a[0].equals(ID)){
                if (velkost-1>=cislo){
                    return a[cislo];
                }
                else{
                    return "";
                }
            }
            else{
                continue;
            }



        }
        return null;
    }


    public ArrayList<String> prepni_obrazovku() {
        ArrayList<String> s = new ArrayList<>();
        s.add("/View/Zamestnanci/MechanikView.fxml");
        s.add("CKT-SERVIS MECHANIK");
        return s;
    }
}







