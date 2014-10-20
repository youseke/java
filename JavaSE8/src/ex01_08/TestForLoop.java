package ex01_08;

import java.util.ArrayList;
import java.util.List;

public class TestForLoop {

    public static void main(String[] args) {
        String[] names = {"Peter", "Paul", "Mary"};
        List<Runnable> runners01 = new ArrayList<>();
        List<Runnable> runners02 = new ArrayList<>();
        for (String name : names) {
            runners01.add(() -> System.out.println(name));
        }
        // うまくそれぞれの値を取れました。
        for (Runnable r : runners01) {
            r.run();
        }

        for (int i = 0; i < names.length; i++) {
            // ラダムから参照するローカル変数は、finalあるいは事実中のfinalである必要がある。
            // runners01.add(() -> System.out.println(names[i]));
        }
    }
}
