package Model.Suciastky.Software.STAGE;

import Model.Suciastky.Suciastka;

public class STAGE3 extends STAGE {


    public STAGE3(String meno, int cena) {
        super(meno, cena);
    }

    public static Suciastka vytvor(){
        Suciastka s = new STAGE3("STAGE3",1000);
        s.setInfo(s.vypisinfo());
        return s;
    }

    @Override
    public String vypisinfo() {
        String info = ("Čip STAGE3 z kategórie STAGE, patrí k najlepším v Európe, zaručúje\n" +
                " kvalitnú úpravu riadiacej jednotky bez toho aby naši zamestnanci museli riadiacu\n" +
                " jednotku ovárať. Je exkluzivitkou VW group ( Čiže značiek ako Škoda, Volkswagen, Seat)." +
                "Cenovka sa pohybuje na úrovni 1000 eur. a je určený pre vyššiu triedu zákazníkov , ktorý \n" +
                "si chcú vylepšiť výkon svojho auta na maximum)");
        return info;

    }
}
