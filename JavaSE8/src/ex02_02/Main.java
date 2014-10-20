/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02_02;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @author tohtetsu
 */
public class Main {

    public static void main(String[] args) {
        Stream<String> strings = Stream.of("This", "is", "a", "test", "for", "finding", "words", "!");
        strings.filter(new Predicate<String>() {

            @Override
            public boolean test(String t) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }).count();
    }
}
