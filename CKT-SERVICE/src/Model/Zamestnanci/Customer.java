package Model.Zamestnanci;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;

public interface Customer {
    default  void showlogin(String username) throws IOException {
        Time logintime = new Time(System.currentTimeMillis());
        FileWriter a = new FileWriter("src/Database/Log.txt",true);
        a.write(logintime + "-" + "Logged: "+username+"\n");
        a.close();
    }
    default void showlogout(String username) throws IOException {
        Time logouttime = new Time(System.currentTimeMillis());
        FileWriter a = new FileWriter("src/Database/Log.txt",true);
        a.write(logouttime + "-" + "Logout: "+username+"\n");
        a.close();
    }
}
