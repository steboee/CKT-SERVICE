package Strategies.SRATEGY;

import Model.Objednavka_atd.Faktura;

import java.io.IOException;

public interface PayStrategy {

    boolean pay(int paymentAmount, Faktura f) throws IOException;
    void collectPaymentDetails(CreditCard karta);
    void collectPaymentDetails(PayPalaccount account);
}
