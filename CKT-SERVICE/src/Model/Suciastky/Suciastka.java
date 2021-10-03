package Model.Suciastky;

import Model.Suciastky.Software.EHMC.EHMC1;
import Model.Suciastky.Software.EHMC.EHMC2;
import Model.Suciastky.Software.EHMC.EHMC3;
import Model.Suciastky.Software.STAGE.STAGE1;
import Model.Suciastky.Software.STAGE.STAGE2;
import Model.Suciastky.Software.STAGE.STAGE3;

import java.util.ArrayList;

public abstract class Suciastka {
    String meno;
    int cena;
    String info;



    public Suciastka(String meno,String info,int cena){
        this.meno = meno;
        this.cena = cena;
        this.info = info;
    }


    public Suciastka() {

    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }


    public Suciastka(String cip) {
        this.meno = cip;
    }

    public String getMeno() {
        return meno;
    }

    public int getCena() {
        return cena;
    }

    public void setInfo(String info){
        this.info = info;
    }




    public static ArrayList<Suciastka> list = new ArrayList<Suciastka>();


    public Suciastka(String meno, int cena){
        this.meno = meno;
        this.cena = cena;
    }


    public void VypisCenu(){
        System.out.println(meno + " " + cena +"");
        vypisinfo();
    }

    public abstract String vypisinfo();

    public abstract int znacka(String znacka);


    public static ArrayList<Suciastka> create(){
        list.add(STAGE1.vytvor());
        list.add(STAGE2.vytvor());
        list.add(STAGE3.vytvor());
        list.add(EHMC1.vytvor());
        list.add(EHMC2.vytvor());
        list.add(EHMC3.vytvor());
        return list;
    }
}
