package ex03_18;

/**
 *
 * @author Tohtetsu Choh
 */
@FunctionalInterface
public interface BiCallable<T, U> {

    U call(T t) throws Exception;
}
