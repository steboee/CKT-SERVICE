package Model.Suciastky.Software.STAGE;

import Model.Suciastky.Suciastka;

public class STAGE extends Suciastka {


    public STAGE(String meno, int cena) {
        super(meno,cena);
    }

    public STAGE(String cip) {
        super(cip);
    }

    public STAGE() {
        super();
    }



    public String Getmeno(){
        return this.getMeno();
    }

    public int Getcena(){
        return this.getCena();
    }



    @Override
    public String vypisinfo() {
        return null;
    }

    @Override
    public int znacka(String znacka) {
        return 0;
    }

}
