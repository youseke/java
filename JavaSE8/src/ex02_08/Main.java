/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02_08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {
        List<Double> dList = Arrays.asList(0.0, 0.1, 0.2);
        System.out.println(sum(dList.stream()));
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        first.
    }
}
