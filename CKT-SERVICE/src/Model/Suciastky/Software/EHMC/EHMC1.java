package Model.Suciastky.Software.EHMC;

import Model.Suciastky.Suciastka;

public class EHMC1 extends EHMC {


    public EHMC1(String meno, int cena) {
        super(meno, cena);
    }

    public static Suciastka vytvor(){
        Suciastka s = new EHMC1("EHMC1",350);
        return s;
    }
    @Override
    public String vypisinfo() {
       String a = "Čip EHMC1 z kategórie EHMC čipov, je všeobecný čip určený pre\n" +
               "pre všetky značky aút okrem VW group, Čip je veľmi kvalitný, pri práci \n" +
               "sa vôbec nezasahuje do riadicaej jednotky. Cena sa pohybuje na úrovni 350 eur.\n" +
               "Je určený pre zákazníkov ktorý si chcú vylepšiť výkon svojho auta bez zbytočne \n" +
               "veľkej investície";
       return a;
    }
}
