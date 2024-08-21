package generics.Box;

import generics.Eatable;
import generics.fruit.Fruit;

public class FruitBox<T extends Fruit & Eatable> extends Box<T>{
}
