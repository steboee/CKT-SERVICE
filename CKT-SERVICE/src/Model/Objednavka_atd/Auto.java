package Model.Objednavka_atd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The type Auto.
 */
public class Auto {
    /**
     * The Brand.
     * Znacka auta
     */
    public String brand;
    /**
     * The Fuel.
     * palivo auta
     */
    public String fuel;
    /**
     * The Engine.
     */
    public String engine;
    /**
     * The Arr.
     */
    static Auto[] arr;

    /**
     * Instantiates a new Auto.
     *
     * @param Brand  the brand
     * @param Fuel   the fuel
     * @param Engine the engine
     */
    public Auto(String Brand, String Fuel, String Engine){
        this.brand = Brand;
        this.fuel = Fuel;
        this.engine = Engine;
    }

    /**
     * Instantiates a new Auto.
     *Kontstruktor pre nové auto ale s argumentom uź vytovreného auta
     * @param a the a
     */
    public Auto(Auto a){
        this.brand  = a.brand;
        this.engine = a.engine;
        this.fuel = a.fuel;
    }

    /**
     * Instantiates a new Auto.
     */
    public Auto() {

    }

    /**
     * Count cars int.
     *Funkcia ktorá spočíta koľko aút je v databáze firmy a toľko aút vie
     * firma upravovať,
     * @return the int
     */
    public static int count_cars(){
        int a = 0;
        File my = new File ("src/Database/DatabaseOfCars ");
        try (Scanner read = new Scanner(my)) {
            while(read.hasNextLine()){
                a++;
                String b = read.nextLine();
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return a;
    }

    /**
     * Database of cars.
     * Načíta sa databáza všetkých aút ktoré su v databaźe
     */
// Databáza áut,
    public static void DatabaseOfCars() {
        int velkost = count_cars();
        arr = new Auto[velkost];
        int i =0;

        File myObj = new File("src/Database/DatabaseOfCars ");
        Scanner myReader = null;
        try {
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String riadok = " ";
        while (riadok != null){
            int count =0;
            String brand = "";
            String palivo = "";
            String motor = "";
            if (myReader.hasNextLine()){
                riadok = myReader.nextLine();
            }
            else{
                break;
            }

            for (int b=0;b< riadok.length();b++){
                if (riadok.charAt(b) == ';'){
                    count++;
                    continue;
                }
                else if (count == 0){
                    brand = brand + riadok.charAt(b);
                }
                else if (count == 1){
                    palivo = palivo + riadok.charAt(b);
                }
                else if (count == 2){
                    motor = motor + riadok.charAt(b);
                }
            }
            arr[i] = new Auto(brand,palivo,motor);
            i++;
        }
        myReader.close();

    }

    /**
     * Znacka get string.
     *funckia vráti znacku auta (x) v databáze
     * @param x the x
     * @return the string
     */
    public static String znackaGet(int x){
        String a;
        a = arr[x].brand;
        return a;
    }

    /**
     * Motor get string.
     *funckia vráti motor auta (x) v databáze
     * @param x the x
     * @return the string
     */
    public static String motorGet(int x){
        String a;
        a = arr[x].engine;
        return a;
    }

    /**
     * Palivo get string.
     *funckai vráti Palivo auta (x) v databáze
     * @param x the x
     * @return the string
     */
    public static String palivoGet(int x){
        String a;
        a = arr[x].fuel;
        return a;
    }




}
