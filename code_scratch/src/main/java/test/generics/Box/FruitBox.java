package test.generics.Box;

import test.generics.Eatable;
import test.generics.fruit.Fruit;

public class FruitBox<T extends Fruit & Eatable> extends Box<T>{
}
