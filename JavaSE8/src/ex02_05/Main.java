/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02_05;

import java.util.stream.Stream;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {
        long a = 321; //25214903917L;
        long c = 11;
        long m = 1999; //(long) Math.pow(2, 48);
  
        System.out.println();
        long seed = 0;
        linearlySynthesize(a, c, m, seed).limit(100).forEach(System.out::println);
    }

    public static Stream<Long> linearlySynthesize(long a, long c, long m, long seed) {
        return Stream.iterate(seed,  y -> (a * y + c) % m - 1);
    }
}
