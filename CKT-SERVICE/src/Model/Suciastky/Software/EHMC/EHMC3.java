package Model.Suciastky.Software.EHMC;

import Model.Suciastky.Suciastka;

public class EHMC3 extends EHMC {


    public EHMC3(String meno, int cena) {
        super(meno, cena);
    }

    public static Suciastka vytvor(){
        Suciastka s = new EHMC3("EHMC3",1000);
        return s;
    }
    public String vypisinfo(){
        String a = "Cip EHMC3 z kategorie EHMC cipov, je všeobecný čip určený pre\n" +
                "pre všetky značky aút okrem VW group, Čip je veľmi kvalitný, pri práci \n" +
                "sa vôbec nezasahuje do riadicaej jednotky. Cena sa pohybuje na úrovni 1000 eur.\n" +
                "Je urceny pre zakaznika ktory si chce vylepsit vykon svojho auta na co najvyssiu uroven\n" +
                " a na cene mu až tak nezáleží";
        return a;
    }
}
