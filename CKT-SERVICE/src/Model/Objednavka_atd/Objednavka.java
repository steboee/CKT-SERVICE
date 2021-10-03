package Model.Objednavka_atd;


import Model.Builder.Director;
import Model.Customer.Zakaznik;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * The type Objednavka.
 */
public class Objednavka{
    private int index;
    private Zakaznik zakaznik = null;
    private Auto auto = null;
    private String Cena_strop = null;
    private Faktura faktura = null;
    private ZaznamVozidla zaznam = null;



    private boolean Aktualizacia;
    private boolean StartStop;

    private Objednavka(ObjednavkaBuilder builder) {
        this.index = builder.index;
        this.zakaznik = builder.zakaznik;
        this.auto = builder.auto;
        this.faktura = builder.faktura;
        this.zaznam = builder.zaznam;
        this.Aktualizacia = builder.Aktualizacia;
        this.StartStop = builder.StartStop;
        this.Cena_strop = builder.Cena_strop;
    }


    /**
     * The type Objednavka builder.
     * BUILDER PATTER pre objednávku
     */
    public static class ObjednavkaBuilder
    {
        private int index;
        private Zakaznik zakaznik;
        private Auto auto;
        private String Cena_strop;
        private Faktura faktura;
        private ZaznamVozidla zaznam;
        private boolean Aktualizacia;
        private boolean StartStop;

        /**
         * Instantiates a new Objednavka builder.
         *
         * @param index the index
         */
        public ObjednavkaBuilder(int index) {
            this.index = index;
        }

        /**
         * Zakaznik objednavka builder.
         *
         * @param zakaznik the zakaznik
         * @return the objednavka builder
         */
        public ObjednavkaBuilder zakaznik(Zakaznik zakaznik) {
            this.zakaznik = zakaznik;
            return this;
        }

        /**
         * Auto objednavka builder.
         *
         * @param car the car
         * @return the objednavka builder
         */
        public ObjednavkaBuilder auto(Auto car) {
            this.auto = car;
            return this;
        }

        /**
         * Faktura objednavka builder.
         *
         * @param f the f
         * @return the objednavka builder
         */
        public ObjednavkaBuilder faktura(Faktura f) {
            this.faktura = f;
            return this;
        }

        /**
         * Zaznam objednavka builder.
         *
         * @param z the z
         * @return the objednavka builder
         */
        public ObjednavkaBuilder zaznam(ZaznamVozidla z) {
            this.zaznam = z;
            return this;
        }

        /**
         * Cena strop objednavka builder.
         *
         * @param Cena the cena
         * @return the objednavka builder
         */
        public ObjednavkaBuilder Cena_strop(String Cena){
            this.Cena_strop = Cena;
            return this;
        }

        /**
         * Aktualizacia objednavka builder.
         *
         * @param A the a
         * @return the objednavka builder
         */
        public ObjednavkaBuilder Aktualizacia(boolean A){
            this.Aktualizacia = A;
            return this;
        }

        /**
         * Start stop objednavka builder.
         *
         * @param A the a
         * @return the objednavka builder
         */
        public ObjednavkaBuilder StartStop(boolean A){
            this.StartStop = A;
            return this;
        }

        /**
         * Objednavka objednavka builder.
         *
         * @param o the o
         * @param i the
         * @return the objednavka builder
         */
        public ObjednavkaBuilder objednavka (Objednavka o,int i){
            if (i == 1){
                this.index = o.getIndex();
                this.auto = o.getAuto();
                this.zakaznik = o.getZakaznik();
                this.Cena_strop = o.getCena_strop();
                return this;
            }
            return this;

        }


        /**
         * Build objednavka.
         *
         * @return the objednavka
         */
        public Objednavka build() {
            Objednavka objednavka = new Objednavka(this);
            return objednavka;
        }
    }


    /**
     * Is aktualizacia boolean.
     *
     * @return the boolean
     */
    public boolean isAktualizacia() {
        return Aktualizacia;
    }

    /**
     * Is start stop boolean.
     *
     * @return the boolean
     */
    public boolean isStartStop() {
        return StartStop;
    }

    /**
     * Gets index.
     *
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Gets zakaznik.
     *
     * @return the zakaznik
     */
    public Zakaznik getZakaznik() {
        return zakaznik;
    }

    /**
     * Gets auto.
     *
     * @return the auto
     */
    public Auto getAuto() {
        return auto;
    }

    /**
     * Gets cena strop.
     *
     * @return the cena strop
     */
    public String getCena_strop() {
        return Cena_strop;
    }

    /**
     * Gets faktura.
     *
     * @return the faktura
     */
    public Faktura getFaktura() {
        return faktura;
    }

    /**
     * Gets zaznam.
     *
     * @return the zaznam
     */
    public ZaznamVozidla getZaznam() {
        return zaznam;
    }

    /**
     * Get o objednavka [ ].
     *
     * @return the objednavka [ ]
     */
    public static Objednavka[] getO() {
        return o;
    }


    /**
     * The constant o.
     */
    public static Objednavka[] o = new Objednavka[50];

    /**
     * Instantiates a new Objednavka.
     */
    public Objednavka(){

    }

    /**
     * Instantiates a new Objednavka.
     *
     * @param Brand      the brand
     * @param Fuel       the fuel
     * @param Engine     the engine
     * @param Index      the index
     * @param ZAKAZNIK   the zakaznik
     * @param Cena_strop the cena strop
     * @throws IOException the io exception
     */
    public Objednavka(String Brand, String Fuel, String Engine,String Index,Zakaznik ZAKAZNIK,String Cena_strop) throws IOException {
        Auto a = new Auto(Brand,Fuel,Engine);
        this.auto = a;
        this.zakaznik = ZAKAZNIK;
        this.Cena_strop = Cena_strop;
        this.index = Integer.parseInt(Index);

    }

