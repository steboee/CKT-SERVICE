package Model.Zamestnanci;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;

public interface Mechanic {

    default void showlogin() throws IOException {
        Time logintime = new Time(System.currentTimeMillis());
        FileWriter a = new FileWriter("src\\Database\\Log.txt",true);
        a.write(logintime + "-" + "Logged: MECHANIK\n");
        a.close();
    }
    default void showlogout() throws IOException {
        Time logouttime = new Time(System.currentTimeMillis());
        FileWriter b = new FileWriter("src\\Database\\Log.txt", true);
        b.write(logouttime + "-" + "Logout: MECHANIK\n");
        b.close();
    }

}
