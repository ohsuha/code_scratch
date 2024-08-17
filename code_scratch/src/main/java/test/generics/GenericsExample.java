package test.generics;

import lombok.extern.slf4j.Slf4j;
import test.generics.Box.FruitBox;
import test.generics.fruit.Apple;
import test.generics.fruit.Fruit;
import test.generics.fruit.Grape;
import test.generics.juice.Juicer;

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