    /**
     * Nacitaj array list.
     *Funkcia Nacitaj , Načíta všetky objednávku z databáz, ku každej objednávke prislúcha
     * aj Faktúra a Zázanm o vozidle
     * @return the array list
     * @throws FileNotFoundException the file not found exception
     */
    public static ArrayList<Objednavka> Nacitaj() throws FileNotFoundException {
        ArrayList<Objednavka> o = new ArrayList<Objednavka>(50);
        File my = new File("src/Database/DatabaseOfOrders.txt");
        Scanner read = new Scanner(my);
        String riadok = "";
        Director dir = new Director();
        int i = 0;
        while (read.hasNextLine() == true) {


            riadok = read.nextLine();
            String[] s;
            s = riadok.split(";",10);

            ObjednavkaBuilder ob = new ObjednavkaBuilder(Integer.parseInt(s[0]));
            Objednavka objednavka = dir.constructObjednavka_file(ob,s);

            o.add(i,objednavka);
            i++;

        }
        File my2 = new File("src/Database/DatabaseZaznamy.txt");
        Scanner read2 = new Scanner(my2);
        String riadok2 = "";

        while(read2.hasNextLine()==true){
            i =0;
            riadok2 = read2.nextLine();
            String[] s2 = riadok2.split(";",10);
            while (o.get(i).index != Integer.parseInt(s2[0])){
                i++;

            }
            int dlzka = s2.length;
            if (dlzka == 6){
                o.get(i).zaznam =  new ZaznamVozidla(s2[0],s2[1],s2[2],s2[3],s2[4]);
            }
            else if (dlzka ==10){
                o.get(i).zaznam = new ZaznamVozidla(s2[0],s2[1],s2[2],s2[3],s2[4],s2[5],s2[6],s2[7],s2[8]);
            }


        }
        File my3 = new File("src/Database/DatabaseFaktury.txt");
        Scanner read3 = new Scanner(my3);
        String riadok3 = "";
        i =0;
        while(read3.hasNextLine() == true){
            riadok3 = read3.nextLine();
            if (riadok3.length() <= 1){
                break;
            }
            String []s3 = riadok3.split(";",5);
            while((o.get(i).index) != Integer.parseInt(s3[0])){
                i++;
            }
            boolean zaplatena;
            if (s3[3].equals("ZAPLATENA")){
                zaplatena = true;
            }
            else{
                zaplatena = false;
            }
            o.get(i).faktura = new Faktura(s3[0],s3[1],Integer.parseInt(s3[2]),zaplatena);
        }

        return o;
    }

    /**
     * Generate index int.
     *Vygeneruje index objednávky
     * @return the int
     */
    public static int generate_index(){
        Random random_number = new Random();
        int x = random_number.nextInt(899999) + 100000;
        return x;
    }


    /**
     * Save data.
     *Funkcia uloží dáta o objendávke do databázy
     * @param o the o
     * @throws IOException the io exception
     */
    public static void save_data(Objednavka o) throws IOException {
        FileWriter my = new FileWriter("src\\Database\\DatabaseOfOrders.txt",true);
        my.write(o.getIndex() + ";" + o.getZakaznik().Name + ";" + o.getZakaznik().Surname+ ";" + o.getAuto().brand + ";" + o.getAuto().fuel + ";" + o.getAuto().engine + ";"+ o.getCena_strop() + ";" + o.isStartStop() +";" + o.isAktualizacia() + ";\n" );
        my.close();
        Nacitaj();
    }


    /**
     * Sets faktura.
     *Funkcia priradú fakturu danej objednávke podľa ID Čísla
     * @param faktura the faktura
     * @return the faktura
     * @throws FileNotFoundException the file not found exception
     */
    public static ArrayList<Objednavka> setFaktura(Faktura faktura) throws FileNotFoundException {
        ArrayList<Objednavka> o = Nacitaj();
        for (int i = 0; i<50;i++){
            if (o.get(i).index == Integer.parseInt(faktura.Index)){
                o.get(i).faktura = faktura;
                return o;
            }
        }
        return o;
    }

    /**
     * Sets zaznam.
     *Funckia priradí zaznam Objednávke podľa ID čísla
     * @param z the z
     * @return the zaznam
     * @throws FileNotFoundException the file not found exception
     */
    public static ArrayList<Objednavka> setZaznam(ZaznamVozidla z) throws FileNotFoundException {
        ArrayList<Objednavka> o =  Nacitaj();
        for (int i = 0; i<50;i++){
            if (o.get(i).index == Integer.parseInt(z.Id)){
                o.get(i).zaznam = z;
                return o;
            }
        }
        return o;
    }

    /**
     * Find objednavka objednavka.
     *Funckia vráti objednávku podľa indexu
     * @param o     the o
     * @param index the index
     * @return the objednavka
     */
    public static Objednavka FindObjednavka(ArrayList<Objednavka>o,int index){
        int i =0;
        while(index != o.get(i).index){
            i++;
        }
        return o.get(i);

    }


    /**
     * Set text.
     *Funkcia ktorá vypisuje údaje o objednávke
     * @param Display the display
     * @param o       the o
     * @throws FileNotFoundException the file not found exception
     */
    public static void SetText(TextArea Display, Objednavka o) throws FileNotFoundException {

        Display.setText("ID : "+ o.index +
                "\nMeno : "+ o.zakaznik.Name +
                "\nPriezvisko : "+o.zakaznik.Surname +
                "\nZnačka auta : "+o.auto.brand+
                "\nTyp paliva : "+o.auto.fuel+
                "\nTyp motora : "+o.auto.engine+
                "\nCena Strop: "+o.Cena_strop);

        Display.setEditable(false);

    }



}
