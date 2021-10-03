package Model.Customer;

import java.io.FileNotFoundException;

public class LoggedUser extends Zakaznik{
    private static String logged[];

    public LoggedUser(String username, String password) {
        super(username,password);
        logged = new String [2];
        logged[0] = username;
        logged[1] = password;
    }

    public static String getname() throws FileNotFoundException {  //ziskanie mena prihlaseného uživateľa
        return CustomerGetName(logged[0],logged[1]);
    }
    public static String getsurname() throws FileNotFoundException { // ziskanie hesla prihláseného uživateĽa
        return CustomerGetSurname(logged[0],logged[1]);
    }

    @Override
    public void vypisinfo() throws FileNotFoundException {
        //System.out.println("Meno "+ CustomerGetName(logged[0],logged[1]));
    }
}
