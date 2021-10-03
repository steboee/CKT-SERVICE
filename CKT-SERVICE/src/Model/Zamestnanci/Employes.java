package Model.Zamestnanci;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Employes.
 */
public class Employes implements Mechanic,Electromechanic,Spravca {
    /**
     * The Username.
     */
    String username;
    /**
     * The Password.
     */
    String password;
    /**
     * The Prihlaseny.
     */
    public String prihlaseny;

    /**
     * Instantiates a new Employes.
     */
    public Employes(){

    }

    /**
     * Instantiates a new Employes.
     *
     * @param Username the username
     * @param Password the password
     */
    public Employes(String Username, String Password){
        this.username = Username;
        this.password = Password;
    }

    /**
     * Databáza zamestnancov firmy.
     *
     * @return the array list
     */
    public static ArrayList<Employes> GetDatabaseEmployes(){                // databáza zamestnaneckých prihl. údajov
        ArrayList<Employes> database = new ArrayList<>();
        database.add(new Mechanik("mechanik","m1234"));
        database.add(new Elektromechanik("elektromechanik","e1234"));
        database.add(new SpravcaObjednavok("spravca","s1234"));

        return database;
    }

    /**
     * funkcia na zistenie o aký typ zamesntnaca ide.
     *
     * @return the object
     */
    public Object whatclass(){              // zisti aký zamestnanec sa prihlasuje;

        if (this.username.equals("mechanik") & this.password.equals("m1234")){
            prihlaseny = "mechanik";
            return new Mechanik();
        }
        if (this.username.equals("elektromechanik") & this.password.equals("e1234")){
            prihlaseny = "elektromechanik";
            return new Elektromechanik();
        }
        if ( this.username.equals("spravca") & this.password.equals("s1234") ){
            prihlaseny = "spravca";
            return new SpravcaObjednavok();
        }
        return null;

    }


    /**
     * Funkcia prepni obrazovku sa použiva pro polymorfii kde sa prepne okno na základe toho kto je prijhlásný
     *
     * @return the array list
     */
    public ArrayList<String> prepni_obrazovku(){
        ArrayList<String> s = new ArrayList<>();
        return s;
    }


    @Override
    public void showlogin() throws IOException {
        if (prihlaseny.equals("mechanik")){
            Mechanic.super.showlogin();
        }
        else if (prihlaseny.equals("elektromechanik")){
            Electromechanic.super.showlogin();
        }
        else{
            Spravca.super.showlogin();
        }

    }

    @Override // defalutlne metody z INTERFACE
    public void showlogout() throws IOException {
        if (prihlaseny.equals("mechanik")){
            Mechanic.super.showlogout();
        }
        else if (prihlaseny.equals("elektromechanik")){
            Electromechanic.super.showlogout();
        }
        else{
            Spravca.super.showlogout();
        }
    }
}
