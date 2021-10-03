package Main;
import Thing.Thing;


public class Main {
    public static void main(String[] args) {

        Thing firsthing = new Thing();

        firsthing.name = "Blablabal";
        firsthing.Sum = 10;
        firsthing.price = 399.01;

        firsthing.PrintInfo();
        if (firsthing.Sum > 100){
            System.out.println("We have too many of" + firsthing.name);
        }
        else{
            System.out.println("The count of "+ firsthing.name+" is ok");
        }

    }
}
