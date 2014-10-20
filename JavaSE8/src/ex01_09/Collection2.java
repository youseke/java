/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex01_09;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author Tohtetsu Choh
 * @param <T>
 */
public interface Collection2<T> extends Collection<T> {
    // Collection2�����������N���X�̃C���X�^���X�ɗ��p����邵���v���t���Ȃ����c
    public default void forEachIf(Consumer<T> action, Predicate<T> filter) {
        if (filter.test((T) this))
            action.accept((T) this);
    }
}
