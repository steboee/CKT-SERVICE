package Model.Suciastky.Software.STAGE;

import Model.Suciastky.Suciastka;

public class STAGE1 extends STAGE {

    public STAGE1(String meno,int cena) {
        super(meno,cena);
    }

    public static Suciastka vytvor(){
        Suciastka s = new STAGE1("STAGE1",200);
        s.setInfo(s.vypisinfo());

        return s;
    }



    @Override
    public String vypisinfo() {
        String info = ("Čip STAGE1 z kategórie STAGE, patrí k najlepším v Európe\n" +
                ", zaručúje kvalitnú úpravu riadiacej jednotky bez toho aby" +
                " naši zamestnanci museli riadiacu jednotku ovárať. Je \n" +
                "exkluzivitkou VW group ( Čiže značiek ako Škoda, Volkswagen,\n" +
                " Seat). Cenovka sa pohybuje na úrovni 200 eur. a je určený pre \n" +
                "najnižšiu triedu zákazníkov , ktorý si chcú vylepšiť výkon svojho auta za čo najmensšiu sumu)");
        return info;

    }



}
