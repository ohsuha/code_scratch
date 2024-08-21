package generics.juice;

public class Juice {
    String name;

    private int quantity;

    protected static boolean isEnabled;

    private Juice(){}

    public Juice(String name) {this.name = name + "Juice";}

    public String toString() {return name;}

    public void getJuice() {
        StringBuilder sb = new StringBuilder("name : ");
        sb.append(this.name)
            .append("\nquantity : ").append(quantity)
            .append("\nis enabled : ").append(isEnabled);
        System.out.printf(sb.toString());
    }
}
