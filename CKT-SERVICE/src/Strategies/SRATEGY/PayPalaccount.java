package Strategies.SRATEGY;

public class PayPalaccount {
    protected String email;
    protected String password;
    protected String Control_num;




    public PayPalaccount(String email,String heslo, String num){
        this.email = email;
        this.password = heslo;
        this.Control_num = num;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getControl_num() {
        return Control_num;
    }




}
