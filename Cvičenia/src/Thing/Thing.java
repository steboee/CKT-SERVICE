package Thing;

public class Thing {
    public String name;
    public int Sum;
    public double price;

    public void PrintInfo(){
        System.out.println("We have " + this.Sum + " : " +this.name + " each costs " + this.price);
    }
}
