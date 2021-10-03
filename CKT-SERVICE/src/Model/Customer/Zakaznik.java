package Model.Customer;


import Model.Zamestnanci.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Zakaznik implements Customer {
    private String Username;
    public String Name="";
    public String Surname="";
    public String Password="";
    static Zakaznik[] array = null;

    public Zakaznik() {

    }


    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getUsername() {
        return Username ;
    }

    public String getPassword() {
        return Password;
    }



    public Zakaznik(String NAME,String SURNAME,String USERNAME,String PASSWORD){
        this.Name = NAME;
        this.Surname = SURNAME;
        this.Username = USERNAME;
        this.Password = PASSWORD;
    }

    public Zakaznik(String user, String passw) {
        this.Username = user;
        this.Password = passw;
    }
    public Zakaznik(String NAME,String SURNAME,boolean Logged){
        this.Name = NAME;
        this.Surname = SURNAME;
    }


    public void loaddata() throws FileNotFoundException {
        array = new Zakaznik[50];
        File my = new File ("src/Database/DatabasePeople.txt");
        Scanner read = new Scanner(my);
        int i =0;
        while(read.hasNextLine()){
            String riadok = read.nextLine();
            String Arr[] = riadok.split(";", 5);
            String username= Arr[0];
            String password= Arr[1];
            String meno = Arr[2];
            String priezvisko = Arr[3];
            if (array[i]==null){
                array[i] = new Zakaznik(meno,priezvisko,username,password);
            }
            i++;

        }

    }

    public int zakaznik_save_data(Zakaznik z) throws IOException {
        loaddata();
        FileWriter my = new FileWriter("src\\Database\\DatabasePeople.txt",true);
        for (int i = 0; i< 50;i++){

            if (array[i] == null){
                array[i] = new Zakaznik(z.Name,z.Surname,z.Username,z.Password);
                my.write(z.Username + ";" + z.Password + ";" + z.Name + ";" + z.Surname + ";\n" );
                my.close();
                return 1;


            }
            else{
                String meno1 = array[i].Name;
                String meno2 = z.Name;
                if (meno1.equals(meno2)==true){
                    System.out.println("Uzivatel už existuje!!");
                    return 0;
                }
            }



        }
        return 0;
        //refreshDatabasePeople();

    }





    public static boolean LoginCustomer(Zakaznik z) throws FileNotFoundException {
        File my = new File ("src/Database/DatabasePeople.txt");
        Scanner read = new Scanner(my);
        int i =0;
        while(read.hasNextLine()) {
            String riadok = read.nextLine();
            String Arr[] = riadok.split(";", 5);
            String username = Arr[0];
            String password = Arr[1];
            if (username.equals(z.Username) == true) {
                if (password.equals(z.Password) == true) {
                    return true;
                }
            }
        }
        return false;

    }

    public static String CustomerGetName(String USER,String pass) throws FileNotFoundException {
        File my = new File ("src/Database/DatabasePeople.txt");
        Scanner read = new Scanner(my);
        int i =0;
        while(read.hasNextLine()) {
            String riadok = read.nextLine();
            String Arr[] = riadok.split(";", 5);
            String username = Arr[0];
            String password = Arr[1];
            String meno = Arr[2];
            if (username.equals(USER) == true & password.equals(pass)==true) {
                return Arr[2];
            }
        }
        return "";
    }

    public static String CustomerGetSurname(String USER,String pass) throws FileNotFoundException {
        File my = new File ("src/Database/DatabasePeople.txt");
        Scanner read = new Scanner(my);
        int i =0;
        while(read.hasNextLine()) {
            String riadok = read.nextLine();
            String Arr[] = riadok.split(";", 5);
            String username = Arr[0];
            String password = Arr[1];
            String priezvisko = Arr[3];
            if (username.equals(USER) == true & password.equals(pass)==true) {
                return Arr[3];
            }
        }
        return "";
    }


    public void vypisinfo() throws FileNotFoundException {

    }

    @Override
    public void showlogin(String username) throws IOException {
        Customer.super.showlogin(username);
    }

    @Override
    public void showlogout(String username) throws IOException {
        Customer.super.showlogout(username);
    }
}