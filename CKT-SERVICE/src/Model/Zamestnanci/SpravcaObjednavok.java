package Model.Zamestnanci;

import Model.Objednavka_atd.Faktura;
import Model.Objednavka_atd.Objednavka;

import java.io.IOException;
import java.util.ArrayList;

import static Model.Objednavka_atd.Objednavka.*;
import static System.Renaming.DeleteZaznam;


/**
 * The type Spravca objednavok.
 */
public class SpravcaObjednavok extends Employes {

    /**
     * Instantiates a new Spravca objednavok.
     *
     * @param Username the username
     * @param Password the password
     */
    public SpravcaObjednavok(String Username, String Password) {
        super(Username, Password);
    }

    /**
     * Instantiates a new Spravca objednavok.
     */
    public SpravcaObjednavok() {

    }


    public ArrayList<String> prepni_obrazovku() {
        ArrayList<String> s = new ArrayList<>();
        s.add("/View/Zamestnanci/SpravcaObjednavokView.fxml");
        s.add("CKT-SERVIS SPRAVCA OBJEDNAVOK");
        return s;
    }


    /**
     * Funkcia vytvorí faktúru a následne ju prradi objednávke podla ID
     *
     * @param Index the index
     * @throws IOException the io exception
     */
// vytvorý faktúru a priradí ju k danej obejdnavke
    public static void VytvorFakturu(String Index) throws IOException {
        ArrayList<Objednavka> o;
        Faktura f = new Faktura(Index);
        o = setFaktura(f);
        Objednavka s = FindObjednavka(o,Integer.parseInt(Index));
        f.NastavCenu(s);
        f.UlozFakturu();


    }

    /**
     * Funkcia vymeže záznam o vozidle
     *
     * @param index the index
     * @throws IOException the io exception
     */
    public static void VymazatZaznam_vozidla(String index) throws IOException {
        DeleteZaznam(index);
    }

}
