package Strategies.SRATEGY;

import Model.Objednavka_atd.Faktura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static System.Renaming.FakturaPayed;
public class PayByCard implements PayStrategy {
    private static final Map<String, String> Data_Base = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;

    public PayByCard(){

    }




    @Override
    public boolean pay(int paymentAmount, Faktura f) throws IOException {
        if (cardIsPresent()) {
            FakturaPayed(f.getIndex());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void collectPaymentDetails(CreditCard karta) {
        this.card = karta;


    }

    @Override
    public void collectPaymentDetails(PayPalaccount account) {

    }


    private boolean cardIsPresent() {
        return true;
    }

}
