package Model.Objednavka_atd;

import Model.Suciastky.Suciastka;

import java.io.FileWriter;
import java.io.IOException;

/**
 * The type Faktura.
 * Faktura
 */
public class Faktura {

    /**
     * The Index.
     */
    protected String Index;
    /**
     * The Uprava.
     */
    protected String Uprava;
    /**
     * The Cena.
     */
    protected int Cena;
    /**
     * The Variabilna.
     */
    protected double variabilna;
    /**
     * The Zaplatena.
     */
    protected boolean Zaplatena = false;


    /**
     * Gets variabilna.
     *
     * @return the variabilna
     */
    public double getVariabilna() {
        return variabilna;
    }

    /**
     * Is zaplatena boolean.
     *
     * @return the boolean
     */
    public boolean isZaplatena() {
        return Zaplatena;
    }


    /**
     * Instantiates a new Faktura.
     *Konštruktor pre Fakturu aj s úpravou
     * @param index  the index
     * @param uprava the uprava
     */
    public Faktura(String index, String uprava) {
        this.Index = index;
        this.Uprava = uprava;
    }

    /**
     * Instantiates a new Faktura.
     *
     * @param index the index
     */
    public Faktura(String index) {
        this.Index = index;
    }

    /**
     * Instantiates a new Faktura.
     *
     * @param index     the index
     * @param zaplatena the zaplatena
     */
    public Faktura(String index,boolean zaplatena){
        this.Index = index;
        this.Zaplatena = zaplatena;
    }

    /**
     * Instantiates a new Faktura.
     *
     * @param index     the index
     * @param info      the info
     * @param cena      the cena
     * @param zaplatena the zaplatena
     */
    public Faktura(String index, String info, int cena, boolean zaplatena) {
        this.Index = index;
        this.Uprava = info;
        this.Cena = cena;
        this.Zaplatena = zaplatena;
    }

    /**
     * Gets uprava.
     *
     * @return the uprava
     */
    public String getUprava() {
        return Uprava;
    }

    /**
     * Gets cena.
     *
     * @return the cena
     */
    public int getCena() {
        return Cena;
    }

    /**
     * Gets index.
     *
     * @return the index
     */
    public String getIndex() {
        return Index;
    }


    /**
     * Instantiates a new Faktura.
     *
     * @param index  the index
     * @param uprava the uprava
     * @param cena   the cena
     */
    public Faktura(String index, String uprava, int cena){
        this.Index = index;
        this.Uprava = uprava;
        this.Cena = cena;
    }

    /**
     * Nastav cenu double.
     *Funkcia ktorá nastavuje cenu Faktúry pre danú objednávku ..
     * nastaví cenu podľa Čipu v aute a aj variabilnej zložky ceny
     * @param o the o
     * @return the double
     */
    public double NastavCenu(Objednavka o){
        int endNM = Integer.parseInt(o.getZaznam().endNm);
        int endKW = Integer.parseInt(o.getZaznam().endKw);
        int endHP = Integer.parseInt(o.getZaznam().endHP);
        int startNM = Integer.parseInt(o.getZaznam().startNm);
        int startKW = Integer.parseInt(o.getZaznam().startKw);
        int startHP = Integer.parseInt(o.getZaznam().startHP);
        int rozdielKW = endKW - startKW;
        int rozdielHP = endHP - startHP;
        int rozdielNM = endNM - startNM;
        Suciastka a = o.getZaznam().cip;
        int price = a.getCena();
        double variabilna = (rozdielKW+rozdielNM+rozdielHP)*0.5;
        Cena = price + (int) variabilna;
        return variabilna;
    }

    /**
     * Zvys cenu.
     * Zvyśi cenu faktúry o 50 eur
     */
    public void ZvysCenu(){
        this.Cena = this.Cena + 50;
    }

    /**
     * Uloz fakturu.
     *Funkcia ktorá ukladá údaje o fakt=ure do databázy
     * @throws IOException the io exception
     */
    public void UlozFakturu() throws IOException {
        FileWriter my = new FileWriter("src\\Database\\DatabaseFaktury.txt",true);
        my.write(this.Index+";"+this.Uprava+";"+this.Cena+";\n" );
        my.close();
    }


    /**
     * Variabilna double.
     *funkcia vypočíta variabilnú cenu faktúry
     * @param o the o
     * @return the double
     */
    public static double variabilna(Objednavka o){
        int endNM = Integer.parseInt(o.getZaznam().endNm);
        int endKW = Integer.parseInt(o.getZaznam().endKw);
        int endHP = Integer.parseInt(o.getZaznam().endHP);
        int startNM = Integer.parseInt(o.getZaznam().startNm);
        int startKW = Integer.parseInt(o.getZaznam().startKw);
        int startHP = Integer.parseInt(o.getZaznam().startHP);
        int rozdielKW = endKW - startKW;
        int rozdielHP = endHP - startHP;
        int rozdielNM = endNM - startNM;
        double variabilnacena = (rozdielKW+rozdielNM+rozdielHP)*0.5;
        return variabilnacena;
    }

}
