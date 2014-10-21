/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02_09;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> combine01(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList(), (i, s) -> {
            i.addAll(s);
            return i;
        });
    }

    public static <T> ArrayList<T> combine02(Stream<ArrayList<T>> stream) {
        return stream.reduce((i, s) -> {
            i.addAll(s);
            return i;
        }).get();
    }

    public static <T> ArrayList<T> combine03(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList<T>(), (i, s) -> {
            i.addAll(s);
            return i;
        }, (i, s) -> {
            i.addAll(s);
            return i;
        });
    }

}
