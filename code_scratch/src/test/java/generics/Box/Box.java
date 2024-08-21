package generics.Box;

import java.util.ArrayList;

public class Box<T> {
    T item;
    ArrayList<T> list = new ArrayList<>();

    public void add(T item) {
        list.add(item);
    }

    public T get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }
    public ArrayList<T> getList() {
        return list;
    }
    public void setItem(T item) {
        this.item = item;
    }
    public T getItem() {
        return item;
    }
}
