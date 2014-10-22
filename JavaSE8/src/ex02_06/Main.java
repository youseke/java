/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02_06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Administrator
 */
public class Main {
    
    public static void main(String[] args) {
        characterStream("test").forEach(System.out::println);
    }
    
    public static Stream<Character> characterStream(String s) {
        return IntStream.range(0, s.length()).mapToObj(s::charAt);
    }
;

}
