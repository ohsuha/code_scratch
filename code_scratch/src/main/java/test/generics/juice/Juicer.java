package test.generics.juice;

import test.generics.Box.FruitBox;
import test.generics.fruit.Fruit;

public class Juicer {
    public static <T extends Fruit> Juice makeJuice(FruitBox<T> box) {
        String tmp = "";

        for (Fruit f : box.getList()){
            tmp += f + " ";
        }
        return new Juice(tmp);
    }
}
