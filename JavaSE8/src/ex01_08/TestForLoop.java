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
        // ���܂����ꂼ��̒l�����܂����B
        for (Runnable r : runners01) {
            r.run();
        }

        for (int i = 0; i < names.length; i++) {
            // ���_������Q�Ƃ��郍�[�J���ϐ��́Afinal���邢�͎�������final�ł���K�v������B
            // runners01.add(() -> System.out.println(names[i]));
        }
    }
}
