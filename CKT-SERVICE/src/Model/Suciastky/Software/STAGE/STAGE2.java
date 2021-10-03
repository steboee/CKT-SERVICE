package Model.Suciastky.Software.STAGE;

import Model.Suciastky.Suciastka;

public class STAGE2 extends STAGE {


    public STAGE2(String meno, int cena) {
        super(meno, cena);
    }

    public static Suciastka vytvor(){
        Suciastka s = new STAGE2("STAGE2",500);
        s.setInfo(s.vypisinfo());
        return s;
    }

    @Override
    public String vypisinfo() {
        String info = ("Čip STAGE2 z kategórie STAGE, patrí k najlepším v Európe, zaručúje\n" +
                " kvalitnú úpravu riadiacej jednotky bez toho aby naši zamestnanci museli riadiacu jednotku\n" +
                " ovárať. Je exkluzivitkou VW group ( Čiže značiek ako Škoda, Volkswagen, Seat )." +
                "Cenovka sa pohybuje na úrovni 500 eur. a je určený pre strednú triedu zákazníkov , ktorý\n" +
                " chcú zdvyihnúť výkon svojho auta ale nechchú platiť príliš veľa)");
        return info;
    }
}
