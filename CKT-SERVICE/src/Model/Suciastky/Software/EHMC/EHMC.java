package Model.Suciastky.Software.EHMC;

import Model.Suciastky.Suciastka;

public class EHMC extends Suciastka {
    public EHMC(String meno, int cena) {
        super(meno, cena);
    }

    public EHMC(String cip) {
        super(cip);
    }

    public EHMC() {
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
        return 100;
    }






}
