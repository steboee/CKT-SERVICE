package Strategies.SRATEGY;

import Model.Objednavka_atd.Faktura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static System.Renaming.FakturaPayed;

public class PayByPayPal implements PayStrategy{
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private String controlnum;
    private boolean signedIn;

    static {
        DATA_BASE.put("kovalcik", "kovalcik@gmail.com");
        DATA_BASE.put("ctibor", "ctibor@gmail.com");
        DATA_BASE.put("123456789","janpalko@gmail.com");
    }


    @Override
    public void collectPaymentDetails(PayPalaccount account) {
        this.email = account.getEmail();
        this.password = account.getPassword();
        this.controlnum = account.getControl_num();
        if (verify()){

        }
    }

    private boolean verify() {
        setSignedIn(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }


    @Override
    public boolean pay(int paymentAmount, Faktura f) throws IOException {
        if (signedIn) {
            System.out.println("Paying " + paymentAmount + " using PayPal.");
            FakturaPayed(f.getIndex());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void collectPaymentDetails(CreditCard karta) {

    }


    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}
