package generics;

import lombok.extern.slf4j.Slf4j;
import generics.Box.FruitBox;
import generics.fruit.Apple;
import generics.fruit.Fruit;
import generics.fruit.Grape;
import generics.juice.Juicer;

@Slf4j
public class GenericsExample {
    FruitBox<Fruit> fruitBox = new FruitBox<>();
    FruitBox<Apple> appleBox = new FruitBox<>();
    FruitBox<Grape> grapeBox = new FruitBox<>();

    public void genericTest() {
        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());

        appleBox.add(new Apple());
        //appleBox.add(new Grape()); //error
        //appleBox.add(new Fruit()); //error

        log.info(Juicer.<Fruit>makeJuice(fruitBox).toString());
        log.info(Juicer.<Apple>makeJuice(appleBox).toString());
    }
}
