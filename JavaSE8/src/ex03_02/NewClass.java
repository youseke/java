package ex03_02;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        withLock(lock, () -> {
            System.out.println("This is a test");
        });
    }

    public static void withLock(ReentrantLock lock, Runnable r) {
        lock.lock();
        try {
            r.run();
        } finally {
            lock.unlock();
        }
    }
}
