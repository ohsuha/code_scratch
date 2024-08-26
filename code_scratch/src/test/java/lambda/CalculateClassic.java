package lambda;

import org.junit.jupiter.api.Test;

public class CalculateClassic{

    @Test
    public void test() {
        Calculate calculate = new Calculate() {
            //익명 클래스를 사용해서 interface 의 메소드를 구현
            @Override
            public int operation(int a, int b) {
                return a+b;
            }
        };

        //람다를 이용해서 메서드를 구현함
        Calculate calculate1 = (a, b) -> a*b;

        //interface 를 매개변수로 받을때 다음처럼 익명클래스, 익명클래스를 구현한 람다로 받을 수 있음!!!

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("a");
            }
        };

        new Thread(runnable).start();

        // 2
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("a");
            }
        });

        // 3
        Runnable runnable2 = () -> System.out.println("c");
        new Thread(runnable2);

        // 4
        new Thread(() -> System.out.println("b"));



    }
}
