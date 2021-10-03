package Model.Suciastky.Software.EHMC;

import Model.Suciastky.Suciastka;

public class EHMC2 extends EHMC{

    public EHMC2(String meno, int cena) {
        super(meno, cena);
    }

    public static Suciastka vytvor(){
        Suciastka s = new EHMC2("EHMC2",600);
        return s;
    }
    @Override
    public String vypisinfo() {
        String a = "Čip EHMC2 z kategórie EHMC čipov, je všeobecný čip určený pre\n" +
                "pre všetky značky aút okrem VW group, Čip je veľmi kvalitný, pri práci \n" +
                "sa vôbec nezasahuje do riadicaej jednotky. Cena sa pohybuje na úrovni 600 eur.\n" +
                "Je určený pre zákazníkov ktorý si chcú celkom poriadne vylepšiť výkon svojho \n" +
                "auta ale za rozumnú sumu";
        return a;
    }

}
