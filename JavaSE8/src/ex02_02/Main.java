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
        strings.filter((String t) -> {
            System.out.println("Filter is called and the element is " + t);
            return t.length() > 2;
        }).limit(5).forEach(System.out::println);
    }
}
