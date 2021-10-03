package Model.Builder;

import Model.Objednavka_atd.Auto;
import Model.Customer.Zakaznik;
import Model.Objednavka_atd.Objednavka;

/**
 * The type Director.
 */
public class Director {

    /**
     * Director zkonštruuje objednávku ktorá bola vybratá z txt súboru.
     *
     * @param builder the builder
     * @param s       the s
     * @return the objednavka
     */
    public Objednavka constructObjednavka_file(Objednavka.ObjednavkaBuilder builder, String[] s) {
        Objednavka.ObjednavkaBuilder ob = new Objednavka.ObjednavkaBuilder(Integer.parseInt(s[0]));
        ob.zakaznik(new Zakaznik(s[1],s[2],true));
        ob.auto(new Auto(s[3],s[4],s[5]));
        ob.Cena_strop(s[6]);
        if (s[7].equals("true")){
            ob.StartStop(true);
        }
        if (s[8].equals("true")){
            ob.Aktualizacia(true);
        }

        Objednavka objednavka  = ob.build();
        return objednavka;
    }

    /**
     * Director skontrštruuje objenávku na základe info z GUI
     *
     * @param objednavka   the objednavka
     * @param Name         the name
     * @param Surname      the surname
     * @param Znacka       the znacka
     * @param Palivo       the palivo
     * @param Motor        the motor
     * @param Strop_cena   the strop cena
     * @param aktualizacia the aktualizacia
     * @param startstop    the startstop
     * @return the objednavka
     */
    public Objednavka constructObjednavka(Objednavka.ObjednavkaBuilder objednavka,String Name, String Surname,String Znacka,String Palivo, String Motor,String Strop_cena,boolean aktualizacia,boolean startstop){
        objednavka.auto(new Auto(Znacka,Palivo,Motor));
        objednavka.faktura(null);
        objednavka.zaznam(null);
        objednavka.zakaznik(new Zakaznik(Name,Surname,true));
        objednavka.Cena_strop(Strop_cena);
        objednavka.Aktualizacia(aktualizacia);
        objednavka.StartStop(startstop);
        Objednavka real = objednavka.build();
        return real;

    }

}
