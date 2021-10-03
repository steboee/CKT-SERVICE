package Model.Objednavka_atd;

import Model.Suciastky.Software.EHMC.EHMC;
import Model.Suciastky.Software.STAGE.STAGE;
import Model.Suciastky.Suciastka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static Model.Suciastky.Suciastka.create;
import static System.RegisterAlert.Alertend;
import static System.Renaming.UpdateFile;

/**
 * The type Zaznam vozidla.
 */
public class ZaznamVozidla {
    /**
     * The Car.
     */
    protected Auto car;
    /**
     * The Id.
     */
    protected String Id;
    /**
     * The Model.
     */
    protected String Model;
    /**
     * The Start hp.
     */
    protected String startHP;
    /**
     * The Start kw.
     */
    protected String startKw;
    /**
     * The Start nm.
     */
    protected String startNm;
    /**
     * The Cip.
     */
    protected Suciastka cip;
    /**
     * The End hp.
     */
    protected String endHP;
    /**
     * The End kw.
     */
    protected String endKw;
    /**
     * The End nm.
     */
    protected String endNm;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return Id;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return Model;
    }

    /**
     * Gets start hp.
     *
     * @return the start hp
     */
    public String getStartHP() {
        return startHP;
    }

    /**
     * Gets start kw.
     *
     * @return the start kw
     */
    public String getStartKw() {
        return startKw;
    }

    /**
     * Gets start nm.
     *
     * @return the start nm
     */
    public String getStartNm() {
        return startNm;
    }

    /**
     * Gets cip.
     *
     * @return the cip
     */
    public String getCip() {
        return cip.getMeno();
    }

    /**
     * Getsuciastka suciastka.
     *
     * @return the suciastka
     */
    public Suciastka getsuciastka(){
        return cip;
    }

    /**
     * Gets end hp.
     *
     * @return the end hp
     */
    public String getEndHP() {
        return endHP;
    }

    /**
     * Gets end kw.
     *
     * @return the end kw
     */
    public String getEndKw() {
        return endKw;
    }

    /**
     * Gets end nm.
     *
     * @return the end nm
     */
    public String getEndNm() {
        return endNm;
    }

    /**
     * Get rozdiel kw string.
     *Funkcia vráti rozdiel medzi počitaočným stavom Kw a koncovým
     * @return the string
     */
    public String getRozdielKW(){
        int startkw = Integer.parseInt(this.startKw);
        int endkw = Integer.parseInt(this.endKw);
        int rozdiel = endkw-startkw;
        return String.valueOf(rozdiel);
    }

    /**
     * Get rozdiel hp string.
     *Funkcia vráti rozdiel medzi počitaočným stavom HP a koncovým
     * @return the string
     */
    public String getRozdielHP(){
        int starthp = Integer.parseInt(this.startHP);
        int endhp = Integer.parseInt(this.endHP);
        int rozdiel = endhp-starthp;
        return String.valueOf(rozdiel);
    }

    /**
     * Get rozdiel nm string.
     *Funkcia vráti rozdiel medzi počitaočným stavom NM a koncovým
     * @return the string
     */
    public String getRozdielNM(){
        int startnm = Integer.parseInt(this.startNm);
        int endnm = Integer.parseInt(this.endNm);
        int rozdiel = endnm-startnm;
        return String.valueOf(rozdiel);
    }


    /**
     * Instantiates a new Zaznam vozidla.
     *
     * @param CAR the car
     * @throws IOException the io exception
     */
    public ZaznamVozidla(Auto CAR) throws IOException {
        this.car = CAR;
    }

    /**
     * Instantiates a new Zaznam vozidla.
     *
     * @param Id      the id
     * @param Model   the model
     * @param startKw the start kw
     * @param startHP the start hp
     * @param startNm the start nm
     * @param cip     the cip
     * @param endKW   the end kw
     * @param endHP   the end hp
     * @param endNm   the end nm
     */
    public ZaznamVozidla(String Id,String Model,String startKw,String startHP,String startNm,String cip, String endKW,String endHP,String endNm){
        this.Id = Id;
        this.Model = Model;
        this.startHP = startHP;
        this.startKw = startKw;
        this.startNm = startNm;
        Suciastka CIP = null;
        ArrayList<Suciastka> s = create();
        if (cip.contains("STAGE")){
            int i = 0;
            while(s.get(i).getMeno().equals(cip)==false){
                i++;
            }

            CIP = s.get(i);
        }
        else if (cip.contains("EHMC")){
            int i = 0;
            while(s.get(i).getMeno().equals(cip)==false){
                i++;
            }
            CIP = s.get(i);
        }
        this.cip = CIP;
        this.endHP = endHP;
        this.endKw = endKW;
        this.endNm = endNm;
    }

    /**
     * Instantiates a new Zaznam vozidla.
     *
     * @param Id      the id
     * @param Model   the model
     * @param startHP the start hp
     * @param startKw the start kw
     * @param startNm the start nm
     */
    public ZaznamVozidla(String Id,String Model,String startHP,String startKw,String startNm){
        this.Model = Model;
        this.Id =Id;
        this.startHP = startHP;
        this.startKw = startKw;
        this.startNm = startNm;
    }

    /**
     * Loadcip.
     *Funkcia načíta čip k danému záznamu podĺa databázy
     * @throws FileNotFoundException the file not found exception
     */
    public void loadcip() throws FileNotFoundException {
        File my = new File("src/Database/DatabaseZaznamy.txt");
        Scanner read = new Scanner(my);
        String riadok = "";
        while (read.hasNextLine() == true) {
            riadok = read.nextLine();
            String[] s;
            s = riadok.split(";");
            if (this.Id.equals(s[0])){
                if (s[5].contains("STAGE")){
                    STAGE a = new STAGE();
                    a.setMeno(s[5]);
                    this.cip = a;
                }
                else{
                    EHMC a = new EHMC();
                    a.setMeno(s[5]);
                    this.cip = a;
                }
            }
        }
    }


    /**
     * Uloz data int.
     *Funkcia uloží dáta o záznem vozidla do databázy
     * @return the int
     * @throws IOException the io exception
     */
    public int UlozData() throws IOException {
        if (this.Id.length()==0 || this.startHP.length()==0||this.startKw.length()==0||this.startNm.length()==0||this.Model.length()==0){
            return 0;
        }
        else{
            FileWriter my = new FileWriter("src\\Database\\DatabaseZaznamy.txt",true);
            my.write(this.Id +";"+this.Model+";"+this.startKw+";"+this.startHP+";"+this.startNm+";\n" );
            my.close();
            return 1;
        }

    }

    /**
     * Update int.
     *Funkcia Aktualizuje údaje z databázy
     * @return the int
     * @throws IOException the io exception
     */
    public int Update() throws IOException {
        File my = new File("src/Database/DatabaseOfOrders.txt");
        Scanner read = new Scanner(my);
        String riadok = "";
        int pocitadlo=0;
        while (read.hasNextLine() == true) {
            riadok = read.nextLine();
            String[] s;
            s = riadok.split(";",9);
            if (s[5] == ""){
                return -1;
            }

        }
        if (Alertend(this.endHP,this.endKw,this.endNm)==1){
            return 0;
        }
        else{
            UpdateFile(Id,this.endKw,this.endHP,this.endNm);
            return 1;
        }
    }

}
