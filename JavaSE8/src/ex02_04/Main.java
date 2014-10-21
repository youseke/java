/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02_04;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {
        int[] x = {1, 4, 9, 16};
        // []のストリームとなります。
        Stream.of(x).forEach(e -> {
            System.out.println(Arrays.toString(e));
        });
        // 正しい取り方
        IntStream.of(x).forEach(e -> {
            System.out.println(e);
        });
    }

}
