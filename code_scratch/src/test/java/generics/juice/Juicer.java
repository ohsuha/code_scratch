package generics.juice;

import generics.Box.FruitBox;
import generics.fruit.Fruit;

public class Juicer {
    public static <T extends Fruit> Juice makeJuice(FruitBox<T> box) {
        String tmp = "";

        for (Fruit f : box.getList()){
            tmp += f + " ";
        }
        return new Juice(tmp);
    }
}
