package collection.collections;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack extends Vector {
	public Object push(Object o) {
		addElement(o);
		return o;
	}

	public Object pop() {
		Object o = peek();
		removeElementAt(size() - 1);
		return o;
	}

	public Object peek() {
		int len = size();
		if(len == 0)
			throw new EmptyStackException();

		return elementAt(len - 1);
	}

	public boolean empty() {
		return size() == 0;
	}

	public int search(Object o) {
		int i = lastIndexOf(o);//끝에서부터 객체를 찾는다.

		if(i >= 0) {
			return size() - i; // 맨위에 저장된 객체의 인덱스를 1로 정의하므로
		}

		return -1; //못찾으면 -1
	}
}
